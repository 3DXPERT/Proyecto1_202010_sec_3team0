
package model.data_structures;

import java.util.ArrayList;

public class Heap<T> extends ListaEncadenada<T> implements IHeap<T>  {

	private int tamaño;
	private Nodo<T> primer;
	private Nodo<T> ultimo;
	private ArrayList<Nodo> lista;

	public Heap(Nodo<T> primero) {
		super(primero);
		primer = (Nodo<T>) super.getUltimoNodo();
		ultimo = (Nodo<T>) super.getPrimerNodo();
		tamaño = super.getTamanio();
		lista = new ArrayList<Nodo>();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (lista.size()==0)
		{
			return true;
		}
		else 
			return false;
	}

	public int size() {
		
		return lista.size();
	}

	public Nodo<T> peek() {
		
		if(!isEmpty()) {
			Nodo respuesta = null;
			for (int i = 0; i < lista.size(); i++) {
				Nodo actual = lista.get(i);

				if(actual.getPrioridad()>respuesta.getPrioridad())
				{
					respuesta=actual;
				}

				return respuesta;
			}
		}

		else return null;
	}
	public Nodo deleteMax() {
		
		Nodo respuesta = null;

		if(!isEmpty()) {

			for (int i = 0; i < lista.size(); i++) {
				Nodo actual = lista.get(i);

				if(actual.getPrioridad()>respuesta.getPrioridad())
				{
					respuesta=actual;
				}

			}
			return respuesta;
			for (int i = 0; i < lista.size(); i++) {


				if(lista.get(i)==respuesta)
				{
					lista.remove(i);

				}
			}
		}




		else

			return null;

	}










	@SuppressWarnings("rawtypes")
	public void insert(Object nodo) {
		
		lista.add((Nodo) nodo);
		swim();


	}

	public void swim() {
	
		lista.mergeSort();



	}

	
	public void sink() {
		
		lista.mergeSort();

	}

	

}

