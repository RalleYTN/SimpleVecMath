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
 * Represents a four dimensional vector.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Vector4 extends Vector<Vector4> {

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
	 * The 4th element
	 * @since 1.0.0
	 */
	public float w;
	
	/**
	 * Constructs a zero vector.
	 * @since 1.0.0
	 */
	public Vector4() {}
	
	/**
	 * Constructs a vector with only the 1st and 2nd element.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @since 1.0.0
	 */
	public Vector4(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * Constructs a vector with the values of a two dimensional one.
	 * @param vector the two dimensional vector
	 * @since 1.0.0
	 */
	public Vector4(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * Constructs a vector with the values of a two dimensional one and the 3rd and 4th element separately.
	 * @param vector the two dimensional vector
	 * @param z the 3rd element
	 * @param w the 4th element
	 * @since 1.0.0
	 */
	public Vector4(Vector2 vector, float z, float w) {
		
		this.set(vector);
		this.z = z;
		this.w = w;
	}
	
	/**
	 * Constructs a vector with only the first 3 elements.
	 * @param x the 1st element
	 * @param y the 2nd element
	 * @param z the 3rd element
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
	 * @param data
	 * @since 1.0.0
	 */
	public Vector4(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param quaternion
	 * @since 1.0.0
	 */
	public Vector4(Quaternion quaternion) {
		
		this.set(quaternion);
	}
	
	/**
	 * 
	 * @param vector
	 * @param z
	 * @since 1.0.0
	 */
	public Vector4(Vector2 vector, float z) {
		
		this.set(vector);
		this.z = z;
	}
	
	private final Vector4 fromMatrix(double m00, double m01, double m02, double m10, double m11, double m12, double m20, double m21, double m22) {
		
		double cos = (m00 + m11 + m22 - 1.0D) * 0.5D;
    	this.x = (float)(m21 - m12);
    	this.y = (float)(m02 - m20);
    	this.z = (float)(m10 - m01);
    	
    	double sin = 0.5D * Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    	this.w = (float)Math.atan2(sin, cos);
    	
    	return this;
	}

	/**
	 * 
	 * @param quaternion
	 * @since 1.0.0
	 */
	public final void set(Quaternion quaternion) {
		
		this.x = quaternion.x;
		this.y = quaternion.y;
		this.z = quaternion.z;
		this.w = quaternion.w;
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
	 * @param data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {
		
		this.x = data[0];
		this.y = data[1];
		
		if(data.length > 1) this.z = data[2];
		if(data.length > 2) this.w = data[3];
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
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 fromMatrix(Matrix3 matrix) {
		
		return this.fromMatrix(matrix.m00, matrix.m01, matrix.m02,
							   matrix.m10, matrix.m11, matrix.m12,
							   matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 fromMatrix(Matrix4 matrix) {
		
		return this.fromMatrix(matrix.m00, matrix.m01, matrix.m02,
							   matrix.m10, matrix.m11, matrix.m12,
							   matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * <p><i>this instance will be manipulated</i></p>
	 * @param quaternion
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 fromQuaternion(Quaternion quaternion) {
		
		// This logic can calculate the angle without normalization.
    	// The direction of (x, y, z) and the sign of rotation cancel each other out and create a correct result.
		
		double sinA2 = Math.sqrt(quaternion.x * quaternion.x + quaternion.y * quaternion.y + quaternion.z * quaternion.z);
    	this.w = (float)(2.0D * Math.atan2(sinA2, quaternion.w));
    	this.x = (float)quaternion.x;
    	this.y = (float)quaternion.y;
    	this.z = (float)quaternion.z;
    	
    	return this;
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
	 * <p><i>this instance will be manipulated</i></p>
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
	 * <p><i>this instance will be manipulated</i></p>
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
	 * <p><i>this instance will be manipulated</i></p>
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
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion toQuaternion() {
		
		return new Quaternion(this);
	}
	
	/**
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 multiply(Matrix3 matrix) {
		
		this.x = this.x * matrix.m00 + this.y * matrix.m01 + this.z * matrix.m02;
		this.y = this.x * matrix.m10 + this.y * matrix.m11 + this.z * matrix.m12;
		this.z = this.x * matrix.m20 + this.y * matrix.m21 + this.z * matrix.m22;
		this.w = 0.0F;
		
		return this;
	}
	
	/**
	 * <p><i>this instance will be manipulated</i></p>
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 multiply(Matrix4 matrix) {
		
		this.x = this.x * matrix.m00 + this.y * matrix.m01 + this.z * matrix.m02 + this.w * matrix.m03;
		this.y = this.x * matrix.m10 + this.y * matrix.m11 + this.z * matrix.m12 + this.w * matrix.m13;
		this.z = this.x * matrix.m20 + this.y * matrix.m21 + this.z * matrix.m22 + this.w * matrix.m23;
		this.w = this.x * matrix.m30 + this.y * matrix.m31 + this.z * matrix.m32 + this.w * matrix.m33;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
    public final float distanceSquared(Vector4 b) {
    	
    	double dx = this.x - b.x;
    	double dy = this.y - b.y;
    	double dz = this.z - b.z;
    	double dw = this.w - b.w;
	
    	return (float)(dx * dx + dy * dy + dz * dz + dw * dw);
    }
    
    /**
     * 
     * @param b
     * @return
     * @since 1.0.0
     */
    public final float distance(Vector4 b) {
    	
    	return (float)Math.sqrt(this.distanceSquared(b));
    }
	
    /**
     * 
     * @param b
     * @return
     * @since 1.0.0
     */
    public final float distanceL1(Vector4 b) {
    	
    	return Math.abs(this.x - b.x) +
    		   Math.abs(this.y - b.y) +
    		   Math.abs(this.z - b.z) +
    		   Math.abs(this.w - b.w);
    }
    
    /**
     * 
     * @param b
     * @return
     * @since 1.0.0
     */
    public final float distanceLinf(Vector4 b) {
    	
    	return Math.max(Math.max(Math.abs(this.x - b.x), Math.abs(this.y - b.y)), Math.max(Math.abs(this.z - b.z), Math.abs(this.w - b.w)));
    }
    
    /**
     * <p><i>this instance will be manipulated</i></p>
     * @param b
     * @return
     * @since 1.0.0
     */
    public final Vector4 project(Vector4 b) {
    	
    	this.x = b.x / b.w;
   	 	this.y = b.y / b.w;
   	 	this.z = b.z / b.w;
   	 	this.w = 1.0F;
   	 	
   	 	return this;
    }
    
    /**
     * <p><i>this instance will be manipulated</i></p>
     * @param b
     * @param alpha
     * @return
     * @since 1.0.0
     */
    public final Vector4 interpolate(Vector4 b, float alpha) {
    	
    	float beta = 1 - alpha;
    	
    	this.x = beta * this.x + alpha * b.x;
    	this.y = beta * this.y + alpha * b.y;
    	this.z = beta * this.z + alpha * b.z;
		this.w = beta * this.w + alpha * b.w;
		
		return this;
    }
    
    /**
     * <p><i>this instance will be manipulated</i></p>
     * @param b
     * @param epsilon
     * @return
     * @since 1.0.0
     */
    public final boolean epsilonEquals(Vector4 b, float epsilon) {
    	
    	return (Math.abs(b.x - this.x) <= epsilon) &&
    		   (Math.abs(b.y - this.y) <= epsilon) &&
    		   (Math.abs(b.z - this.z) <= epsilon) &&
    		   (Math.abs(b.w - this.w) <= epsilon);
    }
    
	@Override
    public final Vector4 clampMin(float min) {
	
    	if(this.x < min) this.x = min;
    	if(this.y < min) this.y = min;
    	if(this.z < min) this.z = min;
    	if(this.w < min) this.w = min;
    	
    	return this;
    }

	@Override
    public final Vector4 clampMax(float max) {
	
    	if(this.x > max) this.x = max;
    	if(this.y > max) this.y = max;
    	if(this.z < max) this.z = max;
    	if(this.w < max) this.w = max;
    	
    	return this;
    }
	
	@Override
	public final Vector4 absolute() {
		
		if(this.x < 0.0F) this.x = -this.x;
		if(this.y < 0.0F) this.y = -this.y;
		if(this.z < 0.0F) this.z = -this.z;
		if(this.w < 0.0F) this.w = -this.w;
		
		return this;
	}
	
	@Override
	public final Vector4 copy() {
		
		return new Vector4(this);
	}
	
	@Override
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
	}

	@Override
	public final Vector4 negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		this.w = -this.w;
		
		return this;
	}

	@Override
	public final Vector4 scale(float scale) {
		
		this.x *= scale;
		this.y *= scale;
		this.z *= scale;
		this.w *= scale;
		
		return this;
	}
	
	@Override
	public final float[] toArray() {
		
		return new float[] {this.x, this.y, this.z, this.w};
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
	
    @Override
    public final int hashCode() {
	
    	return Float.floatToIntBits(this.x) ^
               Float.floatToIntBits(this.y) ^
               Float.floatToIntBits(this.z) ^
               Float.floatToIntBits(this.w);
    }
}
