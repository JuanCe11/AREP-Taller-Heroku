package edu.escuelaing.arep.calculator;

/**
 * Class to reads content.
 */
public class StringReader {
	
	/**
	 * Converts the values of an array of string to an array of double.
	 *  
	 * @param asa_valores String array with the values to convert  
	 * @return An array of double with the converted numbers.
	 */
	public static double[] convertArray(String asa_valores) {
		String[] lsa_valores;
		double[] lda_arreglo;
		
		lsa_valores = asa_valores.split(",");
		lda_arreglo = new double[lsa_valores.length];
		
		try {
			
			for (int i = 0; i < lsa_valores.length; i++) {
				lda_arreglo[i] = Double.valueOf(lsa_valores[i]);
			}
	         
		}catch(Exception e) {
			System.out.println("Imposible cargar datos.");
		}
		
		return lda_arreglo;
	}

}
