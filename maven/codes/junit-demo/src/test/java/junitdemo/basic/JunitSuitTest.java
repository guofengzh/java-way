package junitdemo.basic;

import org.junit.runner.RunWith;		
import org.junit.runners.Suite;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
	CalculationExceptionTest.class,
	CalculationTest.class,  			
})	
public class JunitSuitTest {

}
