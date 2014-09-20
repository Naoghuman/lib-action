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
package de.pro.lib.action;

import de.pro.lib.action.api.IAction;
import de.pro.lib.logger.api.LoggerFacade;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The implementation from the Interface {@link de.pro.lib.action.api.IAction}.<br />
 * Access to this class is over the provider {@link de.pro.lib.action.api.ActionProvider}.
 * 
 * @author PRo
 * @see de.pro.lib.action.api.IAction
 * @see de.pro.lib.action.api.ActionProvider
 * 
 * @author PRo
 */
public class PRoAction implements IAction {
    
    private final static HashMap<String, EventHandler<ActionEvent>> ACTIONS = new HashMap<>();

    @Override
    public void handle(String actionKey) {
        this.handle(actionKey, null);
    }
    
    @Override
    public void handle(String actionKey, Object source) {
        if (!ACTIONS.containsKey(actionKey)) {
            return;
        }
        
        LoggerFacade.getDefault().info(IAction.class, "Handle action: " + actionKey); // NOI18N

        final ActionEvent event = new ActionEvent(source, null);
        ACTIONS.get(actionKey).handle(event);
    }

    @Override
    public void register(String actionKey, EventHandler<ActionEvent> action) {
        if (ACTIONS.containsKey(actionKey)) {
            return;
        }
        
        LoggerFacade.getDefault().info(IAction.class, "Register action: " + actionKey); // NOI18N

        ACTIONS.put(actionKey, action);
    }

    @Override
    public void remove(String actionKey) {
        if (!ACTIONS.containsKey(actionKey)) {
            return;
        }
        
        LoggerFacade.getDefault().info(IAction.class, "Remove action: " + actionKey); // NOI18N

        ACTIONS.remove(actionKey);
    }
}
