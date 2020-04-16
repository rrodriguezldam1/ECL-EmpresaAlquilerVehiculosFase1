
/**
 * @author Ram�n Rodr�guez Lucas
 * 
 * Una furgoneta es un vehículo que añade la característica del volumen de carga
 * (valor de tipo double)
 * 
 * El coste de alquiler de una furgoneta no solo depende del nº de días de
 * alquiler
 * Tendrá un incremento que dependerá de su volumen de carga: hasta 5 m3
 * exclusive ( metros cúbicos) de volumen el incremento sobre el precio
 * final será de 10€, entre 5 y 10 (inclusive) el incremento sobre el precio
 * final será de 15€, si volumen > 10 el incremento sobre el precio final será de
 * 25€
 * 
 */
public class Furgoneta extends Vehiculo {
	double cargaMaxima;
	
	public Furgoneta(String matricula, String marca, String modelo, double precio, double cargaMaxima) {
		super(matricula, marca, modelo, precio);
		this.cargaMaxima = cargaMaxima;
	}

	@Override
	public double calcularPrecioAlquiler(int dias) {
		double alquiler;
		alquiler = dias*precio;
		if(cargaMaxima<=5) {
			alquiler+=10;
		}else if(cargaMaxima>5 && cargaMaxima<=10) {
			alquiler+=15;
		}else
			alquiler+=25;
		return alquiler;
	}

	public double getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	@Override
	public String toString() {
		return "FURGONETA\n"+super.toString()+" | Volumen : "+cargaMaxima+" (m3)";
	}
}
