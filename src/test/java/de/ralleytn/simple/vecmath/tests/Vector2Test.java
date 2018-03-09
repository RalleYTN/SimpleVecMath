package de.ralleytn.simple.vecmath.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ralleytn.simple.vecmath.Vector2;

/**
 * Tests the constructors and methods of the {@linkplain Vector2} class.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
class Vector2Test {

	/**
	 * Goes through all the constructors of the {@linkplain Vector2} class and checks if they properly initialize a 2D vector.
	 * The constructor that takes in a {@code float} array is extensivly tested because it can produce exceptions.
	 * @since 1.0.0
	 */
	@Test
	void testConstructors() {
		
		Vector2 v1 = new Vector2();								// Expected: x=0,y=0
		Vector2 v2 = new Vector2(new float[] {100, 50});		// Expected: x=100,y=50
		Vector2 v3 = new Vector2(v2);							// Expected: x=100,y=50
		Vector2 v4 = new Vector2(100, 50);						// Expected: x=100,y=50
		Vector2 v5 = new Vector2(new float[] {100, 50, 25});	// Expected: x=100,y=50
		Vector2 v6 = null;										// Expected: null
		
		boolean exceptionOccured = false;
		
		try {
			
			v6 = new Vector2(new float[] {100});
			
		} catch(IndexOutOfBoundsException exception) {
			
			// this is the expected case
			exceptionOccured = true;
		}
		
		Assertions.assertTrue(exceptionOccured, "Constructor (float[]) doesn't throw an IndexOutOfBoundsException when a too small array is submitted!");
		Assertions.assertNull(v6, "v6 should be 'null'!");
		Assertions.assertTrue(v1.x == 0 && v1.y == 0, "Constructor () doesn't work!");
		Assertions.assertTrue(v2.x == 100 && v2.y == 50, "Constructor (float[]) doesn't work!");
		Assertions.assertTrue(v5.x == 100 && v5.y == 50, "Constructor (float[]) doesn't work!");
		Assertions.assertTrue(v3.x == 100 && v3.y == 50, "Constructor (Vector2) doesn't work!");
		Assertions.assertTrue(v4.x == 100 && v4.y == 50, "Constructor (float,float) doesn't work!");
	}
	
	@Test
	void testSet() {
		
		
	}
	
	@Test
	void testCopy() {
		
		
	}
	
	@Test
	void testAngle() {
		
		
	}
	
	@Test
	void testCross() {
		
		
	}
	
	@Test
	void testRotate() {
		
		
	}
	
	@Test
	void testTurnLeft() {
		
		
	}
	
	@Test
	void testTurnRight() {
		
		
	}
	
	@Test
	void testDot() {
		
		
	}
	
	@Test
	void testScale() {
		
		
	}
	
	@Test
	void testNormalize() {
		
		
	}
	
	@Test
	void testToArray() {
		
		
	}
	
	@Test
	void testToString() {
		
		
	}
	
	@Test
	void testEquals() {
		
		
	}
	
	@Test
	void testLength() {
		
		
	}
	
	@Test
	void testLengthSquared() {
		
		
	}
	
	@Test
	void testNegate() {
		
		
	}
	
	@Test
	void testAdd() {
		
		
	}
	
	@Test
	void testSubstract() {
		
		
	}
	
	@Test
	void testMultiply() {
		
		
	}
	
	@Test
	void testGetX() {
		
		
	}
	
	@Test
	void testGetY() {
		
		
	}
	
	@Test
	void testDistanceSquared() {
		
		
	}
	
	@Test
	void testDistance() {
		
		
	}
	
	@Test
	void testDistanceL1() {
		
	
	}
	
	@Test
	void testDistanceLinf() {
		
		
	}
}
