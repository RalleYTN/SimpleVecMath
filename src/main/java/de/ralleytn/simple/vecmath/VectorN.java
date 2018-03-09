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
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class VectorN extends Vector {

	private float[] data;
	
	/**
	 * 
	 * @param size
	 * @since 1.0.0
	 */
	public VectorN(int size) {
		
		this.data = new float[size];
	}
	
	/**
	 * 
	 * @param index
	 * @param value
	 * @since 1.0.0
	 */
	public void set(int index, float value) {
		
		this.data[index] = value;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public int size() {
		
		return this.data.length;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public float get(int index) {
		
		return this.data[index];
	}
	
	@Override
	public VectorN copy() {
		
		VectorN copy = new VectorN(this.data.length);
		copy.data = this.toArray();
		
		return copy;
	}

	@Override
	public float lengthSquared() {
		
		float current = 0.0F;
		
		for(int index = 0; index < this.data.length; index++) {
			
			float value = this.data[index];
			current += value * value;
		}
		
		return current;
	}

	@Override
	public VectorN negate() {
		
		for(int index = 0; index < this.data.length; index++) {
			
			this.data[index] = -this.data[index];
		}
		
		return this;
	}

	@Override
	public float[] toArray() {
		
		float[] array = new float[this.data.length];
		
		for(int index = 0; index < array.length; index++) {
			
			array[index] = this.data[index];
		}
		
		return array;
	}

	@Override
	public VectorN scale(float scale) {
		
		for(int index = 0; index < this.data.length; index++) {
			
			this.data[index] *= scale;
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		
		for(int index = 0; index < this.data.length; index++) {
			
			if(index != 0) {
				
				builder.append(',');
			}
			
			builder.append(this.data[index]);
		}
		
		builder.append(')');
		
		return builder.toString();
	}
}
