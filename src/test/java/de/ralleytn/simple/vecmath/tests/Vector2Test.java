package de.ralleytn.simple.vecmath.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.vecmath.Quaternion;
import de.ralleytn.simple.vecmath.Vector2;
import de.ralleytn.simple.vecmath.Vector3;
import de.ralleytn.simple.vecmath.Vector4;

/**
 * Tests the constructors and methods of the {@linkplain Vector2} class.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
class Vector2Test {

	private static final Vector2 createRandomVector() {
		
		return new Vector2((float)Math.random() * 100, (float)Math.random() * 100);
	}
	
	/**
	 * Goes through all the constructors of the {@linkplain Vector2} class and checks if they properly initialize a 2D vector.
	 * The constructor that takes in a {@code float} array is extensively tested because it can produce exceptions.
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
		
		boolean exceptionOccurred = false;
		
		try {
			
			v6 = new Vector2(new float[] {100});
			
		} catch(IndexOutOfBoundsException exception) {
			
			// this is the expected case
			exceptionOccurred = true;
		}
		
		assertTrue(exceptionOccurred, "Constructor (float[]) doesn't throw an IndexOutOfBoundsException when a too small array is submitted!");
		assertNull(v6, "v6 should be 'null'!");
		assertTrue(v1.x == 0 && v1.y == 0, "Constructor () doesn't work!");
		assertTrue(v2.x == 100 && v2.y == 50, "Constructor (float[]) doesn't work!");
		assertTrue(v5.x == 100 && v5.y == 50, "Constructor (float[]) doesn't work!");
		assertTrue(v3.x == 100 && v3.y == 50, "Constructor (Vector2) doesn't work!");
		assertTrue(v4.x == 100 && v4.y == 50, "Constructor (float,float) doesn't work!");
	}
	
	/**
	 * Tests all methods that start with 'to'. {@link Vector2#toArray()} or {@link Vector2#toString()} for example.
	 * @since 1.0.0
	 */
	@Test
	void testConversions() {
		
		Vector2 vec = new Vector2(100, 50);
		
		// Test
		float[] array = vec.toArray();
		assertEquals("(100.0,50.0)", vec.toString(), "The method toString() doesn't work!");
		assertTrue(array[0] == 100 && array[1] == 50, "The method toArray() doesn't work!");
		assertEquals(new Vector3(100, 50, 0), vec.toVector3(), "The method toVector3() doesn't work!");
		assertEquals(new Vector4(100, 50, 0, 0), vec.toVector4(), "The method toVector4() doesn't work!");
		assertEquals(new Quaternion(100, 50, 0, 0), vec.toQuaternion(), "The method toQuaternion() doesn't work!");
	}
	
	/**
	 * Tests the {@link Vector2#set(float[])}, {@link Vector2#set(Vector2)} and {@link Vector2#set(float, float)} methods.
	 * @since 1.0.0
	 */
	@Test
	void testSet() {
		
		Vector2 vec = Vector2Test.createRandomVector();
		
		// Test set(Vector2)
		vec.set(new Vector2(10, 9));
		assertTrue(vec.x == 10 && vec.y == 9, "The method set(Vector2) doesn't work!");
		
		// Test set(float, float)
		vec.set(200, 800);
		assertTrue(vec.x == 200 && vec.y == 800, "The method set(float,float) doesn't work!");
		
		// Test set(float[])
		vec.set(new float[] {1, 0});
		assertTrue(vec.x == 1 && vec.y == 0, "The method set(float[]) doesn't work!");
		
		vec.set(new float[] {2, 9, 1000});
		assertTrue(vec.x == 2 && vec.y == 9, "The method set(float[]) doesn't work!");
		
		boolean exceptionOccurred = false;
		
		try {
			
			vec.set(new float[] {0});
			
		} catch(IndexOutOfBoundsException exception) {
			
			exceptionOccurred = true;
		}
		
		assertTrue(exceptionOccurred, "For some reason no IndexOutOfBoundsException was thrown when set(float[]) was called with a too small array!");
	}
	
	/**
	 * Tests the method {@link Vector2#copy()}.
	 * @since 1.0.0
	 */
	@Test
	void testCopy() {
		
		Vector2 vec = Vector2Test.createRandomVector();
		Vector2 copy = vec.copy();
		
		assertNotNull(copy, "The method copy() returns 'null'!");
		assertEquals(vec.x, copy.x, "The method copy() doesn't copy the 1st element!");
		assertEquals(vec.y, copy.y, "The method copy() doesn't copy the 2nd element!");
		assertFalse(copy == vec, "The method copy() just returns the instance that should be copied but doesn't create a copy like it's supposed to!");
	}
	
	/**
	 * Tests the method {@link Vector2#angle(Vector2)}.
	 * @since 1.0.0
	 */
	@Test
	void testAngle() {
		
		Vector2 a = new Vector2(100, 50);
		Vector2 b = new Vector2(24, 300);
		assertTrue(Math.toDegrees(a.angle(b)) == 58.861026644417464, "The method angle(Vector2) doesn't work!");
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
	void testEquals() {
		
		
	}
	
	@Test
	void testAbsolute() {
		
		
	}
	
	@Test
	void testClamp() {
		
		
	}
	
	@Test
	void testEpsilonEquals() {
		
		
	}
	
	@Test
	void testInterpolate() {
		
		
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
