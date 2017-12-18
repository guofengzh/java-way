package junitdemo.basic;

import static org.junit.Assert.*;  
import org.junit.Test;  

public class CalculationTest {
    @Test  
    public void testFindMax(){  
        assertEquals(4,Calculation.findMax(new int[]{1,3,4,2}));  
    }  
    
    @Test  
    public void testFindMaxNagitive(){  
        assertEquals(-1,Calculation.findMax(new int[]{-12,-1,-3,-4,-2}));  
    }  
}
