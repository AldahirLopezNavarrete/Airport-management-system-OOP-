/*Aldahir Lopez Navarrete
 * 23 de noviembre de 2020
 * Esta clase sirve para representar cada vuelo de un aeropuerto
 */

public class Vuelo {
	private String aerolinea;
	private String origen;
	private String destino;
	private int horaSalida;
	private Integer numVuelo;
	private boolean escalas;
	private Pasajero[] pasajeros;
	private int puertaAbordaje;
	private final int MAX_PASAJEROS=400;
	private int totPasajeros;//leva el control de cuantos pasajeros hay en el vuelo
	private final int AHO_ACTUAL=2020;
	
	//constructor para realizar busquedas 
	public Vuelo(int numVuelo) {
		this.numVuelo=numVuelo;
	}
	
	public Vuelo(String aerolinea,String origen, String destino, int horaSalida,Integer numVuelo,
			boolean escalas,int puertaAbordaje) {
		this.aerolinea=aerolinea;
		this.origen=origen;
		this.destino=destino;
		this.horaSalida=horaSalida;
		this.numVuelo=numVuelo;
		this.escalas=escalas;
		this.pasajeros=new Pasajero[MAX_PASAJEROS];
		this.puertaAbordaje=puertaAbordaje;
		totPasajeros=0;
	}
	
	public String getAerolinea() {
		return aerolinea;
	}
	
	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public int getHoraSalida() {
		return horaSalida;
	}
	
	public Integer getNumVuelo() {
		return numVuelo;
	}
	
	public boolean isEscalas() {
		return escalas;
	}

	public int getPuertaAbordaje() {
		return puertaAbordaje;
	}
	
	public String getUnPasajero(String numPasaporte) {
		String res="No hay ningun pasajero en el vuelo con ese numero de pasaporte";
		int pos;
		Pasajero p;
		
		p=new Pasajero(numPasaporte);
		pos=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(pasajeros,totPasajeros,p);
		if(pos>=0) {
			res=pasajeros[pos].toString();
		}
		return res;
	}
	
	public int getTotPasajeros() {
		return totPasajeros;
	}
	
	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public void setPuertaAbordaje(int puertaAbordaje) {
		this.puertaAbordaje = puertaAbordaje;
	}
	
	//da de alta un pasajero en el arreglo de pasajeros
	public boolean altaPasajero(String nombre, char genero, String paisNacimiento, String numPasaporte, int ahoNacimiento) {
		boolean res=false;
		Pasajero p;
		int pos;
		
		if(totPasajeros<MAX_PASAJEROS) {
			if(ahoNacimiento>=1910 && ahoNacimiento<=AHO_ACTUAL) {// valida el año sea correcto se toma en cuenta como maximo una persona de 110 años
				p=new Pasajero(numPasaporte);
				pos=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(pasajeros,totPasajeros,p);
				if(pos<0) {//valida que el pasajero aun no este dado de alta en el vuelo
					p=new Pasajero(nombre,genero,paisNacimiento,numPasaporte,ahoNacimiento);
					pasajeros[totPasajeros]=p;
					totPasajeros++;
					res=true;
				}
			}
		}
		return res;
	}
	
	//arroja el toString del pasajero mas viejo
	public String pasajeroMasViejo() {
		int pos=0;
		String res;
		
		if(totPasajeros>0) {
			for(int i=1;i<totPasajeros;i++) {
				if(pasajeros[i].calculaEdad(AHO_ACTUAL)>pasajeros[pos].calculaEdad(AHO_ACTUAL))
					pos=i;
			}
			res=pasajeros[pos].toString();
		}
		else
			res="Este vuelo aún no tiene pasajeros dados de alta";
		return res;
	}
	
	//arroja el toString del pasajero mas joven
	public String pasajeroMasJoven() {
		int pos=0;
		String res;
		
		if(totPasajeros>0) {
			for(int i=1;i<totPasajeros;i++) {
				if(pasajeros[i].calculaEdad(AHO_ACTUAL)<pasajeros[pos].calculaEdad(AHO_ACTUAL))
					pos=i;
			}
			res=pasajeros[pos].toString();
		}
		else
			res="Este vuelo aún no tiene pasajeros dados de alta";
		return res;
	}
	
	//promedio de edad de los pasajeros del vuelo
	public double promedioEdadPasajeros() {
		double prom;
		
		if(totPasajeros>0) {
			prom=0;
			for(int i=0;i<totPasajeros;i++) {
				prom+=pasajeros[i].calculaEdad(AHO_ACTUAL);
			}
			prom=prom/totPasajeros;
		}
		else
			prom=-1;
		
		return prom;
	}
	
	//cuantos pasajeros hay de un cierto genero
	public int cuantosPasajerosGenero(char genero) {
		int cont=0;
		
		for(int i=0;i<totPasajeros;i++) {
			if(pasajeros[i].getGenero()==genero) {
				cont++;
			}
		}
		return cont;
	}
	
	//cuantos pasajeros hay de una cierta nacionalidad
	public int cuantosPasajerosNacionalidad(String nacionalidad) {
		int cont=0;
		
		for(int i=0;i<totPasajeros;i++) {
			if(pasajeros[i].getNacionalidad().equalsIgnoreCase(nacionalidad))
				cont++;
		}
		return cont;
	}
	
	//da de baja un pasajero del arreglo de pasajeros
	public String bajaPasajero(String numPasaporte) {
		String res="No hay ningun pasajero en el vuelo con ese numero de pasaporte";
		Pasajero p;
		int pos;
		
		p=new Pasajero(numPasaporte);
		pos=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(pasajeros,totPasajeros,p);
		if(pos>=0) {
			res=pasajeros[pos].toString();
			totPasajeros=ManejadorArreglosGenerico.elimina(pasajeros,totPasajeros,pos);
		}
		
		return res;
	}
	
	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("\n______________________________________________________________");
		cad.append("\n                                                    Vuelo\n");
		cad.append("                                      Num de vuelo: "+numVuelo+"\n");
		cad.append("                                          Origen: "+origen+"\n");
		cad.append("                                         Destino: "+destino+"\n");
		cad.append("                                       Aerolinea: "+aerolinea+"\n");
		if(horaSalida>12)
			cad.append("                                     Hora de salida: "+horaSalida+" pm\n");
		else
			cad.append("                                     Hora de salida: "+horaSalida+" am\n");
		if(escalas)
			cad.append("                                    Este vuelo hace escalas\n");
		else
			cad.append("                                    Este vuelo NO hace escalas\n");
		cad.append("                                       Puerta de abordaje: "+puertaAbordaje+"\n");
		cad.append("                                        Total de pasajeros: "+totPasajeros+"\n\n");
		if(totPasajeros>0) {
			cad.append("                                              Pasajeros: \n");
		}
		else
			cad.append("                  Este vuelo aún no tiene pasajeros dados de alta \n");
		for(int i=0;i<totPasajeros;i++) {
			cad.append(pasajeros[i].toString()+"\n");
		}

		return cad.toString();
	}
	
	//el criterio de comparacion entre vuelos es el numero de vuelo
	public int compareTo(Vuelo otro) {
		return this.numVuelo.compareTo(otro.numVuelo);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numVuelo == null) ? 0 : numVuelo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		if (numVuelo == null) {
			if (other.numVuelo != null)
				return false;
		} else if (!numVuelo.equals(other.numVuelo))
			return false;
		return true;
	}
}
