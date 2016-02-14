/*
 * Copyright (C) 2014 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.lib.action.api;

import com.github.naoghuman.lib.logger.api.LoggerFacade;
import eu.infomas.annotation.AnnotationDetector;
import eu.infomas.annotation.Cursor;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * The facade {@link com.github.naoghuman.lib.action.api.ActionFacade} provides 
 * access to registered action methods.
 * <ul>
 * <li>Only classes with the annotation {@link com.github.naoghuman.lib.action.api.ActionClass }
 * will be scanned in the method {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.</li>
 * <li>Only methods which are marked with the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }
 * will be registered as action method through the scanning.</li>
 * </ul>
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 * @see com.github.naoghuman.lib.action.api.ActionClass
 * @see com.github.naoghuman.lib.action.api.ActionMethod
 */
public enum ActionFacade {
    
    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * functionality in the enum <code>ActionFacade</code>.
     */
    INSTANCE;

    private ActionFacade() {
        this.initialize();
    }
    
    private void initialize() {
        
    }
    
    private final List<ActionData> actionDatas = new ArrayList<>();
    
    private ActionData getActionData(String id) {
        for (ActionData actionData : actionDatas) {
            if (actionData.getActionKey().equals(id)) {
                return actionData;
            }
        }
        
        return null;
    }
    
    /**
     * Scans all classes for the annotation {@link com.github.naoghuman.lib.action.api.ActionClass }.
     * <ul>
     * <li>If annotated classes will be found all methods in this classes will be 
     * scanned for the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }.</li>
     * <li>All founded method will be stored internal.</li>
     * <li>Access to the stored action methods happens through the parameter <code>id</code>.</li>
     * </ul>
     * 
     * @throws IOException 
     * @see com.github.naoghuman.lib.action.api.ActionFacade#trigger(java.lang.String) 
     * @see com.github.naoghuman.lib.action.api.ActionFacade#trigger(java.lang.String, com.github.naoghuman.lib.action.api.TransferData) 
     */
    public void scan() throws IOException {
        final List<Class<?>> types = AnnotationDetector
                .scanClassPath()
                .forAnnotations(ActionClass.class)
                .collect((Cursor cursor) -> cursor.getType());
        
        final List<Method> methods = new ArrayList<>();
        for (Class<?> clazz : types) {
            methods.clear();
            methods.addAll(AnnotationDetector
                    .scanClassPath(clazz.getPackage().getName())
                    .forAnnotations(ActionMethod.class)
                    .on(ElementType.METHOD)
                    .filter((File dir, String name) -> name.endsWith(clazz.getSimpleName() + ".class")) // NOI18N
                    .collect((Cursor cursor) -> cursor.getMethod()));
            
            for (Method method : methods) {
                final Annotation annotation = method.getAnnotation(ActionMethod.class);
                final ActionMethod annotatedMethod = (ActionMethod) annotation;
                final ActionData annotatedData = new ActionData();
                annotatedData.setClazz(clazz);
                annotatedData.setMethod(method);
                annotatedData.setActionKey(annotatedMethod.id());
                actionDatas.add(annotatedData);
            }
        }
    }
    
    /**
     * Triggers the registerd action method which is associated with the <code>id</code>.
     * <ul>
     * <li>If no action method with this id is registerd, then no action event will be triggerd.</li>
     * </ul>
     * 
     * @param id The id which is defined in the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod}.
     */
    public void trigger(String id) {
        this.trigger(id, TransferData.EMPTY);
    }
    
    /**
     * Triggers the registerd action method with the <code>TransferData</code> 
     * which is associated with the <code>id</code>.
     * <ul>
     * <li>Access to the <code>TransferData</code> can be happen during  {@link javafx.event.ActionEvent#getSource() }.</li>
     * <li>If <code>TransferData == null</code> then also <code>ActionEvent#getSource() == null</code>.</li>
     * <li>If no id in this TransferData is registerd, then no action event will be triggerd.</li>
     * <li>If no action method with this id is registerd, then no action event will be triggerd.</li>
     * </ul>
     * 
     * @param transferData The transferData which should be received in the registerd action method.
     */
    public void trigger(TransferData transferData) {
        this.trigger(transferData.getId(), transferData);
    }
    
    /**
     * Triggers the registerd action method with the <code>TransferData</code> 
     * which is associated with the <code>id</code>.
     * <ul>
     * <li>Access to the <code>TransferData</code> can be happen during  {@link javafx.event.ActionEvent#getSource() }.</li>
     * <li>If <code>TransferData == null</code> then also <code>ActionEvent#getSource() == null</code>.</li>
     * <li>If no action method with this id is registerd, then no action event will be triggerd.</li>
     * </ul>
     * 
     * @param id The id which is defined in the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod}.
     * @param transferData The transferData which should be received in the registerd action method.
     */
    public void trigger(String id, TransferData transferData) {
        if (id == null || id.trim().isEmpty()) {
            LoggerFacade.INSTANCE.warn(this.getClass(), "Don't trigger action method because: (id == null || id.trim().isEmpty())"); // NOI18N
            return;
        }
        
        final ActionData annotatedData = getActionData(id);
        if (annotatedData == null) {
            LoggerFacade.INSTANCE.warn(this.getClass(), "Don't trigger action method because no action method is associated with the id: " + id); // NOI18N
            return;
        }
        
        try {
            if (transferData != null) {
                LoggerFacade.INSTANCE.debug(this.getClass(), "Trigger action method with id: " + id + " and TransferData"); // NOI18N
                annotatedData.getMethod().invoke(annotatedData.getClazz().newInstance(), transferData);
            }
            else {
                LoggerFacade.INSTANCE.debug(this.getClass(), "Trigger action method with id: " + id); // NOI18N
                annotatedData.getMethod().invoke(annotatedData.getClazz().newInstance());
            }
        } catch (IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException
                | InstantiationException ex
        ) {
            LoggerFacade.INSTANCE.error(this.getClass(), "Can't invoke action method with id: " + id, ex); // NOI18N
        }
    }
    
    // Simple pojo to store the action data (class, method, id).
    private final class ActionData {
    
        private Class clazz;
        private Method method;
        private String actionKey;

        Class getClazz() {
            return clazz;
        }

        void setClazz(Class clazz) {
            this.clazz = clazz;
        }

        Method getMethod() {
            return method;
        }

        void setMethod(Method method) {
            this.method = method;
        }

        String getActionKey() {
            return actionKey;
        }

        void setActionKey(String actionKey) {
            this.actionKey = actionKey;
        }

    }
}
