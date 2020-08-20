package edu.escuelaing.arep;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.escuelaing.arep.calculator.Calculator;
import edu.escuelaing.arep.calculator.LectorArchivos;
import edu.escuelaing.arep.calculator.LinkedList;
import edu.escuelaing.arep.calculator.Node;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
	/**
	 * Test that calculates the mean with example 1.
	 */
	@Test
	public void shouldCalculateMean() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("ejemplo.txt");
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		
		assertTrue(Calculator.mean(lle_list) == (double)638.9);
		
	}
	
	/**
	 * Test that calculates the mean with proxy size example.
	 */
	@Test
	public void shouldCalculateMeanEstimateProxySize() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("proxy.txt");
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		
		assertTrue(Calculator.mean(lle_list) == (double)550.6);
		
	}
	
	/**
	 * Test that calculates the mean with development hours example.
	 */
	@Test
	public void shouldCalculateMeanDevelopmentHours() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("development.txt");	
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		
		{
			double ld_answer;
			
			ld_answer = Calculator.mean(lle_list);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
					
			assertTrue(ld_answer == (double)60.32);
		}
		
	}
	
	/**
	 * Test that calculates the standar deviation with example 1.
	 */
	@Test
	public void shouldCalculateDeviation() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("ejemplo.txt");
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lle_list);
			ld_answer = (double) Math.round(ld_answer * 1000000) / 1000000;
			
			assertTrue(ld_answer == (double)625.633981);
		}
		
		
	}
	
	/**
	 * Test that calculates the standar deviation with proxy size example.
	 */
	@Test
	public void shouldCalculateDeviationEstimateProxySize() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("proxy.txt");
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lle_list);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
			
			assertTrue(ld_answer == (double)572.03);
		}
		
		
	}
	
	/**
	 * Test that calculates the standar deviation with development hours example.
	 */
	@Test
	public void shouldCalculateDeviationDevelopmentHours() {
		
		LinkedList lle_list;
		double[] lda_values;
		
		lle_list = new LinkedList();		
		lda_values = LectorArchivos.leerArchivo("development.txt");	
		
		for (int i = 0; i < lda_values.length; i++) 
		{
			Node ln_node;
			
			ln_node = new Node();
			
			ln_node.setValor(lda_values[i]);
			lle_list.add(ln_node);
		}
		
		{
			double ld_answer;
			
			ld_answer = Calculator.standardDeviation(lle_list);
			ld_answer = (double) Math.round(ld_answer * 100) / 100;
					
			assertTrue(ld_answer == (double)62.26);
		}
		
	}

}