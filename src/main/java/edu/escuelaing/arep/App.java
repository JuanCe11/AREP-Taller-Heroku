package edu.escuelaing.arep;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.velocity.VelocityTemplateEngine;

/**
 * Clase encargada de iniciar el servicio.
 *
 */
public class App {
	
	/**
	 * Clase principal que inicia el hilo princpal del servicio.
	 * 
	 * @param args Array de strings
	 */
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
        
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("mean", 0);
            model.put("desvest", 0);
            model.put("valid",true);
            return new ModelAndView(model, "index.vm");
        }, new VelocityTemplateEngine());
        
        get("/result", (req, res) -> {
        	Map<String, Object> model = new HashMap<String, Object>();
        	model.put("valid",resultData(model,req,res));
        	return new ModelAndView(model, "index.vm");
        }, new VelocityTemplateEngine());

	}
	
	/**
	 * Especifica el puerto en el que s eva a correr el servicio.
	 * 
	 * @return El puerto en el que se va a correr el servicio.
	 */
	public static int getPort() {    
		if (System.getenv("PORT") != null)
		{            
			return Integer.parseInt(System.getenv("PORT"));      
		} 
		return 4567; 
	}
	
	/**
	 * Metodo encargado de generar los valores de la media y la desviacion estandar.
	 * 
	 * @param model Datos que se le van a pasar al template.
	 * @param req Peticion que recibe el servidor
	 * @param res Respuesta del servidor.
	 * @return Retorna si fue posible calcular los datos con la informacion ingresada.
	 */
	private static boolean resultData(Map model, Request req, Response res){
		String ls_values;
		boolean lb_resp;
		
		ls_values = req.queryParams("lista");
		lb_resp = validList(ls_values);
		
		if (lb_resp) {
			double[] lda_numbers;
        	ListaEncadenada lle_list;
        	
        	lda_numbers = LectorArchivos.convertArray(ls_values);
        	lle_list = new ListaEncadenada();
        	
        	for (int i = 0; i < lda_numbers.length; i++) {
				lle_list.add(lda_numbers[i]);
			}
        	double ld_res;
        	
        	ld_res = Calculadora.media(lle_list);
        	ld_res = (double) Math.round(ld_res * 100) / 100;
        	model.put("mean", ld_res);
        	
        	ld_res = Calculadora.desviacionEstandar(lle_list);
        	ld_res = (double) Math.round(ld_res * 100) / 100;
        	model.put("desvest", ld_res);
		}
		else
		{
			model.put("mean", 0);
        	model.put("desvest",0);
		}
		
		return lb_resp;
	}
	
	/**
	 * Valida si una string es valida para calcular los valores. 
	 * 
	 * @param as_list String que se va a validar.
	 * @return si la string es valida
	 */
	private static boolean validList(String as_list) {
		String[] lsa_parts;
		boolean lb_valid;
		
		lsa_parts = as_list.split(",");
		lb_valid = true;
		
		for (int i = 0; i < lsa_parts.length; i++) {
			try{
				Double.parseDouble(lsa_parts[i]);
			}catch(Exception e){
				lb_valid = false;
			}
		}
		return lb_valid;
	}
	
}