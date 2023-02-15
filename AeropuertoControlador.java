
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Aldahir Lopez
 * 29 de nov 2020
 * clase controlador que da funciones a la clase aeropuertoVista
 */
public class AeropuertoControlador extends AeropuertoVista {
	String aerolinea,origen,destino,nombre,paisNacimiento,numPasaporte,genStr;
	int horaSalida, puertaAbordaje,numPasajeros,ahoNacimiento;
	Integer numVuelo;
	boolean escalas; 
	char genero;
	Aeropuerto a;
	
	public AeropuertoControlador(String titulo) {
		super(titulo);
		a=new Aeropuerto(titulo);
		//alta vuelo
		this.aerolineaCh.addItemListener(new escuchadorAerolinea());
		this.origenTxtf.addActionListener(new escuchadorOrigen());
		this.destinoTxtf.addActionListener(new escuchadorDestino());
		this.horaSalidaCh.addItemListener(new escuchadorHoraSalida());
		this.numVueloTxtf.addActionListener(new escuchadorNumVuelo());
		this.escalasCh.addItemListener(new escuchadorEscalas());
		this.puertaAbordajeTxtf.addActionListener(new escuchadorPuertaAbordaje());
		this.altaVuelo.addActionListener(new escuchadorAltaVuelo());
		this.cancelaVuelo.addActionListener(new escuchadorBajaVuelo());
		//alta pasajero
		this.nombretxt.addActionListener(new escuchadorNombre());
		this.generotxt.addActionListener(new escuchadorGenero());
		this.paisNacimientotxt.addActionListener(new escuchadorPaisNacimiento());
		this.numPasaportetxt.addActionListener(new escuchadorNumPasaporte());
		this.ahoNacimientotxt.addActionListener(new escuchadorAhoNacimiento());
		this.numVueloPasajerotxt.addActionListener(new escuchadorNumVueloPasajero());
		this.aerolineaPasajerotxt.addActionListener(new escuchadorAerolineaPasajero());
		this.altaPasajeroBt.addActionListener(new escuchadorAltaPasajero());
		this.bajaPasajeroBt.addActionListener(new escuchadorBajaPasajero());
		//busqueda vuelos
		this.numVuelotxtVuelo.addActionListener(new escuchadorNumVuelo());
		this.aerolineatxtVuelo.addActionListener(new escuchadorAerolineaVuelo());
		this.buscarVuelo.addActionListener(new escuchadorBuscarVuelo());
		//buscar pasajeros
		this.numVueloPasajerotxt.addActionListener(new escuchadorNumVueloPasajero());
		this.aerolineaPasajerotxt.addActionListener(new escuchadorAerolineaPasajero());
		this.numPasaportetxtPasajero.addActionListener(new escuchadorNumPasaporte());
		this.buscarPasajero.addActionListener(new escuchadorBuscarPasajero());
		//funciones
		this.datosFuncionesBt.addActionListener(new escuchadorDatosFunciones());
		this.numVuelosAerolineaBt.addActionListener(new escuchadorNumVuelosAerolinea());
		this.pasajeroMasJovenBt.addActionListener(new escuchadorPasajeroMasJoven());
		this.pasajeroMasViejoBt.addActionListener(new escuchadorPasajeroMasViejo());
		this.promedioEdadPasajerosBt.addActionListener(new escuchadorPromedio());
		this.cuantosPasajerosGeneroBt.addActionListener(new escuchadorPasajerosGenero());
		this.cuantosPasajerosNacionalidadBt.addActionListener(new escuchadorPasajerosNacionalidad());
		this.numVuelosEscalasBt.addActionListener(new escuchadorNumVuelosEscalas());
		this.cuantosVuelosDestinoBt.addActionListener(new escuchadorVuelosDestino());
		this.infoAeropuertoBt.addActionListener(new escuchadorInfoAeropuerto());
		this.infoArchivoBt.addActionListener(new escuchadorInfoArchivo());
	}
	
