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
 * The <code>Interface</code> for the class {@link de.pro.lib.action.PRoAction}.<br />
 * Over the facade {@link de.pro.lib.action.api.ActionFacade} you can access the
 * methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.action.PRoAction
 * @see de.pro.lib.action.api.ActionFacade
 */
public interface IAction {
    
    /**
     * Fire an event with the associated actionKey.
     * 
     * @param actionKey The key which allowed access to the associated action.
     */
    public void handle(String actionKey);
    
    /**
     * Fire an event with the associated actionKey defined in the <code>TransferModel</code>.<br />
     * 
     * The <code>TransferModel</code> will be stored in the action event and can reached over 
     * <code>event.getSource(): Object</code> in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param model A <code>TransferModel</code> which contains the actionKey and additional parameters.
     */
    public void handle(TransferModel model);
    
    /**
     * Fire an event for every <code>TransferModel</code> with the associated actionKey in the model.<br />
     * 
     * The <code>TransferModel</code> will be stored in the action event and can reached over 
     * <code>event.getSource(): Object</code> in the overriden {@link javafx.event.ActionEvent}.
     * 
     * @param models A List with <code>TransferModel</code> which contains the actionKeys and additional parameters.
     */
    public void handle(List<TransferModel> models);
    
    /**
     * Checks if the specific action key is registered.
     * 
     * @param actionKey The action which should be check if it exists.
     * @return <code>true</code> if the action is registered, otherwise <code>false</code>.
     */
    public Boolean isRegistered(String actionKey);
    
    /**
     * Register an action with the specific key.
     * 
     * @param actionKey The key which allowed access to the associated action.
     * @param action The action which should be registered.
     */
    public void register(String actionKey, EventHandler<ActionEvent> action);
    
    /**
     * Remove the action with the specific key.
     * 
     * @param actionKey The action which should be removed.
     */
    public void remove(String actionKey);
    
}
