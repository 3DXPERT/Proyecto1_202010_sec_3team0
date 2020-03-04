package model.data_structures;

import java.lang.reflect.Array;

import model.logic.Comparendo;

public interface ICola <K> {

	public void enqueue ( Nodo< K > dato);
	public Nodo<K> dequeue() throws noExisteException;
	public boolean isEmpty();
	public int size();
	public Nodo<K> darPrimero() throws noExisteException;
	
}

