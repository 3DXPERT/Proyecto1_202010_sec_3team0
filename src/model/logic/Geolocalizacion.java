package model.logic;

public class Geolocalizacion {
	


	private String tipo;
	
	
	private double[] coordenadas;
	
	
	public Geolocalizacion(String tipo, double[] coordenadas) {
		super();
		this.tipo = tipo;
		this.coordenadas = coordenadas;
	}
	
	public String toString()
	{
		String msj = " el tipo de geo es " + tipo + " las coordenas son " + coordenadas[0] 
				+ ", " + coordenadas[1] + ", " + coordenadas[2]+ ".";
		
		return msj;
	}
}

