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
public final class Vector3 extends Vector {

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
	 * @param position
	 * @param angle
	 * @param axis
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 rotate(Vector3 position, float angle, Vector3 axis) {
		
		return position.copy().rotate(angle, axis);
	}
	
	/**
	 * 
	 * @param vector
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 scale(Vector3 vector, float scale) {
		
		return (Vector3)vector.copy().scale(scale);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 negate(Vector3 vector) {
		
		return (Vector3)vector.copy().negate();
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 normalize(Vector3 vector) {
		
		return (Vector3)vector.copy().normalize();
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 add(Vector3 a, Vector3 b) {
		
		return a.copy().add(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 subtract(Vector3 a, Vector3 b) {
		
		return a.copy().subtract(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 multiply(Vector3 a, Vector3 b) {
		
		return a.copy().multiply(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 cross(Vector3 a, Vector3 b) {
		
		return a.copy().cross(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float dot(Vector3 a, Vector3 b) {
		
		return a.dot(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final float angle(Vector3 a, Vector3 b) {
		
		return a.angle(b);
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
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 copy() {
		
		return new Vector3(this.x, this.y, this.z);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 add(Vector3 vector) {
		
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 subtract(Vector3 vector) {
		
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 multiply(Vector3 vector) {
		
		this.x *= vector.x;
		this.y *= vector.y;
		this.z *= vector.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 cross(Vector3 b) {
		
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
	public final float dot(Vector3 b) {
		
		return this.x * b.x + this.y * b.y + this.z * b.z;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float angle(Vector3 b) {
		
		float dls = Vector3.dot(this, b) / (this.length() * b.length());
		
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
	public final Vector3 rotate(float angle, Vector3 axis) {
		
		Matrix4 matrix = new Matrix4();
		matrix.m03 = this.x;
		matrix.m13 = this.y;
		matrix.m23 = this.z;
		matrix.rotate((float)Math.toRadians(angle), axis);
		
		return new Vector3(matrix.m03, matrix.m13, matrix.m23);
	}

	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	@Override
	public final Vector negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;

		return this;
	}

	@Override
	public final Vector scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		
		return this;
	}
	
	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s,%s)", this.x, this.y, this.z);
	}

	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Vector3) {
			
			Vector3 vector = (Vector3)object;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z;
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
}
