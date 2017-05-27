/*
 * Copyright (C) 2016 Naoghuman
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

/**
 * The class {@link com.github.naoghuman.lib.action.api.TransferData} is a 
 * simple POJO to store optional values in an action.
 * <p>
 * For more information about how to use this class see the second example 
 * (https://github.com/Naoghuman/lib-action#HandleTransferData) in the ReadMe.md.
 *
 * @author Naoghuman
 * @deprecated Deprecated since 0.4.0. Will be replaced with {@link com.github.naoghuman.lib.action.core.TransferData}
 */
@Deprecated
public final class TransferData {
    
    private Boolean booleanParameter = Boolean.FALSE;
    private Character characterParameter;
    private Double doubleParameter = 0.0d;
    private Integer integerParameter = 0;
    private Long longParameter = 0l;
    private Object objectParameter = null;
    private String stringParameter = "";
    
    private String actionId = null;
    private String responseActionId = null;

    /**
     * Get a stored {@link java.lang.Boolean} value.
     * 
     * @return The stored <code>Boolean</code> value.
     */
    @Deprecated
    public Boolean getBoolean() {
        return booleanParameter;
    }

    /**
     * Set the {@link java.lang.Boolean} value.
     * 
     * @param value The <code>Boolean</code> value.
     */
    @Deprecated
    public void setBoolean(Boolean value) {
        this.booleanParameter = value;
    }

    /**
     * Get a stored {@link java.lang.Character} value.
     * 
     * @return The stored <code>Character</code> value.
     */
    @Deprecated
    public Character getCharacter() {
        return characterParameter;
    }

    /**
     * Set a {@link java.lang.Character} value.
     * 
     * @param value The <code>Character</code> value.
     */
    @Deprecated
    public void setCharacter(Character value) {
        this.characterParameter = value;
    }
    
    /**
     * Get the stored {@link java.lang.Double} value.
     * 
     * @return The stored <code>Double</code> value.
     */
    @Deprecated
    public Double getDouble() {
        return doubleParameter;
    }

    /**
     * Set a {@link java.lang.Double} value.
     * 
     * @param value The <code>Double</code> value.
     */
    @Deprecated
    public void setDouble(Double value) {
        this.doubleParameter = value;
    }

    /**
     * Get the stored {@link java.lang.Integer} value.
     * 
     * @return The stored <code>Integer</code> value.
     */
    @Deprecated
    public Integer getInteger() {
        return integerParameter;
    }

    /**
     * Set a {@link java.lang.Integer} value.
     * 
     * @param value The <code>Integer</code> value.
     */
    @Deprecated
    public void setInteger(Integer value) {
        this.integerParameter = value;
    }

    /**
     * Get the stored {@link java.lang.Long} value.
     * 
     * @return The stored <code>Long</code> value.
     */
    @Deprecated
    public Long getLong() {
        return longParameter;
    }

    /**
     * Set a {@link java.lang.Long} value.
     * 
     * @param value The <code>Long</code> value.
     */
    @Deprecated
    public void setLong(Long value) {
        this.longParameter = value;
    }

    /**
     * Get the stored {@link java.lang.String} value.
     * 
     * @return The stored <code>String</code> value.
     */
    @Deprecated
    public String getString() {
        return stringParameter;
    }

    /**
     * Set a {@link java.lang.String} value.
     * 
     * @param value The <code>String</code> value.
     */
    @Deprecated
    public void setString(String value) {
        this.stringParameter = value;
    }
    
    /**
     * Get the stored {@link java.lang.Object} value.
     * 
     * @return The stored <code>Object</code> value.
     */
    @Deprecated
    public Object getObject() {
        return objectParameter;
    }
    
    /**
     * Set a {@link java.lang.Object} value.
     * 
     * @param value The <code>Object</code> value.
     */
    @Deprecated
    public void setObject(Object value) {
        this.objectParameter = value;
    }
    
    /**
     * Get the <code>actionId</code>.
     * 
     * @return The <code>actionId</code>.
     */
    @Deprecated
    public String getActionId() {
        return actionId;
    }

    /**
     * Set an <code>actionId</code>.
     * 
     * @param actionId The <code>actionId</code>.
     */
    @Deprecated
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }
    
    /**
     * Get the <code>responseActionId</code>.
     * 
     * @return The <code>responseActionId</code>.
     */
    @Deprecated
    public String getResponseActionId() {
        return responseActionId;
    }

    /**
     * Set a <code>responseActionId</code>.
     * 
     * @param responseActionId The <code>responseActionId</code>.
     */
    @Deprecated
    public void setResponseActionKey(String responseActionId) {
        this.responseActionId = responseActionId;
    }
    
}
