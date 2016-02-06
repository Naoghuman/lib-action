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
package de.pro.lib.action.api;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The <code>Interface</code> for the class {@link de.pro.lib.action.LibAction}.<br />
 * Over the facade {@link com.github.naoghuman.ActionFacade} you can access the
 * methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.action.LibAction
 * @see com.github.naoghuman.ActionFacade
 */
@Deprecated
public interface ILibAction {
    
    /**
     * Fire an event with the associated actionKey.
     * 
     * @param actionKey The key which allowed access to the associated action.
     */
    @Deprecated
    public void handle(String actionKey);
    
    /**
     * Fire an event with the associated actionKey defined in the 
     * {@link de.pro.lib.action.api.ActionTransferModel}.<br />
     * 
     * The {@link de.pro.lib.action.api.ActionTransferModel} will be stored in 
     * the action event and can reached over <code>event.getSource(): Object</code> 
     * in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param model A <code>ActionTransferModel</code> which contains the actionKey and additional parameters.
     */
    @Deprecated
    public void handle(ActionTransferModel model);
    
    /**
     * Fire an event for every {@link de.pro.lib.action.api.ActionTransferModel} 
     * with the associated actionKey in the model.<br />
     * 
     * The {@link de.pro.lib.action.api.ActionTransferModel} will be stored in 
     * the action event and can reached over <code>event.getSource(): Object</code> 
     * in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param models A List with <code>ActionTransferModel</code> which contains the actionKeys and additional parameters.
     */
    @Deprecated
    public void handle(List<ActionTransferModel> models);
    
    /**
     * Checks if the specific action key is registered.
     * 
     * @param actionKey The action which should be check if it exists.
     * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
     */
    @Deprecated
    public Boolean isRegistered(String actionKey);
    
    /**
     * Register an action with the specific key.
     * 
     * @param actionKey The key which allowed access to the associated action.
     * @param action The action which should be registered.
     */
    @Deprecated
    public void register(String actionKey, EventHandler<ActionEvent> action);
    
    /**
     * Remove the action with the specific key.
     * 
     * @param actionKey The action which should be removed.
     */
    @Deprecated
    public void remove(String actionKey);
    
}
