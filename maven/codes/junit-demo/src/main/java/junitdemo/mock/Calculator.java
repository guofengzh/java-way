package junitdemo.mock;

public class Calculator implements CalculatorService {

	@Override
	public double add(double input1, double input2) {
		System.out.println("add");
		return 0;
	}

	@Override
	public double subtract(double input1, double input2) {
		System.out.println("subtract");
		return 0;
	}

	@Override
	public double multiply(double input1, double input2) {
		System.out.println("multiply");
		return 0;
	}

	@Override
	public double divide(double input1, double input2) {
		System.out.println("divide");
		return 0;
	}

}
