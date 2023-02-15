
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/*Aldahir lopez
 * 29 de noviembre
 * clase que genera la vista para el proyecto final
 */

public class AeropuertoVista extends JFrame{
	//panel 1
	private JLabel aerolineaLb,origenLb,destinoLb,horaSalidaLb,numVueloLb,escalasLb,puertaAbordajeLb;
	protected JTextField origenTxtf,destinoTxtf,numVueloTxtf,puertaAbordajeTxtf;
	protected Choice aerolineaCh,escalasCh,horaSalidaCh;
	protected JButton altaVuelo,cancelaVuelo;
	//panel 2
	private JLabel nombreLb,generoLb,paisNacimientoLb,numPasaporteLb,ahoNacimientoLb,numVueloPasajeroLb,aerolineaPasajeroLb;
	protected JTextField nombretxt,generotxt,paisNacimientotxt,numPasaportetxt,ahoNacimientotxt,numVueloPasajerotxt,aerolineaPasajerotxt;
	protected JButton altaPasajeroBt, bajaPasajeroBt;
	//panel 3
	protected JTextArea display;
	protected JScrollPane barra;
	//panel 4
	protected JButton numVuelosAerolineaBt,pasajeroMasJovenBt,pasajeroMasViejoBt,promedioEdadPasajerosBt,
	cuantosPasajerosGeneroBt,cuantosPasajerosNacionalidadBt,numVuelosEscalasBt,cuantosVuelosDestinoBt,infoAeropuertoBt,infoArchivoBt,datosFuncionesBt;
	protected JTextArea search1;
	private JLabel searchLb,spaceeLb;
	//panel 5 
	private JLabel numVueloLbvuelo,aerolineaLbvuelo,spaceLbVuelo;
	protected JTextField numVuelotxtVuelo,aerolineatxtVuelo;
	protected JButton buscarVuelo;
	//panel 6 
	private JLabel numVueloLbPasajero,aerolineaLbPasajero,numPasaporteLbPasajero,spaceLbPasajero;
	protected JTextField numVuelotxtPasajero,aerolineatxtPasajero,numPasaportetxtPasajero;
	protected JButton buscarPasajero;
	
	public AeropuertoVista(String titulo) {
		super(titulo);
		
		//el numero de los paneles representa el orden en que fueron creadas, pero 
		//pueden estar en diferente orden para una mejor vista
		
		//panel principal
		//este panel contiene todos los otros paneles
		JPanel pp=new JPanel();
		pp.setLayout(new GridLayout(2,3));
		Border gapp=BorderFactory.createEmptyBorder(5,5,5,5);
		pp.setBorder(gapp);
		
		this.add(pp);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel 1 (alta y baja vuelos)
		this.aerolineaLb=new JLabel("Aerolínea: ");
		this.aerolineaCh=new Choice();
		aerolineaCh.add("-");
		aerolineaCh.addItem("aeromexico");
		aerolineaCh.addItem("interjet");
		aerolineaCh.addItem("volaris");
		aerolineaCh.addItem("emirates");
		aerolineaCh.addItem("avianca");
		aerolineaCh.addItem("air france");
		aerolineaCh.addItem("klm");
		aerolineaCh.addItem("united");
		aerolineaCh.addItem("british airlines");
		aerolineaCh.addItem("air canada");
		aerolineaCh.addItem("qatar airways");
		
		this.origenLb=new JLabel("Origen: ");
		this.origenTxtf=new JTextField();
		
		this.destinoLb=new JLabel("Destino: ");
		this.destinoTxtf=new JTextField();
		
		this.horaSalidaLb=new JLabel("Hora de salida: ");
		this.horaSalidaCh=new Choice();
		horaSalidaCh.add("-");
		horaSalidaCh.add("1--AM");
		horaSalidaCh.add("2--AM");
		horaSalidaCh.add("3--AM");
		horaSalidaCh.add("4--AM");
		horaSalidaCh.add("5--AM");
		horaSalidaCh.add("6--AM");
		horaSalidaCh.add("7--AM");
		horaSalidaCh.add("8--AM");
		horaSalidaCh.add("9--AM");
		horaSalidaCh.add("10--AM");
		horaSalidaCh.add("11--AM");
		horaSalidaCh.add("12--PM");
		horaSalidaCh.add("13--PM");
		horaSalidaCh.add("14--PM");
		horaSalidaCh.add("15--PM");
		horaSalidaCh.add("16--PM");
		horaSalidaCh.add("17--PM");
		horaSalidaCh.add("18--PM");
		horaSalidaCh.add("19--PM");
		horaSalidaCh.add("20--PM");
		horaSalidaCh.add("21--PM");
		horaSalidaCh.add("22--PM");
		horaSalidaCh.add("23--PM");
		horaSalidaCh.add("0--AM");
		
		this.numVueloLb=new JLabel("Número de vuelo: ");
		this.numVueloTxtf=new JTextField();
		
		this.escalasLb=new JLabel("Hace escalas: ");
		this.escalasCh=new Choice();
		escalasCh.add("-");
		escalasCh.add("Si");
		escalasCh.add("No");
		
		this.puertaAbordajeLb=new JLabel("Puerta de abordaje: ");
		this.puertaAbordajeTxtf=new JTextField();
		
		this.altaVuelo=new JButton("Alta vuelo");
		altaVuelo.setForeground(Color.BLUE);//cambia el color de la letra
		
		this.cancelaVuelo=new JButton("Cancelar vuelo");
		cancelaVuelo.setForeground(Color.RED);
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(8,2));
		Border gap=BorderFactory.createEmptyBorder(10,10,10,10);
		gap=BorderFactory.createTitledBorder("Alta y baja de vuelos");//asigna titulo al panel
		p1.setBorder(gap);

