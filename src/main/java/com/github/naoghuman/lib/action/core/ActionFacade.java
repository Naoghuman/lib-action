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
package com.github.naoghuman.lib.action.core;

import com.github.naoghuman.lib.action.internal.DefaultActionHandler;
import java.util.Optional;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The facade {@link com.github.naoghuman.lib.action.core.ActionFacade} provides 
 * access to the action methods in the <code>Interface</code> 
 * {@link com.github.naoghuman.lib.action.core.ActionHandler}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.core.ActionHandler
 */
public final class ActionFacade implements ActionHandler {
    
    private static final Optional<ActionFacade> instance = Optional.of(new ActionFacade());

    /**
     * Returns a singleton instance from the class <code>ActionFacade</code>.
     * 
     * @return a singleton instance from the class <code>ActionFacade</code>.
     */
    public static final ActionFacade getDefault() {
        return instance.get();
    }

    private ActionHandler action = null;
    
    private ActionFacade() {
        this.initialize();
    }
    
    private void initialize() {
        action = new DefaultActionHandler();
    }

    @Override
    public void handle(final String actionId) {
        action.handle(actionId);
    }

    @Override
    public void handle(final String actionId, final long value) {
        action.handle(actionId, value);
    }

    @Override
    public void handle(final TransferData transferData) {
        action.handle(transferData);
    }

    @Override
    public void handle(final ObservableList<TransferData> transferDatas) {
        action.handle(transferDatas);
    }

    @Override
    public boolean isRegistered(final String actionId) {
        return action.isRegistered(actionId);
    }

    @Override
    public boolean register(final String actionId, final EventHandler<ActionEvent> eventHandler) {
        return action.register(actionId, eventHandler);
    }

    @Override
    public boolean remove(final String actionId) {
        return action.remove(actionId);
    }
    
}
