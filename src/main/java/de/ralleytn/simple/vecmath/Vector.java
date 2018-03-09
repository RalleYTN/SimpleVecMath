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

/**
 * The abstract representation of a vector with undefined size.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Vector {

	/**
	 * @return the length of the vector
	 * @since 1.0.0
	 */
	public float length() {
		
		return (float)Math.sqrt(this.lengthSquared());
	}
	
	/**
	 * @return the length of the vector * the length of the vector
	 * @since 1.0.0
	 */
	public abstract float lengthSquared();
	
	/**
	 * Negates the vector.<p><i>this instance will be manipulated</i></p>
	 * @return the vector
	 * @since 1.0.0
	 */
	public abstract Vector negate();
	
	/**
	 * @return this vector as a {@code float} array
	 * @since 1.0.0
	 */
	public abstract float[] toArray();
	
	/**
	 * Scales the vector.<p><i>this instance will be manipulated</i></p>
	 * @param scale the scalar value
	 * @return the vector
	 * @since 1.0.0
	 */
	public abstract Vector scale(float scale);
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Vector copy();
	
	/**
	 * Normalizes the vector.<p><i>this instance will be manipulated</i></p>
	 * @return the vector
	 * @since 1.0.0
	 */
	public Vector normalize() {

		return this.scale(1.0F / this.length());
	}
}
