package bound;

public class Calc2 {
  public static void main(String args[]) {
    Integer inums[] = { 1, 2, 3, 4, 5 };
    Calculator<Integer> iob = new Calculator<Integer>(inums);

    Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
    Calculator<Double> dob = new Calculator<Double>(dnums);

    if (iob.sameAvg(dob))
      System.out.println("are the same.");
    else
      System.out.println("differ.");
  }
  
  static class Calculator<T extends Number> {
	  T[] nums;
	  Calculator(T[] o) {
	    nums = o;
	  }
	  
	  double average() {
	    double sum = 0.0;
	    for (int i = 0; i < nums.length; i++)
	      sum += nums[i].doubleValue();
	    return sum / nums.length;
	  }
	  
	  //<T> boolean sameAvg(Calculator<T> ob) {}
	  
	  boolean sameAvg(Calculator<?> ob) { // TODO
	    if (average() == ob.average())
	      return true;
	    return false;
	  }
	}  
}