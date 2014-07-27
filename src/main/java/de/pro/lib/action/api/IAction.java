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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The <code>Interface</code> for the class <code>de.pro.lib.action.PRoAction</code>.
 * Over the factory <code>de.pro.lib.action.api.ActionFactory</code> you can 
 * access the methods in this <code>Interface</code>.
 *
 * @author PRo
 * @see de.pro.lib.action.PRoAction
 * @see de.pro.lib.action.api.ActionFactory
 */
public interface IAction {
    /**
     * Fire an event with the associated action.
     * 
     * @param actionKey The key which allowed access to the associated action.
     */
    public void handle(String actionKey);
    
    /**
     * Fire an event with the associated action. The optional <code>Object</code>
     * can reached over <code>event.getSource(): Object</code> in the overriden
     * {@link javafx.event.ActionEvent}.
     * 
     * @param actionKey The key which allowed access to the associated action.
     * @param source A optional <code>Object</code> which can stored.
     */
    public void handle(String actionKey, Object source);
    
    /**
     * Register an action with the specific key in this module.
     * 
     * @param actionKey The key which allowed access to the associated action.
     * @param action The action which should be registered.
     */
    public void register(String actionKey, EventHandler<ActionEvent> action);
}
