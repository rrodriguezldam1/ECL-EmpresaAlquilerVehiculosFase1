
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * La clase guarda en una colección List (un ArrayList) la flota de vehículos
 * que una agencia de alquiler posee
 * 
 * Los vehículos se modelan como un interface List que se instanciará como una
 * colección concreta ArrayList
 */
package circa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgenciaAlquiler {

	private List<Vehiculo> flota;
	
	public AgenciaAlquiler() {
		flota = new ArrayList<>();
	}
	
	public void addVehiculo(Vehiculo vehiculo) {
		boolean existente = false;
		//Se puede utilizar un iterator
		for (Vehiculo vehi: flota) {
			//Se puede sobreescribir el hashCode para comparar Objetos "custom" directamente con .equals()
			if(vehi.getMatricula().equals(vehiculo.getMatricula())) {
				existente = true;
				break; //No es muy buena practica utilizar break, quiz�s ser�a mejor dejar que recorriese la lista entera
			}
				
		}
		if(!existente)
			flota.add(vehiculo);
	}
	
	public Vehiculo obtenerVehiculo(String linea) {
		Vehiculo vehiculo;
		String[] valores = linea.split("[,]");
		switch(valores[0]) {
		case "C":
			vehiculo =  new Coche(valores[1], valores[2], valores[3], Double.parseDouble(valores[4]), Integer.parseInt(valores[5]));
			break;
		case "F":
			vehiculo = new Furgoneta(valores[1], valores[2], valores[3], Double.parseDouble(valores[4]), Integer.parseInt(valores[5]));
			break;
		default:
			vehiculo = null;
		}
		return vehiculo;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
	public String buscarCoches(int dias) {
		Iterator<Vehiculo> iterator = flota.iterator();
		String resultado = "";
		while(iterator.hasNext()) {
			if (iterator.next() instanceof Coche) {
				double precioTotal = ((Coche) iterator.next()).calcularPrecioAlquiler(dias);
				resultado += ((Coche) iterator.next()).toString() + " | Precio Total: "+precioTotal;
				resultado += "\n ------------------------------------------------";
			}
		}
		return resultado;
	}
	
	List<Coche> cochesOrdenadosMatricula(){
		List<Coche> coches = new ArrayList<>();
		Iterator<Vehiculo> iterator = flota.iterator();
		//Se puede crear un objeto Coche en vez de utilizar el casting (Coche)
		while(iterator.hasNext()) {
			if (iterator.next() instanceof Coche && ((Coche)iterator.next()).getnPlazas() == 4) {
				coches.add((Coche)iterator.next());
			}
		}
		coches.sort(new Comparator<Coche>() {
			@Override
			public int compare(Coche o1, Coche o2) {
				return o1.compareTo(o2);
			}
		});
		return coches; 
	}
}
