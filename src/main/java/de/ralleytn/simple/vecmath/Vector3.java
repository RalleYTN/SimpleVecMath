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
public class Vector3 extends Vector {

	public float x;
	public float y;
	public float z;
	
	/**
	 * @since 1.0.0
	 */
	public Vector3() {}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public Vector3(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector3(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param vector
	 * @param z
	 * @since 1.0.0
	 */
	public Vector3(Vector2 vector, float z) {
		
		this.set(vector);
		this.z = z;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @since 1.0.0
	 */
	public Vector3(float x, float y, float z) {
		
		this.set(x, y, z);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector3(Vector3 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Vector3(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public void set(float[] data) {
		
		this.x = data[0];
		this.y = data[1];
		
		if(data.length > 1) {
			
			this.z = data[2];
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @since 1.0.0
	 */
	public void set(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public void set(Vector3 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public void set(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public void set(Vector2 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
	}
	
	/**
	 * 
	 * @param x
	 * @since 1.0.0
	 */
	public void setX(float x) {
		
		this.x = x;
	}
	
	/**
	 * 
	 * @param y
	 * @since 1.0.0
	 */
	public void setY(float y) {
		
		this.y = y;
	}
	
	/**
	 * 
	 * @param z
	 * @since 1.0.0
	 */
	public void setZ(float z) {
		
		this.z = z;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 add(Vector3 b) {
		
		this.x += b.x;
		this.y += b.y;
		this.z += b.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 subtract(Vector3 b) {
		
		this.x -= b.x;
		this.y -= b.y;
		this.z -= b.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 multiply(Vector3 b) {
		
		this.x *= b.x;
		this.y *= b.y;
		this.z *= b.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 cross(Vector3 b) {
		
		this.x = this.y * b.z - this.z * b.y;
		this.y = b.x * this.z - b.z * this.x;
		this.z = this.x * b.y - this.y * b.x;
		
		return this;
	}

	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float dot(Vector3 b) {
		
		return this.x * b.x + this.y * b.y + this.z * b.z;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float angle(Vector3 b) {
		
		float dls = this.dot(b) / (this.length() * b.length());
		
		if(dls < -1F) {
			
			dls = -1F;
			
		} else if(dls > 1.0F) {
			
			dls = 1.0F;
		}

		return (float)Math.acos(dls);
	}
	
	/**
	 * 
	 * @param angle
	 * @param axis
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 rotate(float angle, Vector3 axis) {
		
		Matrix4 matrix = new Matrix4();
		matrix.m03 = this.x;
		matrix.m13 = this.y;
		matrix.m23 = this.z;
		matrix.rotate((float)Math.toRadians(angle), axis);
		
		return new Vector3(matrix.m03, matrix.m13, matrix.m23);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceSquared(Vector3 b) {
		
		double dx = this.x - b.x;
    	double dy = this.y - b.y;
    	double dz = this.z - b.z;
    	
    	return (float)(dx * dx + dy * dy + dz * dz);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distance(Vector3 b) {
		
		return (float)Math.sqrt(this.distanceSquared(b));
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceL1(Vector3 b) {
		
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y) + Math.abs(this.z - b.z);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceLinf(Vector3 b) {
		
		return Math.max(Math.max(Math.abs(this.x - b.x), Math.abs(this.y - b.y)), Math.abs(this.z - b.z));
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector3 project(Vector4 b) {
		
		 this.x = b.x / b.w;
    	 this.y = b.y / b.w;
    	 this.z = b.z / b.w;
    	 
    	 return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public float getX() {
		
		return this.x;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public float getY() {
		
		return this.y;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public float getZ() {
		
		return this.z;
	}
	
	@Override
	public Vector3 copy() {
		
		return new Vector3(this.x, this.y, this.z);
	}

	@Override
	public float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	@Override
	public Vector3 negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;

		return this;
	}

	@Override
	public Vector3 scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		
		return this;
	}
	
	@Override
	public float[] toArray() {
		
		return new float[] {this.x, this.y, this.z};
	}
	
	@Override
	public String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s,%s)", this.x, this.y, this.z);
	}

	@Override
	public boolean equals(Object object) {
		
		if(object != null && object instanceof Vector3) {
			
			Vector3 vector = (Vector3)object;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z;
		}
		
		return false;
	}
	
    @Override
    public int hashCode() {
	
    	return Float.floatToIntBits(this.x) ^
               Float.floatToIntBits(this.y) ^
               Float.floatToIntBits(this.z);
    }
}
