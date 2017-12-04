package gs;

import java.util.Date;

public class MyGenericDemo {
	   static class Bar {
		   Date currentDate() {
			   return new Date() ;
		   }
	   }
	 
	   public static void main(String[] args) throws Exception {
	 
	       MyGeneric<Bar> mg = new MyGeneric<Bar>(Bar.class);
	 
	       Bar bar = mg.getTObject();
	 
	       bar.currentDate();
	   }
	}