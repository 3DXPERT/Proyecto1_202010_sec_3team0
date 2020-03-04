package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Cola;
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
	
	Cola<Registro> registros = new Cola<Registro>();
	Cola<Comparendo> lista;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Creates the project view and the project model
	 */
	public Controller() {
		modelo = new Modelo();
		view = new View();
		registros = new Cola<Registro>();
		
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


					view.displayOp0Menu(modelo.retornarreq1());
					break;

				case 1:
				
					view.displayOp1Menu();
					view.displayOp1Data();
				
					modelo.cargarDatos();
					

			
					lista = modelo.procesarColaPorComparendo();
					
					
					Nodo<Comparendo> nodo = lista.dequeue();
					
					
					
					while(nodo!=null)
					{
						System.out.println(nodo.darGenerico().toString());
						nodo = lista.dequeue();
					}
					
					
					break;

				case 2 :
					//------------------------------------------------------------------------------------------------------------
					//Mostrar  la lista de comparendos  (Por Código de infracción)
					//------------------------------------------------------------------------------------------------------------
					
					Nodo<Comparendo> nodoOperacion1 = lista.darPrimero();
					String infraccion = null;
					String infraccionAnterior = null;
					Nodo<Comparendo> nodoComparacion = lista.darPrimero();
					String listado = null;
					for(int i = 0; i < lista.size(); i++) {
					infraccion = ((Comparendo) nodoOperacion1.darGenerico()).getInfraccion();
					if(!infraccion.equals(infraccionAnterior)) {
				    Registro registro = new Registro (nodoOperacion1.darGenerico().getInfraccion(), nodoOperacion1.darGenerico().getServicio(), nodoOperacion1.darGenerico().getLocalidad());
					Nodo<Registro> nRegistro = new Nodo<Registro>(registro);
					registros.enqueue(nRegistro);
					for(int j = 0; j < lista.size(); j++) {
						if(nodoComparacion.darGenerico().getInfraccion().equals(infraccion)){
							if (nodoComparacion.darGenerico().getServicio().equals("Privado")) {
							nRegistro.darGenerico().incrementarCantidadPrivado();
							}
							if (nodoComparacion.darGenerico().getServicio().equals("Publico")) {
								nRegistro.darGenerico().darCantidadPublico();
						}
							nRegistro.darGenerico().incrementarCantidad();
						}
						
						nodoComparacion = nodoComparacion.darSiguiente();
					}
					}
					infraccionAnterior = infraccion;
					nodoOperacion1 = nodoOperacion1.darSiguiente();
					}
					
					Nodo<Registro> actual1 = registros.darPrimero();
					for(int p = 0; p < registros.size(); p++) {
						listado = listado + actual1.darGenerico().darCodigo() + ": " + actual1.darGenerico().darCantidad() + " / ";
						actual1 = actual1.darSiguiente();
					}
					
				case 3 : 
					//------------------------------------------------------------------------------------------------------------
					//Mostrar las tres mayores infracciones cometidas
					//------------------------------------------------------------------------------------------------------------
					String MayorInfraccion = null;
					int valorMayorInfraccion = 0;
					String segundaMayorInfraccion = null;
					int valorsegundaMayorInfraccion = 0;
					String terceraMayorInfraccion = null;
					int valorterceraMayorInfraccion = 0;
					Nodo<Registro> actual = registros.darPrimero();
					for(int z = 0; z < registros.size(); z++) {
						if(actual.darGenerico().darCantidad() >= valorMayorInfraccion) {
							MayorInfraccion = actual.darGenerico().darCodigo();
							valorMayorInfraccion = actual.darGenerico().darCantidad();
						}
						else if (actual.darGenerico().darCantidad() >= valorsegundaMayorInfraccion) {
							segundaMayorInfraccion = actual.darGenerico().darCodigo();
							valorsegundaMayorInfraccion = actual.darGenerico().darCantidad();
						}
						else if (actual.darGenerico().darCantidad() >= valorterceraMayorInfraccion) {
							terceraMayorInfraccion = actual.darGenerico().darCodigo();
							valorterceraMayorInfraccion = actual.darGenerico().darCantidad();
						}
					}
				case 4 : 
					//------------------------------------------------------------------------------------------------------------
					//Mostrar grafica ASCII comparendos
					//------------------------------------------------------------------------------------------------------------
					String ASCII = null;
					Nodo<Registro> actual2 = registros.darPrimero();
					for(int d = 0; d < registros.size(); d++) {
						ASCII = ASCII + actual2.darGenerico().darLocalidad() + ": " + actual2.darGenerico().ASCII() + " / ";
						actual2 = actual2.darSiguiente();
					}
				case 5 : 
					//------------------------------------------------------------------------------------------------------------
					//Mostrar  la lista de comparendos  (Por Código de infracción, y Tipo de Servicio)
					//------------------------------------------------------------------------------------------------------------
					String listado2 = null;
					Nodo<Registro> actual3 = registros.darPrimero();
					for(int p = 0; p < registros.size(); p++) {
						listado2 = listado2 + actual3.darGenerico().darCodigo() + ": ((Privado):" + actual3.darGenerico().darCantidadPrivado() + " ) ((Publico): " + actual3.darGenerico().darCantidadPublico() + " / ";
						actual3 = actual3.darSiguiente();
					
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
