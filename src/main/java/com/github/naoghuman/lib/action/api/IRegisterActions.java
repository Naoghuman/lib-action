/*
 * Copyright (C) 2016 Naoghuman
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

/**
 * Over this interface the developer can <code>register</code> 
 * {@link javafx.event.ActionEvent}s during the method
 * {@link com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler) }.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler)
 * @see javafx.event.ActionEvent
 * @deprecated Deprecated since 0.4.0. Will be replaced with {@link com.github.naoghuman.lib.action.core.RegisterActions}
 */
@Deprecated
public interface IRegisterActions {
    
    /**
     * Implementing this method alloweds <code>register</code>
     * {@link javafx.event.ActionEvent}s during the method
     * {@link com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler) }.
     * 
     * @see com.github.naoghuman.lib.action.LibAction#register(java.lang.String, javafx.event.EventHandler)
     * @see javafx.event.ActionEvent
     */
    @Deprecated
    public void registerActions();
    
}
