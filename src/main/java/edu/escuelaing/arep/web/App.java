package edu.escuelaing.arep.web;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.calculator.Calculator;
import edu.escuelaing.arep.calculator.StringReader;
import edu.escuelaing.arep.calculator.LinkedList;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

/**
 * Class in charge of starting the service.
 *
 */
public class App {
	
	/**
	 * Main class that starts the main thread of the service.
	 * 
	 * @param args String array
	 */
	public static void main(String[] args) {
		port(getPort());
		staticFiles.location("/public");
        
        get("/", (req, res) -> {
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
	 * Specifies the port on which the service will run.
	 * 
	 * @return The port where the service will be run.
	 */
	public static int getPort() {    
		if (System.getenv("PORT") != null)
		{            
			return Integer.parseInt(System.getenv("PORT"));      
		} 
		return 4567; 
	}
	
	/**
	 * Method in charge of generating the values of the mean and the standard deviation.
	 * 
	 * @param model Data that will be passed to the template.
	 * @param req Request received by the server
	 * @param res Server response.
	 * @return Returns if it was possible to calculate the data with the information entered.
	 */
	private static boolean resultData(Map<String, Object> model, Request req, Response res){
		String ls_values;
		boolean lb_resp;
		
		ls_values = req.queryParams("list");
		lb_resp = validList(ls_values);
		
		if (lb_resp) {
			double[] lda_numbers;
        	LinkedList lle_list;
        	
        	lda_numbers = StringReader.convertArray(ls_values);
        	lle_list = new LinkedList();
        	
        	for (int i = 0; i < lda_numbers.length; i++) {
				lle_list.add(lda_numbers[i]);
			}
        	double ld_res;
        	
        	ld_res = Calculator.mean(lle_list);
        	ld_res = (double) Math.round(ld_res * 100) / 100;
        	model.put("mean", ld_res);
        	
        	ld_res = Calculator.standardDeviation(lle_list);
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
	 * Validate if a string is valid to calculate the values.
	 * 
	 * @param as_list String to validate.
	 * @return if the string is valid
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