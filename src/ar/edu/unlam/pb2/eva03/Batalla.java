package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBatalla;



public class Batalla {
	
	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	
	public Batalla(TipoDeBatalla terrestre, Double latitud, Double longitud) {
		// TODO Auto-generated constructor stub
		
		this.tipo  = terrestre; 
		
		this.latitud = latitud ; 
		this.longitud = longitud; 
		
		
		vehiculosEnLaBatalla = new HashSet<Vehiculo>();
		
	}
	
	public Set<Vehiculo> getVehiculosEnLaBatalla(){
		return vehiculosEnLaBatalla;
	}

	public TipoDeBatalla tipoBatalla() {
		// TODO Auto-generated method stub
		return this.tipo;
	}
	
	
	
	
	
}
