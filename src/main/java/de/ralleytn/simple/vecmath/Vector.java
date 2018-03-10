/*
 * MIT License
 * 
 * Copyright (c) 2018 Ralph Niemitz
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package de.ralleytn.simple.vecmath;

//==== 10.03.2018 | Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
//This class is generic to prevent the need for casting when using a vector.
//====

/**
 * The abstract representation of a vector.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 * @param <T> the vector type
 */
public abstract class Vector<T extends Vector<T>> {
	
	/**
	 * Calculates the length of this vector according to Pythagoras (a² + b² = c²).
	 * The result of this method is the squared length of the vector's hypotenuse.
	 * @return FOREACH element in elements DO lengthSquared = lengthSquared + element²
	 * @since 1.0.0
	 */
	public abstract float lengthSquared();
	
	/**
	 * Negates the vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @return FOREACH element in elements DO element = -element
	 * @since 1.0.0
	 */
	public abstract T negate();
	
	/**
	 * Converts this vector to a {@code float} array.
	 * @return this vector as a {@code float} array
	 * @since 1.0.0
	 */
	public abstract float[] toArray();
	
	/**
	 * Scales the vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param scale the scalar value
	 * @return FOREACH element in elements DO element = element * scale
	 * @since 1.0.0
	 */
	public abstract T scale(float scale);
	
	/**
	 * Creates a copy of this vector.
	 * @return a copy of this vector
	 * @since 1.0.0
	 */
	public abstract T copy();
	
	/**
	 * Sets all elements of this vector to their absolute value.
	 * <i>this instance will be manipulated</i></p>
	 * @return FOREACH element in elements DO IF element < {@code 0.0F} THEN element = -element
	 * @since 1.0.0
	 */
	public abstract T absolute();

	/**
	 * Clamps this vector to the given minimum value.
	 * <i>this instance will be manipulated</i></p>
	 * @param min the minimum value
	 * @return FOREACH element in elements DO IF element < min THEN element = min
	 * @since 1.0.0
	 */
    public abstract T clampMin(float min);

    /**
     * Clamps this vector to the given maximum value.
     * <i>this instance will be manipulated</i></p>
     * @param max the maximum value
     * @return FOREACH element in elements DO IF element > max THEN element = max
     * @since 1.0.0
     */
    public abstract T clampMax(float max);
    
    /**
     * Clamps this vector to the the given range.
     * <i>this instance will be manipulated</i></p>
     * @param min the minimum value
     * @param max the maximum value
     * @return clampMax(clampMin(a, min), max)
     * @since 1.0.0
     */
    public final T clamp(float min, float max) {

    	return this.clampMin(min).clampMax(max);
    }
	
	/**
	 * Normalizes the vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @return scale({@code 1.0F} / {@link #length()})
	 * @since 1.0.0
	 */
	public final T normalize() {

		return this.scale(1.0F / this.length());
	}
	
	/**
	 * Calculates the actual length of this vector's hypotenuse.
	 * @return sqrt({@link #lengthSquared()})
	 * @since 1.0.0
	 */
	public final float length() {
		
		return (float)Math.sqrt(this.lengthSquared());
	}
}
