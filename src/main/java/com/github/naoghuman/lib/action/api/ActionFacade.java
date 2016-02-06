/*
 * Copyright (C) 2014 PRo
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
import de.pro.lib.action.LibAction;
import de.pro.lib.action.api.ActionTransferModel;
import de.pro.lib.action.api.ILibAction;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The facade {@link com.github.naoghuman.lib.action.api.ActionFacade} provides access to
 * the action methods during the Interface {@link de.pro.lib.action.api.ILibAction}.
 *
 * @author PRo
 * @see de.pro.lib.action.api.ILibAction
 */
public enum ActionFacade implements ILibAction {
    
    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * functionality in <code>ActionFacade</code>.
     */
    INSTANCE;
    
    private ILibAction action = null;

    private ActionFacade() {
        this.initialize();
    }
    
    private void initialize() {
        action = new LibAction();
    }
    
    /**
     * Triggers in the given <code>clazz</code> the action method which is associated
     * with the <code>actionKey</code>.
     * 
     * @param clazz The clazz where the action method is defined.
     * @param actionKey The actionKey which is defined in the annotation {@link com.github.naoghuman.lib.action.api.OnAction}.
     */
    public void onAction(Class clazz, String actionKey) {
        this.onAction(clazz.getName(), actionKey, null);
    }
    
    /**
     * Triggers in the given <code>clazz</code> the action method which is associated
     * with the <code>actionKey</code>.
     * <p>
     * The parameter <code>clazz</code> have the format: {@link java.lang.Class#getName()}.
     * 
     * @param clazz The clazz where the action method is defined.
     * @param actionKey The actionKey which is defined in the annotation {@link com.github.naoghuman.lib.action.api.OnAction}.
     */
    public void onAction(String clazz, String actionKey) {
        this.onAction(clazz, actionKey, null);
    }
    
    /**
     * Triggers in the given <code>clazz</code> the action method (with the parameter
     * <code>data</code>) which is associated with the <code>actionKey</code>.
     * 
     * @param clazz The clazz where the action method is defined.
     * @param actionKey The actionKey which is defined in the annotation {@link com.github.naoghuman.lib.action.api.OnAction}.
     * @param data The data which will delivered the action method as parameter.
     */
    public void onAction(Class clazz, String actionKey, ActionData data) {
        this.onAction(clazz.getName(), actionKey, data);
    }
    
    /**
     * Triggers in the given <code>clazz</code> the action method (with the parameter
     * <code>data</code>) which is associated with the <code>actionKey</code>.
     * <p>
     * The parameter <code>clazz</code> have the format: {@link java.lang.Class#getName()}.
     * 
     * @param clazz The clazz where the action method is defined.
     * @param actionKey The actionKey which is defined in the annotation {@link com.github.naoghuman.lib.action.api.OnAction}.
     * @param data The data which will delivered the action method as parameter.
     */
    public void onAction(String clazz, String actionKey, ActionData data) {
        Class clazz1 = null;
        try {
            clazz1 = Class.forName(clazz);
        } catch (ClassNotFoundException ex) {
            LoggerFacade.INSTANCE.error(this.getClass(), "Class not found via reflection: " + clazz, ex); // NOI18N
        }
        
        for (Method method : clazz1.getDeclaredMethods()) {
            if (method.isAnnotationPresent(OnAction.class)) {
                final Annotation annotation = method.getAnnotation(OnAction.class);
                final OnAction registerOnAction = (OnAction) annotation;
                if (registerOnAction.actionKey().equals(actionKey)) {
                    try {
                        if (data != null) {
                            method.invoke(clazz1.newInstance(), data);
                        }
                        else {
                            method.invoke(clazz1.newInstance());
                        }
                    } catch (IllegalAccessException
                            | IllegalArgumentException
                            | InvocationTargetException
                            | InstantiationException ex
                    ) {
                        LoggerFacade.INSTANCE.error(this.getClass(), "Error during invoking the method", ex); // NOI18N
                    }
                }
            }
        }
    }

    @Deprecated
    @Override
    public void handle(String actionKey) {
        action.handle(actionKey);
    }

    @Deprecated
    @Override
    public void handle(ActionTransferModel model) {
        action.handle(model);
    }

    @Deprecated
    @Override
    public void handle(List<ActionTransferModel> models) {
        action.handle(models);
    }

    @Deprecated
    @Override
    public Boolean isRegistered(String actionKey) {
        return action.isRegistered(actionKey);
    }

    @Deprecated
    @Override
    public void register(String actionKey, EventHandler<ActionEvent> action) {
        this.action.register(actionKey, action);
    }

    @Deprecated
    @Override
    public void remove(String actionKey) {
        action.remove(actionKey);
    }
    
}
