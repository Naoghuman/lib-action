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
 * The {@code Implementation} from the {@code Interface} {@link com.github.naoghuman.lib.action.core.TransferData}.<br>
 * This {@code Implementation} is a simple readonly POJO. All attributes (expected {@code actionId}) 
 * are optional, which means if the xy attribute is not set then an {@link java.util.Optional#empty()} 
 * will instead returned.
 * <p>
 * An instance from this class can be generated with the fluent builder 
 * {@link com.github.naoghuman.lib.action.core.TransferDataBuilder}.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.action.core.TransferDataBuilder
 * @see    java.util.Optional
 */
public final class DefaultTransferData implements TransferData {
    
    /**
     * Factory method to create an instance from the interface 
     * {@link com.github.naoghuman.lib.action.core.TransferData}.
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
     * @param loggingDisabled  flag which dicides if the {@code TransferData} should be
     *                         logged during the {@link javafx.event.ActionEvent} or not.
     * @return                 an instance from the {@code Interface} {@code TransferData}.
     * @see                    com.github.naoghuman.lib.action.core.TransferData
     * @see                    java.util.Optional
     * @see                    javafx.event.ActionEvent
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
            final String    responseActionId,
            final boolean   loggingDisabled
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
                responseActionId,
                loggingDisabled);
    }
    
    private final boolean loggingDisabled;
    
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
            final String    responseActionId,
            final boolean   loggingDisabled
    ) {
        DefaultValidator.getDefault().requireNonNullAndNotEmpty(actionId);
        this.actionId = actionId;
        
        this.booleanValue     = Optional.ofNullable(booleanValue);
        this.characterValue   = Optional.ofNullable(characterValue);
        this.doubleValue      = Optional.ofNullable(doubleValue);
        this.integerValue     = Optional.ofNullable(integerValue);
        this.longValue        = Optional.ofNullable(longValue);
        this.objectValue      = Optional.ofNullable(objectValue);
        this.stringValue      = Optional.ofNullable(stringValue);
        this.responseActionId = Optional.ofNullable(responseActionId);
        
        this.loggingDisabled   = loggingDisabled;
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

    @Override
    public boolean isLoggingDisabled() {
        return loggingDisabled;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("TransferData ["); // NOI18N
        sb.append("[actionId=").append(booleanValue.get().toString()).append("]"); // NOI18N
        sb.append(", [loggingDisabled=").append(String.valueOf(loggingDisabled)).append("]"); // NOI18N
        
        if (booleanValue.isPresent()) {
            sb.append(", [Boolean=").append(String.valueOf(booleanValue.get())).append("]"); // NOI18N
        }
        if (characterValue.isPresent()) {
            sb.append(", [Character=").append(String.valueOf(characterValue.get())).append("]"); // NOI18N
        }
        if (doubleValue.isPresent()) {
            sb.append(", [Double=").append(String.valueOf(doubleValue.get())).append("]"); // NOI18N
        }
        if (integerValue.isPresent()) {
            sb.append(", [Integer=").append(String.valueOf(integerValue.get())).append("]"); // NOI18N
        }
        if (objectValue.isPresent()) {
            sb.append(", [Object=").append(String.valueOf(objectValue.get())).append("]"); // NOI18N
        }
        if (stringValue.isPresent()) {
            sb.append(", [String=").append(stringValue.get()).append("]"); // NOI18N
        }
        if (responseActionId.isPresent()) {
            sb.append(", [responseActionId=").append(responseActionId.get()).append("]"); // NOI18N
        }
        sb.append("]"); // NOI18N
        
        return sb.toString();
    }
    
}
