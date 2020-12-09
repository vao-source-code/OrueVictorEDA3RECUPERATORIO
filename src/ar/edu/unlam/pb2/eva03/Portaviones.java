package ar.edu.unlam.pb2.eva03;

import interfaces.Acuatico;

public class Portaviones extends Vehiculo implements Acuatico {

	public Portaviones(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	private Double profundidad = 0.0; 
	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return profundidad;
	}

}
