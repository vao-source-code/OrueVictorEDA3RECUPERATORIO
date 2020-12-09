package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBatalla;
import interfaces.Acuatico;
import interfaces.BatallaInexistente;
import interfaces.Terreste;
import interfaces.VehiculoIncompatible;
import interfaces.VehiculoInexistente;
import interfaces.Volador;

public class FuerzaArmada {

	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;

	public FuerzaArmada() {

		convoy = new HashSet<Vehiculo>();

		batallas = new HashMap<String, Batalla>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub

		convoy.add(vehiculo);
	}

	public Object getCapacidadDeDefensa() {
		// TODO Auto-generated method stub
		return this.convoy.size() - 1;
	}

	public void crearBatalla(String string, TipoDeBatalla tipoBatalla, Double longitud, Double latitud) {
		// TODO Auto-generated method stub

		Batalla batalla = new Batalla(tipoBatalla, longitud, latitud);

		this.batallas.put(string, batalla);

	}

	public Batalla getBatalla(String string) {
		// TODO Auto-generated method stub
		return this.batallas.get(string);
	}

	public Boolean enviarALaBatalla(String string, Integer i)
			throws VehiculoIncompatible, VehiculoInexistente, BatallaInexistente {
		// TODO Auto-generated method stub

		Boolean estado = false;
		if (this.batallas.containsKey(string)) {

			Batalla batalla = this.batallas.get(string);

			Vehiculo vehiculo = this.buscarVehiculo(i);

			if (vehiculo != null) {
				switch (this.batallas.get(string).tipoBatalla()) {

				case TERRESTRE:
					if (vehiculo instanceof Terreste) {
						this.batallas.remove(string, batalla);
						estado = batalla.vehiculosEnLaBatalla.add(vehiculo);

						this.batallas.put(string, batalla);
					}
					break;
				case NAVAL:
					if (vehiculo instanceof Acuatico) {

						batalla.vehiculosEnLaBatalla.add(vehiculo);
						this.batallas.remove(string, batalla);
						this.batallas.put(string, batalla);
					}

					break;

				case AEREA:
					if (vehiculo instanceof Volador) {
						estado = batalla.vehiculosEnLaBatalla.add(vehiculo);
						this.batallas.remove(string, batalla);
						this.batallas.put(string, batalla);
					}
					break;
				default:
					throw new VehiculoIncompatible("Vehiculo Incompatible");

				}
			} else {
				throw new VehiculoInexistente("no existe el vehiculo");
			}

		} else {

			throw new BatallaInexistente("No existe la batalla");
		}
		return true;
	}

	private Vehiculo buscarVehiculo(Integer i) {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : this.convoy) {
			if (vehiculo.getId().equals(i)) {
				return vehiculo;
			}

		}
		return null;
	}

}
