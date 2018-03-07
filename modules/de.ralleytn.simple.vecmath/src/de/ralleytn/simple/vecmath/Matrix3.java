/*
 * MIT License
 * 
 * Copyright (c) 2017 Ralph Niemitz
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
public final class Matrix3 extends Matrix {

	public float m00, m01, m02;
	public float m10, m11, m12;
	public float m20, m21, m22;
	
	/**
	 * @since 1.0.0
	 */
	public Matrix3() {
		
		this.setIdentity();
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Matrix3(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public Matrix3(Matrix3 matrix) {
		
		this.set(matrix);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 add(Matrix3 a, Matrix3 b) {
		
		return a.copy().add(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 subtract(Matrix3 a, Matrix3 b) {
		
		return a.copy().subtract(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 multiply(Matrix3 a, Matrix3 b) {
		
		return a.copy().multiply(b);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector3 transform(Matrix3 matrix, Vector3 vector) {
		
		return matrix.copy().transform(vector);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 invert(Matrix3 matrix) {
		
		return (Matrix3)matrix.copy().invert();
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 negate(Matrix3 matrix) {
		
		return (Matrix3)matrix.copy().negate();
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix3 transpose(Matrix3 matrix) {
		
		return (Matrix3)matrix.copy().transpose();
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {
		
		this.m00 = data[0];
		this.m01 = data[1];
		this.m02 = data[2];
		
		this.m10 = data[3];
		this.m11 = data[4];
		this.m12 = data[5];
		
		this.m20 = data[6];
		this.m21 = data[7];
		this.m22 = data[8];
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public final void set(Matrix3 matrix) {
		
		this.set(matrix.toArray());
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 copy() {
		
		return new Matrix3(new float[] {
			
			this.m00, this.m01, this.m02,
			this.m10, this.m11, this.m12,
			this.m20, this.m21, this.m22
		});
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 add(Matrix3 matrix) {
		
		this.m00 += matrix.m00;
		this.m01 += matrix.m01;
		this.m02 += matrix.m02;
		
		this.m10 += matrix.m10;
		this.m11 += matrix.m11;
		this.m12 += matrix.m12;
		
		this.m20 += matrix.m20;
		this.m21 += matrix.m21;
		this.m22 += matrix.m22;
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 subtract(Matrix3 matrix) {
		
		this.m00 -= matrix.m00;
		this.m01 -= matrix.m01;
		this.m02 -= matrix.m02;
		
		this.m10 -= matrix.m10;
		this.m11 -= matrix.m11;
		this.m12 -= matrix.m12;
		
		this.m20 -= matrix.m20;
		this.m21 -= matrix.m21;
		this.m22 -= matrix.m22;
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 multiply(Matrix3 matrix) {
		
		float m00 = this.m00 * matrix.m00 + this.m10 * matrix.m01 + this.m20 * matrix.m02;
		float m01 = this.m01 * matrix.m00 + this.m11 * matrix.m01 + this.m21 * matrix.m02;
		float m02 = this.m02 * matrix.m00 + this.m12 * matrix.m01 + this.m22 * matrix.m02;
		
		float m10 = this.m00 * matrix.m10 + this.m10 * matrix.m11 + this.m20 * matrix.m12;
		float m11 = this.m01 * matrix.m10 + this.m11 * matrix.m11 + this.m21 * matrix.m12;
		float m12 = this.m02 * matrix.m10 + this.m12 * matrix.m11 + this.m22 * matrix.m12;
		
		float m20 = this.m00 * matrix.m20 + this.m10 * matrix.m21 + this.m20 * matrix.m22;
		float m21 = this.m01 * matrix.m20 + this.m11 * matrix.m21 + this.m21 * matrix.m22;
		float m22 = this.m02 * matrix.m20 + this.m12 * matrix.m21 + this.m22 * matrix.m22;

		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 transform(Vector3 vector) {
		
		float x = this.m00 * vector.x + this.m10 * vector.y + this.m20 * vector.z;
		float y = this.m01 * vector.x + this.m11 * vector.y + this.m21 * vector.z;
		float z = this.m02 * vector.x + this.m12 * vector.y + this.m22 * vector.z;

		return new Vector3(x, y, z);
	}
	
	@Override
	public final Matrix setIdentity() {
		
		this.m00 = 1.0F;
		this.m01 = 0.0F;
		this.m02 = 0.0F;
		
		this.m10 = 0.0F;
		this.m11 = 1.0F;
		this.m12 = 0.0F;
		
		this.m20 = 0.0F;
		this.m21 = 0.0F;
		this.m22 = 1.0F;
		
		return this;
	}

	@Override
	public final Matrix invert() {
		
		float determinant = this.determinant();
		float determinantInv = 1.0F / determinant;
		
		float t00 = this.m11 * this.m22 - this.m12 * this.m21;
		float t01 = -this.m10 * this.m22 + this.m12 * this.m20;
		float t02 = this.m10 * this.m21 - this.m11 * this.m20;
		
		float t10 = -this.m01 * this.m22 + this.m02 * this.m21;
		float t11 = this.m00 * this.m22 - this.m02 * this.m20;
		float t12 = -this.m00 * this.m21 + this.m01 * this.m20;
		
		float t20 = this.m01 * this.m12 - this.m02 * this.m11;
		float t21 = -this.m00 * this.m12 + this.m02 * this.m10;
		float t22 = this.m00 * this.m11 - this.m01 * this.m10;

		this.m00 = t00 * determinantInv;
		this.m11 = t11 * determinantInv;
		this.m22 = t22 * determinantInv;
		this.m01 = t10 * determinantInv;
		this.m10 = t01 * determinantInv;
		this.m20 = t02 * determinantInv;
		this.m02 = t20 * determinantInv;
		this.m12 = t21 * determinantInv;
		this.m21 = t12 * determinantInv;

		return this;
	}

	@Override
	public final Matrix negate() {
		
		this.m00 = -this.m00;
		this.m01 = -this.m02;
		this.m02 = -this.m01;
		
		this.m10 = -this.m10;
		this.m11 = -this.m12;
		this.m12 = -this.m11;
		
		this.m20 = -this.m20;
		this.m21 = -this.m22;
		this.m22 = -this.m21;

		return this;
	}

	@Override
	public final Matrix transpose() {
		
		float m00 = this.m00;
		float m01 = this.m10;
		float m02 = this.m20;
		
		float m10 = this.m01;
		float m11 = this.m11;
		float m12 = this.m21;
		
		float m20 = this.m02;
		float m21 = this.m12;
		float m22 = this.m22;

		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		
		return this;
	}

	@Override
	public final Matrix setZero() {
		
		this.m00 = 0.0F;
		this.m01 = 0.0F;
		this.m02 = 0.0F;
		
		this.m10 = 0.0F;
		this.m11 = 0.0F;
		this.m12 = 0.0F;
		
		this.m20 = 0.0F;
		this.m21 = 0.0F;
		this.m22 = 0.0F;

		return this;
	}

	@Override
	public final float determinant() {
		
		return this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) +
			   this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) +
			   this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
	}
	
	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("[\n\t[%s,%s,%s],\n\t[%s,%s,%s],\n\t[%s,%s,%s]\n]", this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22);
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Matrix3) {
			
			Matrix3 matrix = (Matrix3)object;
			
			return this.m00 == matrix.m00 && this.m01 == matrix.m01 && this.m02 == matrix.m02 &&
				   this.m10 == matrix.m10 && this.m11 == matrix.m11 && this.m12 == matrix.m12 &&
				   this.m20 == matrix.m20 && this.m21 == matrix.m21 && this.m22 == matrix.m22;
		}
		
		return false;
	}

	@Override
	public final float[] toArray() {
		
		return new float[] {
				
			this.m00, this.m01, this.m02,
			this.m10, this.m11, this.m12,
			this.m20, this.m21, this.m22
		};
	}
}
