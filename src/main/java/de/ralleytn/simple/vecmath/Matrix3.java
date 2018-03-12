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
public final class Matrix3 extends Matrix<Matrix3> {

	public float m00, m01, m02;
	public float m10, m11, m12;
	public float m20, m21, m22;
	
	/**
	 * @since 1.0.0
	 */
	public Matrix3() {
		
		this.identity();
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
	 * @param matrix
	 * @since 1.0.0
	 */
	public Matrix3(Matrix4 matrix) {
		
		this.set(matrix);
	}
	
	private final void set(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
		
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {
		
		this.set(data[0], data[1], data[2],
				 data[3], data[4], data[5],
				 data[6], data[7], data[8]);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public final void set(Matrix3 matrix) {
		
		this.set(matrix.m00, matrix.m01, matrix.m02,
				 matrix.m10, matrix.m11, matrix.m12,
				 matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public final void set(Matrix4 matrix) {
		
		this.set(matrix.m00, matrix.m01, matrix.m02,
				 matrix.m10, matrix.m11, matrix.m12,
				 matrix.m20, matrix.m21, matrix.m22);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 copy() {
		
		return new Matrix3(this);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 add(Matrix3 matrix) {
		
		this.set(this.m00 + matrix.m00, this.m01 + matrix.m01, this.m02 + matrix.m02,
				 this.m10 + matrix.m10, this.m11 + matrix.m11, this.m12 + matrix.m12,
				 this.m20 + matrix.m20, this.m21 + matrix.m21, this.m22 + matrix.m22);
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 subtract(Matrix3 matrix) {
		
		this.set(this.m00 - matrix.m00, this.m01 - matrix.m01, this.m02 - matrix.m02,
				 this.m10 - matrix.m10, this.m11 - matrix.m11, this.m12 - matrix.m12,
				 this.m20 - matrix.m20, this.m21 - matrix.m21, this.m22 - matrix.m22);
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 multiply(Matrix3 matrix) {
		
		this.set(this.m00 * matrix.m00 + this.m10 * matrix.m01 + this.m20 * matrix.m02,
				 this.m01 * matrix.m00 + this.m11 * matrix.m01 + this.m21 * matrix.m02,
				 this.m02 * matrix.m00 + this.m12 * matrix.m01 + this.m22 * matrix.m02,
				 this.m00 * matrix.m10 + this.m10 * matrix.m11 + this.m20 * matrix.m12,
				 this.m01 * matrix.m10 + this.m11 * matrix.m11 + this.m21 * matrix.m12,
				 this.m02 * matrix.m10 + this.m12 * matrix.m11 + this.m22 * matrix.m12,
				 this.m00 * matrix.m20 + this.m10 * matrix.m21 + this.m20 * matrix.m22,
				 this.m01 * matrix.m20 + this.m11 * matrix.m21 + this.m21 * matrix.m22,
				 this.m02 * matrix.m20 + this.m12 * matrix.m21 + this.m22 * matrix.m22);

		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector3 transform(Vector3 vector) {

		return new Vector3(this.m00 * vector.x + this.m10 * vector.y + this.m20 * vector.z,
						   this.m01 * vector.x + this.m11 * vector.y + this.m21 * vector.z,
						   this.m02 * vector.x + this.m12 * vector.y + this.m22 * vector.z);
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 toMatrix4() {
		
		return new Matrix4(this);
	}
	
	@Override
	public final Matrix3 identity() {
		
		this.set(1.0F, 0.0F, 0.0F,
				 0.0F, 1.0F, 0.0F,
				 0.0F, 0.0F, 1.0F);
		
		return this;
	}

	@Override
	public final Matrix3 invert() {
		
		float invertedDeterminant = 1.0F / this.determinant();
		
		this.set((this.m11 * this.m22 - this.m12 * this.m21) * invertedDeterminant,
				 (-this.m01 * this.m22 + this.m02 * this.m21) * invertedDeterminant,
				 (this.m01 * this.m12 - this.m02 * this.m11) * invertedDeterminant,
				 (-this.m10 * this.m22 + this.m12 * this.m20) * invertedDeterminant,
				 (this.m00 * this.m22 - this.m02 * this.m20) * invertedDeterminant,
				 (-this.m00 * this.m12 + this.m02 * this.m10) * invertedDeterminant,
				 (this.m10 * this.m21 - this.m11 * this.m20) * invertedDeterminant,
				 (-this.m00 * this.m21 + this.m01 * this.m20) * invertedDeterminant,
				 (this.m00 * this.m11 - this.m01 * this.m10) * invertedDeterminant);

		return this;
	}

	@Override
	public final Matrix3 negate() {
		
		this.set(-this.m00, -this.m01, -this.m02,
				 -this.m10, -this.m11, -this.m12,
				 -this.m20, -this.m21, -this.m22);
		
		return this;
	}

	@Override
	public final Matrix3 transpose() {
		
		this.set(this.m00, this.m10, this.m20,
				 this.m01, this.m11, this.m21,
				 this.m02, this.m12, this.m22);
		
		return this;
	}

	@Override
	public final Matrix3 zero() {
		
		this.set(0.0F, 0.0F, 0.0F,
				 0.0F, 0.0F, 0.0F,
				 0.0F, 0.0F, 0.0F);

		return this;
	}

	@Override
	public final float determinant() {
		
		return this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) +
			   this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) +
			   this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
	}
	
	@Override
	public final float[] toArray() {
		
		return new float[] {
				
			this.m00, this.m01, this.m02,
			this.m10, this.m11, this.m12,
			this.m20, this.m21, this.m22
		};
	}
	
	@Override
	public final String toString() {
		
		// Cannot take %f because it will format the values depending on locale
		return String.format("[\n\t[%s,%s,%s],\n\t[%s,%s,%s],\n\t[%s,%s,%s]\n]", this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22);
	}
	
    @Override
    public final int hashCode() {
	
    	return Float.floatToIntBits(this.m00) ^
    		   Float.floatToIntBits(this.m01) ^
    		   Float.floatToIntBits(this.m02) ^
               Float.floatToIntBits(this.m10) ^
               Float.floatToIntBits(this.m11) ^
               Float.floatToIntBits(this.m12) ^
               Float.floatToIntBits(this.m20) ^
               Float.floatToIntBits(this.m21) ^
               Float.floatToIntBits(this.m22);
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
}
