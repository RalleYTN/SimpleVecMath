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
 * Represents a three dimensional vector.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Vector3 extends Vector<Vector3> {

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
	 * The 3rd element
	 * @since 1.0.0
	 */
	public float z;
	
	/**
	 * Constructs a zero vector.
	 * @since 1.0.0
	 */
	public Vector3() {}
	
	/**
	 * Constructs a vector with only the 1st and the 2nd element.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @since 1.0.0
	 */
	public Vector3(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * Constructs a vector with the values of a two dimensional one.
	 * @param vector a two dimensional vector
	 * @since 1.0.0
	 */
	public Vector3(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * Constructs a vector with the 1st and 2nd element from a two dimensional vector and a separate 3rd element.
	 * @param vector a two dimensional vector
	 * @param z the 3rd element
	 * @since 1.0.0
	 */
	public Vector3(Vector2 vector, float z) {
		
		this.set(vector);
		this.z = z;
	}
	
	/**
	 * Constructs a vector.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @param z the 3rd element
	 * @since 1.0.0
	 */
	public Vector3(float x, float y, float z) {
		
		this.set(x, y, z);
	}
	
	/**
	 * Constructs a vector from another three dimensional vector.
	 * @param vector another three dimensional vector
	 * @since 1.0.0
	 */
	public Vector3(Vector3 vector) {
		
		this.set(vector);
	}
	
	/**
	 * Constructs a vector from a {@code float} array.
	 * @param data a {@code float} array containing the vector data
	 * @since 1.0.0
	 */
	public Vector3(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * Sets the values of this vector.
	 * @param data a {@code float} array containing the vector data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {
		
		this.x = data[0];
		this.y = data[1];
		
		if(data.length > 1) {
			
			this.z = data[2];
		}
	}
	
	/**
	 * Sets the values of this vector.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @param z the 3rd element
	 * @since 1.0.0
	 */
	public final void set(float x, float y, float z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Sets the values of this vector.
	 * @param vector another three dimensional vector
	 * @since 1.0.0
	 */
	public final void set(Vector3 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
		this.z = vector.z;
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
	 * @param vector a two dimensional vector
	 * @since 1.0.0
	 */
	public final void set(Vector2 vector) {
		
		this.x = vector.x;
		this.y = vector.y;
	}
	
	/**
	 * Adds the value of another vector to this one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a + b
	 * @since 1.0.0
	 */
	public final Vector3 add(Vector3 b) {
		
		this.x += b.x;
		this.y += b.y;
		this.z += b.z;
		
		return this;
	}
	
	/**
	 * Subtracts the other vector from this one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a - b
	 * @since 1.0.0
	 */
	public final Vector3 subtract(Vector3 b) {
		
		this.x -= b.x;
		this.y -= b.y;
		this.z -= b.z;
		
		return this;
	}
	
	/**
	 * Multiplies this vector with another one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return a * b
	 * @since 1.0.0
	 */
	public final Vector3 multiply(Vector3 b) {
		
		this.x *= b.x;
		this.y *= b.y;
		this.z *= b.z;
		
		return this;
	}
	
	/**
	 * Calculates the cross product between this vector and another one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @return x = y * z2 - z * y2<br>y = x2 * z - z2 * x<br>z = x * y2 - y * x2
	 * @since 1.0.0
	 */
	public final Vector3 cross(Vector3 b) {
		
		this.x = this.y * b.z - this.z * b.y;
		this.y = b.x * this.z - b.z * this.x;
		this.z = this.x * b.y - this.y * b.x;
		
		return this;
	}

	/**
	 * Calculates the dot product between this vector and another one.
	 * @param b the vector on the right side of the calculation
	 * @return x * x2 + y * y2 + z * z2
	 * @since 1.0.0
	 */
	public final float dot(Vector3 b) {
		
		return this.x * b.x + this.y * b.y + this.z * b.z;
	}
	
	/**
	 * Calculates the angle between this vector and another one.
	 * @param b the vector on the right side of the calculation
	 * @return acos(min(max(dot(b) / (a.length() * b.length()), -1), 1))
	 * @since 1.0.0
	 */
	public final float angle(Vector3 b) {
		
		float dls = this.dot(b) / (this.length() * b.length());
		
		if(dls < -1F) {
			
			dls = -1F;
			
		} else if(dls > 1.0F) {
			
			dls = 1.0F;
		}

		return (float)Math.acos(dls);
	}
	
	/**
	 * Rotates this vector on a single axis.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param angle the angle in degrees
	 * @param axis the axis on which the vector should be rotated.
	 * @return the rotated vector
	 * @since 1.0.0
	 */
	public final Vector3 rotate(float angle, Axis axis) {
		
		Matrix4 matrix = new Matrix4();
		matrix.m03 = this.x;
		matrix.m13 = this.y;
		matrix.m23 = this.z;
		matrix.rotate((float)Math.toRadians(angle), axis);
		
		return new Vector3(matrix.m03, matrix.m13, matrix.m23);
	}
	
	/**
	 * Calculates the squared distance between this vector and another three dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return (x - x2)² + (y - y2)² + (z - z2)²
	 * @since 1.0.0
	 */
	public final float distanceSquared(Vector3 b) {
		
		double dx = this.x - b.x;
    	double dy = this.y - b.y;
    	double dz = this.z - b.z;
    	
    	return (float)(dx * dx + dy * dy + dz * dz);
	}
	
	/**
	 * Calculates the distance between this vector and another three dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return sqrt({@link #distanceSquared(Vector3)})
	 * @since 1.0.0
	 */
	public final float distance(Vector3 b) {
		
		return (float)Math.sqrt(this.distanceSquared(b));
	}
	
	/**
	 * Calculates the L-1 (Manhattan) distance between this vector and another three dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return abs(x - x2) + abs(y - y2) + abs(z - z2)
	 * @since 1.0.0
	 */
	public final float distanceL1(Vector3 b) {
		
		return Math.abs(this.x - b.x) + Math.abs(this.y - b.y) + Math.abs(this.z - b.z);
	}
	
	/**
	 * Calculates the L-infinite distance between this vector and another three dimensional vector.
	 * @param b the vector on the right side of the calculation
	 * @return max(max(abs(x - x2), abs(y - y2)), abs(z - z2))
	 * @since 1.0.0
	 */
	public final float distanceLinf(Vector3 b) {
		
		return Math.max(Math.max(Math.abs(this.x - b.x), Math.abs(this.y - b.y)), Math.abs(this.z - b.z));
	}
	
	/**
	 * Projects a four dimensional vector on this one.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the four dimensional vector that should be projected to this one
	 * @return x = x2 / w2<br>y = y2 / w2<br>z = z2 / w2
	 * @since 1.0.0
	 */
	public final Vector3 project(Vector4 b) {
		
		 this.x = b.x / b.w;
    	 this.y = b.y / b.w;
    	 this.z = b.z / b.w;
    	 
    	 return this;
	}
	
	/**
	 * Multiplies this vector with a three dimensional matrix.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix the three dimensional matrix
	 * @return x = x * m00 + y * m01 + z * m02<br>y = x * m10 + y * m11 + z * m12<br>z = x * m20 + y * m21 + z * m22
	 * @since 1.0.0
	 */
	public final Vector3 multiply(Matrix3 matrix) {
		
		this.x = this.x * matrix.m00 + this.y * matrix.m01 + this.z * matrix.m02;
		this.y = this.x * matrix.m10 + this.y * matrix.m11 + this.z * matrix.m12;
		this.z = this.x * matrix.m20 + this.y * matrix.m21 + this.z * matrix.m22;
		
		return this;
	}
	
	/**
	 * Multiplies this vector with a four dimensional matrix.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix the four dimensional matrix
	 * @return x = x * m00 + y * m01 + z * m02<br>y = x * m10 + y * m11 + z * m12<br>z = x * m20 + y * m21 + z * m22
	 * @since 1.0.0
	 */
	public final Vector3 multiply(Matrix4 matrix) {
		
		this.x = this.x * matrix.m00 + this.y * matrix.m01 + this.z * matrix.m02;
		this.y = this.x * matrix.m10 + this.y * matrix.m11 + this.z * matrix.m12;
		this.z = this.x * matrix.m20 + this.y * matrix.m21 + this.z * matrix.m22;
		
		return this;
	}
	
	/**
	 * Linearly interpolates between this and another three dimensional vector.
	 * <p><i>this instance will be manipulated</i></p>
	 * @param b the vector on the right side of the calculation
	 * @param alpha the alpha interpolation parameter
	 * @return beta = {@code 1.0F} - alpha<br>x = beta * x + alpha * x2<br>y = beta * y + alpha * y2<br>z = beta * z + alpha * z2
	 * @since 1.0.0
	 */
	public final Vector3 interpolate(Vector3 b, float alpha) {
		
    	float beta = 1.0F - alpha;
    	
    	this.x = beta * this.x + alpha * b.x;
    	this.y = beta * this.y + alpha * b.y;
    	this.z = beta * this.z + alpha * b.z;
    	
    	return this;
	}
	
	/**
	 * Returns {@code true} if the L-infinite distance between this vector and the other one
	 * is less than or equal to the epsilon parameter, else {@code false}
	 * @param b the vector that is compared with this vector
	 * @param epsilon the threshold value
	 * @return (abs(x2 - x) <= epsilon) AND (abs(y2 - y) <= epsilon) AND (abs(z2 - z) <= epsilon)
	 * @since 1.0.0
	 */
	public final boolean epsilonEquals(Vector3 b, float epsilon) {
		
		return (Math.abs(b.x - this.x) <= epsilon) &&
			   (Math.abs(b.y - this.y) <= epsilon) &&
			   (Math.abs(b.z - this.z) <= epsilon);
	}
	
	/**
	 * Converts this three dimensional vector to a four dimensional one.
	 * @return the four dimensional vector
	 * @since 1.0.0
	 */
	public final Vector4 toVector4() {
		
		return new Vector4(this);
	}
	
	/**
	 * Converts this vector to a quaternion.
	 * @return the quaternion
	 * @since 1.0.0
	 */
	public final Quaternion toQuaternion() {
		
		return new Quaternion(this);
	}
	
	@Override
    public final Vector3 clampMin(float min) {
	
    	if(this.x < min) this.x = min;
    	if(this.y < min) this.y = min;
    	if(this.z < min) this.z = min;
    	
    	return this;
    }

	@Override
    public final Vector3 clampMax(float max) {
	
    	if(this.x > max) this.x = max;
    	if(this.y > max) this.y = max;
    	if(this.z < max) this.z = max;
    	
    	return this;
    }
	
	@Override
	public final Vector3 absolute() {
		
		if(this.x < 0.0F) this.x = -this.x;
		if(this.y < 0.0F) this.y = -this.y;
		if(this.z < 0.0F) this.z = -this.z;
		
		return this;
	}
	
	@Override
	public final Vector3 copy() {
		
		return new Vector3(this);
	}

	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z;
	}

	@Override
	public final Vector3 negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;

		return this;
	}

	@Override
	public final Vector3 scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		
		return this;
	}
	
	@Override
	public final float[] toArray() {
		
		return new float[] {this.x, this.y, this.z};
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
	
    @Override
    public final int hashCode() {
	
    	return Float.floatToIntBits(this.x) ^
               Float.floatToIntBits(this.y) ^
               Float.floatToIntBits(this.z);
    }
}
