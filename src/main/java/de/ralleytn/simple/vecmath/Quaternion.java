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
	 * @param quat
	 * @since 1.0.0
	 */
	public final void set(Quaternion quat) {
		
		this.set(quat.x, quat.y, quat.z, quat.w);
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
		
		if(data.length > 1) this.z = data[2]; else this.z = 0.0F;
		if(data.length > 2) this.w = data[3]; else this.w = 0.0F;
	}
	
	/**
	 * 
	 * @param vec
	 * @since 1.0.0
	 */
	public final void set(Vector4 vec) {
		
		this.set(vec.x, vec.y, vec.z, vec.w);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 * @since 1.0.0
	 */
	public final void set(float x, float y, float z) {
		
		this.set(x, y, z, 0.0F);
	}
	
	/**
	 * 
	 * @param vec
	 * @since 1.0.0
	 */
	public final void set(Vector3 vec) {
		
		this.set(vec.x, vec.y, vec.z, 0.0F);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @since 1.0.0
	 */
	public final void set(float x, float y) {
		
		this.set(x, y, 0.0F, 0.0F);
	}
	
	/**
	 * 
	 * @param vec
	 * @since 1.0.0
	 */
	public final void set(Vector2 vec) {
		
		this.set(vec.x, vec.y, 0.0F, 0.0F);
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
		
		this.set(0.0F, 0.0F, 0.0F, 1.0F);
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion multiply(Quaternion b) {

		this.set(this.x * b.w + this.w * b.x + this.y * b.z - this.z * b.y,
				 this.y * b.w + this.w * b.y + this.z * b.x - this.x * b.z,
				 this.z * b.w + this.w * b.z + this.x * b.y - this.y * b.x,
				 this.w * b.w - this.x * b.x - this.y * b.y - this.z * b.z);
		
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
		
		this.set((this.x * b.w - this.w * b.x - this.y * b.z + this.z * b.y) * n,
				 (this.y * b.w - this.w * b.y - this.z * b.x + this.x * b.z) * n,
				 (this.z * b.w - this.w * b.z - this.x * b.y + this.y * b.x) * n,
				 (this.w * b.w + this.x * b.x + this.y * b.y + this.z * b.z) * n);
		
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
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector2 toVector2() {
		
		return new Vector2(this.x, this.y);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 toVector3() {
		
		return new Vector3(this.x, this.y, this.z);
	}

	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion conjugate() {

		this.set(-this.x, -this.y, -this.z, this.w);
		
		return this;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion inverse() {
		
		float n = this.lengthSquared();
		
		this.set(-this.x / n,
				 -this.y / n,
				 -this.z / n,
				  this.w / n);
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @param alpha
	 * @return
	 * @since 1.0.0
	 */
	public final Quaternion interpolate(Quaternion b, double alpha) {
		
		this.normalize();
		double n1 = this.length();
		
		double x1 = b.x / n1;
    	double y1 = b.y / n1;
    	double z1 = b.z / n1;
    	double w1 = b.w / n1;
    	
    	double dot = this.x * x1 + this.y * y1 + this.z * z1 + this.w * w1;
    	
    	if(1.0 > Math.abs(dot)) {
    		
    		double theta = Math.acos(dot);
        	double thetaSin = Math.sin(theta);
        	
        	if(thetaSin != 0.0) {
        		
        		double s = Math.sin((1.0D - alpha) * theta) / thetaSin;
            	theta = Math.sin(alpha * theta) / thetaSin;
            	
            	this.set((float)(s * this.x + theta * x1),
            			 (float)(s * this.y + theta * y1),
            			 (float)(s * this.z + theta * z1),
            			 (float)(s * this.w + theta * w1));
        		
        	} else {
        		
        		// same quaternion (avoid zero-div)
        	}
    		
    	} else {
    		
    		// same quaternion (avoid domain error)
    	}
		
		return this;
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
		
		return new float[] {
				
			this.x,
			this.y,
			this.z,
			this.w
		};
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
