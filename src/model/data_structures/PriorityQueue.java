
package model.data_structures;

public class PriorityQueue<T> extends ListaEncadenada implements IPriorityQueue<T> {

	private int tamaño;
	private Nodo<T> primer;
	private Nodo<T> ultimo;

	public PriorityQueue <T> (Nodo<T> primero)
	{
		super(primero);
		primer = (Nodo<T>) super.getUltimoNodo();
		ultimo = (Nodo<T>) super.getPrimerNodo();
		tamaño = super.getTamanio();
	}



	public void enqueue(Nodo<T> nodo) {
		if (primer==null)
		{
			super.AppendNode((Nodo<T>)nodo);
			super.setUltimoNodo((Nodo<T>)nodo);
			primer = (Nodo<T>)super.getUltimoNodo();
			ultimo = (Nodo<T>)super.getPrimerNodo();
			tamaño = super.getTamanio();
		}
		else {
			super.AppendNode((Nodo<T>)nodo);
			ultimo = (Nodo<T>)super.getPrimerNodo();
		}
		tamaño = super.getTamanio();
	}

	public Nodo<T> dequeue ()
	{
		Nodo<T> respuesta = primer;
		if(primer == ultimo){
			super.setPrimerNodo(null);
			super.setUltimoNodo(null);
			super.setPrimeroAntiguo(null);
			primer = (Nodo<T>) super.getUltimoNodo();
			ultimo = (Nodo<T>) super.getPrimerNodo();
			super.setTamanio(0);
			tamaño = super.getTamanio();
			return respuesta;
		}
		else {
			super.deleteNode(super.getTamanio()-1);
			primer = (Nodo<T>) super.getUltimoNodo();
			tamaño = super.getTamanio();
			return respuesta;
		}
	}

	public boolean isEmpty()
	{
		boolean respuesta = false;
		tamaño = getTamanio();
		if(tamaño==0)
		{
			respuesta = true;
		}
		return respuesta;

	}

	public int getTamanio() {
		
		return tamaño;
	}

	public int size()
	{
		return tamaño;
	}

	public Nodo<T> peek()
	{
		return primer;
	}

	public Nodo<T> peekLast()
	{
		return ultimo;
	}

	public Nodo<T> deleteMax()
	{
		if(!isEmpty())
		{
			Nodo respuesta = primer;
			Nodo actual = primer;
			boolean done = false;
			
			
			while (actual != null)
			{
				if(actual.getPrioridad()>respuesta.getPrioridad())
				{
					respuesta=actual;

				}
				actual = actual.darSiguiente();
			}

			while(!done)
			{
				Nodo actual2= primer;
				if(actual2== respuesta)
				{
					if (primer.darSiguiente()==respuesta)
					{
						primer.setSiguiente(primer.darSiguiente().getSiguiente());
					}
					if(primer==respuesta)
					{
						setPrimerNodo(primer.darSiguiente());
					}
				}
			}
			return respuesta;
		}

		else

			return null;


	}

	public Nodo<T> darPrimero() throws noExisteException
	{
		
		
		
		if (primero == null)
		{
			throw new noExisteException();
		}
		
		else return primero;
	}




}