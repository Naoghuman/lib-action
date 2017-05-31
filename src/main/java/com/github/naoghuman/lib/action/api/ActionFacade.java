/*
 * Copyright (C) 2014 Naoghuman
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

import com.github.naoghuman.lib.action.LibAction;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The facade {@link com.github.naoghuman.lib.action.api.ActionFacade} provides 
 * access to the action methods during the Interface 
 * {@link com.github.naoghuman.lib.action.api.ILibAction}.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ILibAction
 * @deprecated Deprecated since 0.4.0. Will be replaced with {@link com.github.naoghuman.lib.action.core.ActionHandlerFacade}
 */
@Deprecated
public final class ActionFacade implements ILibAction {
    
    private static final Optional<ActionFacade> instance = Optional.of(new ActionFacade());

    /**
     * Returns a singleton instance from the class <code>ActionFacade</code>.
     * 
     * @return a singleton instance from the class <code>ActionFacade</code>.
     */
    @Deprecated
    public static final ActionFacade getDefault() {
        return instance.get();
    }

    private ILibAction action = null;
    
    private ActionFacade() {
        this.initialize();
    }
    
    private void initialize() {
        action = new LibAction();
    }

    @Override
    @Deprecated
    public void handle(String actionId) {
        action.handle(actionId);
    }

    @Override
    @Deprecated
    public void handle(String actionId, long data) {
        action.handle(actionId, data);
    }

    @Override
    @Deprecated
    public void handle(String actionId, Object data) {
        action.handle(actionId, data);
    }

    @Override
    @Deprecated
    public void handle(TransferData transferData) {
        action.handle(transferData);
    }

    @Override
    @Deprecated
    public void handle(List<TransferData> transferDatas) {
        action.handle(transferDatas);
    }

    @Override
    @Deprecated
    public Boolean isRegistered(String actionId) {
        return action.isRegistered(actionId);
    }

    @Override
    @Deprecated
    public void register(String actionId, EventHandler<ActionEvent> event) {
        action.register(actionId, event);
    }

    @Override
    @Deprecated
    public void remove(String actionId) {
        action.remove(actionId);
    }

}
