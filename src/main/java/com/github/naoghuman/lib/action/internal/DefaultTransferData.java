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

import com.github.naoghuman.lib.action.core.TransferData;
import java.util.Optional;

/**
 * The implementation from the interface {@link com.github.naoghuman.lib.action.core.TransferData}.<br>
 * This implementation is a simple readonly POJO. All attributes (expected <code>actionId</code>) 
 * are optional, which means if the xy attribute is not set then an {@link java.util.Optional#empty()} 
 * will instead returned.
 * <p>
 * An instance from this calss can be generated with the builder 
 * {@link com.github.naoghuman.lib.action.core.TransferDataBuilder}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.action.core.TransferDataBuilder
 * @see    java.util.Optional
 */
public final class DefaultTransferData implements TransferData {
    
    /**
     * Factory method to create an instance from the interface {@link com.github.naoghuman.lib.action.core.TransferData}.
     * 
     * @param actionId         mandory attribute which can't be NULL or EMPTY.
     * @param booleanValue     optional attribute, if set then can't be NULL.
     * @param characterValue   optional attribute, if set then can't be NULL.
     * @param doubleValue      optional attribute, if set then can't be NULL.
     * @param integerValue     optional attribute, if set then can't be NULL.
     * @param longValue        optional attribute, if set then can't be NULL.
     * @param objectValue      optional attribute, if set then can't be NULL.
     * @param stringValue      optional attribute, if set then can't be NULL or EMPTY.
     * @param responseActionId optional attribute, if set then can't be NULL or EMPTY.
     * @return                 an instance from the interface <code>TransferData</code>.
     * @see                    com.github.naoghuman.lib.action.core.TransferData
     * @see                    java.util.Optional
     */
    public static final TransferData create(
            final String actionId,
            final Boolean   booleanValue,
            final Character characterValue,
            final Double    doubleValue,
            final Integer   integerValue,
            final Long      longValue,
            final Object    objectValue,
            final String    stringValue,
            final String    responseActionId
    ) {
        return new DefaultTransferData(
                actionId,
                booleanValue,
                characterValue,
                doubleValue,
                integerValue,
                longValue,
                objectValue,
                stringValue,
                responseActionId);
    }
    
    private final Optional<Boolean>   booleanValue;
    private final Optional<Character> characterValue;
    private final Optional<Double>    doubleValue;
    private final Optional<Integer>   integerValue;
    private final Optional<Long>      longValue;
    private final Optional<Object>    objectValue;
    private final Optional<String>    stringValue;
    private final Optional<String>    responseActionId;
    
    private final String actionId;
    
    private DefaultTransferData(
            final String actionId,
            final Boolean   booleanValue,
            final Character characterValue,
            final Double    doubleValue,
            final Integer   integerValue,
            final Long      longValue,
            final Object    objectValue,
            final String    stringValue,
            final String    responseActionId
    ) {
        DefaultTransferDataValidator.getDefault().requireNonNullAndNotEmpty(actionId);
        this.actionId = actionId;
        
        this.booleanValue     = (booleanValue     != null) ? Optional.ofNullable(booleanValue)     : Optional.empty();
        this.characterValue   = (characterValue   != null) ? Optional.ofNullable(characterValue)   : Optional.empty();
        this.doubleValue      = (doubleValue      != null) ? Optional.ofNullable(doubleValue)      : Optional.empty();
        this.integerValue     = (integerValue     != null) ? Optional.ofNullable(integerValue)     : Optional.empty();
        this.longValue        = (longValue        != null) ? Optional.ofNullable(longValue)        : Optional.empty();
        this.objectValue      = (objectValue      != null) ? Optional.ofNullable(objectValue)      : Optional.empty();
        this.stringValue      = (stringValue      != null) ? Optional.ofNullable(stringValue)      : Optional.empty();
        this.responseActionId = (responseActionId != null) ? Optional.ofNullable(responseActionId) : Optional.empty();
    }

    @Override
    public String getActionId() {
        return actionId;
    }

    @Override
    public Optional<Boolean> getBoolean() {
        return booleanValue;
    }

    @Override
    public Optional<Character> getCharacter() {
        return characterValue;
    }

    @Override
    public Optional<Double> getDouble() {
        return doubleValue;
    }

    @Override
    public Optional<Integer> getInteger() {
        return integerValue;
    }

    @Override
    public Optional<Long> getLong() {
        return longValue;
    }

    @Override
    public Optional<Object> getObject() {
        return objectValue;
    }

    @Override
    public Optional<String> getResponseActionId() {
        return responseActionId;
    }

    @Override
    public Optional<String> getString() {
        return stringValue;
    }
    
}
