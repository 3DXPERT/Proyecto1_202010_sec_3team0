package model.logic;
public class Comparendo
{

	public long id;

	public String fecha;

	public String medioDete;

	public String vehiculo;

	public String servicio;

	public String infraccion;

	public String descripcion;

	public String localidad;

	public Geolocalizacion geo;



	public Comparendo(long id, String fecha, String medioDete, String vehiculo, String servicio, String infraccion,
			String descripcion, String localidad, Geolocalizacion geo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.medioDete = medioDete;
		this.vehiculo = vehiculo;
		this.servicio = servicio;
		this.infraccion = infraccion;
		this.descripcion = descripcion;
		this.localidad = localidad;
		this.geo = geo;
	}

	public String toString()
	{

		String msj = "La id es "+ id +" la fecha del comparendo "+ fecha 
				+" el medio de detencion es "+ medioDete +
				" el vehiculo es "+ vehiculo +" el tipo de servicio es " + servicio + 
				" la infraccion es " + infraccion + 
				" la descripcion de lo sucedido es " + descripcion + " la localidad es "+
				localidad +" la geografira es "+ geo.toString();


		return msj;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMedioDete() {
		return medioDete;
	}

	public void setMedioDete(String medioDete) {
		this.medioDete = medioDete;
	}

	public String getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getInfraccion() {
		return infraccion;
	}

	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Geolocalizacion getGeologic() {
		return geo;
	}

	public void setGeologic(Geolocalizacion geo) {
		this.geo = geo;
	}


}


