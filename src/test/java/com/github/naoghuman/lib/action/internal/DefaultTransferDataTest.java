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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class DefaultTransferDataTest {
    
    public DefaultTransferDataTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testCreateAttrActionIdThrowsNullPointerException() {
        String actionId          = null; // <---------------------
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttrActionIdThrowsIllegalArgumentException() {
        String actionId          = ""; // <---------------------
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttrResponseActionIdThrowsIllegalArgumentException() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = ""; // <---------------------
        boolean loggingDisabled  = false;
        
        DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
    }

    @Test
    public void testGetActionId() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertEquals("actionId", data.getActionId());
    }

    @Test
    public void testGetBoolean() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getBoolean().isPresent());
        assertEquals(true, data.getBoolean().get());
    }

    @Test
    public void testGetCharacter() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getCharacter().isPresent());
        assertTrue('c' == data.getCharacter().get());
    }

    @Test
    public void testGetDouble() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getDouble().isPresent());
        assertTrue(1.2d == data.getDouble().get());
    }

    @Test
    public void testGetInteger() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getInteger().isPresent());
        assertTrue(5 == data.getInteger().get());
    }

    @Test
    public void testGetLong() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getLong().isPresent());
        assertTrue(123L == data.getLong().get());
    }

    @Test
    public void testGetObject() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getObject().isPresent());
        assertEquals("hello", data.getObject().get());
    }

    @Test
    public void testGetString() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getString().isPresent());
        assertEquals("stringValue", data.getString().get());
    }

    @Test
    public void testGetResponseActionId() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertTrue(data.getResponseActionId().isPresent());
        assertEquals("responseActionId", data.getResponseActionId().get());
    }

    @Test
    public void testIsLoggingDisabled() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        assertFalse(data.isLoggingDisabled());
    }

    @Test
    public void testToString() {
        String actionId          = "actionId";
        Boolean booleanValue     = true;
        Character characterValue = 'c';
        Double doubleValue       = 1.2d;
        Integer integerValue     = 5;
        Long longValue           = 123L;
        Object objectValue       = "hello";
        String stringValue       = "stringValue";
        String responseActionId  = "responseActionId";
        boolean loggingDisabled  = false;
        
        TransferData data = DefaultTransferData.create(actionId, booleanValue, characterValue, doubleValue, integerValue, longValue, objectValue, stringValue, responseActionId, loggingDisabled);
        String expected = "TransferData ["
                + "[actionId=true], "
                + "[loggingDisabled=false], "
                + "[Boolean=true], "
                + "[Character=c], "
                + "[Double=1.2], "
                + "[Integer=5], "
                + "[Object=hello], "
                + "[String=stringValue], "
                + "[responseActionId=responseActionId]]";
        assertEquals(expected, data.toString());
    }
    
}
