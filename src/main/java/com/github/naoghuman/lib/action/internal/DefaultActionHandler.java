/*
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
package com.github.naoghuman.lib.action.internal;

import com.github.naoghuman.lib.action.core.ActionHandler;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.HashMap;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The implementation from the {@code Interface} {@link com.github.naoghuman.lib.action.core.ActionHandler}
 * which can be access over the facade {@link com.github.naoghuman.lib.action.core.ActionHandlerFacade}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.ActionHandler
 * @see    com.github.naoghuman.lib.action.core.ActionHandlerFacade
 */
public final class DefaultActionHandler implements ActionHandler {
    
    private final static HashMap<String, EventHandler<ActionEvent>> ACTIONS = new HashMap<>();

    @Override
    public void handle(final String actionId) {
        final TransferData transferData = TransferDataBuilder.create()
                .actionId(actionId)
                .build();
        
        this.handle(transferData);
    }

    @Override
    public void handle(final String actionId, final long value) {
        final TransferData transferData = TransferDataBuilder.create()
                .actionId(actionId)
                .longValue(value)
                .build();
        
        this.handle(transferData);
    }

    @Override
    public void handle(final TransferData transferData) {
        if (!ACTIONS.containsKey(transferData.getActionId())) {
            LoggerFacade.getDefault().warn(ActionHandler.class, 
                    "Given [actionId==" + transferData.getActionId() // NOI18N
                    + "] is missing. Can't execute the action!");      // NOI18N
        
            return;
        }
        
        LoggerFacade.getDefault().debug(ActionHandler.class, "Handle action: " + transferData.getActionId()); // NOI18N
        if (!transferData.isLoggingDisabled()) {
           LoggerFacade.getDefault().debug(ActionHandler.class, transferData.toString());
        }
        
        final ActionEvent event = new ActionEvent(transferData, null);
        ACTIONS.get(transferData.getActionId()).handle(event);
    }

    @Override
    public void handle(final ObservableList<TransferData> transferDatas) {
        transferDatas.stream()
                .forEach((transferData) -> {
                    this.handle(transferData);
                });
    }

    @Override
    public boolean isRegistered(final String actionId) {
        boolean isRegistered = Boolean.FALSE;
        if (ACTIONS.containsKey(actionId)) {
            isRegistered = Boolean.TRUE;
        }
        
        LoggerFacade.getDefault().info(ActionHandler.class, 
                "The given [actionId=" + actionId // NOI18N
                + "] exists: " + isRegistered);    // NOI18N
                
        return isRegistered;
    }

    @Override
    public boolean register(final String actionId, final EventHandler<ActionEvent> eventHandler) {
        boolean isRegistered = Boolean.FALSE;
        if (!ACTIONS.containsKey(actionId)) {
            isRegistered = Boolean.TRUE;
            ACTIONS.put(actionId, eventHandler);
        }
        
        LoggerFacade.getDefault().info(ActionHandler.class, 
                "The given [actionId=" + actionId // NOI18N
                + "] is successfully registered: " + isRegistered);    // NOI18N

        return isRegistered;
    }

    @Override
    public boolean remove(final String actionId) {
        boolean isRemoved = Boolean.FALSE;
        if (ACTIONS.containsKey(actionId)) {
            isRemoved = Boolean.TRUE;
            ACTIONS.remove(actionId);
        }
        
        LoggerFacade.getDefault().info(ActionHandler.class, 
                "The given [actionId=" + actionId // NOI18N
                + "] is successfully removed: " + isRemoved);    // NOI18N

        return isRemoved;
    }
    
}
