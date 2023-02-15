/*Aldahir Lopez Navarrete
 * 21 de noviembre de 2020
 * Clase que modela a un pasajero de un vuelo internacional
 */

public class Pasajero {
	private String nombre;
	private char genero;
	private String nacionalidad; 
	private String numPasaporte;            
	private int ahoNacimiento;
	
	//constructor para realizar busquedas
	public Pasajero(String numPasaporte) {
		this.numPasaporte=numPasaporte;
	}
	
	public Pasajero(String nombre, char genero, String paisNacimiento, String numPasaporte, int ahoNacimiento) {
		this.nombre=nombre;
		this.genero=genero;
		this.nacionalidad=paisNacimiento;
		this.numPasaporte=numPasaporte;
		this.ahoNacimiento=ahoNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public char getGenero() {
		return genero;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getNumPasaporte() {
		return numPasaporte;
	}

	public int getAhoNacimiento() {
		return ahoNacimiento;
	}
	
	//metodo que calcula la edad del pasajero
	public int calculaEdad(int ahoActual) {
		return ahoActual-this.ahoNacimiento;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		//el toString tiene mucho espacio para que en la interfaz se vea centrado
		cad.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
		cad.append("                                              Pasajero\n");
		cad.append("                                            Nombre: "+nombre+"\n");
		cad.append("                                            Genero: "+genero+"\n");
		cad.append("                              Pais de Nacionalidad: "+nacionalidad+"\n");
		cad.append("                               Numero de pasaporte: "+numPasaporte+"\n");
		cad.append("                                 Año de nacimiento: "+ahoNacimiento+"\n");
		
		return cad.toString();
	}
	
	//el numero de pasaporte es el criterio de comparación entre pasajeros
	public int compareTo(Pasajero otro) {
		return this.numPasaporte.compareTo(otro.numPasaporte);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numPasaporte == null) ? 0 : numPasaporte.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		if (numPasaporte == null) {
			if (other.numPasaporte != null)
				return false;
		} else if (!numPasaporte.equals(other.numPasaporte))
			return false;
		return true;
	}	
}
