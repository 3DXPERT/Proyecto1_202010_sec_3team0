package model.logic;

public class Registro {
private String codigo;
private String servicio;
private int cantidad;
private String localidad;
private int cantidadPrivado;
private int cantidadPublico;

public Registro (String codigoInfraccion, String servicioInfraccion, String localidadInfraccion) {
	codigo = codigoInfraccion;
	servicio = servicioInfraccion;
	cantidad = 0;
	localidad = localidadInfraccion;
}

public String darCodigo() {
	return codigo;
}
public String darServicio() {
	return servicio;
}
public int darCantidad() {
	return cantidad;
}
public String darLocalidad() {
	return localidad;
}
public void incrementarCantidad() {
	cantidad++;
}
public int darCantidadPrivado() {
	return cantidadPrivado;
}
public int darCantidadPublico() {
	return cantidadPublico;
}
public void incrementarCantidadPrivado() {
	cantidadPrivado++;
}
public void incrementarCantidadPublico() {
	cantidadPublico++;
}
public String ASCII() {
	String ASCII = null;
	int valor = 50;
	boolean paro = false;
	while(paro =! true) {
		if(cantidad >= valor) {
			ASCII = ASCII + "*";
			valor = valor + 50;
		}
		else {
			paro = true;
		}
	}
	return ASCII;
}
}
