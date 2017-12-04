package bound;

public class Calc1 {
	public static void main(String args[]) {
		Integer inums[] = { 1, 2, 3, 4, 5 };
		Calculator<Integer> iob = new Calculator<Integer>(inums);
		double v = iob.average();
		System.out.println("iob average is " + v);
		Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Calculator<Double> dob = new Calculator<Double>(dnums);
		double w = dob.average();
		System.out.println("dob average is " + w);
	}

	static class Calculator<T extends Number> {
		T[] nums;

		Calculator(T[] o) {
			nums = o;
		}

		double average() {
			double sum = 0.0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i].doubleValue();
			}
			return sum / nums.length;
		}
	}

}