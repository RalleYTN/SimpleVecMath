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
public final class Matrix4 extends Matrix<Matrix4> {

	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;
	
	/**
	 * @since 1.0.0
	 */
	public Matrix4() {
		
		this.identity();
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Matrix4(float[] data) {
		
		this.set(data);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public Matrix4(Matrix4 matrix) {
		
		this.set(matrix);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public Matrix4(Matrix3 matrix) {
		
		this.set(matrix);
	}
	
	private static final float determinant3x3(float t00, float t01, float t02, float t10, float t11, float t12, float t20, float t21, float t22) {

		return t00 * (t11 * t22 - t12 * t21)
             + t01 * (t12 * t20 - t10 * t22)
             + t02 * (t10 * t21 - t11 * t20);
	}
	
	private final void set(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
		
		this.m00 = m00;
		this.m01 = m01;
		this.m02 = m02;
		this.m03 = m03;
		
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.m13 = m13;
		
		this.m20 = m20;
		this.m21 = m21;
		this.m22 = m22;
		this.m23 = m23;
		
		this.m30 = m30;
		this.m31 = m31;
		this.m32 = m32;
		this.m33 = m33;
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public final void set(float[] data) {

		this.set(data[0],  data[1],  data[2],  data[3],
				 data[4],  data[5],  data[6],  data[7],
				 data[8],  data[9],  data[10], data[11],
				 data[12], data[13], data[14], data[15]);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public final void set(Matrix4 matrix) {
		
		this.set(matrix.m00, matrix.m01, matrix.m02, matrix.m03,
				 matrix.m10, matrix.m11, matrix.m12, matrix.m13,
				 matrix.m20, matrix.m21, matrix.m22, matrix.m23,
				 matrix.m30, matrix.m31, matrix.m32, matrix.m33);
	}
	
	/**
	 * 
	 * @param matrix
	 * @since 1.0.0
	 */
	public final void set(Matrix3 matrix) {
		
		this.set(matrix.m00, matrix.m01, matrix.m02, 0.0F,
				 matrix.m10, matrix.m11, matrix.m12, 0.0F,
				 matrix.m20, matrix.m21, matrix.m22, 0.0F,
				 0.0F,       0.0F,       0.0F,       0.0F);
	}

	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 copy() {
		
		return new Matrix4(this);
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 add(Matrix4 b) {
		
		this.set(this.m00 + b.m00, this.m01 + b.m01, this.m02 + b.m02, this.m03 + b.m03,
				 this.m10 + b.m10, this.m11 + b.m11, this.m12 + b.m12, this.m13 + b.m13,
				 this.m20 + b.m20, this.m21 + b.m21, this.m22 + b.m22, this.m23 + b.m23,
				 this.m30 + b.m30, this.m31 + b.m31, this.m32 + b.m32, this.m33 + b.m33);
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 subtract(Matrix4 b) {
		
		this.set(this.m00 - b.m00, this.m01 - b.m01, this.m02 - b.m02, this.m03 - b.m03,
				 this.m10 - b.m10, this.m11 - b.m11, this.m12 - b.m12, this.m13 - b.m13,
				 this.m20 - b.m20, this.m21 - b.m21, this.m22 - b.m22, this.m23 - b.m23,
				 this.m30 - b.m30, this.m31 - b.m31, this.m32 - b.m32, this.m33 - b.m33);
		
		return this;
	}
	
	/**
	 * 
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 multiply(Matrix4 b) {
		
		this.set(this.m00 * b.m00 + this.m10 * b.m01 + this.m20 * b.m02 + this.m30 * b.m03,
				 this.m01 * b.m00 + this.m11 * b.m01 + this.m21 * b.m02 + this.m31 * b.m03,
				 this.m02 * b.m00 + this.m12 * b.m01 + this.m22 * b.m02 + this.m32 * b.m03,
				 this.m03 * b.m00 + this.m13 * b.m01 + this.m23 * b.m02 + this.m33 * b.m03,
				 this.m00 * b.m10 + this.m10 * b.m11 + this.m20 * b.m12 + this.m30 * b.m13,
				 this.m01 * b.m10 + this.m11 * b.m11 + this.m21 * b.m12 + this.m31 * b.m13,
				 this.m02 * b.m10 + this.m12 * b.m11 + this.m22 * b.m12 + this.m32 * b.m13,
				 this.m03 * b.m10 + this.m13 * b.m11 + this.m23 * b.m12 + this.m33 * b.m13,
				 this.m00 * b.m20 + this.m10 * b.m21 + this.m20 * b.m22 + this.m30 * b.m23,
				 this.m01 * b.m20 + this.m11 * b.m21 + this.m21 * b.m22 + this.m31 * b.m23,
				 this.m02 * b.m20 + this.m12 * b.m21 + this.m22 * b.m22 + this.m32 * b.m23,
				 this.m03 * b.m20 + this.m13 * b.m21 + this.m23 * b.m22 + this.m33 * b.m23,
				 this.m00 * b.m30 + this.m10 * b.m31 + this.m20 * b.m32 + this.m30 * b.m33,
				 this.m01 * b.m30 + this.m11 * b.m31 + this.m21 * b.m32 + this.m31 * b.m33,
				 this.m02 * b.m30 + this.m12 * b.m31 + this.m22 * b.m32 + this.m32 * b.m33,
				 this.m03 * b.m30 + this.m13 * b.m31 + this.m23 * b.m32 + this.m33 * b.m33);

		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 transform(Vector4 vector) {

		return new Vector4(this.m00 * vector.x + this.m10 * vector.y + this.m20 * vector.z + this.m30 * vector.w,
						   this.m01 * vector.x + this.m11 * vector.y + this.m21 * vector.z + this.m31 * vector.w,
						   this.m02 * vector.x + this.m12 * vector.y + this.m22 * vector.z + this.m32 * vector.w,
						   this.m03 * vector.x + this.m13 * vector.y + this.m23 * vector.z + this.m33 * vector.w);
	}
	
	/**
	 * 
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 scale(Vector3 scale) {
		
		this.m00 *= scale.x;
		this.m01 *= scale.x;
		this.m02 *= scale.x;
		this.m03 *= scale.x;
		
		this.m10 *= scale.y;
		this.m11 *= scale.y;
		this.m12 *= scale.y;
		this.m13 *= scale.y;
		
		this.m20 *= scale.z;
		this.m21 *= scale.z;
		this.m22 *= scale.z;
		this.m23 *= scale.z;
		
		return this;
	}
	
	/**
	 * 
	 * @param angle
	 * @param axis
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 rotate(float angle, Axis axis) {
		
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		
		float oneminusc = 1.0F - c;
		
		float xy = axis.getX() * axis.getY();
		float yz = axis.getY() * axis.getZ();
		float xz = axis.getX() * axis.getZ();
		float xs = axis.getX() * s;
		float ys = axis.getY() * s;
		float zs = axis.getZ() * s;
		
		float f00 = axis.getX() * axis.getX() * oneminusc + c;
		float f01 = xy * oneminusc + zs;
		float f02 = xz * oneminusc - ys;
		
		float f10 = xy * oneminusc - zs;
		float f11 = axis.getY() * axis.getY() * oneminusc + c;
		float f12 = yz * oneminusc + xs;
		
		float f20 = xz * oneminusc + ys;
		float f21 = yz * oneminusc - xs;
		float f22 = axis.getZ() * axis.getZ() * oneminusc + c;

		this.set(this.m00 * f00 + this.m10 * f01 + this.m20 * f02,
				 this.m01 * f00 + this.m11 * f01 + this.m21 * f02,
				 this.m02 * f00 + this.m12 * f01 + this.m22 * f02,
				 this.m03 * f00 + this.m13 * f01 + this.m23 * f02,
				 this.m00 * f10 + this.m10 * f11 + this.m20 * f12,
				 this.m01 * f10 + this.m11 * f11 + this.m21 * f12,
				 this.m02 * f10 + this.m12 * f11 + this.m22 * f12,
				 this.m03 * f10 + this.m13 * f11 + this.m23 * f12,
				 this.m00 * f20 + this.m10 * f21 + this.m20 * f22,
				 this.m01 * f20 + this.m11 * f21 + this.m21 * f22,
				 this.m02 * f20 + this.m12 * f21 + this.m22 * f22,
				 this.m03 * f20 + this.m13 * f21 + this.m23 * f22,
			     this.m30, this.m31, this.m32, this.m33);
		
		return this;
	}
	
	/**
	 * 
	 * @param rotation
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 rotate(Vector3 rotation) {
		
		return this.rotate(rotation.x, Axis.X)
				   .rotate(rotation.y, Axis.Y)
				   .rotate(rotation.z, Axis.Z);
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 translate(Vector3 vector) {
		
		this.m30 += this.m00 * vector.x + this.m10 * vector.y + this.m20 * vector.z;
		this.m31 += this.m01 * vector.x + this.m11 * vector.y + this.m21 * vector.z;
		this.m32 += this.m02 * vector.x + this.m12 * vector.y + this.m22 * vector.z;
		this.m33 += this.m03 * vector.x + this.m13 * vector.y + this.m23 * vector.z;

		return this;
	}
	
	/**
	 * 
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 scale(float scale) {
		
		return this.scale(new Vector3(scale, scale, scale));
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix3 toMatrix3() {
		
		return new Matrix3(this);
	}
	
	@Override
	public final float determinant() {
		
		float determinant =  this.m00 * ((this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32) - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
			  determinant -= this.m01 * ((this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32) - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
			  determinant += this.m02 * ((this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31) - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
			  determinant -= this.m03 * ((this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31) - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
	
		return determinant;
	}
	
	@Override
	public final Matrix4 invert() {

		float invertedDeterminant = 1.0F / this.determinant();
		
		this.set(Matrix4.determinant3x3(this.m11, this.m12, this.m13, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m01, this.m02, this.m03, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m31, this.m32, this.m33) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m21, this.m22, this.m23) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m10, this.m12, this.m13, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m00, this.m02, this.m03, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m30, this.m32, this.m33) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m10, this.m11, this.m13, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m00, this.m01, this.m03, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m30, this.m31, this.m33) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m10, this.m11, this.m12, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m00, this.m01, this.m02, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32) * invertedDeterminant,
				-Matrix4.determinant3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m30, this.m31, this.m32) * invertedDeterminant,
				 Matrix4.determinant3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22) * invertedDeterminant);

		return this;
	}
	
	@Override
	public final Matrix4 negate() {
		
		this.set(-this.m00, -this.m01, -this.m02, -this.m03,
				 -this.m10, -this.m11, -this.m12, -this.m13,
				 -this.m20, -this.m21, -this.m22, -this.m23,
				 -this.m30, -this.m31, -this.m32, -this.m33);
		
		return this;
	}
	
	@Override
	public final Matrix4 identity() {
		
		this.set(1, 0, 0, 0,
				 0, 1, 0, 0,
				 0, 0, 1, 0,
				 0, 0, 0, 1);
		
		return this;
	}
	
	@Override
	public final Matrix4 zero() {
		
		this.set(0, 0, 0, 0,
				 0, 0, 0, 0,
				 0, 0, 0, 0,
				 0, 0, 0, 0);
		
		return this;
	}
	
	@Override
	public final Matrix4 transpose() {
		
		this.set(this.m00, this.m10, this.m20, this.m30,
				 this.m01, this.m11, this.m21, this.m31,
				 this.m02, this.m12, this.m22, this.m32,
				 this.m03, this.m13, this.m23, this.m33);
		
		return this;
	}
	
	@Override
	public final float[] toArray() {
		
		return new float[] {
				
			this.m00, this.m01, this.m02, this.m03,
			this.m10, this.m11, this.m12, this.m13,
			this.m20, this.m21, this.m22, this.m23,
			this.m30, this.m31, this.m32, this.m33
		};
	}
	
    @Override
    public final int hashCode() {
	
    	return Float.floatToIntBits(this.m00) ^
    		   Float.floatToIntBits(this.m01) ^
    		   Float.floatToIntBits(this.m02) ^
    		   Float.floatToIntBits(this.m03) ^
               Float.floatToIntBits(this.m10) ^
               Float.floatToIntBits(this.m11) ^
               Float.floatToIntBits(this.m12) ^
               Float.floatToIntBits(this.m13) ^
               Float.floatToIntBits(this.m20) ^
               Float.floatToIntBits(this.m21) ^
               Float.floatToIntBits(this.m22) ^
               Float.floatToIntBits(this.m23) ^
               Float.floatToIntBits(this.m30) ^
               Float.floatToIntBits(this.m31) ^
               Float.floatToIntBits(this.m32) ^
               Float.floatToIntBits(this.m33);
    }
	
	@Override
	public final String toString() {
		
		return String.format("[\n\t[%s,%s,%s,%s],\\n\\t[%s,%s,%s,%s],\\n\\t[%s,%s,%s,%s],\\n\\t[%s,%s,%s,%s]\n]", this.m00, this.m01, this.m02, this.m03,
																												  this.m10, this.m11, this.m12, this.m13,
																												  this.m20, this.m21, this.m22, this.m23,
																												  this.m30, this.m31, this.m32, this.m33);
	}
	
	@Override
	public final boolean equals(Object object) {
		
		if(object != null && object instanceof Matrix4) {
			
			Matrix4 matrix = (Matrix4)object;
			
			return this.m00 == matrix.m00 && this.m01 == matrix.m01 && this.m02 == matrix.m02 && this.m03 == matrix.m03 &&
				   this.m10 == matrix.m10 && this.m11 == matrix.m11 && this.m12 == matrix.m12 && this.m13 == matrix.m13 &&
				   this.m20 == matrix.m20 && this.m21 == matrix.m21 && this.m22 == matrix.m22 && this.m23 == matrix.m23 &&
				   this.m30 == matrix.m30 && this.m31 == matrix.m31 && this.m32 == matrix.m32 && this.m33 == matrix.m33;
		}
		
		return false;
	}
}
