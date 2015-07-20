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

import de.pro.lib.action.api.ILibAction;
import de.pro.lib.action.api.ActionTransferModel;
import de.pro.lib.logger.api.LoggerFacade;
import java.util.HashMap;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The implementation from the Interface {@link de.pro.lib.action.api.ILibAction}.<br />
 * Access to this class is over the facade {@link de.pro.lib.action.api.ActionFacade}.
 * 
 * @author PRo
 * @see de.pro.lib.action.api.ILibAction
 * @see de.pro.lib.action.api.ActionFacade
 */
public class LibAction implements ILibAction {
    
    private final static HashMap<String, EventHandler<ActionEvent>> ACTIONS = new HashMap<>();

    @Override
    public void handle(String actionKey) {
        final ActionTransferModel model = new ActionTransferModel();
        model.setActionKey(actionKey);
        
        this.handle(model);
    }
    
    @Override
    public void handle(ActionTransferModel model) {
        if (!ACTIONS.containsKey(model.getActionKey())) {
            return;
        }
        
        LoggerFacade.INSTANCE.getLogger().own(ILibAction.class, "Handle action: " + model.getActionKey()); // NOI18N

        final ActionEvent event = new ActionEvent(model, null);
        ACTIONS.get(model.getActionKey()).handle(event);
    }
    
    @Override
    public void handle(List<ActionTransferModel> models) {
        models.stream().forEach((model) -> {
            this.handle(model);
        });
    }

    @Override
    public Boolean isRegistered(String actionKey) {
        if (ACTIONS.containsKey(actionKey)) {
            LoggerFacade.INSTANCE.getLogger().own(ILibAction.class, "The action exists: " + actionKey); // NOI18N

            return Boolean.TRUE;
        }
        
        LoggerFacade.INSTANCE.getLogger().warn(ILibAction.class, "The action doesn't exists: " + actionKey); // NOI18N
                
        return Boolean.FALSE;
    }

    @Override
    public void register(String actionKey, EventHandler<ActionEvent> action) {
        if (ACTIONS.containsKey(actionKey)) {
            return;
        }
        
        LoggerFacade.INSTANCE.getLogger().own(ILibAction.class, "Register action: " + actionKey); // NOI18N

        ACTIONS.put(actionKey, action);
    }

    @Override
    public void remove(String actionKey) {
        if (!ACTIONS.containsKey(actionKey)) {
            return;
        }
        
        LoggerFacade.INSTANCE.getLogger().own(ILibAction.class, "Remove action: " + actionKey); // NOI18N

        ACTIONS.remove(actionKey);
    }
    
}