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
public class Vector2 extends Vector {

	public float x;
	public float y;
	
	/**
	 * @since 1.0.0
	 */
	public Vector2() {}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public Vector2(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Vector2(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector2(Vector2 vector) {
		
		this.set(vector);
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
	 * @param data
	 * @since 1.0.0
	 */
	public void set(float[] data) {
		
		this.x = data[0];
		this.y = data[1];
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
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float dot(Vector2 b) {
		
		return this.x * b.x + this.y * b.y;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float angle(Vector2 b) {
		
		float dls = this.dot(b) / (this.length() * b.length());
		
		if(dls < -1F) {
			
			dls = -1F;
			
		} else if (dls > 1.0F) {
			
			dls = 1.0F;
		}
		
		return (float)Math.acos(dls);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float cross(Vector2 b) {
		
		return this.x * b.y - this.y * b.x;
	}
	
	/**
	 * 
	 * @param angle
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 rotate(float angle) {

		this.x = (float)(this.x * Math.cos(angle) - this.y * Math.sin(angle));
		this.y = (float)(this.x * Math.sin(angle) + this.y * Math.cos(angle));
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 turnLeft() {
		
		this.y = this.x;
		this.x = -this.y;
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 turnRight() {
		
		this.x = this.y;
		this.y = -this.x;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 add(Vector2 b) {
		
		this.x += b.x;
		this.y += b.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 subtract(Vector2 b) {
		
		this.x -= b.x;
		this.y -= b.y;
		
		return this;
	}

	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public Vector2 multiply(Vector2 b) {
		
		this.x *= b.x;
		this.y *= b.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceSquared(Vector2 b) {
		
		double dx = this.x - b.x;
    	double dy = this.y - b.y;
	
    	return (float)(dx * dx + dy * dy);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distance(Vector2 b) {
		
		return (float)Math.sqrt(this.distanceSquared(b));
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceL1(Vector2 b) {
		
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public float distanceLinf(Vector2 b) {
		
		return Math.max(Math.abs(this.x - b.x), Math.abs(this.y - b.y));
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
	
	@Override
	public Vector2 copy() {
		
		return new Vector2(this.x, this.y);
	}

	@Override
	public float lengthSquared() {
		
		return this.x * this.x + this.y * this.y;
	}

	@Override
	public Vector2 negate() {
		
		this.x = -this.x;
		this.y = -this.y;

		return this;
	}

	@Override
	public Vector2 scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;

		return this;
	}
	
	@Override
	public float[] toArray() {
		
		return new float[] {this.x, this.y};
	}
	
	@Override
	public String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s)", this.x, this.y);
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(object != null && object instanceof Vector2) {
			
			Vector2 vector = (Vector2)object;
			return this.x == vector.x && this.y == vector.y;
		}
		
		return false;
	}
	
    @Override
    public int hashCode() {
	
    	return Float.floatToIntBits(this.x) ^
               Float.floatToIntBits(this.y);
    }
}
