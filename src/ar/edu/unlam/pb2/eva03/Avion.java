package ar.edu.unlam.pb2.eva03;

import interfaces.Volador;

public class Avion extends Vehiculo implements Volador {

	public Avion(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	private Double altura = 0.0; 
	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}

}
