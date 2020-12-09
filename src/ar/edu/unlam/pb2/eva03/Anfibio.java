package ar.edu.unlam.pb2.eva03;

import interfaces.Acuatico;
import interfaces.Terreste;

public class Anfibio  extends Vehiculo implements Acuatico, Terreste {

	public Anfibio(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	private Double velocidad =0.0 , profundidad = 0.0; 
	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

}
