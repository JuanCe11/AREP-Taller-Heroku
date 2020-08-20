package edu.escuelaing.arep;

/**
 * Clase encargada de mostrar el comportamiento de un nodo 
 *
 */
public class Node {
	
	/** Propiedad in anterior. */
	private Node in_anterior;
	
	/** Propiedad in siguiente. */
	private Node in_siguiente;
	
	/** Propiedad id valor. */
	private double id_valor;
	
	public Node() {
		in_anterior = null;
		in_siguiente = null;
		id_valor = 0;
	}
	
	/**
	 * M�todo encargado de devolver el valor de la propiedad anterior
	 * 
	 * @return Retorna el valor de la propiedad anterior
	 */
	public Node getAnterior() {
		return in_anterior;
	}
	
	/**
	 * M�todo encargado de modificar el valor de la propiedad anterior
	 * 
	 * @param an_n El nuevo valo para la propiedad anterior
	 */
	public void setAnterior(Node an_n) {
		in_anterior = an_n;
	}
	
	/**
	 * M�todo encargado de devolver el valor de la propiedad siguiente
	 * 
	 * @return Retorna el valor de la propiedad siguiente.
	 */
	public Node getSiguiente() {
		return in_siguiente;
	}
	
	/**
	 * M�todo encargado de modificar el valor de la propiedad siguiente
	 * 
	 * @param an_n El nuevo valo para la propiedad siguiente
	 */
	public void setSiguiente(Node an_n) {
		in_siguiente = an_n;
	}
	
	/**
	 * M�todo encargado de devolver el valor de la propiedad valor
	 * 
	 * @return Retorna el valor de la propiedad valor
	 */
	public double getValor() {
		return id_valor;
	}
	
	/**
	 * M�todo encargado de modificar el valor de la propiedad valor
	 * 
	 * @param ad_d El nuevo valo para la propiedad valor
	 */
	public void setValor(double ad_d) {
		id_valor = ad_d;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (Double.doubleToLongBits(id_valor) != Double.doubleToLongBits(other.id_valor))
			return false;
		return true;
	}
}