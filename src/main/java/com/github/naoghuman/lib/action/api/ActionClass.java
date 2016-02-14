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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a <code>class</code> as a class which contains action methods which must 
 * be marked with the annotation {@link com.github.naoghuman.lib.action.api.ActionMethod }.
 * <p>
 * Only classes which are marked with this annotation will be scaned for 
 * action methods. The registration from all action methods should be happen 
 * during starttime through the method {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 * @see com.github.naoghuman.lib.action.api.ActionMethod
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
public @interface ActionClass {
    
}
