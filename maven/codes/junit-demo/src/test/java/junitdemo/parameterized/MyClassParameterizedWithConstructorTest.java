package junitdemo.parameterized;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyClassParameterizedWithConstructorTest {

    private int m1;
    private int m2;

    public MyClassParameterizedWithConstructorTest(int p1, int p2) {
        m1 = p1;
        m2 = p2;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2 }, { 5, 3 }, { 121, 4 } };
        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyException() {
        ParameterizedTestClass tester = new ParameterizedTestClass();
        assertEquals("Result", m1 * m2, tester.multiply(m1, m2));
    }
}
