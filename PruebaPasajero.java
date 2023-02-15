/*Aldahir lopez navarrete
 * 23 de nov 2020
 * esta clase contiene un main que prueba la clase Pasajero
 */
public class PruebaPasajero {
	private static final int AHO_ACTUAL=2020;

	public static void main(String[] args) {
		Pasajero p1,p2,p3;
		
		p1=new Pasajero("Aldahir",'H',"mexico","G34334432",2002);
		System.out.println(p1.toString());
		System.out.println("Edad: "+p1.calculaEdad(AHO_ACTUAL)+" años");
		p2=new Pasajero("Michel",'H',"mexico","G3213321",2007);
		System.out.println(p2.toString());
		System.out.println("Edad: "+p2.calculaEdad(AHO_ACTUAL)+" años");
		p3=new Pasajero("Stephany",'M',"canada","G3813377",2005);
		System.out.println(p3.toString());
		System.out.println("Edad: "+p3.calculaEdad(AHO_ACTUAL)+" años");
	}
}
