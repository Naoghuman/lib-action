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

import de.pro.lib.action.LibAction;

/**
 * The facade {@link de.pro.lib.action.api.ActionFacade} supplies a 
 * singleton instance of the Interface {@link de.pro.lib.action.api.ILibAction}.
 *
 * @author PRo
 * @see de.pro.lib.action.api.ILibAction
 */
public final class ActionFacade {
    
    private static ILibAction instance = null;
    
    /**
     * Provides a singleton instance from the Interface {@link de.pro.lib.action.api.ILibAction}.
     * 
     * @return A singleton instance of {@link de.pro.lib.action.api.ILibAction}.
     * @see de.pro.lib.action.api.ILibAction
     */
    public static ILibAction getDefault() {
        
        if (instance == null) {
            instance = new LibAction();
        }
        
        return instance;
    }
    
    private ActionFacade() { }
    
}
