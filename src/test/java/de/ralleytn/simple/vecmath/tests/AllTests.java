package de.ralleytn.simple.vecmath.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Vector2Test.class,
	Vector3Test.class,
	Vector4Test.class,
	VectorNTest.class,
	QuaternionTest.class,
	Matrix3Test.class,
	Matrix4Test.class,
	MatrixNTest.class
})
public class AllTests {}
