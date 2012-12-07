package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContrasea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ComboBox.buttonBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(UIManager.getColor("Button.disabledText"));
		txtUsuario.setText("Usuario");
		txtUsuario.setBounds(88, 243, 266, 45);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setForeground(UIManager.getColor("Button.disabledText"));
		txtContrasea.setBackground(UIManager.getColor("Button.highlight"));
		txtContrasea.setText("Contrase\u00F1a");
		txtContrasea.setColumns(10);
		txtContrasea.setBounds(88, 318, 266, 45);
		contentPane.add(txtContrasea);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Volumes/SHARED HD/Ingenieria de Software 1/ChibchaWeb/assets/logochibcha.png"));
		label.setBounds(28, 6, 396, 104);
		contentPane.add(label);
		
		JLabel lblInicioDeSesion = new JLabel("Inicio de Sesi\u00F3n");
		lblInicioDeSesion.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesion.setBounds(88, 116, 266, 45);
		contentPane.add(lblInicioDeSesion);
		
		JLabel lblUsuario = new JLabel("Por Favor ingrese su usuario y contrase\u00F1a");
		lblUsuario.setBounds(88, 185, 266, 16);
		contentPane.add(lblUsuario);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(237, 391, 117, 36);
		contentPane.add(btnNewButton);
	}
}
