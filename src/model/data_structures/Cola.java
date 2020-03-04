package model.data_structures;

import java.util.Iterator;

public class Cola <K> implements ICola <K>, Iterable <K> {

	private Nodo<K> primero;

	private Nodo<K> ultimo;

	private int tamano;

	
	public Cola()
	{
		primero = null;

		ultimo = null;

		tamano = 0;
	}
	
	
	public void enqueue(Nodo <K> item) {
		
		if(primero == null)
		{
			primero = item;
			ultimo = item;

		}
		else
		{
			item.cambiarAnterior(ultimo);
			ultimo.cambiarSiguiente(item);
			ultimo = item;
		}

		tamano++;
		
	}

	public Nodo<K> dequeue() throws noExisteException
	{
		
		
		if(tamano == 0)
		{
			throw new noExisteException();
		}
		else
		{
			Nodo<K> aEliminar = primero;
			
			if(aEliminar.darSiguiente() != null)
			{
				
				primero = aEliminar.darSiguiente();

				primero.desconectarAnterior();
				


			}
			else
			{
			
				ultimo = null;
				primero = null;
				


			}



			tamano--;

			return aEliminar;
		}
	}

	public boolean isEmpty() {
		boolean si = false;
		
		if (tamano == 0)
		{
			si = true;
		}
		
		return si;
	}

	public int size() {
		
		return tamano;
	}


	public Nodo<K> darPrimero() throws noExisteException
	{
		
		
		
		if (primero == null)
		{
			throw new noExisteException();
		}
		
		else return primero;
	}


	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return primero;
	}
	
	


	
}
	
	
