package model.data_structures;

import model.logic.Comparendo;

public interface IPriorityQueue<T> {

	public void enqueue(Nodo<T> nComparendo);
	
	public Nodo<T> dequeue();
	
	public boolean isEmpty();

	public int size();

	public Nodo<T> peek();

	public Nodo<T> peekLast();
	
	public Nodo<T> deleteMax();
}