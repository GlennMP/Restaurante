package GUIs;

import java.io.*;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.Platos;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.Box;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/* -----------------------------------------------------------------------------------------------------------
 * ESTE ES EL FRAME PRINCIPAL ES EL PROGRAMA EN S�
 * ESTA EXLUSIVAMENTE DISE�ADO PARA QUE SE HABRA ATRAVEZ DE UN FRAME DE LOGIN
 *-------------------------------------------------------------------------------------------------------------*/

public class Principal extends JFrame {
	/* -----------------------------------------------------------------------------------------------------------
	 * CREANDO LAS VARIABLES QUE UTILIZAREMOS
	 * QUE HACEN REFERENCIA A LOS FRAMES QUE HEMOS CREADO
	 *-------------------------------------------------------------------------------------------------------------*/
	public static JPanel contentPane;
	private frmMenu fmenupag;
	private frmMesas2 fmesas;
	private frmRealMenu fmenureal;
	private frmUsuarios fusuarios;
	private frmCaja1 Fcaja;
	private frmLogin Flogin;
	private JDesktopPane PanelMenu;
	public static JDesktopPane PanelPrincipal;
	
	
	/* -----------------------------------------------------------------------------------------------------------
	 * TODAS LAS VARIABLES ESTAN EN PRIVATE PORQUE SOLO SE UTILIZARAN EN ESTE FRAME
	 *-------------------------------------------------------------------------------------------------------------*/
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/* -----------------------------------------------------------------------------------------------------------
	 * SE HIZO UN METODO DONDE ESTAN TODAS LAS DECLARACIONES DE LOS GUIS IMPLEMENTADOS EN ESTE JFRAME.
	 *-------------------------------------------------------------------------------------------------------------*/
		
	void Dise�odePrinc(){
		/* -----------------------------------------------------------------------------------------------------------
		 * ESTA DECLARACION ES DE EL FONDO PRINCIPAL DEL PROGRAMA
		 *-------------------------------------------------------------------------------------------------------------*/
		setTitle("RESTAURANT");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 744);
		/* -----------------------------------------------------------------------------------------------------------
		 * ESTA DECLARACION ES DEL MENU BAR QUE TIENE EN LA PARTE SUPERIOR DEL PROGRAMA
		 *-------------------------------------------------------------------------------------------------------------*/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		setJMenuBar(menuBar);
		/* -----------------------------------------------------------------------------------------------------------
		 * DECLARACI�N DE LOS BOTONES QUE ESTAN DENTRO DEL MENU BAR EN LA PARTE SUPERIOR DEL PROGRAMA
		 * CADA BOTON TIENE SU RESPECTIVO NOMBRE.
		 *-------------------------------------------------------------------------------------------------------------*/
		JButton btnMen_1 = new JButton("Agregar platos");
		btnMen_1.setEnabled(false);
		/* -----------------------------------------------------------------------------------------------------------
		 * ESTE IF-ELSE SIRVE PARA QUE SE ACTIVE CUANDO ENTRA EL ADMINISTRADOR
		 * ESTO LO HACEMOS POR LO MISMO QUE CREAMOS 2 USUARIOS PARA QUE NO SE PUEDA EDITAR LOS MENUS Y CAMBIAR
		   EL CONTENIDO O LOS PRECIOS MAS QUE POR LOS MISMOS ADMINISTRADORES 
		 *-------------------------------------------------------------------------------------------------------------*/
		
		
		
		
		
		
		
