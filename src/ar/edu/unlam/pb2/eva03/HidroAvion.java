package ar.edu.unlam.pb2.eva03;

import interfaces.Acuatico;
import interfaces.Volador;

public class HidroAvion extends Vehiculo implements Acuatico, Volador {

	public HidroAvion(Integer id, String nombre) {
		super(id, nombre);
		// TODO Auto-generated constructor stub
	}

	private Double altura = 0.0 , profundidad =0.0 ; 
	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

}
