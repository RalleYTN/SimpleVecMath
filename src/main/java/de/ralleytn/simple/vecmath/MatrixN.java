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
public final class MatrixN extends Matrix<MatrixN> {

	// first Y then X to keep it consistent with the other matrices
	
	private int width;
	private int height;
	private float[][] data;
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @since 1.0.0
	 */
	public MatrixN(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.data = new float[height][width];
	}
	
	@Override
	public final MatrixN identity() {
		
		return null;
	}

	@Override
	public final MatrixN invert() {
		
		return null;
	}

	@Override
	public final MatrixN negate() {
		
		for(int y = 0; y < this.height; y++) {
			
			for(int x = 0; x < this.width; x++) {
				
				this.data[y][x] = -this.data[y][x];
			}
		}
		
		return this;
	}

	@Override
	public final MatrixN transpose() {
		
		return null;
	}

	@Override
	public final MatrixN zero() {
		
		for(int y = 0; y < this.height; y++) {
			
			for(int x = 0; x < this.width; x++) {
				
				this.data[y][x] = 0.0F;
			}
		}
		
		return this;
	}

	@Override
	public final float determinant() {
		
		return 0;
	}

	@Override
	public final float[] toArray() {
		
		float[] array = new float[this.width * this.height];
		int index = 0;
		
		for(int y = 0; y < this.height; y++) {
			
			for(int x = 0; x < this.width; x++) {
				
				array[index] = this.data[y][x];
				index++;
			}
		}
		
		return array;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final int getWidth() {
		
		return this.width;
	}
	
	/**
	 * 
	 * @return
	 * @since 1.0.0
	 */
	public final int getHeight() {
		
		return this.height;
	}
}
