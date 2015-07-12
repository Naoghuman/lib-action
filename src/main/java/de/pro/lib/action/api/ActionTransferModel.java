/*
 * Copyright (C) 2015 PRo
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

/**
 * The class <code>ActionTransferModel</code> is a simple POJO to store optional
 * parameters in an action. For more information see the Interface 
 * <code>de.pro.lib.action.api.ILibAction</code> and/or the ReadMe.md (at the end 
 * of the section examples).
 *
 * @author PRo
 * @see ILibAction#handle(de.pro.lib.action.api.TransferModel) 
 */
public class ActionTransferModel {
    
    private Boolean booleanParameter = Boolean.FALSE;
    private Double doubleParameter = 0.0d;
    private Integer integerParameter = 0;
    private Long longParameter = 0l;
    private Object objectParameter = null;
    private String stringParameter = "";
    
    private String actionKey = null;
    private String responseActionKey = null;

    /**
     * Get the stored <code>Boolean</code> parameter.
     * 
     * @return The stored <code>Boolean</code> parameter.
     */
    public Boolean getBoolean() {
        return booleanParameter;
    }

    /**
     * Set the <code>Boolean</code> parameter.
     * 
     * @param booleanParameter The <code>Boolean</code> parameter.
     */
    public void setBoolean(Boolean booleanParameter) {
        this.booleanParameter = booleanParameter;
    }

    /**
     * Get the stored <code>Double</code> parameter.
     * 
     * @return The stored <code>Double</code> parameter.
     */
    public Double getDouble() {
        return doubleParameter;
    }

    /**
     * Set the <code>Double</code> parameter.
     * 
     * @param doubleParameter The <code>Double</code> parameter.
     */
    public void setDouble(Double doubleParameter) {
        this.doubleParameter = doubleParameter;
    }

    /**
     * Get the stored <code>Integer</code> parameter.
     * 
     * @return The stored <code>Integer</code> parameter.
     */
    public Integer getInteger() {
        return integerParameter;
    }

    /**
     * Set the <code>Integer</code> parameter.
     * 
     * @param integerParameter The <code>Integer</code> parameter.
     */
    public void setInteger(Integer integerParameter) {
        this.integerParameter = integerParameter;
    }

    /**
     * Get the stored <code>Long</code> parameter.
     * 
     * @return The stored <code>Long</code> parameter.
     */
    public Long getLong() {
        return longParameter;
    }

    /**
     * Set the <code>Long</code> parameter.
     * 
     * @param longParameter The <code>Long</code> parameter.
     */
    public void setLong(Long longParameter) {
        this.longParameter = longParameter;
    }

    /**
     * Get the stored <code>String</code> parameter.
     * 
     * @return The stored <code>String</code> parameter.
     */
    public String getString() {
        return stringParameter;
    }

    /**
     * Set the <code>String</code> parameter.
     * 
     * @param stringParameter The <code>String</code> parameter.
     */
    public void setString(String stringParameter) {
        this.stringParameter = stringParameter;
    }
    
    /**
     * Get the stored <code>Object</code> parameter.
     * 
     * @return The stored <code>Object</code> parameter.
     */
    public Object getObject() {
        return objectParameter;
    }
    
    /**
     * Set the <code>Object</code> parameter.
     * 
     * @param objectParameter The <code>Object</code> parameter.
     */
    public void setObject(Object objectParameter) {
        this.objectParameter = objectParameter;
    }
    
    /**
     * Get the <code>action key</code>.
     * 
     * @return The <code>action key</code>.
     */
    public String getActionKey() {
        return actionKey;
    }

    /**
     * Set the <code>action key</code>.
     * 
     * @param actionKey The <code>action key</code>.
     */
    public void setActionKey(String actionKey) {
        this.actionKey = actionKey;
    }
    
    /**
     * Get the <code>responce action key</code>.
     * 
     * @return The <code>responce action key</code>.
     */
    public String getResponseActionKey() {
        return responseActionKey;
    }

    /**
     * Set the <code>responce action key</code>.
     * 
     * @param responseActionKey The <code>responce action key</code>.
     */
    public void setResponseActionKey(String responseActionKey) {
        this.responseActionKey = responseActionKey;
    }

}
