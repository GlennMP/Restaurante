package GUIs;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.omg.CORBA.PUBLIC_MEMBER;

import mantenimiento.gestionmenu;
import mantenimiento.gestionusuario;
import model.cargo;
import model.registramesa;
import model.usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmUsuarios extends JInternalFrame {

	private JPanel contentPane;
	public static String user;
	private JComboBox combocargo;
	private JPasswordField txcontrasena;
	private JTextField txparametro;
	private JTextField txnombre;
	private JTextField txusuario;
	private JTextField txtelefono;
	private JTextField txdireccion;
	private JTable tblusuarios;
	public DefaultTableModel modelo;
	public int cod;
	private JScrollPane scrollPane;
	private JButton btnGuardar;
	private JButton btnactualizar;
	private JButton btneliminar;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuarios frame = new frmUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusacarUsuarios = new JLabel("Busacar Usuario:");
		lblBusacarUsuarios.setBounds(49, 34, 118, 14);
		contentPane.add(lblBusacarUsuarios);
		
		JLabel lblRegistrarOModificar = new JLabel("Registrar o modificar Usuario:");
		lblRegistrarOModificar.setBounds(21, 221, 290, 14);
		contentPane.add(lblRegistrarOModificar);
		
		combocargo = new JComboBox();
		combocargo.setBounds(288, 322, 154, 20);
		contentPane.add(combocargo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				registrar();
				limpiar();
				eliminar();
				listartabla();
				
			}
		});
		btnGuardar.setIcon(new ImageIcon(frmUsuarios.class.getResource("/iconos22x22/dialog-accept.png")));
		btnGuardar.setActionCommand("OK");
		btnGuardar.setBounds(555, 221, 117, 31);
		contentPane.add(btnGuardar);
		
		button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
		button.setIcon(new ImageIcon(frmUsuarios.class.getResource("/iconos22x22/dialog-cancel-3.png")));
		button.setActionCommand("Cancel");
		button.setBounds(555, 349, 117, 31);
		contentPane.add(button);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				eliminar();
				listartablaporparametro();
				
			}
		});
		btnBuscar.setBounds(504, 30, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 258, 118, 14);
		contentPane.add(lblNombre);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(21, 289, 118, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContra = new JLabel("Contrase\u00F1a:");
		lblContra.setBounds(223, 289, 118, 14);
		contentPane.add(lblContra);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(21, 325, 118, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(21, 357, 118, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(235, 325, 118, 14);
		contentPane.add(lblCargo);
		
		txcontrasena = new JPasswordField();
		txcontrasena.setBounds(305, 286, 137, 20);
		contentPane.add(txcontrasena);
		
		txparametro = new JTextField();
		txparametro.setBounds(204, 31, 290, 20);
		contentPane.add(txparametro);
		txparametro.setColumns(10);
		
		txnombre = new JTextField();
		txnombre.setColumns(10);
		txnombre.setBounds(77, 255, 290, 20);
		contentPane.add(txnombre);
		
		txusuario = new JTextField();
		txusuario.setColumns(10);
		txusuario.setBounds(77, 286, 136, 20);
		contentPane.add(txusuario);
		
		txtelefono = new JTextField();
		txtelefono.setColumns(10);
		txtelefono.setBounds(77, 322, 136, 20);
		contentPane.add(txtelefono);
		
		txdireccion = new JTextField();
		txdireccion.setColumns(10);
		txdireccion.setBounds(77, 354, 365, 20);
		contentPane.add(txdireccion);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		scrollPane.setBounds(10, 59, 718, 151);
		contentPane.add(scrollPane);
		
		tblusuarios = new JTable();
		tblusuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
                // aqui pasamos toda informacion de la tabla a los txt
				int filaseleciona = tblusuarios.rowAtPoint(arg0.getPoint());
				
				int codigo =Integer.parseInt(tblusuarios.getValueAt(filaseleciona, 0).toString());
				cod=codigo;
				
				txusuario.setText(tblusuarios.getValueAt(filaseleciona, 1).toString());
				txnombre.setText(tblusuarios.getValueAt(filaseleciona, 2).toString());
				txcontrasena.setText(tblusuarios.getValueAt(filaseleciona, 3).toString());
				txtelefono.setText(tblusuarios.getValueAt(filaseleciona, 4).toString());
				txdireccion.setText(tblusuarios.getValueAt(filaseleciona, 5).toString());
				
				btnGuardar.setEnabled(false);
				btnactualizar.setEnabled(true);
				btneliminar.setEnabled(true);
				
					
				
			}
		});
		scrollPane.setViewportView(tblusuarios);
		modelo=new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Nombre");
		modelo.addColumn("Contraseņa");
		modelo.addColumn("Telefono");
		modelo.addColumn("Direccion");
		modelo.addColumn("Cargo");
		tblusuarios.setModel(modelo);
		
		JButton btnlistartodo = new JButton("Listar usuarios");
		btnlistartodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				eliminar();
				listartabla();
				txparametro.setText(null);
				
			}
		});
		btnlistartodo.setBounds(603, 30, 125, 23);
		contentPane.add(btnlistartodo);
		
		btnactualizar = new JButton("Actualizar");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actualizarusu();
				limpiar();
				eliminar();
				listartabla();
				btnGuardar.setEnabled(true);
				btnactualizar.setEnabled(false);
				btneliminar.setEnabled(false);
				
			}
		});
		btnactualizar.setBounds(555, 263, 117, 31);
		contentPane.add(btnactualizar);
		
		btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				elimiarusu();
				limpiar();
				eliminar();
				listartabla();
				btnGuardar.setEnabled(true);
				btnactualizar.setEnabled(false);
				btneliminar.setEnabled(false);
				
			}
		});
		btneliminar.setBounds(555, 306, 117, 31);
		contentPane.add(btneliminar);
		
		
		

		listarcargo();
		listartabla();
		btnactualizar.setEnabled(false);
		btneliminar.setEnabled(false);
		
	}
	

	void listarcargo(){
		gestionmenu gm=new gestionmenu();
		ArrayList<cargo> lista=gm.muestracargo();
		for(cargo usu:lista){
			combocargo.addItem(usu);
		}
	}
	
	
	
    private void actualizarusu(){
		
		int cargo,codigousu;
		String usuario,nombre,contracena,telefono,direccion;
		
		codigousu=cod;
		nombre=txnombre.getText();
		usuario=txusuario.getText();
		contracena=txcontrasena.getText();
		telefono=txtelefono.getText();
		direccion=txdireccion.getText();
		cargo=combocargo.getSelectedIndex();
		int suma = cargo+1;
		
		System.out.println(suma);
		
		usuario u = new usuario();
		u.setCodigo(codigousu);
		u.setCargo(suma);
		u.setNombre(nombre);
		u.setUsuario(usuario);
		u.setContracena(contracena);
		u.setTelefono(telefono);
		u.setDireccion(direccion);
		
		gestionusuario g = new gestionusuario();
		int ok=g.actualizarusu(u);
		
		if(ok==0){
			System.out.println("Error en la operacion");
			
	       }else{
	    	System.out.println("Actualizado correctamente");
	    
	       }
		
	}
    
    
    
    private void elimiarusu(){
		
		int codigousu = cod;
		String estado ="n";
		
		usuario u = new usuario();
		u.setCodigo(codigousu);
		u.setEstado(estado);
		
		gestionusuario g = new gestionusuario();
		int ok=g.eliminarusu(u);
		
		if(ok==0){
			System.out.println("Error en la operacion");
			
			
	       }else{
	    	System.out.println("Actualizado correctamente");
	    
	       }
		
	}
	
    
    
    
	
	private void registrar(){
		
		int cargo;
		String usuario,nombre,contracena,telefono,direccion,estado;
		
		nombre=txnombre.getText();
		usuario=txusuario.getText();
		contracena=txcontrasena.getText();
		telefono=txtelefono.getText();
		direccion=txdireccion.getText();
		cargo=combocargo.getSelectedIndex();
		estado="a";
		int suma = cargo+1;
		
		System.out.println(suma);
		
		usuario u = new usuario();
		u.setCargo(suma);
		u.setNombre(nombre);
		u.setUsuario(usuario);
		u.setContracena(contracena);
		u.setTelefono(telefono);
		u.setDireccion(direccion);
		u.setEstado(estado);
		
		gestionusuario g = new gestionusuario();
		int ok=g.registrarusu(u);
		
		if(ok==0){
			System.out.println("Error en la operacion");
		
			
	       }else{
	    	   System.out.println("Registrado correctamente");
	    	
	       }
		
	}
	
    void limpiar(){
		
		txcontrasena.setText(null);
		txdireccion.setText(null);
		txnombre.setText(null);
		txtelefono.setText(null);
		txusuario.setText(null);
		
	}
    
    void listartabla(){
		
		gestionusuario gm=new gestionusuario();
		ArrayList<usuario>lista=gm.listausuarios();
		for(usuario r:lista){
			Object fila[]={
					r.getCodigo(),
					r.getUsuario(),
					r.getNombre(),
					r.getContracena(),
					r.getTelefono(),
					r.getDireccion(),
					r.getNombrecargo()
						
			};
			modelo.addRow(fila);
			
		}
		
	}
    
    void listartablaporparametro(){
		String parametro=txparametro.getText();
		
		System.out.println(parametro);
	
		
		gestionusuario gm=new gestionusuario();
		ArrayList<usuario>lista=gm.muestrausuarioporparametro(parametro);
		for(usuario r:lista){
			Object fila[]={
					r.getCodigo(),
					r.getUsuario(),
					r.getNombre(),
					r.getContracena(),
					r.getTelefono(),
					r.getDireccion(),
					r.getNombrecargo()
						
			};
			modelo.addRow(fila);
		}
		
	}
    
    
    public void eliminar(){
        DefaultTableModel tb = (DefaultTableModel) tblusuarios.getModel();
        int a = tblusuarios.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
      
    }
}
