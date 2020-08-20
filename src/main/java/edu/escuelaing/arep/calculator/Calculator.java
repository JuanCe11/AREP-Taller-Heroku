package edu.escuelaing.arep.calculator;

/**
 * Class in charge of performing calculator operations.
 *
 */
public class Calculator {
	
	/**
	 * Method in charge of calculating the mean of the values of a specified list.
	 * 
	 * @param ale_lista Object of type <code>LinkedList</code> with the values to be calculated.
	 * @return the mean of the values in the specified list.
	 */
	public static double mean(LinkedList ale_lista) {
		int li_cont;
		double ld_suma;
		
		li_cont = 0;
		ld_suma = 0;
		
		for (Node ln_iterador: ale_lista) 
		{
			ld_suma += ln_iterador.getValor();
			li_cont++;
		}
		
		return (double)ld_suma/li_cont;
	}
	
	/**
	 * Method in charge of calculating the standard deviation of the values of a specified list.
	 * 
	 * @param ale_lista Object of type <code>LinkedList</code> with the values to be calculated.
	 * @return The standard deviation of the values in the specified list.
	 */
	public static double standardDeviation(LinkedList ale_lista) {
		int li_cont;
		double ld_suma;
		double ld_media;
		
		li_cont = 0;
		ld_suma = 0;
		ld_media = Calculator.mean(ale_lista);
		
		for (Node ln_iterador: ale_lista) 
		{
			ld_suma += Math.pow(ln_iterador.getValor() - ld_media, 2);
			li_cont++;
		}
		
		return Math.sqrt((double)ld_suma/(li_cont-1));
	}
	
}