	private class escuchadorAerolinea implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			aerolinea=e.getItem().toString();
		}
	}
	
	private class escuchadorOrigen implements ActionListener {
		public void actionPerformed(ActionEvent e) {	
			origen=e.getActionCommand();
		}
	}
	
	private class escuchadorDestino implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			destino=e.getActionCommand();
		}
	}
	
	private class escuchadorHoraSalida implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			Object hora;
			String horaStr;
			
			hora=e.getItem();
			if(hora.toString().charAt(1)=='-') {
				horaStr=hora.toString().substring(0,1);
				horaSalida=Integer.parseInt(horaStr);
			}
			else {
				horaStr=hora.toString().substring(0,2);
				horaSalida=Integer.parseInt(horaStr);
			}	
		}
	}
	
	private class escuchadorNumVuelo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String numVuelostr;
			
			numVuelostr=e.getActionCommand();
			numVuelo=Integer.parseInt(numVuelostr);
		}
	}
	
	private class escuchadorEscalas implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			if(e.getItem().equals("Si")) 
				escalas=true;
			else
				escalas=false;
		}
	}
	
	private class escuchadorPuertaAbordaje implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			puertaAbordaje=Integer.parseInt(e.getActionCommand());
		}
	}
		
	private class escuchadorAltaVuelo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(a.altaVuelo(aerolinea, origen, destino, horaSalida, numVuelo, escalas, puertaAbordaje)) {
				display.setText("Alta de vuelo exitosa :)");
				//para reiniciar todos los campos y volver a proporcionar info
				origenTxtf.setText("");
				destinoTxtf.setText("");
				numVueloTxtf.setText("");
				puertaAbordajeTxtf.setText("");
				aerolineaCh.select("-");
				escalasCh.select("-");
				horaSalidaCh.select("-");
			}
			else
				display.setText("Error en el alta del vuelo, porfavor verifique los datos ingresados");
		}		
	}
	
	private class escuchadorBajaVuelo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String res;
			
			res=a.cancelaVuelo(numVuelo,aerolinea);
			numVueloTxtf.setText("");
			aerolineaCh.select("-");
			display.setText("Vuelo cancelado: \n"+res);
		}
	}
	
	private class escuchadorNombre implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			nombre=e.getActionCommand();
		}
	}
	
	private class escuchadorGenero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			genero=e.getActionCommand().charAt(0);
		}
	}
	
	private class escuchadorPaisNacimiento implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			paisNacimiento=e.getActionCommand();
		}
	}
	
	private class escuchadorNumPasaporte implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			numPasaporte=e.getActionCommand();
		}
	}
	
	private class escuchadorAhoNacimiento implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ahoNacimiento=Integer.parseInt(e.getActionCommand());
		}
	}

	private class escuchadorNumVueloPasajero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			numVuelo=Integer.parseInt(e.getActionCommand());
		}
	}
	
	private class escuchadorAerolineaPasajero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			aerolinea=e.getActionCommand();
		}
	}
	
	private class escuchadorAltaPasajero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			boolean res;
			
			res=a.altaPasajeroEnVuelo(numVuelo, aerolinea, nombre, genero, paisNacimiento, numPasaporte, ahoNacimiento);
			if(res) {
				display.setText("Alta de pasajero en vuelo exitosa :)");
				nombretxt.setText("");
				generotxt.setText("");
				paisNacimientotxt.setText("");
				numPasaportetxt.setText("");
				ahoNacimientotxt.setText("");
				numVueloPasajerotxt.setText("");
				aerolineaPasajerotxt.setText("");
			}
			else
				display.setText("Error en el alta del pasajero, porfavor verifique los datos ingresados");
			
		}
	}
	
	private class escuchadorBajaPasajero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String res;
			
			res=a.bajaPasajeroEnVuelo(numVuelo,aerolinea,numPasaporte);
			display.setText("Pasajero dado de baja: \n"+res);
			numPasaportetxt.setText("");
			numVueloPasajerotxt.setText("");
			aerolineaPasajerotxt.setText("");
		}
	}
	
	private class escuchadorAerolineaVuelo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			aerolinea=e.getActionCommand();
		}
	}
	
	private class escuchadorBuscarVuelo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String res;
			
			res=a.getUnVuelo(numVuelo,aerolinea);
			display.setText(res);
			numVuelotxtVuelo.setText("");
			aerolineatxtVuelo.setText("");
		}
	}
	
	private class escuchadorBuscarPasajero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String res;
			
			numVuelo=Integer.parseInt(numVuelotxtPasajero.getText());
			aerolinea=aerolineatxtPasajero.getText();
			numPasaporte=numPasaportetxtPasajero.getText();
			res=a.getUnPasajeroEnVuelo(numVuelo,aerolinea,numPasaporte);
			display.setText(res);
			numVuelotxtPasajero.setText("");
			aerolineatxtPasajero.setText("");
			numPasaportetxtPasajero.setText("");
		}
	}
	
	private class escuchadorDatosFunciones implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			StringBuilder cad=new StringBuilder();
			
			cad.append("                           Datos requeridos para cada función: \n");
			cad.append("___________________________________________________________________________________\n");
			cad.append(" Nota: es importante usar la coma para separar datos.\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Número de vuelos por aerolinea: aerolínea\n");
			cad.append(" ejemplo-- aeromexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Pasajero más joven: numVuelo,aerolinea\n");
			cad.append(" ejemplo-- 2300,aeromexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Pasajero más viejo: numVuelo,aerolínea\n");
			cad.append(" ejemplo-- 2300,aeromexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Promedio edad pasajeros de un vuelo: numVuelo,aerolínea\n");
			cad.append(" ejemplo-- 2300,aeromexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Número de pasajeros de cierto género en un vuelo: numVuelo,aerolínea,género\n");
			cad.append(" ejemplo-- 2300,aeromexico,hombre\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Número de pasajeros de cierta nacionalidad en un vuelo: numVuelo,aerolínea,nacionalidad\n");
			cad.append(" ejemplo-- 2300,aeromexico,Mexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Cuántos vuelos hacen escalas en cierta aerolínea: aerolínea\n");
			cad.append(" ejemplo-- aeromexico\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Cúantos vuelos se dirigen a un cierto destino: destino\n");
			cad.append(" ejemplo-- Toronto\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Obtener la información completa del aeropuerto: ninguno\n");
			cad.append("___________________________________________________________________________________\n");
			cad.append("* Cargar la información desde un archivo: ninguno\n");
			
			display.setText(cad.toString());
		}
	}
	
	
	private class escuchadorNumVuelosAerolinea implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int res;
			
			aerolinea=search1.getText();
			res=a.getNumVuelosAerolinea(aerolinea);
			if(res!=-1) {
				display.setText("El numero de vuelos que tiene esa aerolínea son: "+res);
			}
			else
				display.setText("Aerolínea no registrada");
		}
	}
	
	private class escuchadorPasajeroMasJoven implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str,res;
			int posComa;
			
			//manejo del string, se toma en cuenta la coma como separacion de datos
			str=search1.getText();
			posComa=str.indexOf(",");
			numVuelo=Integer.parseInt(str.substring(0,posComa));
			aerolinea=str.substring(posComa+1,str.length());
			res=a.pasajeroMasJovenEnVuelo(numVuelo, aerolinea);
			display.setText(res);
		}
	}
	
	private class escuchadorPasajeroMasViejo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str,res;
			int posComa;
			
			//manejo del string, se toma en cuenta la coma como separacion de datos
			str=search1.getText();
			posComa=str.indexOf(",");
			numVuelo=Integer.parseInt(str.substring(0,posComa));
			aerolinea=str.substring(posComa+1,str.length());
			res=a.pasajeroMasViejoEnVuelo(numVuelo,aerolinea);
			display.setText(res);
		}
	}
	
	private class escuchadorPromedio implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String str;
			double prom;
			int posComa;
			
			//manejo del string, se toma en cuenta la coma como separacion de datos
			str=search1.getText();
			posComa=str.indexOf(",");
			numVuelo=Integer.parseInt(str.substring(0,posComa));
			aerolinea=str.substring(posComa+1,str.length());
			prom=a.promedioEdadPasajerosVuelo(numVuelo,aerolinea);
			if(prom!=-1) {
				display.setText("El promedio de edad de los pasajeros del vuelo es: "+prom+" años");
			}
			else
				display.setText("El vuelo no tiene pasajeros dados de alta");
		}
	}
	
	private class escuchadorPasajerosGenero implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int res,posComa1,posComa2;
			String str;
			
			str=search1.getText();
			posComa1=str.indexOf(",");
			numVuelo=Integer.parseInt(str.substring(0,posComa1));
			posComa2=str.lastIndexOf(",");
			aerolinea=str.substring(posComa1+1,posComa2);
			genero=str.charAt(posComa2+1);
			res=a.cuantosPasajerosGeneroEnVuelo(numVuelo, aerolinea, genero);
			if(res!=-1) {
				display.setText("Hay "+res+" pasajeros de ese genero en el vuelo "+numVuelo);
			}
			else
				display.setText("No se encontraron vuelos con esas características");
		}
	}
	
	private class escuchadorPasajerosNacionalidad implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int res,posComa1,posComa2;
			String str;
			
			str=search1.getText();
			posComa1=str.indexOf(",");
			numVuelo=Integer.parseInt(str.substring(0,posComa1));
			posComa2=str.lastIndexOf(",");
			aerolinea=str.substring(posComa1+1,posComa2);
			paisNacimiento=str.substring(posComa2+1,str.length());
			res=a.cuantosPasajerosNacionalidadEnVuelo(numVuelo, aerolinea,paisNacimiento);
			if(res!=-1) {
				display.setText("Hay "+res+" pasajeros de esa nacionalidad en el vuelo "+numVuelo);
			}
			else
				display.setText("No se encontraron vuelos con esas características");
		}
	}
	
	private class escuchadorNumVuelosEscalas implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int res;
			
			aerolinea=search1.getText();
			res=a.numVuelosEscalasAerolinea(aerolinea);
			if(res!=-1) {
				display.setText("El número de vuelos que hacen escalas de esa aerolínea es: "+res);
				search1.setText("");
			}
			else
				display.setText("Aerolínea no encontrada, verifique los datos ingresados");
		}
	}
	
	private class escuchadorVuelosDestino implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String destino;
			int res;
			
			destino=search1.getText();
			res=a.cuantosVuelosDestino(destino);
			display.setText("Hay "+res+" vuelos que se dirigen a ese destino");
		}
	}
	
	//muestra el toString del aeropuerto
	private class escuchadorInfoAeropuerto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			display.setText(a.toString());
		}
	}
	
	private class escuchadorInfoArchivo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			File ent=new File("/Users/aldahir/Desktop/primer semestre/Algoritmos Y programas/java proyects/ProyectoFinal/info.txt");
			
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
				display.setText("Información cargada con éxito");
			}
			catch(FileNotFoundException fnfe) {
				System.err.println("ERROR: "+fnfe);
				System.exit(-1);
			}
		}
	}
	
	public static void main(String[] args) {
		AeropuertoControlador a=new AeropuertoControlador("Benito Júarez ");
	}
}
