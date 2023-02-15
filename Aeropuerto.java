/*Aldahir Lopez Navarrete
 * 23 de noviembre de 2020
 * clase que modela un Aeropuerto definida por una matriz de vuelos
 * renglones de la matriz son las aerolineas y las columnas sus vuelos
 */
public class Aeropuerto {
	private String nombre;
	private Vuelo[][] vuelos;
	private final int MAX_VUELOS=10;
	private final String[] AEROLINEAS={"aeromexico","interjet","volaris","emirates","avianca",
			"air france","klm","united","british airways","air canada","qatar airways"};
	private final int MAX_AEROLINEAS=11;
	private Integer[] numVuelos;//arreglo paralelo que indica el numero de vuelos que hay en cada renglon
	private int totVuelos;							
	
	//por el manejo de la matriz en el que cada renglon cuenta con un numero diferente de
	//vuelos dados de alta no es eficiente mandar a llamar en las busquedas al manejadorMatricesGenerico
	//ya que tendria que recorrer lugares que no vale la pena recorrer porque están vacíos.
	
	public Aeropuerto(String nombre) {
		this.nombre=nombre;
		this.vuelos=new Vuelo[MAX_AEROLINEAS][MAX_VUELOS];
		this.numVuelos=new Integer[MAX_AEROLINEAS];
		for(int i=0;i<MAX_AEROLINEAS;i++) {
			numVuelos[i]=0;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getUnVuelo(Integer numVuelo, String aerolinea) {
		String res="No se encontraron vuelos con esas caracteristicas";
		Vuelo v;
		int posA,posV;
		
		aerolinea=aerolinea.toLowerCase();//convierte todo a minusculas
		v=new Vuelo(numVuelo);
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS,aerolinea);
		//valida que la aerolinea que se recibe como parametro esté en el arreglo
		if(posA>=0) {
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA],v);
			//busca el vuelo en el renglon de la aerolinea
			if(posV>=0) {
				res=vuelos[posA][posV].toString();
			}
		}
		return res;
	}
	
	//Obtener el numero de vuelos de cierta aerolinea
	public int getNumVuelosAerolinea(String aerolinea) {
		int res=-1;
		int pos;
		
		aerolinea=aerolinea.toLowerCase();
		pos=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS,aerolinea);
		if(pos>=0) {
			res=numVuelos[pos];
		}
		return res;
	}
	
	public boolean altaVuelo(String aerolinea,String origen, String destino, int horaSalida,Integer numVuelo,
			boolean escalas,int puertaAbordaje) {
		boolean res=false;
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS,aerolinea);
		//valida la aerolinea
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA],v);
			//valida que el vuelo aun no este dado de alta
			if(posV<0) {
				if(horaSalida>=0 && horaSalida<24) {//valida que la hora sea valida
					if(puertaAbordaje>0) { //valida que la puerta de abordaje no sea negativa
						v=new Vuelo(aerolinea,origen,destino,horaSalida,numVuelo,escalas,puertaAbordaje);
						vuelos[posA][numVuelos[posA]]=v;
						numVuelos[posA]++;
						res=true;
						totVuelos++;
					}
				}
			}
			
		}
		return res;
	}
	
	public String cancelaVuelo(Integer numVuelo,String aerolinea) {
		String res="No se encontraron vuelos con esas caracteristicas";
		int posA,posV;
		Vuelo v;
		
		//primero hace las validaciones pertinentes a los parametros recibidos
		//posA=posicion de la aerolinea
		//posV=posicion de el vuelo
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS,aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA],v);
			if(posV>=0) {
				res=vuelos[posA][posV].toString();
				numVuelos[posA]=ManejadorArreglosGenerico.elimina(vuelos[posA],numVuelos[posA],posV);
				totVuelos--;
			}
		}

		return res;
	}
	
	public boolean altaPasajeroEnVuelo(Integer numVuelo,String aerolinea,String nombre, char genero, String paisNacimiento, 
			String numPasaporte, int ahoNacimiento) {
		boolean res=false;
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].altaPasajero(nombre, genero, paisNacimiento, numPasaporte, ahoNacimiento);
			}
		}
		
		return res;
	}
	
	public String bajaPasajeroEnVuelo(Integer numVuelo,String aerolinea, String numPasaporte) {
		String res="Pasajero no encontrado";
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].bajaPasajero(numPasaporte);
			}
		}
		return res;
	}
	
	public String getUnPasajeroEnVuelo(Integer numVuelo,String aerolinea,String numPasaporte) {
		String res="No se encontraron pasajeros con esas caracteristicas";
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].getUnPasajero(numPasaporte);
			}
		}
		return res;
	}
	
	// cual es el pasajero mas viejo de un cierto vuelo
	public String pasajeroMasViejoEnVuelo(Integer numVuelo,String aerolinea) {
		String res="No existen vuelos con esas caracteristicas";
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].pasajeroMasViejo();
			}
		}
		return res;
	}
	
	// cual es el pasajero mas joven de un cierto vuelo
	public String pasajeroMasJovenEnVuelo(Integer numVuelo, String aerolinea) {
		String res="No existen vuelos con esas caracteristicas";
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].pasajeroMasJoven();
			}
		}
		return res;
	}
	
	//cual es el promedio de edad de los pasajeros de cierto vuelo
	public double promedioEdadPasajerosVuelo(Integer numVuelo, String aerolinea) {
		double res=-1;
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].promedioEdadPasajeros();
			}
		}
		return res;
	}
	
	//cuantos pasajeros hay de cierto genero en un vuelo
	public int cuantosPasajerosGeneroEnVuelo(Integer numVuelo, String aerolinea,char genero) {
		int res=-1;
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].cuantosPasajerosGenero(genero);
			}
		}
		return res;
		
	}
	
	//cuantos pasajeros hay de cierta nacionalidad en un vuelo
	public int cuantosPasajerosNacionalidadEnVuelo(Integer numVuelo, String aerolinea,String nacionalidad) {
		int res=-1;
		int posA,posV;
		Vuelo v;
		
		aerolinea=aerolinea.toLowerCase();
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			v=new Vuelo(numVuelo);
			posV=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(vuelos[posA],numVuelos[posA], v);
			if(posV>=0) {
				res=vuelos[posA][posV].cuantosPasajerosNacionalidad(nacionalidad);
			}
		}
		return res;
	}
	
	
	//cuantos vuelos hacen escalas de una cierta aerolinea
	public int numVuelosEscalasAerolinea(String aerolinea) {
		int posA,cont;
		
		aerolinea=aerolinea.toLowerCase();
		cont=0;
		posA=ManejadorArreglosGenerico.busquedaSecuenciaDesordenada(AEROLINEAS,MAX_AEROLINEAS, aerolinea);
		if(posA>=0) {
			for(int i=0;i<numVuelos[posA];i++) {
				if(vuelos[posA][i].isEscalas())
					cont++;
			}
		}
		else
			cont=-1;
		return cont;	
	}
	
	public int cuantosVuelosDestino(String destino) {
		int cont=0;
		
		for(int i=0;i<MAX_AEROLINEAS;i++) {
			for(int j=0;j<numVuelos[i];j++) {
				if(vuelos[i][j].getDestino().equalsIgnoreCase(destino)) {
					cont++;
				}
			}
		}
		return cont;
	}

	public String toString() {
		StringBuilder cad=new StringBuilder();
		
		cad.append("                                               Aeropuerto\n");
		cad.append("                                      Nombre: "+nombre+"\n");
		cad.append("                                                 Vuelos: "+totVuelos);
		for(int i=0;i<MAX_AEROLINEAS;i++){
			for(int j=0;j<numVuelos[i];j++) {
				cad.append(vuelos[i][j].toString());
			}
		}
		
		return cad.toString();
	}
	
	public int compareTo(Aeropuerto otro) {
		return this.nombre.compareTo(otro.nombre);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}