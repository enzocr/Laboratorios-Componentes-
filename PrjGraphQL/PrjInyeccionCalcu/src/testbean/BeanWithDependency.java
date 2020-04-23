package testbean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calculator.ICalculator;

@Service
public class BeanWithDependency {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private ICalculator calculator;

	@Autowired
	public void setCalculator(ICalculator pCalcu) {
		this.calculator = pCalcu;
	}

	public void run() {
		int num1 = 0, num2 = 0;
		System.out.print("Digite # 1 a sumar: ");
		try {
			num1 = Integer.parseInt(in.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("Digite # 2 a sumar: ");
		try {
			num2 = Integer.parseInt(in.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		calculator.calculator(num1, num2);
	}
}
