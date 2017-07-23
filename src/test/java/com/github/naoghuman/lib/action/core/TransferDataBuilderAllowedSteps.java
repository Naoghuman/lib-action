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
package com.github.naoghuman.lib.action.core;

import java.awt.Point;

/**
 *
 * @author Naoghuman
 */
public class TransferDataBuilderAllowedSteps {
    
    TransferDataBuilderAllowedSteps() {
        
        /*
        The TransferDataBuilder creates an TransferData which can be used to store
        additional data in an ActionEvent.
         - The attribute 'actionId' is mandory. The attribute is needed to identify
           the associated EventHandler which fires the ActionEvent.
         - All other attributes are optional. If not set then Optional<T>.empty()
           will returned.
         - Exception is the method 'disableLogging()' which allowed the developer
           to disable the logging from the 'TransferData' during the ActionEvent.
        */
        final TransferData transferData = TransferDataBuilder.create()
                .actionId("actionId")                 // mandory (NOT NULL && NOT EMPTY)
                .disableLogging()                     // optional (if used, then the logging is disabled)
                .booleanValue(Boolean.FALSE)          // optional
                .characterValue(Character.MIN_VALUE)  // optional
                .doubleValue(Double.NaN)              // optional
                .integerValue(Integer.MIN_VALUE)      // optional
                .longValue(Long.MIN_VALUE)            // optional
                .objectValue(new Point())             // optional
                .stringValue("value")                 // optional
                .responseActionId("responseActionId") // optional
                .build();
        
        /*
        Examples from diffrent combinations with the builder.
         - The mandory attribute 'actionId' is the first attribute after the 
           method create().
         - The sequence from all optinal attributes aren't fixed.
         - If one optional attribute used twice or more then the last usage will 
           be stored.
        */
        TransferDataBuilder.create().actionId("actionId").build();
        TransferDataBuilder.create().actionId("actionId").longValue(0L).build();
        TransferDataBuilder.create().actionId("actionId").disableLogging().integerValue(1).longValue(0L).build();
        TransferDataBuilder.create().actionId("actionId").disableLogging().integerValue(1).booleanValue(Boolean.FALSE).build();
        
    }
    
}
