package calculator;

public class CalculatorSum implements ICalculator {
	@Override
	public void calculator(int num1, int num2) {
		System.out.println("El resultado es: " + (num1 + num2));
	}
}
