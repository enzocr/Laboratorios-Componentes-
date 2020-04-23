package calculator;

public class CalculatorConcat implements ICalculator {
	@Override
	public void calculator(int num1, int num2) {
		System.out.println("El resultado es: " + num1 + " +8 " + num2);
	}
}
