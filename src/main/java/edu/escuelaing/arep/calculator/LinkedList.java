package edu.escuelaing.arep.calculator;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * Clase encargada de simular el comportamiento de una lista encadenada
 *
 */
public class LinkedList implements Collection<Node>{
	
	/** Propiedad cabeza*/
	private Node in_cabeza;
	
	/**
	 * Metodo encargado de instanciar un objeto de ListaEncadenada
	 */
	public LinkedList() {
		in_cabeza = null;
	}
	
	/**
	 * Metodo encargado de dar el tamaño de la lista
	 * 
	 * @return El tamñao de la lista
	 */
	public int size() {
		int li_cantidad;
		Node ln_actual;
				
		li_cantidad = 0;
		ln_actual = in_cabeza;
				
		while (ln_actual != null) 
		{
			li_cantidad++;
		}
		
		return li_cantidad;
	}
	
	/**
	 * Metodo enrgado de validar si la lista esta vacia
	 * 
	 *  @return Si la lista esta vacia
	 */
	public boolean isEmpty() {
		return in_cabeza == null;
	}
	
	/**
	 * Metodo encargado de buscar un elemento dentro de la lista
	 *
	 * @param ao_o Elemento a buscar dentro de la lista 
	 * @return Si el elemento esta dentro de la lista
	 */
	public boolean contains(Object ao_o) {
		if (ao_o instanceof Node) 
		{
			boolean lb_encontrado;
			Node ln_actual;
			
			lb_encontrado = false;
			ln_actual = in_cabeza;
			
			while (ln_actual != null && !lb_encontrado) 
			{
				lb_encontrado = ln_actual.equals(ao_o);
				ln_actual = ln_actual.getSiguiente();
			} 
			return lb_encontrado;
		}
		return false;
	}
	
	/**
	 * Retorna un objeto de tipo <code>Iterator</code> sobre la lista.
	 * 
	 * @return un objeto de tipo <code>Iterator</code> sobre la lista.
	 */
	public Iterator<Node> iterator() {			
		return new Iterador();
	}
	
	/**
	 * Metodo encargado de convertir la lista en un arreglo de sus elmentos
	 * 
	 * @return Un arreglo con todos los elentos de la lista
	 */
	public Object[] toArray() {
		Node ln_actual;
		Node[] lna_arreglo;
		
		ln_actual = in_cabeza;
		lna_arreglo = new Node[size()];
		
		for (int i = 0; i < lna_arreglo.length; i++) 
		{
			lna_arreglo[i] = ln_actual;
			ln_actual = ln_actual.getSiguiente();
		}	
		 
		return lna_arreglo;
	}
	
	
	/**
	 * Metodo encargado de eliminar un objeto dentro de la lista
	 * 
	 * @param ao_o objeto a eliminar dentro de la lista 
	 * @return Si la operacon se realizo exitosamente
	 */
	public boolean remove(Object ao_o) {
		boolean lb_encontrado;
		Node ln_actual;
		
		lb_encontrado = false;
		ln_actual = in_cabeza;
		
		while (ln_actual != null && !lb_encontrado) 
		{
			ln_actual = ln_actual.getSiguiente();
			lb_encontrado = ln_actual.equals(ao_o);
		}
		
		if (ln_actual != null)
		{
			ln_actual.getAnterior().setSiguiente(ln_actual.getSiguiente());
			ln_actual.getSiguiente().setAnterior(ln_actual.getAnterior());
		}	
		
		return ln_actual == null;
	}
	
	/**
	 * Retorna true si esta coleccion contiene todos los elementos la de coleccion especificada.
	 * 
	 * @param ac_c Colecion a ser revisada
	 * @return true si esta coleccion contiene todos los elementos la de coleccion especificada.
	 */
	public boolean containsAll(Collection<?> ac_c) {
		for (Object lo_iterador : ac_c) 
		{
			if (!contains(lo_iterador))
				return false;
		}
		return true;
	}
	
	/**
	 * M�todo encargado de a�adir todos los elementos de la colecci�n especificada.
	 * 
	 * @param ac_c La coleci�n a agregar.
	 * @return true si la acci�n se realiz� correctamente.
	 */
	@SuppressWarnings("rawtypes")
	public boolean addAll(Collection ac_c) {
		
		for (Object lo_iterador : ac_c) 
		{
			if (!(lo_iterador instanceof Node))
				return false;
		}
		
		for (Object lo_iterador : ac_c) {
			add((Node)lo_iterador);
		}
		
		return true;
	}
	
