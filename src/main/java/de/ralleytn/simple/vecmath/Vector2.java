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
 * Represents a two dimensional vector.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Vector2 extends Vector<Vector2> {

	/**
	 * The 1st element
	 * @since 1.0.0
	 */
	public float x;
	
	/**
	 * The 2nd element
	 * @since 1.0.0
	 */
	public float y;
	
	/**
	 * Constructs a zero vector.
	 * @since 1.0.0
	 */
	public Vector2() {}
	
	/**
	 * Constructs a vector.
	 * @param x 1st element
	 * @param y 2nd element
	 * @since 1.0.0
	 */
	public Vector2(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * Constructs a vector from a {@code float} array.
	 * @param data a {@code float} array containing the vector data
	 * @since 1.0.0
	 */
	public Vector2(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * Constructs a vector with the values of another two dimensional vector.
	 * @param vector another two dimensional vector
	 * @since 1.0.0
	 */
	public Vector2(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * Sets the values of this vector.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @since 1.0.0
	 */
	public final void set(float x, float y) {
		
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the values of this vector.
	 * @param vector another two dimensional vector
	 * @since 1.0.0
	 */
	public final void set(Vector2 vector) {
		
		this.set(vector.x, vector.y);
	}
	
	/**
	 * Sets the values of this vector.
	 * @param data a {@code float} array containing the vector data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {
		
		this.set(data[0], data[1]);
	}
	
	/**
	 * Calculates the dot product of this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation.
	 * @return x * x2 + y + y2
	 * @since 1.0.0
	 */
	public final float dot(Vector2 b) {
		
		return this.x * b.x + this.y * b.y;
	}
	
	/**
	 * Calculates the angle between this vector and another one in radians.
	 * @param b the vector on the right side of the calculation
	 * @return acos(min(max(dot(b) / (a.length() * b.length()), -1), 1))
	 * @since 1.0.0
	 */
	public final float angle(Vector2 b) {
		
		float dls = this.dot(b) / (this.length() * b.length());
		
		if(dls < -1F) {
			
			dls = -1F;
			
		} else if (dls > 1.0F) {
			
			dls = 1.0F;
		}
		
		return (float)Math.acos(dls);
	}
	
	/**
	 * Calculates the cross product between this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return x * y2 - y * x2
	 * @since 1.0.0
	 */
	public final float cross(Vector2 b) {
		
		return this.x * b.y - this.y * b.x;
	}
	
	/**
	 * Rotates this vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param angle the angle in degrees
	 * @return x2 = x<br>x = x2 * cos(angle) - y * sin(angle)<br>y = x2 * sin(angle) + y * cos(angle)
	 * @since 1.0.0
	 */
	public final Vector2 rotate(float angle) {

		this.set((float)(this.x * Math.cos(angle) - this.y * Math.sin(angle)),
				 (float)(this.x * Math.sin(angle) + this.y * Math.cos(angle)));
		
		return this;
	}
	
	/**
	 * Rotates this vector 90° to the left.
	 * <p><i>this instance will be manipulated</i></p>
	 * @return y = x<br>x = -y
	 * @since 1.0.0
	 */
	public final Vector2 turnLeft() {
		
		this.set(-this.y, this.x);
		
		return this;
	}
	
	/**
	 * Rotates this vector 90° to the right.
	 * <p><i>this instance will be manipulated</i></p>
	 * @return x = y<br>y = -x
	 * @since 1.0.0
	 */
	public final Vector2 turnRight() {
		
		this.set(this.y, -this.x);
		
		return this;
	}
	
	/**
	 * Adds the value of the other vector to this one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a + b
	 * @since 1.0.0
	 */
	public final Vector2 add(Vector2 b) {
		
		this.x += b.x;
		this.y += b.y;
		
		return this;
	}
	
	/**
	 * Subtracts the value of the other vector from this one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a - b
	 * @since 1.0.0
	 */
	public final Vector2 subtract(Vector2 b) {
		
		this.x -= b.x;
		this.y -= b.y;
		
		return this;
	}

	/**
	 * Multiplies this vector with another vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a * b
	 * @since 1.0.0
	 */
	public final Vector2 multiply(Vector2 b) {
		
		this.x *= b.x;
		this.y *= b.y;
		
		return this;
	}
	
	/**
	 * Multiplies this vector with a three dimensional matrix.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix the three dimensional matrix
	 * @return x = x * m00 + y * m01<br>y = y * m10 + y * m11
	 * @since 1.0.0
	 */
	public final Vector2 multiply(Matrix3 matrix) {
		
		this.set(this.x * matrix.m00 + this.y * matrix.m01,
				 this.x * matrix.m10 + this.y * matrix.m11);
		
		return this;
	}
	
	/**
	 * Multiplies this vector with a four dimensional matrix.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix matrix the four dimensional matrix
	 * @return x = x * m00 + y * m01<br>y = y * m10 + y * m11
	 * @since 1.0.0
	 */
	public final Vector2 multiply(Matrix4 matrix) {

		this.set(this.x * matrix.m00 + this.y * matrix.m01,
				 this.x * matrix.m10 + this.y * matrix.m11);
		
		return this;
	}
	
	/**
	 * Calculates the squared distance between this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return (x - x2)² + (y - y2)²
	 * @since 1.0.0
	 */
	public final float distanceSquared(Vector2 b) {
		
		double dx = this.x - b.x;
    	double dy = this.y - b.y;
	
    	return (float)(dx * dx + dy * dy);
	}
	
	/**
	 * Calculates the distance between this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return sqrt({@link #distanceSquared(Vector2)})
	 * @since 1.0.0
	 */
	public final float distance(Vector2 b) {
		
		return (float)Math.sqrt(this.distanceSquared(b));
	}
	
	/**
	 * Calculates the L-1 (Manhattan) distance between this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return abs(x - x2) + abs(y - y2)
	 * @since 1.0.0
	 */
	public final float distanceL1(Vector2 b) {
		
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y);
	}
	
	/**
	 * Calculates the L-infinite distance between this vector and another two dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return max(abs(x - x2), abs(y - y2))
	 * @since 1.0.0
	 */
	public final float distanceLinf(Vector2 b) {
		
		return Math.max(Math.abs(this.x - b.x), Math.abs(this.y - b.y));
	}
	
	/**
	 * Converts this vector from a two dimensional to a three dimensional one.
	 * The missing elements will be filled with {@code 0.0F}.
	 * @return the three dimensional vector
	 * @since 1.0.0
	 */
	public final Vector3 toVector3() {
		
		return new Vector3(this);
	}
	
	/**
	 * Converts this vector from a two dimensional to a four dimensional one.
	 * The missing elements will be filled with {@code 0.0F}.
	 * @return the four dimensional vector
	 * @since 1.0.0
	 */
	public final Vector4 toVector4() {
		
		return new Vector4(this);
	}
	
	/**
	 * Converts this vector to a quaternion.
	 * The missing elements will be filled with {@code 0.0F}.
	 * @return the quaternion
	 * @since 1.0.0
	 */
	public final Quaternion toQuaternion() {
		
		return new Quaternion(this);
	}
	
	/**
	 * Returns {@code true} if the L-infinite distance between this vector and the other one
	 * is less than or equal to the epsilon parameter, else {@code false}
	 * @param b the vector that is compared with this vector
	 * @param epsilon the threshold value
	 * @return (abs(x2 - x) <= epsilon) AND (abs(y2 - y) <= epsilon)
	 * @since 1.0.0
	 */
	public final boolean epsilonEquals(Vector2 b, float epsilon) {
		
		return (Math.abs(b.x - this.x) <= epsilon) &&
			   (Math.abs(b.y - this.y) <= epsilon);
	}
    
	/**
	 * Linearly interpolates between this and another two dimensional vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @param alpha the alpha interpolation parameter
	 * @return beta = {@code 1.0F} - alpha<br>x = beta * x + alpha * x2<br>y = beta * y + alpha * y2
	 * @since 1.0.0
	 */
    public final Vector2 interpolate(Vector2 b, float alpha) {
    	
    	float beta = 1.0F - alpha;
    	
    	this.x = beta * this.x + alpha * b.x;
    	this.y = beta * this.y + alpha * b.y;
    	
    	return this;
    }
	
	@Override
    public final Vector2 clampMin(float min) {
	
    	if(this.x < min) this.x = min;
    	if(this.y < min) this.y = min;
    	
    	return this;
    }

	@Override
    public final Vector2 clampMax(float max) {
	
    	if(this.x > max) this.x = max;
    	if(this.y > max) this.y = max;
    	
    	return this;
    }
	
	@Override
	public final Vector2 absolute() {
		
		if(this.x < 0.0F) this.x = -this.x;
		if(this.y < 0.0F) this.y = -this.y;
		
		return this;
	}
	
	@Override
	public final Vector2 copy() {
		
		return new Vector2(this);
	}

	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y;
	}

	@Override
	public final Vector2 negate() {
		
		this.set(-this.x, -this.y);

		return this;
	}

	@Override
	public final Vector2 scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;

		return this;
	}
	
	@Override
	public final float[] toArray() {
		
		return new float[] {
				
			this.x,
			this.y
		};
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
	
    @Override
    public final int hashCode() {
	
    	return Float.floatToIntBits(this.x) ^
               Float.floatToIntBits(this.y);
    }
}
