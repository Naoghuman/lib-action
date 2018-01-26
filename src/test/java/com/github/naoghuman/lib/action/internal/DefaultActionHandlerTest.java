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
package com.github.naoghuman.lib.action.internal;

import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import javafx.collections.FXCollections;
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
public class DefaultActionHandlerTest {
    
    public DefaultActionHandlerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testHandleAttrActionIdThrowsNullPointerException() {
        String actionId = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(actionId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHandleAttrActionIdThrowsIllegalArgumentException() {
        String actionId = ""; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(actionId);
    }

    @Test
    public void testHandleAttrActionId() {
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-testHandleAttrActionId",
                (event) -> {
                    Object source = event.getSource();
                    if (source instanceof TransferData) {
                        TransferData data = (TransferData) source;
                        assertEquals("actionId-testHandleAttrActionId", data.getActionId());
                    }
                });
        
        instance.handle("actionId-testHandleAttrActionId");
    }

    @Test(expected = NullPointerException.class)
    public void testHandleAttrActionIdThrowsNullPointerExceptionAndValueLong() {
        String actionId = null; // <----------------------------
        Long   value    = 12345L;
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(actionId, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHandleAttrActionIdThrowsIllegalArgumentExceptionAndValueLong() {
        String actionId = ""; // <----------------------------
        Long   value    = 12345L;
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(actionId, value);
    }

    @Test(expected = NullPointerException.class)
    public void testHandleAttrActionIdAndValueLongThrowsNullPointerException() {
        String actionId = "actionId-testHandleAttrActionIdAndValueLongThrowsNullPointerException";
        Long   value    = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(actionId, value);
    }

    @Test
    public void testHandleAttrActionIdAndValueLong() {
        String actionId = "actionId-testHandleAttrActionIdAndValueLong";
        Long   value    = 12345L;
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-testHandleAttrActionIdAndValueLong",
                (event) -> {
                    Object source = event.getSource();
                    if (source instanceof TransferData) {
                        TransferData data = (TransferData) source;
                        assertEquals("actionId-testHandleAttrActionIdAndValueLong", data.getActionId());
                        assertTrue(data.getLong().isPresent());
                        assertTrue(12345L == data.getLong().get());
                    }
                });
        
        instance.handle(actionId, value);
    }

    @Test(expected = NullPointerException.class)
    public void testHandleAttrTransferDataThrowsNullPointerException() {
        TransferData transferData = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(transferData);
    }

    @Test
    public void testHandleAttrTransferData() {
        TransferData transferData = TransferDataBuilder.create()
                .actionId("actionId-testHandleAttrTransferData")
                .build();
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-testHandleAttrTransferData",
                (event) -> {
                    Object source = event.getSource();
                    if (source instanceof TransferData) {
                        TransferData data = (TransferData) source;
                        assertEquals("actionId-testHandleAttrTransferData", data.getActionId());
                    }
                });
        
        instance.handle(transferData);
    }

    @Test(expected = NullPointerException.class)
    public void testHandleAttrObservableListThrowsNullPointerException() {
        ObservableList<TransferData> transferDatas = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.handle(transferDatas);
    }

    @Test
    public void testHandleAttrObservableList() {
        ObservableList<TransferData> transferDatas = FXCollections.observableArrayList();
        transferDatas.add(TransferDataBuilder.create()
                .actionId("actionId-1-testHandleAttrObservableList")
                .build());
        transferDatas.add(TransferDataBuilder.create()
                .actionId("actionId-2-testHandleAttrObservableList")
                .build());
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-1-testHandleAttrObservableList",
                (event) -> {
                    Object source = event.getSource();
                    if (source instanceof TransferData) {
                        TransferData data1 = (TransferData) source;
                        assertEquals("actionId-1-testHandleAttrObservableList", data1.getActionId());
                    }
                });
        instance.register(
                "actionId-2-testHandleAttrObservableList",
                (event) -> {
                    Object source = event.getSource();
                    if (source instanceof TransferData) {
                        TransferData data2 = (TransferData) source;
                        assertEquals("actionId-2-testHandleAttrObservableList", data2.getActionId());
                    }
                });
        
        instance.handle(transferDatas);
    }

    @Test(expected = NullPointerException.class)
    public void testIsRegisteredAttrActionIdThrowsNullPointerException() {
        String actionId = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.isRegistered(actionId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsRegisteredAttrActionIdIllegalArgumentException() {
        String actionId = ""; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.isRegistered(actionId);
    }

    @Test
    public void testIsRegisteredTRUE() {
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-testIsRegisteredTRUE",
                (event) -> { }
        );
        
        boolean isRegistered = instance.isRegistered("actionId-testIsRegisteredTRUE");
        
        assertTrue(isRegistered);
    }

    @Test
    public void testIsRegisteredFALSE() {
        DefaultActionHandler instance = new DefaultActionHandler();
        boolean isRegistered = instance.isRegistered("actionId-testIsRegisteredFALSE");
        
        assertFalse(isRegistered);
    }

    @Test(expected = NullPointerException.class)
    public void testRegisterAttrActionIdThrowsNullPointerException() {
        String actionId = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                actionId,
                (event) -> { }
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRegisterAttrActionIdThrowsIllegalArgumentException() {
        String actionId = ""; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                actionId,
                (event) -> { }
        );
    }

    @Test(expected = NullPointerException.class)
    public void testRegisterAttrEventHandlerThrowsNullPointerException() {
        EventHandler<ActionEvent> eventHandler = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "valid-actionId",
                eventHandler
        );
    }

    @Test
    public void testRegister() {
        DefaultActionHandler instance = new DefaultActionHandler();
        boolean hasRegistered = instance.register(
                "valid-actionId",
                (event) -> { }
        );
        
        assertTrue(hasRegistered);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveAttrActionIdThrowsNullPointerException() {
        String actionId = null; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.remove(actionId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAttrActionIdThrowsIllegalArgumentException() {
        String actionId = ""; // <----------------------------
        
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.remove(actionId);
    }

    @Test
    public void testRemoveTRUE() {
        DefaultActionHandler instance = new DefaultActionHandler();
        instance.register(
                "actionId-Is-Previous-Registered",
                (event) -> { }
        );
        
        boolean isRemoved = instance.remove("actionId-Is-Previous-Registered");
        
        assertTrue(isRemoved);
    }

    @Test
    public void testRemoveFALSE() {
        DefaultActionHandler instance = new DefaultActionHandler();
        
        boolean isRemoved = instance.remove("actionId-Is-NOT-Previous-Registered");
        
        assertFalse(isRemoved);
    }
    
}
