/*Aldahir Lopez 
 * 26 de nov 2020
 * Esta clase con main prueba la clase vuelo 
 */
public class PruebaVuelo {
	public static void main(String[] args) {
		Vuelo v1;
		
		v1=new Vuelo("Aeromexico","MEX", "YUL",13,123,true,6);
		if(v1.altaPasajero("Aldahir",'H',"Mexicana","G34334432",2002))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
			
		
		if(v1.altaPasajero("Michel",'H',"Mexicana","G3213321",2007))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		
		if(v1.altaPasajero("Stephany",'M',"Canadiense","G3813321",2005))
			System.out.println("Alta exitosa");
		else
			System.out.println("ERROR en el alta");
		
		//System.out.println(v1.bajaPasajero("G3213321"));
		System.out.println("Num de pasajeros que son hombres: "+v1.cuantosPasajerosGenero('H'));
		System.out.println("Num de pasajeros que son mujeres: "+v1.cuantosPasajerosGenero('M'));
		System.out.println("Pasajero mas viejo: \n"+v1.pasajeroMasViejo());
		System.out.println("Pasajero mas joven: \n"+v1.pasajeroMasJoven());
		System.out.println("Cuantos pasajeros son mexicanos: "+v1.cuantosPasajerosNacionalidad("mexicana"));
		System.out.println("Cuantos pasajeros son candienses: "+v1.cuantosPasajerosNacionalidad("canadiense"));
		System.out.println("Promedio de edad pasajeros: "+v1.promedioEdadPasajeros()+"años");
		System.out.println(v1.toString());
	}
}
