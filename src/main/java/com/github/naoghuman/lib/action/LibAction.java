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
package com.github.naoghuman.lib.action;

import com.github.naoghuman.lib.action.api.ILibAction;

import com.github.naoghuman.lib.action.api.TransferData;
import com.github.naoghuman.lib.logger.api.LoggerFacade;
import java.util.HashMap;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The implementation from the Interface {@link com.github.naoghuman.lib.action.api.ILibAction}.<br />
 * Access to this class is over the facade {@link com.github.naoghuman.lib.action.api.ActionFacade}.
 * 
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ILibAction
 * @see com.github.naoghuman.lib.action.api.ActionFacade
 */
public class LibAction implements ILibAction {
    
    private final static HashMap<String, EventHandler<ActionEvent>> ACTIONS = new HashMap<>();

    @Override
    public void handle(String actionId) {
        final TransferData transferData = new TransferData();
        transferData.setActionId(actionId);
        
        this.handle(transferData);
    }
    
    @Override
    public void handle(TransferData transferData) {
        if (!ACTIONS.containsKey(transferData.getActionId())) {
            return;
        }
        
        LoggerFacade.INSTANCE.own(ILibAction.class, "Handle action: " + transferData.getActionId()); // NOI18N

        final ActionEvent event = new ActionEvent(transferData, null);
        ACTIONS.get(transferData.getActionId()).handle(event);
    }
    
    @Override
    public void handle(List<TransferData> transferDatas) {
        transferDatas.stream().forEach((transferData) -> {
            this.handle(transferData);
        });
    }

    @Override
    public Boolean isRegistered(String actionId) {
        boolean isRegistered = Boolean.FALSE;
        if (ACTIONS.containsKey(actionId)) {
            isRegistered = Boolean.TRUE;
        }
        LoggerFacade.INSTANCE.own(ILibAction.class, "The action exists: " + actionId); // NOI18N
                
        return isRegistered;
    }

    @Override
    public void register(String actionId, EventHandler<ActionEvent> event) {
        if (ACTIONS.containsKey(actionId)) {
            return;
        }
        
        LoggerFacade.INSTANCE.own(ILibAction.class, "Register action: " + actionId); // NOI18N

        ACTIONS.put(actionId, event);
    }

    @Override
    public void remove(String actionId) {
        if (!ACTIONS.containsKey(actionId)) {
            return;
        }
        
        LoggerFacade.INSTANCE.own(ILibAction.class, "Remove action: " + actionId); // NOI18N

        ACTIONS.remove(actionId);
    }
    
}
