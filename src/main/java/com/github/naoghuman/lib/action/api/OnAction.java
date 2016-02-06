/*
 * Copyright (C) 2016 PRo
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
 * Marks a <code>method</code> in a <code>class</code> as an <code>action</code>.
 * <p>
 * Access to the action will be happen through reflection during runtime.
 *
 * @author PRo
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface OnAction {
    
    /**
     * Define the <code>actionKey</code> which will triggers the marked method.
     * 
     * @return The actionKey. 
     */
    public String actionKey() default "";
    
}