		btnMen_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Realmenu();
				
			}
		});
		menuBar.add(btnMen_1);
		
		
		JButton btnMesas = new JButton(" Mesas de salon");
		btnMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				mesas();
			
			}
		});
		
		JButton btnAgregarUsuario = new JButton("Usuarios");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usuarios();
				
			}
			
		});
		
		
		btnAgregarUsuario.setEnabled(false);
		
		//esto se utiliza para abilitar o desavilitar los botones segun el usuario ingresado
        if (frmLogin.user1 == 2){
			
			btnMen_1.setEnabled(true);
			btnAgregarUsuario.setEnabled(true);
		}
		
		
		menuBar.add(btnAgregarUsuario);
		menuBar.add(btnMesas);
		
		JButton btnCaja = new JButton("Caja");
		btnCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Caja();
				
				
				
			}
		});
		menuBar.add(btnCaja);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 1366, 40);
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setFocusTraversalKeysEnabled(false);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setForeground(SystemColor.activeCaption);
		contentPane.add(toolBar);
		
		JButton btnNewButton = new JButton("CAMBIAR USUARIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				newLogin();
				dispose();
				
				
			}
		});
		toolBar.add(btnNewButton);
		
		JButton btnCerrarSesion = 
				new JButton("SALIR");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			
			}
		});
		toolBar.add(btnCerrarSesion);
		
		JButton btnMen = new JButton("MEN\u00DA");
		btnMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				menu();
				
			}
		});
		
		//aqui es glen lo que tienes que ocultar
		/*if (frmLogin.user.equalsIgnoreCase(frmLogin.user1)){
			btnCargarDatos.setEnabled(true);
			}*/
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		toolBar.add(btnMen);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setEnabled(true);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				fmenupag.dispose();
				menu();
				/*if(fmenupag!=null){
					fmenupag.dispose();
				menu();
				}*/
				
			}
		});
		toolBar.add(btnActualizar);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 39, 900, 643);
		contentPane.add(panel);
		panel.setLayout(null);
		
		PanelPrincipal = new JDesktopPane();
		PanelPrincipal.setBounds(0, 0, 900, 643);
		panel.add(PanelPrincipal);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(898, 39, 468, 643);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		PanelMenu = new JDesktopPane();
		PanelMenu.setBounds(12, 13, 444, 618);
		panel_1.add(PanelMenu);
		GroupLayout gl_PanelMenu = new GroupLayout(PanelMenu);
		gl_PanelMenu.setHorizontalGroup(
			gl_PanelMenu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 444, Short.MAX_VALUE)
		);
		gl_PanelMenu.setVerticalGroup(
			gl_PanelMenu.createParallelGroup(Alignment.LEADING)
				.addGap(0, 618, Short.MAX_VALUE)
		);
		PanelMenu.setLayout(gl_PanelMenu);
		
		fmenupag=new frmMenu();
		PanelMenu.add(fmenupag);
		fmenupag.show();
		fmenupag.move(2,2);
		
		mesas();
		
	}
	/**
	 * Create the frame.
	 */
	public Principal() {
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		Dise�odePrinc();
		
		
	
	}
	
	public void menu(){
		
		
			fmenupag=new frmMenu();
		PanelMenu.add(fmenupag);
		fmenupag.show();
		fmenupag.move(2,2);
		
		
		
		/*if(fmenupag==null || fmenupag.isClosed()){
			fmenupag=new frmMenu();
		PanelMenu.add(fmenupag);
		fmenupag.show();
		fmenupag.move(2,2);
		
		}
		else fmenupag.isFocusable();*/
	}
	public void mesas(){
		
		if(fmesas==null || fmesas.isClosed()){
		fmesas=new frmMesas2();
		PanelPrincipal.add(fmesas);
		fmesas.show();
		fmesas.move(2,2);
		
		}
		else 
			fmesas.isFocusable();
	}
	
	void Realmenu(){
		
	if(fmenureal==null || fmenureal.isClosed()){
		fmenureal=new frmRealMenu();
		PanelPrincipal.add(fmenureal);
		fmenureal.show();
		fmenureal.move(2,2);
		fmenureal.NombreRestaurant=fmenureal.txtFRestaurant.getText();
	}
	
	else fmenureal.isFocusable();
		
		
	}
	
	
	void usuarios(){
		
		if(fusuarios==null || fusuarios.isClosed()){
			fusuarios=new frmUsuarios();
			PanelPrincipal.add(fusuarios);
			fusuarios.show();
			fusuarios.move(2,2);
		}
		
		else fusuarios.isFocusable();
			
			
		}
	
	
	
	
	
	void Caja(){
		
		if(Fcaja==null || Fcaja.isClosed()){
			Fcaja=new frmCaja1();
		PanelPrincipal.add(Fcaja);
		Fcaja.show();
		Fcaja.move(2,2);
		
		}
		else Fcaja.isFocusable();
		
	}
	
void newLogin(){
		
		Flogin = new frmLogin();
		Flogin.show();
		Flogin.setVisible(true);
				
	}
public static ArrayList<Platos> Pl= new ArrayList<Platos>();
public static ArrayList<Platos> Piq= new ArrayList<Platos>();
public static ArrayList<Platos> Beb= new ArrayList<Platos>();

public static void GrabarPlato(Platos P){
	Pl.add(P);
}
public static void GrabarPiqueo(Platos P){
	Piq.add(P);
}
public static void GrabarBebida(Platos P){
	Beb.add(P);
}

private void grabarPlatos() {
	try {
		PrintWriter pw;
		Platos P;       
		String linea;
		pw = new PrintWriter(new FileWriter("ReportePlatos.txt"));
		for (int i=0; i<Pl.size(); i++) {
			P = Pl.get(i);
			linea = P.getCodigo()+ ";" +P.getNombre()+ ";" +P.getPrecio()+ ";" +P.getContenido();
			pw.println(linea);
			}
		pw.close();
		}    
	catch (Exception e) {
		JOptionPane.showMessageDialog(this, "No hay Platos que guardar", "Error de Datos",
				JOptionPane.INFORMATION_MESSAGE);
	}
} 

private void grabarPiqueos() {
	try {
		PrintWriter pw;
		Platos P;       
		String linea;
		pw = new PrintWriter(new FileWriter("ReportePiqueos.txt"));
		for (int i=0; i<Piq.size(); i++) {
			P = Piq.get(i);
			linea = P.getCodigo()+ ";" +P.getNombre()+ ";" +P.getPrecio()+ ";" +P.getContenido();
			pw.println(linea);
			}
		pw.close();
		}    
	catch (Exception e) {
		JOptionPane.showMessageDialog(this, "No hay Piqueos que guardar", "Error de Datos",
				JOptionPane.INFORMATION_MESSAGE);
	}
} 
private void grabarBebidas() {
	try {
		PrintWriter pw;
		Platos P;       
		String linea;
		pw = new PrintWriter(new FileWriter("ReporteBebidas.txt"));
		for (int i=0; i<Beb.size(); i++) {
			P = Beb.get(i);
			linea = P.getCodigo()+ ";" +P.getNombre()+ ";" +P.getPrecio()+ ";" +P.getContenido();
			pw.println(linea);
			}
		pw.close();
		}    
	catch (Exception e) {
		JOptionPane.showMessageDialog(this, "No hay Bebidas que guardar", "Error de Datos",
				JOptionPane.INFORMATION_MESSAGE);
	} 
} 
}
