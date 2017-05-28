/**
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
package com.github.naoghuman.lib.action.core;

import com.github.naoghuman.lib.action.internal.DefaultTransferData;
import com.github.naoghuman.lib.action.internal.DefaultTransferDataValidator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

/**
 * With the builder class {@link com.github.naoghuman.lib.action.core.TransferDataBuilder} 
 * the developer can create an implementation from the interface 
 * {@link com.github.naoghuman.lib.action.core.TransferData}.
 * <ul>
 * <li>The first attribute <code>actionId</code> is mandory to identify the associated 
 * {@link javafx.event.EventHandler}.</li>
 * <li>All other attributes are optional, that means skipping them returned 
 * {@link java.util.Optional#empty()}</li>
 * </ul>
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.TransferData
 * @see    com.github.naoghuman.lib.action.core.TransferDataBuilder
 * @see    java.util.Optional
 * @see    javafx.event.EventHandler
 */
public final class TransferDataBuilder {
    
    /**
     * Starts the generation from an implementation from the interface 
     * {@link com.github.naoghuman.lib.action.core.TransferData}.
     * 
     * @return the first step ActionIdStep.
     * @see    com.github.naoghuman.lib.action.core.TransferData
     */
    public static final ActionIdStep create() {
        return new TransferDataBuilderImpl();
    }
    
    /**
     * First step interface <code>ActionIdStep</code>.
     */
    public interface ActionIdStep {
        
        /**
         * Let the developer set the attribute <code>actionId</code> which is 
         * associated with an {@link javafx.event.EventHandler}.
         * <p>
         * This attribute is mandory and must not <code>NULL</code> && not <code>EMPTY</code>.
         * 
         * @param  actionId identifier for the associated EventHandler.
         * @return The next <code>Step</code> interface.
         * @see    javafx.event.EventHandler
         */
        public Step actionId(final String actionId);
    }
    
    /**
     * The interface Step contains all optional attributes in the interface 
     * {@link com.github.naoghuman.lib.action.core.TransferData} expected the 
     * last method <code>build()</code> in the chain which builds an implementation 
     * from the interface <code>TransferData</code>.
     * 
     * @see com.github.naoghuman.lib.action.core.TransferData
     */
    public interface Step {
        
        /**
         * Let the developer define an optional {@link java.lang.Boolean} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Boolean</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Boolean
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step booleanValue(final Boolean value);
        
        /**
         * Let the developer define an optional {@link java.lang.Character} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Character</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Character
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step characterValue(final Character value);
        
        /**
         * Let the developer define an optional {@link java.lang.Double} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Double</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Double
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step doubleValue(final Double value);
        
        /**
         * Let the developer define an optional {@link java.lang.Integer} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Integer</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Integer
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step integerValue(final Integer value);
        
        /**
         * Let the developer define an optional {@link java.lang.Long} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Long</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Long
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step longValue(final Long value);
        
        /**
         * Let the developer define an optional {@link java.lang.Object} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>Object</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.Object
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step objectValue(final Object value);
        
        /**
         * Let the developer define an optional {@link java.lang.String} attribute <code>value</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code> or <code>EMPTY</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  value The <code>String</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.String
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step stringValue(final String value);
        
        /**
         * Let the developer define an optional {@link java.lang.String} attribute <code>responseActionId</code>. 
         * <ul>
         * <li>If set then the attribute can't be <code>NULL</code> or <code>EMPTY</code>.</li>
         * <li>If this method is used more then ones, then the last usage will be stored for the generation 
         * from the implementation.</li>
         * <li>If not set then the implementation from {@link com.github.naoghuman.lib.action.core.TransferData}
         * will returned {@link java.util.Optional#empty()}.
         * </ul>
         * 
         * @param  responseActionId The <code>String</code> value which should be stored.
         * @return The next <code>Step</code> interface.
         * @see    java.lang.String
         * @see    java.util.Optional
         * @see    com.github.naoghuman.lib.action.core.TransferData
         */
        public Step responseActionId(final String responseActionId);
        
        /**
         * Returns an implementation from the interface {@link com.github.naoghuman.lib.action.core.TransferData}.
         * 
         * @return an implementation from the interface <code>TransferData</code>.
         * 
         * @see com.github.naoghuman.lib.action.core.TransferData
         */
        public TransferData build();
    }
    
    private static final class TransferDataBuilderImpl implements ActionIdStep, Step
    {
        private static final String ATTR__ACTION_ID          = "actionId";         // NOI18N
        private static final String ATTR__BOOLEAN_VALUE      = "booleanValue";     // NOI18N
        private static final String ATTR__CHARACTER_VALUE    = "characterValue";   // NOI18N
        private static final String ATTR__DOUBLE_VALUE       = "doubleValue";      // NOI18N
        private static final String ATTR__INTERGER_VALUE     = "integerValue";     // NOI18N
        private static final String ATTR__LONG_VALUE         = "longValue";        // NOI18N
        private static final String ATTR__OBJECT_VALUE       = "objectValue";      // NOI18N
        private static final String ATTR__STRING_VALUE       = "stringValue";      // NOI18N
        private static final String ATTR__RESPONSE_ACTION_ID = "responseActionId"; // NOI18N
    
