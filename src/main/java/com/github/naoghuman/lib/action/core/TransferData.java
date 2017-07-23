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

import java.util.Optional;

/**
 * The interface {@link com.github.naoghuman.lib.action.core.TransferData} is a 
 * simple readonly POJO to store optional values in an {@link javafx.event.ActionEvent}.
 * An implementation from this interface can be generated with the builder class 
 * {@link com.github.naoghuman.lib.action.core.TransferDataBuilder}.<br>
 * All optional attributes if not set will returned {@link java.util.Optional#empty()}.
 * <p>
 * For additional information how to use the {@code TransferDataBuilder}
 * plz see 'TODO add link to example in readme'.
 *
 * @author Naoghuman
 * @see    com.github.naoghuman.lib.action.core.TransferDataBuilder
 * @see    java.util.Optional
 * @see    javafx.event.ActionEvent
 */
public interface TransferData {

    /**
     * Get the stored {@link java.lang.String} {@code actionId}.
     * 
     * @return The {@code actionId}.
     * @see    java.lang.String
     */
    public String getActionId();

    /**
     * Get a stored {@link java.lang.Boolean} {@code value} as an {@link java.util.Optional}.
     * 
     * @return The stored value as an Optional&lt;Boolean&gt; or Optional.empty().
     * @see    java.lang.Boolean
     * @see    java.util.Optional
     */
    public Optional<Boolean> getBoolean();

    /**
     * Get a stored {@link java.lang.Character} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;Character&gt; or Optional.empty().
     * @see    java.lang.Character
     * @see    java.util.Optional
     */
    public Optional<Character> getCharacter();

    /**
     * Get the stored {@link java.lang.Double} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;Double&gt; or Optional.empty().
     * @see    java.lang.Double
     * @see    java.util.Optional
     */
    public Optional<Double> getDouble();

    /**
     * Get the stored {@link java.lang.Integer} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;Integer&gt; or Optional.empty().
     * @see    java.lang.Integer
     * @see    java.util.Optional
     */
    public Optional<Integer> getInteger();

    /**
     * Get the stored {@link java.lang.Long} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;Long&gt; or Optional.empty().
     * @see    java.lang.Long
     * @see    java.util.Optional
     */
    public Optional<Long> getLong();

    /**
     * Get the stored {@link java.lang.Object} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;Object&gt; or Optional.empty().
     * @see    java.lang.Object
     * @see    java.util.Optional
     */
    public Optional<Object> getObject();

    /**
     * Get the stored {@link java.lang.String} {@code value} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;String&gt; or Optional.empty().
     * @see    java.lang.String
     * @see    java.util.Optional
     */
    public Optional<String> getString();

    /**
     * Get the stored {@link java.lang.String} {@code responseActionId} as an {@link java.util.Optional}.
     *
     * @return The stored value as an Optional&lt;String&gt; or Optional.empty().
     * @see    java.lang.String
     * @see    java.util.Optional
     */
    public Optional<String> getResponseActionId();
    
    /**
     * This flag allowed the developer to verify if the logging from the 
     * {@link com.github.naoghuman.lib.action.core.TransferData} during the 
     * {@link javafx.event.ActionEvent} is disabled or not.
     * <p>
     * {@code Default} the logging is enabled.
     * 
     * @return {@code TRUE} if the logging from the {@code TransferData} disabled
     *         during the handling from the {@code ActionEvent} otherwise {@code FALSE}.
     * @see    javafx.event.ActionEvent
     */
    public boolean isLoggingDisabled();

}
