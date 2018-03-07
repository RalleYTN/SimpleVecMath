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
public final class Vector4 extends Vector {

	public float x;
	public float y;
	public float z;
	public float w;
	
	/**
	 * @since 1.0.0
	 */
	public Vector4() {}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public Vector4(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector4(Vector2 vector) {
		
		this.set(vector);
	}
	
	public Vector4(Vector2 vector, float z, float w) {
		
		this.set(vector);
		this.z = z;
		this.w = w;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @since 1.0.0
	 */
	public Vector4(float x, float y, float z) {
		
		this.set(x, y, z);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector4(Vector3 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param vector
	 * @param w
	 * @since 1.0.0
	 */
	public Vector4(Vector3 vector, float w) {
		
		this.set(vector);
		this.w = w;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @since 1.0.0
	 */
	public Vector4(float x, float y, float z, float w) {
		
		this.set(x, y, z, w);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Vector4(Vector4 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 normalize(Vector4 vector) {
		
		return (Vector4)vector.copy().normalize();
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float dot(Vector4 a, Vector4 b) {
		
		return a.dot(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static final Vector4 add(Vector4 a, Vector4 b) {
		
		return a.copy().add(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 subtract(Vector4 a, Vector4 b) {
		
		return a.copy().subtract(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 multiply(Vector4 a, Vector4 b) {
		
		return a.copy().multiply(b);
	}
	
	/**
	 * 
	 * @param vector
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 scale(Vector4 vector, float scale) {
		
		return (Vector4)vector.copy().scale(scale);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 negate(Vector4 vector) {
		
		return (Vector4)vector.copy().negate();
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float angle(Vector4 a, Vector4 b) {
		
		return a.angle(b);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 * @since 1.0.0
	 */
	public final void set(float x, float y, float z, float w) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public final void set(Vector4 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
		this.w = vector.w;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @since 1.0.0
	 */
	public final void set(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public final void set(Vector3 vector) {
		
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
	 * @param z
	 * @since 1.0.0
	 */
	public final void setZ(float z) {
		
		this.z = z;
	}
	
	/**
	 * 
	 * @param w
	 * @since 1.0.0
	 */
	public final void setW(float w) {
		
		this.w = w;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 copy() {
		
		return new Vector4(this.x, this.y, this.z, this.w);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float dot(Vector4 b) {
		
		return this.x * b.x + this.y * b.y + this.z * b.z + this.w * b.w;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 add(Vector4 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		this.w += vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 subtract(Vector4 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		this.w -= vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 multiply(Vector4 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		this.w *= vector.w;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float angle(Vector4 b) {
		
		float dls = Vector4.dot(this, b) / (this.length() * b.length());
		
		if(dls < -1F) {
			
			dls = -1F;
	
		} else if (dls > 1.0F) {
			
			dls = 1.0F;
		}
		
		return (float)Math.acos(dls);
	}
	
	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
	}

	@Override
	public final Vector negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		this.w = -this.w;
		
		return this;
	}

	@Override
	public final Vector scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		this.w *= scale;
		
		return this;
	}

	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s,%s,%s)", this.x, this.y, this.z, this.w);
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Vector4) {
			
			Vector4 vector = (Vector4)object;
			return this.x == vector.x && this.y == vector.y && this.z == vector.z && this.w == vector.w;
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
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final float getZ() {
		
		return this.z;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final float getW() {
		
		return this.w;
	}
}
