package ar.edu.unlam.pb2.eva03;

import interfaces.Terreste;

public class Camion extends Vehiculo implements Terreste {

	public Camion(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	private Double velocidad = 0.0;
	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return this.velocidad;
	}

}
