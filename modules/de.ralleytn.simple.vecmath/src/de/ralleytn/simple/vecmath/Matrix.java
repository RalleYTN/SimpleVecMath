/*
 * MIT License
 * 
 * Copyright (c) 2017 Ralph Niemitz
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
 * The abstract representation of a matrix with undefined size.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Matrix {

	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Matrix setIdentity();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Matrix invert();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Matrix negate();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Matrix transpose();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract Matrix setZero();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract float determinant();
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public abstract float[] toArray();
}
