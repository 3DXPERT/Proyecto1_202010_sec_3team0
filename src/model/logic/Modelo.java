package model.logic;



import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


import model.data_structures.ICola;

import model.data_structures.Cola;

import model.data_structures.Nodo;
import model.data_structures.noExisteException;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private ICola<Comparendo> datosQueue;
	
	
	


	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		
		datosQueue = new Cola<Comparendo>();
		
		
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
//	public Modelo(int capacidad)
//	{
//		//datos = new ArregloDinamico(capacidad);
//	}
	
	public Cola<Comparendo> darDatosQueue()
	{
		return  (Cola<Comparendo>) datosQueue;
	}
	
	
	

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datosQueue.size();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregarComparendo(Nodo<Comparendo> dato)
	{	
		datosQueue.enqueue(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 * @throws noExisteObjetoException 
	 */
	
	
	

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 * @throws noExisteObjetoException 
	 */
	
	public Nodo<Comparendo> eliminarComparendo() throws noExisteException
	{
		return datosQueue.dequeue();
	}

	public void cargarDatos() throws noExisteException 
	{
		String path = "./data/Json.Json";
		JsonReader lector;


		try {


			
			Cola<Comparendo> listaQueue = new Cola<Comparendo>();


			lector = new JsonReader(new FileReader(path));
			JsonElement elem = JsonParser.parseReader(lector);
			JsonObject ja = elem.getAsJsonObject();

			JsonArray features = ja.getAsJsonArray("features");


			for(JsonElement e : features)
			{



				JsonObject propiedades = (JsonObject) e.getAsJsonObject().get("properties");
				long id = propiedades.get("OBJECTID").getAsLong();
				String fecha = propiedades.get("FECHA_HORA").getAsString();
				String medioDete = propiedades.getAsJsonObject().get("MEDIO_DETE").getAsString();
				String claseVehiculo = propiedades.getAsJsonObject().get("CLASE_VEHI").getAsString();
				String tipoServicio = propiedades.getAsJsonObject().get("TIPO_SERVI").getAsString();
				String infraccion = propiedades.getAsJsonObject().get("INFRACCION").getAsString();
				String descripcion = propiedades.getAsJsonObject().get("DES_INFRAC").getAsString();
				String localidad = propiedades.getAsJsonObject().get("LOCALIDAD").getAsString();


				JsonObject geometry = (JsonObject) e.getAsJsonObject().get("geometry");

				String tipo = geometry.get("type").getAsString();

				double[] listaCoords = new double[3];

				JsonArray coordsJson = geometry.getAsJsonArray("coordinates");




				for(int i = 0; i < coordsJson.size(); i ++)
				{
					listaCoords[i] = coordsJson.get(i).getAsDouble();


				}

				Geolocalizacion geometria = new Geolocalizacion(tipo, listaCoords);

				Comparendo comparendo = new Comparendo(id, fecha, medioDete, claseVehiculo, tipoServicio, infraccion, descripcion, localidad, geometria);


				Nodo<Comparendo> nComparendo = new Nodo<Comparendo>(comparendo);
				datosQueue.enqueue(nComparendo);
				

			} 

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}


	} 
	
	public String retornarreq1() throws noExisteException
	{
		return datosQueue.size()+" " + datosQueue.darPrimero().darGenerico().toString();
	}


	public Cola<Comparendo> procesarColaPorComparendo() throws noExisteException
	{
		
		
		Cola<Comparendo> arregloFinal = new Cola<Comparendo>();
		Nodo<Comparendo> nodoActual = datosQueue.dequeue();
		Comparendo ComparendoActual = nodoActual.darGenerico();
		Comparendo siguienteComparendo = nodoActual.darSiguiente().darGenerico();
		
		String tipoComparendoActual = ComparendoActual.getInfraccion();
		
		
		Cola<Comparendo> arregloTemporal = new Cola<Comparendo>();
		
		while(nodoActual != null)
		{
			arregloTemporal.enqueue(nodoActual);
			if(!(tipoComparendoActual.equals(siguienteComparendo.getInfraccion())))
			{
				if(arregloTemporal.size() >= arregloFinal.size())
				{
					arregloFinal = arregloTemporal;
				}
				arregloTemporal = new  Cola<Comparendo>();
			}
		}
		
		return arregloFinal;
		
	} 
	
	public Cola<Comparendo> reportarComparendos(int pCantidadComparendos, String tipoComparendo) throws noExisteException
	{
		Nodo<Comparendo> nodoActual = datosQueue.dequeue();
		Comparendo ComparendoActual = nodoActual.darGenerico();
		Cola<Comparendo> cola = new Cola<Comparendo>();
		while(nodoActual.hasNext() && pCantidadComparendos <= cola.size())
		{
			if(ComparendoActual.getInfraccion().equals(tipoComparendo) )
			{
				cola.enqueue(nodoActual);
			}
			
		}
		
		
		
		return cola;
	}
	
	
	
	

}