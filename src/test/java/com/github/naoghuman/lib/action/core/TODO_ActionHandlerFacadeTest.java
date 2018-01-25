/**
 * Copyright (C) 2018 - 2018 Naoghuman
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

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class TODO_ActionHandlerFacadeTest {
    
    public TODO_ActionHandlerFacadeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDefault() {
        System.out.println("getDefault");
        ActionHandlerFacade expResult = null;
        ActionHandlerFacade result = ActionHandlerFacade.getDefault();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHandle_String() {
        System.out.println("handle");
        String actionId = "";
        ActionHandlerFacade instance = null;
        instance.handle(actionId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHandle_String_long() {
        System.out.println("handle");
        String actionId = "";
        long value = 0L;
        ActionHandlerFacade instance = null;
        instance.handle(actionId, value);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHandle_TransferData() {
        System.out.println("handle");
        TransferData transferData = null;
        ActionHandlerFacade instance = null;
        instance.handle(transferData);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHandle_ObservableList() {
        System.out.println("handle");
        ObservableList<TransferData> transferDatas = null;
        ActionHandlerFacade instance = null;
        instance.handle(transferDatas);
        fail("The test case is a prototype.");
    }

    @Test
    public void testIsRegistered() {
        System.out.println("isRegistered");
        String actionId = "";
        ActionHandlerFacade instance = null;
        boolean expResult = false;
        boolean result = instance.isRegistered(actionId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRegister() {
        System.out.println("register");
        String actionId = "";
        EventHandler<ActionEvent> eventHandler = null;
        ActionHandlerFacade instance = null;
        boolean expResult = false;
        boolean result = instance.register(actionId, eventHandler);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        System.out.println("remove");
        String actionId = "";
        ActionHandlerFacade instance = null;
        boolean expResult = false;
        boolean result = instance.remove(actionId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
