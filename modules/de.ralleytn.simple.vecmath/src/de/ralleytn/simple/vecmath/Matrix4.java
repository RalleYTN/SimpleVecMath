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

import de.ralleytn.simple.vecmath.internal.LunaticMatrixUtil;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class Matrix4 extends Matrix {

	public float m00, m01, m02, m03;
	public float m10, m11, m12, m13;
	public float m20, m21, m22, m23;
	public float m30, m31, m32, m33;
	
	/**
	 * @since 1.0.0
	 */
	public Matrix4() {
		
		this.setIdentity();
	}
	
	/**
	 * 
	 * @param data
	 * @since 1.0.0
	 */
	public Matrix4(float[] data) {
		
		this.m00 = data[0];
		this.m01 = data[1];
		this.m02 = data[2];
		this.m03 = data[3];
		
		this.m10 = data[4];
		this.m11 = data[5];
		this.m12 = data[6];
		this.m13 = data[7];
		
		this.m20 = data[8];
		this.m21 = data[9];
		this.m22 = data[10];
		this.m23 = data[11];
		
		this.m30 = data[12];
		this.m31 = data[13];
		this.m32 = data[14];
		this.m33 = data[15];
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 add(Matrix4 a, Matrix4 b) {
		
		return a.copy().add(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 subtract(Matrix4 a, Matrix4 b) {
		
		return a.copy().subtract(b);
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 multiply(Matrix4 a, Matrix4 b) {
		
		return a.copy().multiply(b);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Vector4 transform(Matrix4 matrix, Vector4 vector) {
		
		return matrix.transform(vector);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 scale(Matrix4 matrix, Vector3 scale) {
		
		return matrix.copy().scale(scale);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param scale
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 scale(Matrix4 matrix, float scale) {
		
		return matrix.copy().scale(scale);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param angle
	 * @param axis
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 rotate(Matrix4 matrix, float angle, Vector3 axis) {
		
		return matrix.copy().rotate(angle, axis);
	}
	
	/**
	 * 
	 * @param matrix
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 translate(Matrix4 matrix, Vector3 vector) {
		
		return matrix.copy().translate(vector);
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 invert(Matrix4 matrix) {
		
		return (Matrix4)matrix.copy().invert();
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 negate(Matrix4 matrix) {
		
		return (Matrix4)matrix.copy().negate();
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public static final Matrix4 transpose(Matrix4 matrix) {
		
		return (Matrix4)matrix.copy().transpose();
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 copy() {
		
		return new Matrix4(this.toArray());
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 add(Matrix4 matrix) {
		
		this.m00 += matrix.m00;
		this.m01 += matrix.m01;
		this.m02 += matrix.m02;
		this.m03 += matrix.m03;
		
		this.m10 += matrix.m10;
		this.m11 += matrix.m11;
		this.m12 += matrix.m12;
		this.m13 += matrix.m13;
		
		this.m20 += matrix.m20;
		this.m21 += matrix.m21;
		this.m22 += matrix.m22;
		this.m23 += matrix.m23;
		
		this.m30 += matrix.m30;
		this.m31 += matrix.m31;
		this.m32 += matrix.m32;
		this.m33 += matrix.m33;
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 subtract(Matrix4 b) {
		
		this.m00 -= b.m00;
		this.m01 -= b.m01;
		this.m02 -= b.m02;
		this.m03 -= b.m03;
		
		this.m10 -= b.m10;
		this.m11 -= b.m11;
		this.m12 -= b.m12;
		this.m13 -= b.m13;
		
		this.m20 -= b.m20;
		this.m21 -= b.m21;
		this.m22 -= b.m22;
		this.m23 -= b.m23;
		
		this.m30 -= b.m30;
		this.m31 -= b.m31;
		this.m32 -= b.m32;
		this.m33 -= b.m33;
		
		return this;
	}
	
	/**
	 * 
	 * @param matrix
	 * @return
	 * @since 1.0.0
	 */
	public final Matrix4 multiply(Matrix4 b) {
		
		float m00 = this.m00 * b.m00 + this.m10 * b.m01 + this.m20 * b.m02 + this.m30 * b.m03;
		float m01 = this.m01 * b.m00 + this.m11 * b.m01 + this.m21 * b.m02 + this.m31 * b.m03;
		float m02 = this.m02 * b.m00 + this.m12 * b.m01 + this.m22 * b.m02 + this.m32 * b.m03;
		float m03 = this.m03 * b.m00 + this.m13 * b.m01 + this.m23 * b.m02 + this.m33 * b.m03;
		
		float m10 = this.m00 * b.m10 + this.m10 * b.m11 + this.m20 * b.m12 + this.m30 * b.m13;
		float m11 = this.m01 * b.m10 + this.m11 * b.m11 + this.m21 * b.m12 + this.m31 * b.m13;
		float m12 = this.m02 * b.m10 + this.m12 * b.m11 + this.m22 * b.m12 + this.m32 * b.m13;
		float m13 = this.m03 * b.m10 + this.m13 * b.m11 + this.m23 * b.m12 + this.m33 * b.m13;
		
		float m20 = this.m00 * b.m20 + this.m10 * b.m21 + this.m20 * b.m22 + this.m30 * b.m23;
		float m21 = this.m01 * b.m20 + this.m11 * b.m21 + this.m21 * b.m22 + this.m31 * b.m23;
		float m22 = this.m02 * b.m20 + this.m12 * b.m21 + this.m22 * b.m22 + this.m32 * b.m23;
		float m23 = this.m03 * b.m20 + this.m13 * b.m21 + this.m23 * b.m22 + this.m33 * b.m23;
		
		float m30 = this.m00 * b.m30 + this.m10 * b.m31 + this.m20 * b.m32 + this.m30 * b.m33;
		float m31 = this.m01 * b.m30 + this.m11 * b.m31 + this.m21 * b.m32 + this.m31 * b.m33;
		float m32 = this.m02 * b.m30 + this.m12 * b.m31 + this.m22 * b.m32 + this.m32 * b.m33;
		float m33 = this.m03 * b.m30 + this.m13 * b.m31 + this.m23 * b.m32 + this.m33 * b.m33;

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
		
		return this;
	}
	
	/**
	 * 
	 * @param vector
	 * @return
	 * @since 1.0.0
	 */
	public final Vector4 transform(Vector4 vector) {
		
		float x = this.m00 * vector.x + this.m10 * vector.y + this.m20 * vector.z + this.m30 * vector.w;
		float y = this.m01 * vector.x + this.m11 * vector.y + this.m21 * vector.z + this.m31 * vector.w;
		float z = this.m02 * vector.x + this.m12 * vector.y + this.m22 * vector.z + this.m32 * vector.w;
		float w = this.m03 * vector.x + this.m13 * vector.y + this.m23 * vector.z + this.m33 * vector.w;
		
		return new Vector4(x, y, z, w);
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
	public final Matrix4 rotate(float angle, Vector3 axis) {
		
		float c = (float)Math.cos(angle);
		float s = (float)Math.sin(angle);
		float oneminusc = 1.0F - c;
		float xy = axis.x * axis.y;
		float yz = axis.y * axis.z;
		float xz = axis.x * axis.z;
		float xs = axis.x * s;
		float ys = axis.y * s;
		float zs = axis.z * s;
		
		float f00 = axis.x * axis.x * oneminusc+c;
		float f01 = xy * oneminusc + zs;
		float f02 = xz * oneminusc - ys;
		
		float f10 = xy * oneminusc - zs;
		float f11 = axis.y * axis.y * oneminusc + c;
		float f12 = yz * oneminusc + xs;
		
		float f20 = xz * oneminusc + ys;
		float f21 = yz * oneminusc - xs;
		float f22 = axis.z * axis.z * oneminusc + c;
		
		float t00 = this.m00 * f00 + this.m10 * f01 + this.m20 * f02;
		float t01 = this.m01 * f00 + this.m11 * f01 + this.m21 * f02;
		float t02 = this.m02 * f00 + this.m12 * f01 + this.m22 * f02;
		float t03 = this.m03 * f00 + this.m13 * f01 + this.m23 * f02;
		
		float t10 = this.m00 * f10 + this.m10 * f11 + this.m20 * f12;
		float t11 = this.m01 * f10 + this.m11 * f11 + this.m21 * f12;
		float t12 = this.m02 * f10 + this.m12 * f11 + this.m22 * f12;
		float t13 = this.m03 * f10 + this.m13 * f11 + this.m23 * f12;
		
		this.m20 = this.m00 * f20 + this.m10 * f21 + this.m20 * f22;
		this.m21 = this.m01 * f20 + this.m11 * f21 + this.m21 * f22;
		this.m22 = this.m02 * f20 + this.m12 * f21 + this.m22 * f22;
		this.m23 = this.m03 * f20 + this.m13 * f21 + this.m23 * f22;
		
		this.m00 = t00;
		this.m01 = t01;
		this.m02 = t02;
		this.m03 = t03;
		
		this.m10 = t10;
		this.m11 = t11;
		this.m12 = t12;
		this.m13 = t13;
		
		return this;
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
	
	@Override
	public final float determinant() {
		
		float determinant = this.m00 * ((this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32) - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
		determinant -= this.m01 * ((this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32) - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
		determinant += this.m02 * ((this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31) - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
		determinant -= this.m03 * ((this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31) - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
	
		return determinant;
	}
	
	@Override
	public final Matrix invert() {
		
		float determinant = this.determinant();
		float determinant_inv = 1.0F / determinant;

		float t00 =  LunaticMatrixUtil.determinant3x3(this.m11, this.m12, this.m13, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33);
		float t01 = -LunaticMatrixUtil.determinant3x3(this.m10, this.m12, this.m13, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33);
		float t02 =  LunaticMatrixUtil.determinant3x3(this.m10, this.m11, this.m13, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33);
		float t03 = -LunaticMatrixUtil.determinant3x3(this.m10, this.m11, this.m12, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32);
		
		float t10 = -LunaticMatrixUtil.determinant3x3(this.m01, this.m02, this.m03, this.m21, this.m22, this.m23, this.m31, this.m32, this.m33);
		float t11 =  LunaticMatrixUtil.determinant3x3(this.m00, this.m02, this.m03, this.m20, this.m22, this.m23, this.m30, this.m32, this.m33);
		float t12 = -LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m03, this.m20, this.m21, this.m23, this.m30, this.m31, this.m33);
		float t13 =  LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m02, this.m20, this.m21, this.m22, this.m30, this.m31, this.m32);
		
		float t20 =  LunaticMatrixUtil.determinant3x3(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m31, this.m32, this.m33);
		float t21 = -LunaticMatrixUtil.determinant3x3(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m30, this.m32, this.m33);
		float t22 =  LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m30, this.m31, this.m33);
		float t23 = -LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m30, this.m31, this.m32);
		
		float t30 = -LunaticMatrixUtil.determinant3x3(this.m01, this.m02, this.m03, this.m11, this.m12, this.m13, this.m21, this.m22, this.m23);
		float t31 =  LunaticMatrixUtil.determinant3x3(this.m00, this.m02, this.m03, this.m10, this.m12, this.m13, this.m20, this.m22, this.m23);
		float t32 = -LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m03, this.m10, this.m11, this.m13, this.m20, this.m21, this.m23);
		float t33 =  LunaticMatrixUtil.determinant3x3(this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22);

		this.m00 = t00 * determinant_inv;
		this.m11 = t11 * determinant_inv;
		this.m22 = t22 * determinant_inv;
		this.m33 = t33 * determinant_inv;
		this.m01 = t10 * determinant_inv;
		this.m10 = t01 * determinant_inv;
		this.m20 = t02 * determinant_inv;
		this.m02 = t20 * determinant_inv;
		this.m12 = t21 * determinant_inv;
		this.m21 = t12 * determinant_inv;
		this.m03 = t30 * determinant_inv;
		this.m30 = t03 * determinant_inv;
		this.m13 = t31 * determinant_inv;
		this.m31 = t13 * determinant_inv;
		this.m32 = t23 * determinant_inv;
		this.m23 = t32 * determinant_inv;
			
		return this;
	}
	
	@Override
	public final Matrix negate() {
		
		this.m00 = -this.m00;
		this.m01 = -this.m01;
		this.m02 = -this.m02;
		this.m03 = -this.m03;
		
		this.m10 = -this.m10;
		this.m11 = -this.m11;
		this.m12 = -this.m12;
		this.m13 = -this.m13;
		
		this.m20 = -this.m20;
		this.m21 = -this.m21;
		this.m22 = -this.m22;
		this.m23 = -this.m23;
		
		this.m30 = -this.m30;
		this.m31 = -this.m31;
		this.m32 = -this.m32;
		this.m33 = -this.m33;
		
		return this;
	}
	
	@Override
	public final Matrix setIdentity() {
		
		this.m00 = 1.0F;
		this.m01 = 0.0F;
		this.m02 = 0.0F;
		this.m03 = 0.0F;
		
		this.m10 = 0.0F;
		this.m11 = 1.0F;
		this.m12 = 0.0F;
		this.m13 = 0.0F;
		
		this.m20 = 0.0F;
		this.m21 = 0.0F;
		this.m22 = 1.0F;
		this.m23 = 0.0F;
		
		this.m30 = 0.0F;
		this.m31 = 0.0F;
		this.m32 = 0.0F;
		this.m33 = 1.0F;
		
		return this;
	}
	
	@Override
	public final Matrix setZero() {
		
		this.m00 = 0.0F;
		this.m01 = 0.0F;
		this.m02 = 0.0F;
		this.m03 = 0.0F;
		
		this.m10 = 0.0F;
		this.m11 = 0.0F;
		this.m12 = 0.0F;
		this.m13 = 0.0F;
		
		this.m20 = 0.0F;
		this.m21 = 0.0F;
		this.m22 = 0.0F;
		this.m23 = 0.0F;
		
		this.m30 = 0.0F;
		this.m31 = 0.0F;
		this.m32 = 0.0F;
		this.m33 = 0.0F;
		
		return this;
	}
	
	@Override
	public final Matrix transpose() {
		
		float m00 = this.m00;
		float m01 = this.m10;
		float m02 = this.m20;
		float m03 = this.m30;
		float m10 = this.m01;
		float m11 = this.m11;
		float m12 = this.m21;
		float m13 = this.m31;
		float m20 = this.m02;
		float m21 = this.m12;
		float m22 = this.m22;
		float m23 = this.m32;
		float m30 = this.m03;
		float m31 = this.m13;
		float m32 = this.m23;
		float m33 = this.m33;

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
		
		return this;
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

	@Override
	public final float[] toArray() {
		
		return new float[] {
				
			this.m00, this.m01, this.m02, this.m03,
			this.m10, this.m11, this.m12, this.m13,
			this.m20, this.m21, this.m22, this.m23,
			this.m30, this.m31, this.m32, this.m33
		};
	}
}
