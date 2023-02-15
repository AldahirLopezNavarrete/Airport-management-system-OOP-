/*Aldahir Lopez 
 * 25 nov de 2020
 * este main prueba la clase Aeropuerto 
 */

public class PruebaAeropuerto {
	public static void main(String[] args) {
		Aeropuerto a;
		
		//alta 3 vuelos con 2 pasajeros cada vuelo
		
		//vuelo1
		a=new Aeropuerto("Internacional Airport");
		if(a.altaVuelo("aeromexico","MEX","YUL", 3,180, true,4)) 
			System.out.println("Alta exitosa");
		else
			System.out.println("Error en el alta");
		
		if(a.altaPasajeroEnVuelo(180,"aeromexico","Aldahir",'H',"Mexico","G34334432",2002))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		if(a.altaPasajeroEnVuelo(180,"aeromexico","Michel",'H',"Mexico","G3213321",2007))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		
		//vuelo para probar metodo cuantos vuelos tienen escala de cierta aerolinea
		if(a.altaVuelo("aeromexico","MEX","YUL", 3,1870, false,9)) 
			System.out.println("Alta exitosa");
		else
			System.out.println("Error en el alta");
		
			
		
		//vuelo 2
		if(a.altaVuelo("air canada","YYC","FFR", 6,1900, false,7)) 
			System.out.println("Alta exitosa");
		else
			System.out.println("Error en el alta");
		if(a.altaPasajeroEnVuelo(1900,"air canada","Jorge",'H',"Peru","G3993321",2000))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		if(a.altaPasajeroEnVuelo(1900,"air canada","Stephany",'M',"Canada","G3813321",2005))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		
		
		//vuelo 3
		if(a.altaVuelo("avianca","COL","ARG", 12,2311, true,1)) 
			System.out.println("Alta exitosa");
		else
			System.out.println("Error en el alta");
		if(a.altaPasajeroEnVuelo(2311,"avianca","Sofia",'M',"Francia","G3993321",1999))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		if(a.altaPasajeroEnVuelo(2311,"avianca","Mariana",'M',"Colombia","G3813321",1990))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		
		System.out.println(a.toString());
		System.out.println("Num de vuelos aeromexico: "+a.getNumVuelosAerolinea("aeromexico"));
		System.out.println(a.getUnVuelo(2311, "avianca"));
		//System.out.println(a.cancelaVuelo(2311,"avianca"));
		//System.out.println(a.toString());
		//System.out.println(a.bajaPasajeroEnVuelo(180,"aeromexico", "G34334432"));
		System.out.println(a.getUnPasajeroEnVuelo(2311,"avianca", "G3813321"));
		System.out.println("Pasajero mas viejo vuelo 180: \n"+a.pasajeroMasViejoEnVuelo(180,"aeromexico"));
		System.out.println("Pasajero mas joven vuelo 180: \n"+a.pasajeroMasJovenEnVuelo(180,"aeromexico"));
		System.out.println("Promedio edad pasajeros vuelo 2311: "+a.promedioEdadPasajerosVuelo(2311,"avianca"));
		System.out.println("Cuantas mujeres hay en el vuelo 1900: "+a.cuantosPasajerosGeneroEnVuelo(1900,"air canada",'M'));
		System.out.println("Cuantos mexicanos hay en el vuelo 180: "+a.cuantosPasajerosNacionalidadEnVuelo(180,"aeromexico", "Mexico"));
		System.out.println("Cuantos vuelos de aeromexico hacen escala: "+a.numVuelosEscalasAerolinea("aeromexico"));
		System.out.println("Cuantos vuelos hay en el aeropuerto con cierto destino: "+a.cuantosVuelosDestino("ARG"));
	}

}
