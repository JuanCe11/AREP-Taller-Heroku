package edu.escuelaing.arep.calculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivos {
	
	/**
	 * Lee los valores que contenga el archivo especificado. Cabe resaltar que para el correcto funcionamiento el archivo debe estar en la carpeta resources dentro del directorio raiz del proyecto.
	 * Este lector asume que los números a leer estan separados por un salto de línea. 
	 *  
	 * @param as_nombre El nombre del archivo a buscar. Este parámetro debe contener el nombre del archivo con la extensión. 
	 * @return Un arreglo de double con los números que encontro en el archivo.
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

}
