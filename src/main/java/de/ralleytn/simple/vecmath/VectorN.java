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

import de.ralleytn.simple.vecmath.internal.Util;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class VectorN extends Vector<VectorN> {

	private int size;
	private float[] data;
	
	/**
	 * 
	 * @param size
	 * @since 1.0.0
	 */
	public VectorN(int size) {
		
		this.data = new float[size];
		this.size = size;
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public VectorN(float[] data) {
		
		this.size = data.length;
		this.data = Util.copy(data);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public VectorN(VectorN vector) {
		
		this.size = vector.size;
		this.data = vector.toArray();
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public VectorN(Vector2 vector) {
		
		this.data = vector.toArray();
		this.size = this.data.length;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public VectorN(Vector3 vector) {
		
		this.data = vector.toArray();
		this.size = this.data.length;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public VectorN(Vector4 vector) {
		
		this.data = vector.toArray();
		this.size = this.data.length;
	}
	
	/**
	 * 
	 * @param quaternion
	 * @since 1.0.0
	 */
	public VectorN(Quaternion quaternion) {
		
		this.data = quaternion.toArray();
		this.size = this.data.length;
	}
	
	/**
	 * 
	 * @param data
	 * @param size
	 * @since 1.0.0
	 */
	public VectorN(float[] data, int size) {
		
		this.data = new float[size];
		this.size = size;
		
		for(int index = 0; index < this.size; index++) {
			
			this.data[index] = data[index];
		}
	}
	
	/**
	 * 
	 * @param data
	 * @param size
	 * @param offset
	 * @since 1.0.0
	 */
	public VectorN(float[] data, int size, int offset) {
		
		this.data = new float[size];
		this.size = size;
		int i = 0;
		
		for(int index = offset; index < offset + this.size; index++) {
			
			this.data[i] = data[index];
			i++;
		}
	}
	
	/**
	 * 
	 * @param index
	 * @param value
	 * @since 1.0.0
	 */
	public final void set(int index, float value) {
		
		this.data[index] = value;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final int size() {
		
		return this.size;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 * @since 1.0.0
	 */
	public final float get(int index) {
		
		return this.data[index];
	}
	
	@Override
    public final VectorN clampMin(float min) {
	
    	for(int index = 0; index < this.size; index++) {
    		
    		if(this.data[index] < min) {
    			
    			this.data[index] = min;
    		}
    	}
    	
    	return this;
    }

	@Override
    public final VectorN clampMax(float max) {
	
    	for(int index = 0; index < this.size; index++) {
    		
    		if(this.data[index] > max) {
    			
    			this.data[index] = max;
    		}
    	}
    	
    	return this;
    }
	
	@Override
	public final VectorN absolute() {
		
		for(int index = 0; index < this.size; index++) {
			
			if(this.data[index] < 0.0F) {
				
				this.data[index] = -this.data[index];
			}
		}
		
		return this;
	}
	
	@Override
	public final VectorN copy() {

		return new VectorN(this);
	}

	@Override
	public final float lengthSquared() {
		
		float current = 0.0F;
		
		for(int index = 0; index < this.size; index++) {
			
			float value = this.data[index];
			current += value * value;
		}
		
		return current;
	}

	@Override
	public final VectorN negate() {
		
		for(int index = 0; index < this.size; index++) {
			
			this.data[index] = -this.data[index];
		}
		
		return this;
	}

	@Override
	public final float[] toArray() {
		
		return Util.copy(this.data);
	}

	@Override
	public final VectorN scale(float scale) {
		
		for(int index = 0; index < this.size; index++) {
			
			this.data[index] *= scale;
		}
		
		return this;
	}
	
	@Override
	public final String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append('(');
		
		for(int index = 0; index < this.size; index++) {
			
			if(index != 0) {
				
				builder.append(',');
			}
			
			builder.append(this.data[index]);
		}
		
		builder.append(')');
		return builder.toString();
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof VectorN) {
			
			VectorN vector = (VectorN)object;
			
			if(this.size == vector.size) {
				
				for(int index = 0; index < this.size; index++) {
					
					if(this.data[index] != vector.data[index]) {
						
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public final int hashCode() {
		
		int hash = 0;
		
		for(int index = 0; index < this.size; index++) {
			
		    long bits = Double.doubleToLongBits(this.data[index]);
		    hash ^= (int)(bits ^ (bits >> 32));
		}
		
		return hash;
	}
}
