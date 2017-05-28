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

/**
 * With this interface the developer have an <code>official</code> method to register all this methods in 
 * the implementing classes which will <code>register</code> {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) }
 * with an specific <code>actionId</code>.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 */
public interface RegisterActions {
    
    /**
     * Implementing this method alloweds the developer to <code>register</code> all methods in the 
     * implementing class which will <code>register</code> {@link javafx.event.ActionEvent}s during the method
     * {@link com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler) }.
     * 
     * @see com.github.naoghuman.lib.action.core.ActionHandler#register(java.lang.String, javafx.event.EventHandler)
     * @see javafx.event.ActionEvent
     */
    public void register();
    
}
