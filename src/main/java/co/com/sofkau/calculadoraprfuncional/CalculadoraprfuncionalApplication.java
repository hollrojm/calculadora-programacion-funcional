package co.com.sofkau.calculadoraprfuncional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

@SpringBootApplication
public class CalculadoraprfuncionalApplication {

	static IntBinaryOperator suma = (a, b)->a+b;


	static IntBinaryOperator resta = (a,b)->a-b;


	static IntBinaryOperator multiplicacion = (a, b)-> {
		if (b < 0 && a > 0){
				int c = a;
				a=b;
				b=c;
		}
		if (b < 0 && a < 0){
			a =-a;
		}
		int finalA = a;
		return IntStream.range(0, Math.abs(b) + 1)
				.reduce((acumalated, number) -> suma
						.applyAsInt(finalA, acumalated))
						.getAsInt();


	};
	static IntBinaryOperator division = (a,b) ->{
		return IntStream.range(0,Math.abs(a)).reduce((acumalate, number)-> multiplicacion
				.applyAsInt(number, b) <= a ? suma
				.applyAsInt(acumalate, 1): acumalate)
				.getAsInt();
	};

	public static void main(String[] args) {
		//SpringApplication.run(CalculadoraprfuncionalApplication.class, args);

		System.out.println(division.applyAsInt(5,-2));




	}

}
