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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Naoghuman
 * @since  0.6.0
 */
public class TransferDataBuilderTest {
    
    public TransferDataBuilderTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = NullPointerException.class)
    public void testCreateAttrActionIdThrowsNullPointerException() {
        TransferDataBuilder.create()
                .actionId(null) // <---------------------
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttrActionIdThrowsIllegalArgumentException() {
        TransferDataBuilder.create()
                .actionId("") // <---------------------
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testCreateAttrResponseActionIdThrowsNullPointerException() {
        TransferDataBuilder.create()
                .actionId("actionId")
                .responseActionId(null) // <---------------------
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAttrResponseActionIdThrowsIllegalArgumentException() {
        TransferDataBuilder.create()
                .actionId("actionId")
                .responseActionId("") // <---------------------
                .build();
    }

    @Test
    public void testCreateAttrActionId() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .build();
        
        assertEquals("actionId", result.getActionId());
    }

    @Test
    public void testCreateAttrBoolean() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .booleanValue(Boolean.FALSE)
                .build();
        
        assertTrue(result.getBoolean().isPresent());
        assertFalse(result.getBoolean().get());
    }

    @Test
    public void testCreateAttrCharacter() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .characterValue('a')
                .build();
        
        assertTrue(result.getCharacter().isPresent());
        assertTrue('a' == result.getCharacter().get());
    }

    @Test
    public void testCreateAttrDouble() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .doubleValue(1.24d)
                .build();
        
        assertTrue(result.getDouble().isPresent());
        assertTrue(1.24d == result.getDouble().get());
    }

    @Test
    public void testCreateAttrInteger() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .integerValue(5)
                .build();
        
        assertTrue(result.getInteger().isPresent());
        assertTrue(5 == result.getInteger().get());
    }

    @Test
    public void testCreateAttrLong() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .longValue(99L)
                .build();
        
        assertTrue(result.getLong().isPresent());
        assertTrue(99L == result.getLong().get());
    }

    @Test
    public void testCreateAttrObject() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .objectValue("hello")
                .build();
        
        assertTrue(result.getObject().isPresent());
        assertEquals("hello", result.getObject().get());
    }

    @Test
    public void testCreateAttrString() {
        TransferData result = TransferDataBuilder.create()
                .actionId("actionId")
                .stringValue("world")
                .build();
        
        assertTrue(result.getString().isPresent());
        assertEquals("world", result.getString().get());
    }
    
}
