package junitdemo.behavior;

import static org.mockito.BDDMockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import junitdemo.mock.CalculatorService;
import junitdemo.mock.MathApplication;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationBehaviorTest {
	
   private MathApplication mathApplication;
   private CalculatorService calcService;

   @Before
   public void setUp(){
      mathApplication = new MathApplication();
      calcService = mock(CalculatorService.class);
      mathApplication.setCalculatorService(calcService);
   }

   @Test
   public void testAdd(){

      //Given
      given(calcService.add(20.0,10.0)).willReturn(30.0);

      //when
      double result = calcService.add(20.0,10.0);

      //then
      Assert.assertEquals(result,30.0,0);   
   }
}