		p1.add(aerolineaLb);
		p1.add(aerolineaCh);
		p1.add(origenLb);
		p1.add(origenTxtf);
		p1.add(destinoLb);
		p1.add(destinoTxtf);
		p1.add(horaSalidaLb);
		p1.add(horaSalidaCh);
		p1.add(numVueloLb);
		p1.add(numVueloTxtf);
		p1.add(escalasLb);
		p1.add(escalasCh);
		p1.add(puertaAbordajeLb);
		p1.add(puertaAbordajeTxtf);
		p1.add(altaVuelo);
		p1.add(cancelaVuelo);
		
		pp.add(p1);
		this.setVisible(true);
		this.setBounds(25,100,1400,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel 3 (pantalla que muestra resultados)
		this.display=new JTextArea();
		display.setText("                                               Bienvenido :)");
		display.setEditable(false);//para que el usuario no pueda editar aqui la info
		this.barra=new JScrollPane(display);//barra scrollbar
		barra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel p3=new JPanel();
		p3.setLayout(new GridLayout(1,1));
		Border gap3=BorderFactory.createEmptyBorder(10,10,10,10);
		gap3=BorderFactory.createTitledBorder("Información ");
		p3.setBorder(gap3);
		p3.setBackground(Color.lightGray);
		
		p3.add(barra);
		
		pp.add(p3);
		this.setVisible(true);
		this.setBounds(25,100,1400,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel 2 (alta y baja pasajeros) 
		this.nombreLb=new JLabel("Nombre: ");
		this.nombretxt=new JTextField();
				
		this.generoLb=new JLabel("Género: ");
		this.generotxt=new JTextField();
			
		this.paisNacimientoLb=new JLabel("País de nacimiento: ");
		this.paisNacimientotxt=new JTextField();
			
		this.numPasaporteLb=new JLabel("Número de pasaporte: ");
		this.numPasaportetxt=new JTextField();
				
		this.ahoNacimientoLb=new JLabel("Año de nacimiento: ");
		this.ahoNacimientotxt=new JTextField();
		
		this.numVueloPasajeroLb=new JLabel("Número de vuelo: ");
		this.numVueloPasajerotxt=new JTextField();
		
		this.aerolineaPasajeroLb=new JLabel("Aerolínea en la que viaja: ");
		this.aerolineaPasajerotxt=new JTextField();
				
		this.altaPasajeroBt=new JButton("Alta pasajero");
		altaPasajeroBt.setForeground(Color.BLUE);
		
		this.bajaPasajeroBt=new JButton("Baja pasajero");
		bajaPasajeroBt.setForeground(Color.RED);
				
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(8,2));
		Border gap2=BorderFactory.createEmptyBorder(10,10,10,10);
		gap2=BorderFactory.createTitledBorder("Alta y baja de pasajeros en vuelos");
		p2.setBorder(gap2);
				
		p2.add(nombreLb);
		p2.add(nombretxt);
		p2.add(generoLb);
		p2.add(generotxt);
		p2.add(paisNacimientoLb);
		p2.add(paisNacimientotxt);
		p2.add(numPasaporteLb);
		p2.add(numPasaportetxt);
		p2.add(ahoNacimientoLb);
		p2.add(ahoNacimientotxt);
		p2.add(numVueloPasajeroLb);
		p2.add(numVueloPasajerotxt);
		p2.add(aerolineaPasajeroLb);
		p2.add(aerolineaPasajerotxt);
		p2.add(altaPasajeroBt);
		p2.add(bajaPasajeroBt);
				
		pp.add(p2);
		this.setVisible(true);
		this.setBounds(25,100,1400,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//panel 5 busquedas de vuelos
		this.numVueloLbvuelo=new JLabel("Número de vuelo: ");
		this.numVuelotxtVuelo=new JTextField();
		
		this.aerolineaLbvuelo=new JLabel("Aerolinea: ");
		this.aerolineatxtVuelo=new JTextField();
		
		this.buscarVuelo=new JButton("Buscar vuelo");
		this.spaceLbVuelo=new JLabel("");
		
		JPanel p5=new JPanel(new FlowLayout());
		p5.setLayout(new GridLayout(3,2));
		Border gap5=BorderFactory.createEmptyBorder(10,10,10,10);
		gap5=BorderFactory.createTitledBorder("Búsqueda de vuelos: ");
		p5.setBorder(gap5);
		
		p5.add(numVueloLbvuelo);
		p5.add(numVuelotxtVuelo);
		p5.add(aerolineaLbvuelo);
		p5.add(aerolineatxtVuelo);
		p5.add(spaceLbVuelo);//espacio libre para que el boton quede del otro lado
		p5.add(buscarVuelo);
		
		pp.add(p5);
		this.setVisible(true);
		this.setBounds(25,100,1400,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel 4 funciones
		this.numVuelosAerolineaBt=new JButton("Número de vuelos por aerolínea");
		this.pasajeroMasJovenBt=new JButton("Pasajero más joven");
		this.pasajeroMasViejoBt=new JButton("Pasajero más viejo");
		this.promedioEdadPasajerosBt=new JButton("Promedio de edad pasajeros de un vuelo");
		this.cuantosPasajerosGeneroBt=new JButton("Número de pasajeros de cierto género en un vuelo");
		this.cuantosPasajerosNacionalidadBt=new JButton("Número de pasajeros de cierta nacionalidad en un vuelo");
		this.numVuelosEscalasBt=new JButton("Cuántos vuelos hacen escalas de una cierta aerolínea");
		this.cuantosVuelosDestinoBt=new JButton("Cúantos vuelos se dirigen a cierto destino");
		this.searchLb=new JLabel("                   Ingrese aquí los datos separados por una coma ");
		this.search1=new JTextArea();
		this.spaceeLb=new JLabel("");//espacio para que se vea mejor
		this.infoAeropuertoBt=new JButton("Obtener la información completa del aeropuerto");
		this.infoArchivoBt=new JButton("Cargar información desde un archivo");
		this.datosFuncionesBt=new JButton("Consultar los datos requeridos para ejecutar cada función");
		
		JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(14,1));
		Border gap4=BorderFactory.createEmptyBorder(10,10,10,10);
		gap4=BorderFactory.createTitledBorder("Funciones");
		p4.setBorder(gap4);
		
		p4.add(searchLb);
		p4.add(search1);
		p4.add(spaceeLb);
		p4.add(datosFuncionesBt);
		p4.add(numVuelosAerolineaBt);
		p4.add(pasajeroMasJovenBt);
		p4.add(pasajeroMasViejoBt);
		p4.add(promedioEdadPasajerosBt);
		p4.add(cuantosPasajerosGeneroBt);
		p4.add(cuantosPasajerosNacionalidadBt);
		p4.add(numVuelosEscalasBt);
		p4.add(cuantosVuelosDestinoBt);
		p4.add(infoAeropuertoBt);
		p4.add(infoArchivoBt);
		
		 
		pp.add(p4);
		this.setVisible(true);
		this.setBounds(25,100,1400,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//panel 6 busqueda pasajeros
		this.numVueloLbPasajero=new JLabel("Número de vuelo: ");
		this.numVuelotxtPasajero=new JTextField();
		
		this.aerolineaLbPasajero=new JLabel("Aerolínea: ");
		this.aerolineatxtPasajero=new JTextField();
		
		this.numPasaporteLbPasajero=new JLabel("Número de pasaporte: ");
		this.numPasaportetxtPasajero=new JTextField();
		
		this.spaceLbPasajero=new JLabel("");
		this.buscarPasajero=new JButton("Buscar pasajero");
		
		JPanel p6=new JPanel(new FlowLayout());
		p6.setLayout(new GridLayout(4,2));
		Border gap6=BorderFactory.createEmptyBorder(10,10,10,10);
		gap6=BorderFactory.createTitledBorder("Búsqueda de Pasajeros: ");
		p6.setBorder(gap6);
		
		p6.add(numVueloLbPasajero);
		p6.add(numVuelotxtPasajero);
		p6.add(aerolineaLbPasajero);
		p6.add(aerolineatxtPasajero);
		p6.add(numPasaporteLbPasajero);
		p6.add(numPasaportetxtPasajero);
		p6.add(spaceLbPasajero);
		p6.add(buscarPasajero);
		
		pp.add(p6);
		this.setVisible(true);
		this.setBounds(25,100,1400,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}

	public static void main(String[] args) {
		AeropuertoVista a=new AeropuertoVista("Aeropuerto");
	}
}