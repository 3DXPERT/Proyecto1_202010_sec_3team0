
package model.data_structures;

public interface IHeap<T> {

	
	public void insert(T nodo);
	
	public boolean isEmpty();

	public int size();

	public Nodo<T> peek();

	
	public Nodo<T> deleteMax();
	public void swim();
	
	public void sink();
	
	
}