/*
 * MIT License
 * 
 * Copyb (c) 2017 Ralph Niemitz
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the bs
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyb notice and this permission notice shall be included in all
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
public final class Vector2 extends Vector {

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
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector2(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float dot(Vector2 a, Vector2 b) {
		
		return a.dot(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float angle(Vector2 a, Vector2 b) {
		
		return a.angle(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 add(Vector2 a, Vector2 b) {
		
		return a.copy().add(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 subtract(Vector2 a, Vector2 b) {
		
		return a.copy().subtract(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 multiply(Vector2 a, Vector2 b) {
		
		return a.copy().multiply(b);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 negate(Vector2 vector) {
		
		return (Vector2)vector.copy().negate();
	}
	
	/**
	 * 
	 * @param vector
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 scale(Vector2 vector, float scale) {
		
		return (Vector2)vector.copy().scale(scale);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float cross(Vector2 a, Vector2 b) {
		
		return a.cross(b);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 normalize(Vector2 vector) {
		
		return (Vector2)vector.copy().normalize();
	}
	
	/**
	 * 
	 * @param vector
	 * @param angle
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 rotate(Vector2 vector, float angle) {

		return vector.copy().rotate(angle);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 turnLeft(Vector2 vector) {
		
		return vector.copy().turnLeft();
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector2 turnRight(Vector2 vector) {
		
		return vector.copy().turnRight();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public final void set(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public final void set(Vector2 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
	}
	
	/**
	 * 
	 * @param x
	 * @since 1.0.0
	 */
	public final void setX(float x) {
		
		this.x = x;
	}
	
	/**
	 * 
	 * @param y
	 * @since 1.0.0
	 */
	public final void setY(float y) {
		
		this.y = y;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 copy() {
		
		return new Vector2(this.x, this.y);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float dot(Vector2 b) {
		
		return this.x * b.x + this.y * b.y;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float angle(Vector2 b) {
		
		float dls = Vector2.dot(this, b) / (this.length() * b.length());
		
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
	public final float cross(Vector2 b) {
		
		return this.x * b.y - this.y * b.x;
	}
	
	/**
	 * 
	 * @param angle
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 rotate(float angle) {

		this.x = (float)(this.x * Math.cos(angle) - this.y * Math.sin(angle));
		this.y = (float)(this.x * Math.sin(angle) + this.y * Math.cos(angle));
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 turnLeft() {
		
		this.y = this.x;
		this.x = -this.y;
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 turnRight() {
		
		this.x = this.y;
		this.y = -this.x;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 add(Vector2 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 subtract(Vector2 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		
		return this;
	}

	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 multiply(Vector2 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		
		return this;
	}

	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y;
	}

	@Override
	public final Vector negate() {
		
		this.x = -this.x;
		this.y = -this.y;

		return this;
	}

	@Override
	public final Vector scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;

		return this;
	}
	
	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s)", this.x, this.y);
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Vector2) {
			
			Vector2 vector = (Vector2)object;
			return this.x == vector.x && this.y == vector.y;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final float getX() {
		
		return this.x;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final float getY() {
		
		return this.y;
	}
}
