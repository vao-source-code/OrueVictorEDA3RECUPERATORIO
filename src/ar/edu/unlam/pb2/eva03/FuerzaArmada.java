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
		return this.convoy.size();
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

	public boolean enviarALaBatalla(String string, Integer i) throws VehiculoIncompatible, VehiculoInexistente, BatallaInexistente {
		// TODO Auto-generated method stub

		Boolean estado = false;
		if (this.batallas.containsKey(string)) {

			Iterator<Vehiculo> iterator = this.convoy.iterator();

			while (iterator.hasNext()) {

				Vehiculo vehiculo = (Vehiculo) iterator.next();
				if (vehiculo.getId().equals(i)) {
					switch (this.batallas.get(string).tipoBatalla()) {

					case TERRESTRE:
						if (iterator.next() instanceof Terreste) {
							estado = this.batallas.get(string).vehiculosEnLaBatalla.add(iterator.next());
						}
						break;
					case NAVAL:
						if (iterator.next() instanceof Acuatico) {
							estado = this.batallas.get(string).vehiculosEnLaBatalla.add(iterator.next());
						}

						break;

					case AEREA:
						if (iterator.next() instanceof Volador) {
							estado = this.batallas.get(string).vehiculosEnLaBatalla.add(iterator.next());
						}

					default:
						throw new VehiculoIncompatible("Vehiculo Incompatible");

					}
				}

			}
			if (!estado) {
				throw new VehiculoInexistente("Vehiculo Incompatible");
			}
		} else {

			throw new BatallaInexistente("No existe la batalla"); 
		}
		return false;
	}

}
