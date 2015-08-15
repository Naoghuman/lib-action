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
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * The facade {@link de.pro.lib.action.api.ActionFacade} provides access to
 * the action methods during the Interface {@link de.pro.lib.action.api.ILibAction}.
 *
 * @author PRo
 * @see de.pro.lib.action.api.ILibAction
 */
public enum ActionFacade implements ILibAction {
    
    /**
     * Over the value <code>INSTANCE</code> the developer have access to the
     * functionality in <code>ActionFacade</code>.
     */
    INSTANCE;
    
    private ILibAction action = null;

    private ActionFacade() {
        this.initialize();
    }
    
    private void initialize() {
        action = new LibAction();
    }

    @Override
    public void handle(String actionKey) {
        action.handle(actionKey);
    }

    @Override
    public void handle(ActionTransferModel model) {
        action.handle(model);
    }

    @Override
    public void handle(List<ActionTransferModel> models) {
        action.handle(models);
    }

    @Override
    public Boolean isRegistered(String actionKey) {
        return action.isRegistered(actionKey);
    }

    @Override
    public void register(String actionKey, EventHandler<ActionEvent> action) {
        this.action.register(actionKey, action);
    }

    @Override
    public void remove(String actionKey) {
        action.remove(actionKey);
    }
    
}
