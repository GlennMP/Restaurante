package GUIs;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.FramePeer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.xml.bind.ParseConversionEvent;

import mantenimiento.gestionusuario;
import model.usuario;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	public static Integer user1;
	public static String user;
	private JTextField txtUsuario;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public frmLogin() {
		setTitle("Inicio de Sesi\u00F3n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Aceptar");
		button.setBounds(10, 306, 117, 31);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				validaAcceso();
				//aceptar();
				
			}
		});
		button.setIcon(new ImageIcon(frmLogin.class.getResource("/iconos22x22/dialog-accept.png")));
		button.setActionCommand("OK");
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(137, 306, 113, 31);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			
			}
		});
		button_1.setIcon(new ImageIcon(frmLogin.class.getResource("/iconos22x22/dialog-cancel-3.png")));
		button_1.setActionCommand("Cancel");
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(29, 264, 58, 14);
		contentPane.add(label_1);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(130, 261, 99, 20);
		contentPane.add(txtClave);
		
		JLabel lblUsuariooooo = new JLabel("Usuario");
		lblUsuariooooo.setBounds(29, 228, 78, 14);
		contentPane.add(lblUsuariooooo);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(130, 225, 99, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(frmLogin.class.getResource("/imagenes/user.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(62, 25, 148, 157);
		contentPane.add(label_2);
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				//if(e.getKeyCode()==KeyEvent.VK_ENTER)
					//aceptar();
				
			}
		});
	}
	
	/*
	void aceptar() {
		String usuario, clave;
		usuario = txtUsuario.getText();
		clave = txtClave.getText();
		user1 = "admin";
		user2 = "mesero";
		pass1 = "admin";
		pass2 = "mesero";

		if (usuario.equalsIgnoreCase(user1) && clave.equals(pass1)|| usuario.equalsIgnoreCase(user2) && clave.equals(pass2)) {
			user = usuario;
			JFrame fp=new Principal();
			fp.setVisible(true);
			this.dispose();
		} else
			JOptionPane.showMessageDialog(this, "Usuario o Clave Incorrectos", "Inicio de Sesi�n",
					JOptionPane.ERROR_MESSAGE);
		
	}*/
	
	
	private void aviso(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
	private String leerClave(){
		return txtClave.getText();
	}
	private String leerUsuario(){
		return txtUsuario.getText();
	}
	void validaAcceso(){
		String usuario,clave;
		
		usuario=leerUsuario();
		clave=leerClave();
		
		
		
		gestionusuario gu=new gestionusuario();
		usuario u=gu.validaAcceso(usuario, clave);
		
		user1 = u.getCargo();
		
		System.out.println(user1);
		
		if(u ==null){
			aviso("Usuario o clave incorrecta");
		}
		else{
			
			user = usuario;
			aviso("Bienvenido  "+u.getNombre());
			JFrame fp=new Principal();
			fp.setVisible(true);
			dispose();
			
		}
		
	}
}
