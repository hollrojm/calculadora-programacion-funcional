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
		if (b<0&&a>0){
				int c = a;
				a=b;
				b=c;
		}
		if (b<0&&a<0){
			a =-a;
		}
		int finalA = a;
		return IntStream.range(0, Math.abs(b) + 1)
				.reduce((acumalated, number) -> suma
						.applyAsInt(finalA, acumalated))
						.getAsInt();


	};

	public static void main(String[] args) {

		System.out.println(multiplicacion.applyAsInt(-5,-2));
		SpringApplication.run(CalculadoraprfuncionalApplication.class, args);




	}

}
