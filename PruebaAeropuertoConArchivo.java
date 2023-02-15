import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Aldahir lopez
 * 26 de nov
 * este main prueba la clase aeropuerto leyendo los datos desde un archivo llamado info.txt
 */

public class PruebaAeropuertoConArchivo {

	public static void main(String[] args) {
		File ent=new File("info.txt");
		Aeropuerto a;
		String aerolinea,origen,destino,nombre,paisNacimiento,numPasaporte,genStr;
		int horaSalida, puertaAbordaje,numPasajeros,ahoNacimiento;
		Integer numVuelo;
		boolean escalas; 
		char genero;
		
		try(Scanner lec=new Scanner(ent)){
			a=new Aeropuerto("Benito Juarez");
			while(lec.hasNext()) {
				aerolinea=lec.next();
				origen=lec.next();
				destino=lec.next();
				horaSalida=lec.nextInt();
				numVuelo=lec.nextInt();
				escalas=lec.nextBoolean();
				puertaAbordaje=lec.nextInt();
				if(a.altaVuelo(aerolinea, origen, destino, horaSalida, numVuelo, escalas, puertaAbordaje))
					System.out.println("Alta vuelo exitosa");
				else
					System.out.println("Error en el alta vuelo");
				numPasajeros=lec.nextInt();
				for(int i=0;i<numPasajeros;i++) {
					nombre=lec.next();
					genStr=lec.next();
					genero=genStr.charAt(0);
					paisNacimiento=lec.next();
					numPasaporte=lec.next();
					ahoNacimiento=lec.nextInt();
					if(a.altaPasajeroEnVuelo(numVuelo, aerolinea, nombre, genero, paisNacimiento, numPasaporte, ahoNacimiento))
						System.out.println("Alta pasajero exitosa");
					else
						System.out.println("Error en el alta pasajero");
				}
			}
			lec.close();
			System.out.println(a.toString());
			System.out.println("\n\n\n. . . . . . . . . . . . . . . . . . . .");
			System.out.println("Vuelo 1450: "+a.getUnVuelo(1450, "aeromexico"));
			System.out.println("Num de vuelos Aeromexico: "+a.getNumVuelosAerolinea("aeromexico"));
			System.out.println("\nVuelo cancelado: "+a.cancelaVuelo(2300, "united"));
			System.out.println("\nPasajero luca vuelo 2300: \n"+a.getUnPasajeroEnVuelo(2300,"united", "FFGG23"));
			System.out.println("Pasajero mas viejo en vuelo 1450: \n"+a.pasajeroMasViejoEnVuelo(1450,"aeromexico")+"\n");
			System.out.println("Pasajero mas joven en vuelo 1450: \n"+a.pasajeroMasJovenEnVuelo(1450, "aeromexico")+"\n");
			System.out.println("Promedio de edad pasajeros vuelo 1260: "+a.promedioEdadPasajerosVuelo(1260, "aeromexico"));
			System.out.println("Numero de mujeres en vuelo 8909: "+a.cuantosPasajerosGeneroEnVuelo(8909, "emirates", 'M'));
			System.out.println("Numero de alemanes en vuelo 9001: "+a.cuantosPasajerosNacionalidadEnVuelo(9001,"klm", "Alemania"));
			System.out.println("Numero de vuelos de aeromexico que hacen escalas: "+a.numVuelosEscalasAerolinea("aeromexico"));
			System.out.println("Numero de vuelos que con destino a Canada: "+a.cuantosVuelosDestino("Canada"));
			System.out.println("Baja pasajero en vuelo 1450:\n "+a.bajaPasajeroEnVuelo(1450,"aeromexico","G432323"));
			
		}
		catch(FileNotFoundException fnfe) {
			System.err.println("ERROR: "+fnfe);
			System.exit(-1);
		}
	}
}