        @SuppressWarnings("rawtypes")
        private final ObservableMap<String, Property> properties = FXCollections.observableHashMap();

        private TransferDataBuilderImpl() {
            this.init();
        }

        private void init() {
            properties.put(ATTR__ACTION_ID,          new SimpleStringProperty());
            properties.put(ATTR__BOOLEAN_VALUE,      new SimpleBooleanProperty());
            properties.put(ATTR__CHARACTER_VALUE,    new SimpleObjectProperty());
            properties.put(ATTR__DOUBLE_VALUE,       new SimpleDoubleProperty());
            properties.put(ATTR__INTERGER_VALUE,     new SimpleIntegerProperty());
            properties.put(ATTR__LONG_VALUE,         new SimpleLongProperty());
            properties.put(ATTR__OBJECT_VALUE,       new SimpleObjectProperty());
            properties.put(ATTR__STRING_VALUE,       new SimpleStringProperty());
            properties.put(ATTR__RESPONSE_ACTION_ID, new SimpleStringProperty());
        }

        @Override
        public Step actionId(final String actionId) {
            DefaultTransferDataValidator.getDefault().requireNonNullAndNotEmpty(actionId);
            
            properties.put(ATTR__ACTION_ID, new SimpleStringProperty(actionId));
            
            return this;
        }

        @Override
        public Step booleanValue(final Boolean value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__BOOLEAN_VALUE, new SimpleBooleanProperty(value));
            
            return this;
        }

        @Override
        public Step characterValue(final Character value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__CHARACTER_VALUE, new SimpleObjectProperty(value));
            
            return this;
        }

        @Override
        public Step doubleValue(final Double value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__DOUBLE_VALUE, new SimpleDoubleProperty(value));
            
            return this;
        }

        @Override
        public Step integerValue(final Integer value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__INTERGER_VALUE, new SimpleIntegerProperty(value));
            
            return this;
        }

        @Override
        public Step longValue(final Long value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__LONG_VALUE, new SimpleLongProperty(value));
            
            return this;
        }

        @Override
        public Step objectValue(final Object value) {
            DefaultTransferDataValidator.getDefault().requireNonNull(value);
            
            properties.put(ATTR__OBJECT_VALUE, new SimpleObjectProperty(value));
            
            return this;
        }

        @Override
        public Step stringValue(final String value) {
            DefaultTransferDataValidator.getDefault().requireNonNullAndNotEmpty(value);
            
            properties.put(ATTR__STRING_VALUE, new SimpleStringProperty(value));
            
            return this;
        }

        @Override
        public Step responseActionId(final String responseActionId) {
            DefaultTransferDataValidator.getDefault().requireNonNullAndNotEmpty(responseActionId);
            
            properties.put(ATTR__RESPONSE_ACTION_ID, new SimpleStringProperty(responseActionId));
            
            return this;
        }

        @Override
        public TransferData build() {
            // Catch data
            final StringProperty actionId         = (StringProperty) properties.get(ATTR__ACTION_ID);
            final BooleanProperty booleanValue    = (BooleanProperty) properties.get(ATTR__BOOLEAN_VALUE);
            final ObjectProperty characterValue   = (ObjectProperty) properties.get(ATTR__CHARACTER_VALUE);
            final DoubleProperty  doubleValue     = (DoubleProperty) properties.get(ATTR__DOUBLE_VALUE);
            final IntegerProperty  integerValue   = (IntegerProperty) properties.get(ATTR__INTERGER_VALUE);
            final LongProperty longValue          = (LongProperty) properties.get(ATTR__LONG_VALUE);
            final ObjectProperty objectValue      = (ObjectProperty) properties.get(ATTR__OBJECT_VALUE);
            final StringProperty stringValue      = (StringProperty) properties.get(ATTR__STRING_VALUE);
            final StringProperty responseActionId = (StringProperty) properties.get(ATTR__RESPONSE_ACTION_ID);
            
            // Create a new TransferData
            return DefaultTransferData.create(
                    actionId.getValue(),
                    booleanValue.getValue(),
                    (Character)characterValue.getValue(), // TODO add unittest
                    doubleValue.getValue(),
                    integerValue.getValue(),
                    longValue.getValue(),
                    objectValue.getValue(),
                    stringValue.getValue(),
                    responseActionId.getValue());
        }
        
    }
    
}
