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
 * simple POJO to store optional parameters in an action.
 * <p>
 * For more information see the ReadMe.md (at the end of the section examples).
 *
 * @author Naoghuman
 */
public class TransferData {
    
    public static final TransferData EMPTY = null;
    
    private Boolean booleanParameter = Boolean.FALSE;
    private Character characterParameter;
    private Double doubleParameter = 0.0d;
    private Integer integerParameter = 0;
    private Long longParameter = 0l;
    private Object objectParameter = null;
    private String stringParameter = "";
    
    private String id = null;
    private String responseId = null;

    /**
     * Get the stored {@link java.lang.Boolean} parameter.
     * 
     * @return The stored <code>Boolean</code> parameter.
     */
    public Boolean getBoolean() {
        return booleanParameter;
    }

    /**
     * Set the {@link java.lang.Boolean} parameter.
     * 
     * @param booleanParameter The <code>Boolean</code> parameter.
     */
    public void setBoolean(Boolean booleanParameter) {
        this.booleanParameter = booleanParameter;
    }

    /**
     * Get the stored {@link java.lang.Character} parameter.
     * 
     * @return The stored <code>Character</code> parameter.
     */
    public Character getCharacter() {
        return characterParameter;
    }

    /**
     * Set the {@link java.lang.Character} parameter.
     * 
     * @param characterParameter The <code>Character</code> parameter.
     */
    public void setCharacter(Character characterParameter) {
        this.characterParameter = characterParameter;
    }
    
    /**
     * Get the stored {@link java.lang.Double} parameter.
     * 
     * @return The stored <code>Double</code> parameter.
     */
    public Double getDouble() {
        return doubleParameter;
    }

    /**
     * Set the {@link java.lang.Double} parameter.
     * 
     * @param doubleParameter The <code>Double</code> parameter.
     */
    public void setDouble(Double doubleParameter) {
        this.doubleParameter = doubleParameter;
    }

    /**
     * Get the stored {@link java.lang.Integer} parameter.
     * 
     * @return The stored <code>Integer</code> parameter.
     */
    public Integer getInteger() {
        return integerParameter;
    }

    /**
     * Set the {@link java.lang.Integer} parameter.
     * 
     * @param integerParameter The <code>Integer</code> parameter.
     */
    public void setInteger(Integer integerParameter) {
        this.integerParameter = integerParameter;
    }

    /**
     * Get the stored {@link java.lang.Long} parameter.
     * 
     * @return The stored <code>Long</code> parameter.
     */
    public Long getLong() {
        return longParameter;
    }

    /**
     * Set the {@link java.lang.Long} parameter.
     * 
     * @param longParameter The <code>Long</code> parameter.
     */
    public void setLong(Long longParameter) {
        this.longParameter = longParameter;
    }

    /**
     * Get the stored {@link java.lang.String} parameter.
     * 
     * @return The stored <code>String</code> parameter.
     */
    public String getString() {
        return stringParameter;
    }

    /**
     * Set the {@link java.lang.String} parameter.
     * 
     * @param stringParameter The <code>String</code> parameter.
     */
    public void setString(String stringParameter) {
        this.stringParameter = stringParameter;
    }
    
    /**
     * Get the stored {@link java.lang.Object} parameter.
     * 
     * @return The stored <code>Object</code> parameter.
     */
    public Object getObject() {
        return objectParameter;
    }
    
    /**
     * Set the {@link java.lang.Object} parameter.
     * 
     * @param objectParameter The <code>Object</code> parameter.
     */
    public void setObject(Object objectParameter) {
        this.objectParameter = objectParameter;
    }
    
    /**
     * Get the <code>id</code>.
     * 
     * @return The <code>id</code>.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the <code>id</code>.
     * 
     * @param id The <code>id</code>.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Get the <code>responce id</code>.
     * 
     * @return The <code>responce id</code>.
     */
    public String getResponseId() {
        return responseId;
    }

    /**
     * Set the <code>responce id</code>.
     * 
     * @param responseId The <code>responce id</code>.
     */
    public void setResponseActionKey(String responseId) {
        this.responseId = responseId;
    }
    
}
