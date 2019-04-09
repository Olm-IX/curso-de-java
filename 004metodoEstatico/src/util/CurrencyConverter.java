package util;

public class CurrencyConverter {
	
	public static final double IOF = 0.06; // VARIÁVEL ESTÁTICA! COLOCAR PALAVRA "FINAL". TEM QUE TER TODOS AS LETRAS EM MAIUSCULO.
	
	public static double converter(double x, double y) {
		
		return x * y * (1 + IOF);
		
	}
	
	
	
}
