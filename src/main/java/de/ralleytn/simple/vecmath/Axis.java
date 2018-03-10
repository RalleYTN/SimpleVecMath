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
 * Represents an axis. Used for rotating matrices and vectors.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Axis {

	/**
	 * X axis
	 * @since 1.0.0
	 */
	public static final Axis X = new Axis(1.0F, 0.0F, 0.0F);
	
	/**
	 * Y axis
	 * @since 1.0.0
	 */
	public static final Axis Y = new Axis(0.0F, 1.0F, 0.0F);
	
	/**
	 * Z axis
	 * @since 1.0.0
	 */
	public static final Axis Z = new Axis(0.0F, 0.0F, 1.0F);
	
	private final float x;
	private final float y;
	private final float z;
	
	private Axis(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * @return the x value
	 * @since 1.0.0
	 */
	public final float getX() {
		
		return this.x;
	}
	
	/**
	 * @return the y value
	 * @since 1.0.0
	 */
	public final float getY() {
		
		return this.y;
	}
	
	/**
	 * @return the z value
	 * @since 1.0.0
	 */
	public final float getZ() {
		
		return this.z;
	}
}
