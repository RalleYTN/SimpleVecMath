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
public final class Quaternion extends Vector<Quaternion> {

	public float x;
	public float y;
	public float z;
	public float w;
	
	/**
	 * @since 1.0.0
	 */
	public Quaternion() {
		
		this.identity();
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public Quaternion(float x, float y) {
		
		this.set(x, y);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Quaternion(Vector2 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param vector
	 * @param z
	 * @since 1.0.0
	 */
	public Quaternion(Vector2 vector, float z) {
		
		this.set(vector);
		this.z = z;
	}
	
	/**
	 * 
	 * @param vector
	 * @param z
	 * @param w
	 * @since 1.0.0
	 */
	public Quaternion(Vector2 vector, float z, float w) {
		
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
	public Quaternion(float x, float y, float z) {
		
		this.set(x, y, z);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Quaternion(Vector3 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param vector
	 * @param w
	 * @since 1.0.0
	 */
	public Quaternion(Vector3 vector, float w) {
		
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
	public Quaternion(float x, float y, float z, float w) {
		
		this.set(x, y, z, w);
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Quaternion(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param vector
	 * @since 1.0.0
	 */
	public Quaternion(Vector4 vector) {
		
		this.set(vector);
	}
	
	/**
	 * 
	 * @param quaternion
	 * @since 1.0.0
	 */
	public Quaternion(Quaternion quaternion) {
		
		this.set(quaternion);
	}
	
	private final Quaternion fromMatrix(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		
		float s;
		float tr = m00 + m11 + m22;
		
		if(tr >= 0.0D) {
			
			s = (float)Math.sqrt(tr + 1.0D);
			this.w = s * 0.5F;
			s = 0.5F / s;
			this.x = (m21 - m12) * s;
			this.y = (m02 - m20) * s;
			this.z = (m10 - m01) * s;
			
		} else {
			
			float max = Math.max(Math.max(m00, m11), m22);
			
			if(max == m00) {
				
				s = (float)Math.sqrt(m00 - (m11 + m22) + 1.0D);
				this.x = s * 0.5F;
				s = 0.5F / s;
				this.y = (m01 + m10) * s;
				this.z = (m20 + m02) * s;
				this.w = (m21 - m12) * s;
				
			} else if (max == m11) {
				
				s = (float)Math.sqrt(m11 - (m22 + m00) + 1.0D);
				this.y = s * 0.5F;
				s = 0.5F / s;
				this.z = (m12 + m21) * s;
				this.x = (m01 + m10) * s;
				this.w = (m02 - m20) * s;
				
			} else {
				
				s = (float)Math.sqrt(m22 - (m00 + m11) + 1.0D);
				this.z = s * 0.5F;
				s = 0.5F / s;
				this.x = (m20 + m02) * s;
				this.y = (m12 + m21) * s;
				this.w = (m10 - m01) * s;
			}
		}

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
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final float dot(Quaternion b) {
		
		return this.x * b.x + this.y * b.y + this.z * b.z + this.w * b.w;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion identity() {
		
		this.x = 0.0F;
		this.y = 0.0F;
		this.z = 0.0F;
		this.w = 1.0F;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion multiply(Quaternion b) {
		
		float x = this.x * b.w + this.w * b.x + this.y * b.z - this.z * b.y;
		float y = this.y * b.w + this.w * b.y + this.z * b.x - this.x * b.z;
		float z = this.z * b.w + this.w * b.z + this.x * b.y - this.y * b.x;
		float w = this.w * b.w - this.x * b.x - this.y * b.y - this.z * b.z;
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion multiplyInverse(Quaternion b) {
		
		float n = b.lengthSquared();
		
		if(n != 0.0F) {
			
			n = 1.0F / n;
		}

		float x = (this.x * b.w - this.w * b.x - this.y * b.z + this.z * b.y) * n;
		float y = (this.y * b.w - this.w * b.y - this.z * b.x + this.x * b.z) * n;
		float z = (this.z * b.w - this.w * b.z - this.x * b.y + this.y * b.x) * n;
		float w = (this.w * b.w + this.x * b.x + this.y * b.y + this.z * b.z) * n;
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		
		return this;
	}
	
	/**
	 * 
	 * @param axisAngle
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion fromAxisAngle(Vector4 axisAngle) {
		
		this.x = axisAngle.x;
		this.y = axisAngle.y;
		this.z = axisAngle.z;
		
		float n = (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		float s = (float)(Math.sin(0.5D * axisAngle.w) / n);
		
		this.x *= s;
		this.y *= s;
		this.z *= s;
		this.w = (float) Math.cos(0.5D * axisAngle.w);
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion fromMatrix(Matrix3 matrix) {
		
		return this.fromMatrix(matrix.m00, matrix.m01, matrix.m02,
				   			   matrix.m10, matrix.m11, matrix.m12,
				   			   matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion fromMatrix(Matrix4 matrix) {
		
		return this.fromMatrix(matrix.m00, matrix.m01, matrix.m02,
							   matrix.m10, matrix.m11, matrix.m12,
							   matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 toVector4() {
		
		return new Vector4(this);
	}
	
	@Override
    public final Quaternion clampMin(float min) {
	
    	if(this.x < min) this.x = min;
    	if(this.y < min) this.y = min;
    	if(this.z < min) this.z = min;
    	if(this.w < min) this.w = min;
    	
    	return this;
    }

	@Override
    public final Quaternion clampMax(float max) {
	
    	if(this.x > max) this.x = max;
    	if(this.y > max) this.y = max;
    	if(this.z < max) this.z = max;
    	if(this.w < max) this.w = max;
    	
    	return this;
    }
	
	@Override
	public final Quaternion absolute() {
		
		if(this.x < 0.0F) this.x = -this.x;
		if(this.y < 0.0F) this.y = -this.y;
		if(this.z < 0.0F) this.z = -this.z;
		if(this.w < 0.0F) this.w = -this.w;
		
		return this;
	}

	@Override
	public final Quaternion negate() {
		
		this.x = -this.x;
		this.y = -this.y;
		this.z = -this.z;
		
		// TODO
		// ==== 09.03.2018 | Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
		// For some reason the LWJGL2 legacy code doesn't negate the 4th element of the quaternion.
		// This doesn't seem correct.
		// Please someone confirm!
		// https://github.com/LWJGL/lwjgl/blob/master/src/java/org/lwjgl/util/vector/Quaternion.java
		// ====
		
		return this;
	}
	
	@Override
	public final Quaternion copy() {
		
		return new Quaternion(this);
	}
	
	@Override
	public final Quaternion scale(float scale) {
		
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
	public final float lengthSquared() {
		
		return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
	}

	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("(%s,%s,%s,%s)", this.x, this.y, this.z, this.w);
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Quaternion) {
			
			Quaternion quaternion = (Quaternion)object;
			return this.x == quaternion.x && this.y == quaternion.y && this.z == quaternion.z && this.w == quaternion.w;
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
