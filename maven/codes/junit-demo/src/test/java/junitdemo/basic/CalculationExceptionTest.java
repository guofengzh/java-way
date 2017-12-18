package junitdemo.basic;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculationExceptionTest {

	@Test(expected = IllegalArgumentException.class)
	public void testFindMax() {
		System.out.println("test case find max");
		assertEquals(4, CalculationFull.findMax(new int[] { 1, 3, 4, 2 }));
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Ignore("Not implemented")
	public void ignoreTestFindMax() {
		System.out.println("test case find max");
		assertEquals(4, CalculationFull.findMax(new int[] { 1, 3, 4, 2 }));
	}
}
