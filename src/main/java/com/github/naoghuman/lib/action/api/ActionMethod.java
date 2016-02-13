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
 * Marks a <code>method</code> as an <code>action</code> method.
 * <p>
 * The marked action method will be only registered if the <code>class</code> 
 * which contains the marked method is registered with the annotation 
 * {@link com.github.naoghuman.lib.action.api.AnnotatedClass }. The registration 
 * should be happen during starttime through the method 
 * {@link com.github.naoghuman.lib.action.api.ActionFacade#scan() }.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.action.api.AnnotatedClass
 * @see com.github.naoghuman.lib.action.api.ActionFacade#scan()
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface ActionMethod {
    
    /**
     * Define the <code>id</code> for the marked action method.
     * 
     * @return The unique id. 
     */
    public String id() default "unique-id"; // NOI18N
    
}
