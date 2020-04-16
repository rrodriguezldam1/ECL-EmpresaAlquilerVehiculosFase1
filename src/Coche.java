
/**
 * @author Ram�n Rodr�guez Lucas
 * 
 * Un coche es un vehículo que añade un nº de plazas
 * 
 * El coste final de alquiler depende no solo del nº de días de alquiler 
 * sino también del nº de plazas. Si el nº de plazas es > 4 se añaden 5€ más por día
 */
public class Coche extends Vehiculo {

	int nPlazas;

	public Coche(String matricula, String marca, String modelo, double precio, int plazas) {
		super(matricula, marca, modelo, precio);
		nPlazas = plazas;
	}

	@Override
	public double calcularPrecioAlquiler(int dias) {
		double alquiler;
		alquiler = dias * precio;
		if(nPlazas > 4)
			alquiler += 5*dias;
		return alquiler;
	}
	
	public int compareTo(Coche c) {
	    return matricula.compareTo(c.matricula);
	}
	 
	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	@Override
	public String toString() {
		return "COCHE\n"+super.toString()+" | Plazas : "+nPlazas+" (m3)";
	}

}
