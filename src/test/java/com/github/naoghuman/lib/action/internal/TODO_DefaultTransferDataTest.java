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
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class TODO_DefaultTransferDataTest {
    
    public TODO_DefaultTransferDataTest() {
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

//    @Test
//    public void testGetActionId() {
//        System.out.println("getActionId");
//        DefaultTransferData instance = null;
//        String expResult = "";
//        String result = instance.getActionId();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetBoolean() {
//        System.out.println("getBoolean");
//        DefaultTransferData instance = null;
//        Optional<Boolean> expResult = null;
//        Optional<Boolean> result = instance.getBoolean();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetCharacter() {
//        System.out.println("getCharacter");
//        DefaultTransferData instance = null;
//        Optional<Character> expResult = null;
//        Optional<Character> result = instance.getCharacter();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetDouble() {
//        System.out.println("getDouble");
//        DefaultTransferData instance = null;
//        Optional<Double> expResult = null;
//        Optional<Double> result = instance.getDouble();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetInteger() {
//        System.out.println("getInteger");
//        DefaultTransferData instance = null;
//        Optional<Integer> expResult = null;
//        Optional<Integer> result = instance.getInteger();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetLong() {
//        System.out.println("getLong");
//        DefaultTransferData instance = null;
//        Optional<Long> expResult = null;
//        Optional<Long> result = instance.getLong();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetObject() {
//        System.out.println("getObject");
//        DefaultTransferData instance = null;
//        Optional<Object> expResult = null;
//        Optional<Object> result = instance.getObject();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetResponseActionId() {
//        System.out.println("getResponseActionId");
//        DefaultTransferData instance = null;
//        Optional<String> expResult = null;
//        Optional<String> result = instance.getResponseActionId();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testGetString() {
//        System.out.println("getString");
//        DefaultTransferData instance = null;
//        Optional<String> expResult = null;
//        Optional<String> result = instance.getString();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testIsLoggingDisabled() {
//        System.out.println("isLoggingDisabled");
//        DefaultTransferData instance = null;
//        boolean expResult = false;
//        boolean result = instance.isLoggingDisabled();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        DefaultTransferData instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}
