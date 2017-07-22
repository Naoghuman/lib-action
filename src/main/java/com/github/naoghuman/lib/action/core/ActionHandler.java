/**
 * Copyright (C) 2017 Naoghuman
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
package com.github.naoghuman.lib.action.core;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * With this interface the developer have access to all methods in context from 
 * store, access and manage {@link javafx.event.EventHandler}s mapped to a specific 
 * {@code actionId}.
 * 
 * The implementation from this interface {@link com.github.naoghuman.lib.action.internal.DefaultActionHandler}
 * can be access over the facade {@link com.github.naoghuman.lib.action.core.ActionHandlerFacade}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.ActionHandlerFacade
 * @see    com.github.naoghuman.lib.action.internal.DefaultActionHandler
 * @see    javafx.event.EventHandler
 */
public interface ActionHandler {
    
    /**
     * Fires an {@link javafx.event.ActionEvent} with the associated {@code actionId}.
     * <p>
     * <b>Hint:</b><br>
     * The {@code actionId} and its associated {@link javafx.event.EventHandler} 
     * must registered before during the method 
     * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
     * 
     * @param actionId The actionId which allowed access to the assoziated action.
     * @see            com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) 
     * @see            javafx.event.ActionEvent
     * @see            javafx.event.EventHandler
     */
    public void handle(final String actionId);
    
    /**
     * Fires an {@link javafx.event.ActionEvent} with the associated {@code actionId} 
     * and the given parameter {@code value}.
     * <p>
     * Internal the parameter {@code data} will be stored in a 
     * {@link com.github.naoghuman.lib.action.api.TransferData}. The data can 
     * be access via:<br>
     * public void handleOnAction(ActionEvent event) {<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;final TransferData transferData = (TransferData) event.getSource();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;final long data = transferData.getLong();<br>
     * &nbsp;&nbsp;&nbsp;&nbsp;&frasl; &frasl; do anything with the data<br>
     * }
     * <p>
     * <b>Hint:</b><br>
     * The {@code actionId} and its associated {@link javafx.event.EventHandler} 
     * must before registered during the method 
     * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
     * 
     * @param actionId The actionId which allowed access to the assoziated action.
     * @param value    The long parameter which should be stored and transfered by this event.
     * @see            com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
     * @see            com.github.naoghuman.lib.action.core.TransferData
     * @see            javafx.event.ActionEvent
     * @see            javafx.event.EventHandler
     */
    public void handle(String actionId, long value);
    
    /**
     * Fires an {@link javafx.event.ActionEvent} with the associated {@code actionId} 
     * defined in the {@link com.github.naoghuman.lib.action.core.TransferData}.
     * <p>
     * The {@link com.github.naoghuman.lib.action.core.TransferData} will be 
     * stored in the executed {@code ActionEvent} and can reached with the method 
     * {@code event.getSource(): Object} in the overriden {@code ActionEvent}.
     * <p>
     * <b>Hint:</b><br>
     * The {@code actionId} and its associated {@link javafx.event.EventHandler} 
     * must before registered during the method 
     * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
     * 
     * @param transferData A {@code TransferData} which contains the actionId and additional parameters.
     * @see                com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
     * @see                com.github.naoghuman.lib.action.core.TransferData
     * @see                javafx.event.ActionEvent
     * @see                javafx.event.EventHandler
     */
    public void handle(final TransferData transferData);
    
    /**
     * Fires an {@link javafx.event.ActionEvent} for every {@link com.github.naoghuman.lib.action.core.TransferData} 
     * with the associated {@code actionId} in the specific {@code TransferData}.
     * <p>
     * The {@link com.github.naoghuman.lib.action.core.TransferData} will be 
     * stored in the executed {@code ActionEvent} and can reached with the method 
     * {@code event.getSource(): Object} in the overriden {@code ActionEvent}.
     * <p>
     * <b>Hint:</b><br>
     * All {@code actionId}s and its associated {@link javafx.event.EventHandler} 
     * must before registered during the method 
     * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)}.
     * 
     * @param transferDatas A List with {@code TransferData} which contains the actionIds and additional parameters.
     * @see                 com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
     * @see                 com.github.naoghuman.lib.action.core.TransferData
     * @see                 javafx.event.ActionEvent
     * @see                 javafx.event.EventHandler
     */
    public void handle(final ObservableList<TransferData> transferDatas);
    
    /**
     * Checks if the specific {@code actionId} is registered.
     * 
     * @param actionId The actionId which should be check if it is exists.
     * @return         {@code true} if the actionId (with associated EventHandler) 
     *                 is registered, otherwise {@code false}.
     */
    public boolean isRegistered(final String actionId);
    
    /**
     * Register an {@link javafx.event.EventHandler} with the specific {@code actionId}.
     * 
     * @param actionId     The actionId which allowed access to the associated EventHandler.
     * @param eventHandler The assoziated EventHandler which should be registered.
     * @return             {@code true} if the EventHandler is registered, otherwise {@code false}.
     * @see                javafx.event.EventHandler
     */
    public boolean register(final String actionId, final EventHandler<ActionEvent> eventHandler);
    
    /**
     * Removes the {@link javafx.event.EventHandler} with the specific specific 
     * {@code actionId}.
     * 
     * @param actionId The actionId which should be removed with the associated EventHandler.
     * @return         {@code true} if the EventHandler is removed, otherwise {@code false}.
     * @see            javafx.event.EventHandler
     */
    public boolean remove(final String actionId);
    
}
