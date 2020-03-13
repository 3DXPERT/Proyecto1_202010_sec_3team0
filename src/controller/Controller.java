package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.PriorityQueue;
import model.data_structures.Nodo;
import model.data_structures.noExisteException;
import model.logic.Modelo;
import model.logic.Registro;
import model.logic.Comparendo;
import view.View;

public class Controller{
//-------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------

	/**
	 * A model.
	 */
	private Modelo modelo;

	/**
	 * A view.
	 */
	private View view;
	
	PriorityQueue<Registro> registros = new PriorityQueue<Registro>();
	PriorityQueue<Comparendo> lista;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Creates the project view and the project model
	 */
	public Controller() {
		modelo = new Modelo();
		view = new View();
		registros = new PriorityQueue<Registro>();
		
	}

	// -------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------

	/**
	 * Prints the user options and updates the view using the model.
	 *
	 * @throws InputMismatchException If the user inputs an incorrect number sequence.
	 * @throws noExisteObjetoException 
	 */
	public void run() throws InputMismatchException, noExisteException {
		try {
			Scanner reader = new Scanner(System.in);
			boolean end = false;

			while (!end) {
				view.displayMenu();
				int option = reader.nextInt();
				switch (option) {

				case 0:
					
					modelo.cargarDatos();


					
					break;

				case 1:
				
					view.displayOp1Menu();
					view.displayOp1Data();
				
					modelo.cargarDatos();
					

			
					lista = modelo.procesarPriorityQueuePorComparendo();
					
					
					Nodo<Comparendo> nodo = lista.dequeue();
					
					
					
					while(nodo!=null)
					{
						System.out.println(nodo.darGenerico().toString());
						nodo = lista.dequeue();
					}
					
					
					break;

				case 2 :
					//----------------------------------------------------------------------------------------------------------
					// Mostrar los comparendos por latitud MaxCola
					//----------------------------------------------------------------------------------------------------------}
					lista.
				
		}
			}
		}
		}
		
		
		catch (InputMismatchException e)
		{
			run();
		}
	}

}
