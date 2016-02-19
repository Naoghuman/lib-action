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

import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The <code>Interface</code> for the class {@link de.pro.lib.action.LibAction}.<br />
 * Over the facade {@link com.github.naoghuman.lib.action.api.ActionFacade} you 
 * can access the methods in this <code>Interface</code>.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.LibAction
 * @see com.github.naoghuman.lib.action.api.ActionFacade
 */
public interface ILibAction {
    
    /**
     * Fire an event with the associated actionKey.
     * 
     * @param actionId The actionId which allowed access to the assoziated action.
     */
    public void handle(String actionId);
    
    /**
     * Fire an event with the associated actionKey defined in the 
     * {@link com.github.naoghuman.lib.action.api.TransferData}.<br />
     * 
     * The {@link com.github.naoghuman.lib.action.api.TransferData} will be 
     * stored in the action event and can reached over <code>event.getSource(): Object</code> 
     * in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param transferData A <code>TransferData</code> which contains the actionId and additional parameters.
     */
    public void handle(TransferData transferData);
    
    /**
     * Fire an event for every {@link com.github.naoghuman.lib.action.api.TransferData} 
     * with the associated actionKey in the model.<br />
     * 
     * The {@link com.github.naoghuman.lib.action.api.TransferData} will be stored in 
     * the action event and can reached over <code>event.getSource(): Object</code> 
     * in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param transferDatas A List with <code>TransferData</code> which contains the actionIds and additional parameters.
     */
    public void handle(List<TransferData> transferDatas);
    
    /**
     * Checks if the specific action key is registered.
     * 
     * @param actionId The action which should be check if it exists.
     * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
     */
    public Boolean isRegistered(String actionId);
    
    /**
     * Register an action with the specific id.
     * 
     * @param actionId The actionId which allowed access to the associated action.
     * @param event The assoziated action which should be registered.
     */
    public void register(String actionId, EventHandler<ActionEvent> event);
    
    /**
     * Remove the action with the specific id.
     * 
     * @param actionId The assoziated action which should be removed.
     */
    public void remove(String actionId);
    
}
