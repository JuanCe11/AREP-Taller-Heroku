package edu.escuelaing.arep;

/**
 * Clase encargada de realizar operaciones de calculadora.
 *
 */
public class Calculadora {
	
	/**
	 * M�todo encargado de calcular la media de los valores de una lista especificada.
	 * 
	 * @param ale_lista objeto de tipo <code>ListaEncadenada</code> con los valores a calcular
	 * @return la media de los valores de la lista especificada.
	 */
	public static double media(ListaEncadenada ale_lista) {
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
	 * M�todo encargado de calcular la desviaci�n estandar de los valores de una lista especificada.
	 * 
	 * @param ale_lista objeto de tipo <code>ListaEncadenada</code> con los valores a calcular
	 * @return la desviaci�n estandar de los valores de la lista especificada.
	 */
	public static double desviacionEstandar(ListaEncadenada ale_lista) {
		int li_cont;
		double ld_suma;
		double ld_media;
		
		li_cont = 0;
		ld_suma = 0;
		ld_media = Calculadora.media(ale_lista);
		
		for (Node ln_iterador: ale_lista) 
		{
			ld_suma += Math.pow(ln_iterador.getValor() - ld_media, 2);
			li_cont++;
		}
		
		return Math.sqrt((double)ld_suma/(li_cont-1));
	}
	
}