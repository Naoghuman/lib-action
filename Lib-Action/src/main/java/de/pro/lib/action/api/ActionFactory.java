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

import de.pro.lib.action.PRoAction;

/**
 * The factory <code>de.pro.lib.action.api.ActionFactory</code> provides a 
 * singleton instance of the Interface <code>de.pro.lib.action.api.IAction</code>.
 *
 * @author PRo
 * @see de.pro.lib.action.api.IAction
 */
public final class ActionFactory {
    private static IAction instance = null;
    
    /**
     * Provides a singleton instance from the Interface <code>de.pro.lib.action.api.IAction</code>.
     * 
     * @return A singleton instance of <code>de.pro.lib.action.api.IAction</code>.
     * @see de.pro.lib.action.api.IAction
     */
    public static IAction getDefault() {
        
        if (instance == null) {
            instance = new PRoAction();
        }
        
        return instance;
    }
    
    private ActionFactory() { }
}
