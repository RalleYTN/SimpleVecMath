package de.ralleytn.simple.vecmath.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.ralleytn.simple.vecmath.Axis;

/**
 * There is not much to test for the {@linkplain Axis} class but we should do it anyway.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
class AxisTest {

	/**
	 * Tests if the values of the 3 axis are correct.
	 * If this test fails, someone sabotaged the library.
	 * @since 1.0.0
	 */
	@Test
	void testAxis() {
		
		// Test X axis
		Assertions.assertEquals(Axis.X.getX(), 1.0F);
		Assertions.assertEquals(Axis.X.getY(), 0.0F);
		Assertions.assertEquals(Axis.X.getZ(), 0.0F);
		
		// Test Y axis
		Assertions.assertEquals(Axis.Y.getX(), 0.0F);
		Assertions.assertEquals(Axis.Y.getY(), 1.0F);
		Assertions.assertEquals(Axis.Y.getZ(), 0.0F);
		
		// Test Z axis
		Assertions.assertEquals(Axis.Z.getX(), 0.0F);
		Assertions.assertEquals(Axis.Z.getY(), 0.0F);
		Assertions.assertEquals(Axis.Z.getZ(), 1.0F);
	}
}
