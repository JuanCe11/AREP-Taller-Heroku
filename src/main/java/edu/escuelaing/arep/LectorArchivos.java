package edu.escuelaing.arep;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivos {
	
	/**
	 * Lee los valores que contenga el archivo especificado. Cabe resaltar que para el correcto funcionamiento el archivo debe estar en la carpeta resources dentro del directorio raiz del proyecto.
	 * Este lector asume que los n�meros a leer estan separados por un salto de l�nea. 
	 *  
	 * @param as_nombre El nombre del archivo a buscar. Este par�metro debe contener el nombre del archivo con la extensi�n. 
	 * @return Un arreglo de double con los n�meros que encontro en el archivo.
	 */
	public static double[] leerArchivo(String as_nombre) {
		File lf_file = null;
		FileReader lfr_fr = null;
		BufferedReader lbr_br = null;
		double[] lda_arreglo;
		ArrayList<Double> lal_array = null;
		
		try {
			lal_array = new ArrayList<Double>();
			String ls_linea;
			
			lf_file = new File("resources/"+as_nombre);
			lfr_fr = new FileReader(lf_file);
			lbr_br = new BufferedReader(lfr_fr);
			
	         while((ls_linea = lbr_br.readLine())!=null)
	            lal_array.add(Double.valueOf(ls_linea));
	         
		}catch(IOException e) {
			
			System.out.println("Ocurrio un error al abrir el archivo "+as_nombre);
			
		}finally {
			
			try{                 
	            if( null != lfr_fr )   
	            	lfr_fr.close();
	            	
	         } catch (IOException e) {
	        	 
				e.printStackTrace();
				
			}
		}
		
		lda_arreglo = new double[lal_array.size()];
		
		for (int i = 0; i < lal_array.size() ; i++) {
			lda_arreglo[i] = lal_array.get(i);
		}
		
		return lda_arreglo;
		
	}
	
	/**
	 * Convierte los valores de un arreglo de escring a un arreglo de double.
	 *  
	 * @param asa_valores Arreglo de String con los valores a convertir  
	 * @return Un arreglo de double con los numeros convertidos.
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