	/**
	 * M�todo encargado de eliminar todos los elementos de la colecci�n especificada.
	 * 
	 * @param ac_c La coleci�n a eliminar.
	 * @return true si la acci�n se realiz� correctamente.
	 */
	public boolean removeAll(Collection<?> ac_c) {
		for (Object lo_iterador : ac_c) 
		{
			remove(lo_iterador);
		}
		return false;
	}
	
	/**
	 * Mantiene en la lista los elementos que estan contenidos en la colecci�n especificada
	 * 
	 * @return Si la acci�n se realiz� correctamente.
	 */
	public boolean retainAll(Collection<?> ac_c) {
		for (Object lo_iterador : this) 
		{
			if (!ac_c.contains(lo_iterador))
				remove(lo_iterador);
		}
		return true;
	}
	
	/**
	 * M�todo encargado de limpiar la lista
	 */
	public void clear() {
		in_cabeza = null;
	}
	
	/**
	 * M�todo encargado de a�adir un nodo a la lista.
	 * 
	 * @param an_nuevo Elemento de tipo <code>Node</code> para a�adir a la lista.
	 * @return Si el elemento se a�adio a la lista 
	 */
	public boolean add(Node an_nuevo) {
		return add(an_nuevo.getValor());
	}
	
	/**
	 * M�todo encargado de a�adir un nodo a la lista dado su valor.
	 * 
	 * @param an_nuevo Elemento de tipo <code>double</code> para a�adir a la lista.
	 * @return Si el elemento se a�adio a la lista 
	 */
	public boolean add(double an_nuevo) {
		Node in_actual;
		Node in_nuevo;
		
		in_actual = in_cabeza;
		in_nuevo = new Node();
		in_nuevo.setValor(an_nuevo);
		 
		if (in_actual != null)
		{
			
			while (in_actual.getSiguiente() != null) 
			{
				in_actual = in_actual.getSiguiente();
			}
			in_nuevo.setAnterior(in_actual);
			in_actual.setSiguiente(in_nuevo);
			
		}else 
			in_cabeza = in_nuevo;
			
		
		return true;
	}

	/**
	 * Devulve un arreglo con todos los elementos en esta colecci�n
	 * 
	 * @param lt_a el tipo de arreglo para contener la colecci�n
	 * @return un arreglo con todos los elementos en esta colecci�n
	 */
	public <T> T[] toArray(T[] lt_a) {
		
		if (lt_a[0].getClass() != in_cabeza.getClass())
			return null;
		else
		{
			Node[] lna_arrreglo;
			
			lna_arrreglo = (Node[]) toArray();
			
			if(lna_arrreglo.length <= lt_a.length) 
			{
				for (int i = 0; i < lna_arrreglo.length; i++) 
				{
					lt_a[i] = (T) lna_arrreglo[i];
				}
				
				if(lna_arrreglo.length < lt_a.length) 
					lt_a[lna_arrreglo.length] = null;
			}else
				lt_a = (T[]) lna_arrreglo;
			
			return lt_a;
		}
		
	}
	
	/**
	 * Clase encargada de crear un iterador sobre ListaEncadenada 
	 */
	protected class Iterador implements Iterator<Node>   {

		/** Propiedad actual */
        protected Node in_actual;
        
        /**
         * Creador de un objeto de <code>Iterador</code>
         */
        public Iterador()   {
        	in_actual = in_cabeza; 
        }
        
        /**
         * Indica si la lista tienen un siguiente elemento.
         * 
         * @return si la lista tienen un siguiente elemento.
         */
        public boolean hasNext() {
            boolean result;
            if (in_actual != null) 
            	result = true;
            else 
            	result = false;
            return result;
        }

        /**
         * Devuelve el siguiente elemento de la lista.
         * 
         * @return El siguiente elemento de la lista.
         */
        public Node next() {
        	Node ln_devolver;
        	
        	ln_devolver = in_actual; 
        	if (in_actual != null) 
        		in_actual = in_actual.getSiguiente();
            return ln_devolver;
        }

    }

}