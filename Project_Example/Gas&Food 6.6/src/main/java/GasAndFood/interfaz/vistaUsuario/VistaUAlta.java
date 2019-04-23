package GasAndFood.interfaz.vistaUsuario;

import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VistaUAlta extends JFrame {

	private Controlador control;

	public VistaUAlta(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Alta usuario");
		JPanel panel = new JPanel();
		JLabel lNombre = new JLabel("Nombre:");
		final JTextField tNombre = new JTextField(20);
		JLabel lContra = new JLabel("Contrasenya:");
		final JTextField tContra = new JTextField(20);
		JLabel lUsuario = new JLabel("Usuario:");
		final JTextField tUsuario = new JTextField(20);
		JLabel lEMail = new JLabel("e-mail:");
		final JTextField tEmail = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(lNombre);
		panel.add(tNombre);
		panel.add(lContra);
		panel.add(tContra);
		panel.add(lUsuario);
		panel.add(tUsuario);
		panel.add(lEMail);
		panel.add(tEmail);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String nombre = tNombre.getText();
				String eMail = tEmail.getText();
				String contra = tContra.getText();
				String usuario = tUsuario.getText();
				if (nombre.length() != 0 && eMail.length() != 0 && contra.length() != 0 && usuario.length() != 0) {
					TUsuario tU = new TUsuario("", nombre, contra, usuario, eMail, true);
					try {
						control.accion(Evento.ALTA_USUARIO, tU);
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						dispose();
					}
				}
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
					
			}
		});
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
