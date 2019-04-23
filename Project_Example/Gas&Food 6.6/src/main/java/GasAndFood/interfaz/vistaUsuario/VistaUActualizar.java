package GasAndFood.interfaz.vistaUsuario;

import GasAndFood.business.Usuario.TUsuario;
import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class VistaUActualizar extends JFrame {

	private Controlador control;

	public VistaUActualizar(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Actualizar usuario");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID:");
		final JTextField tId = new JTextField(20);
		JLabel lContra = new JLabel("Contrasenya:");
		final JTextField tContra = new JTextField(20);
		JLabel lEmail = new JLabel("E-Mail:");
		final JTextField tEmail = new JTextField(20);
		JLabel lAct = new JLabel("Activo:");
		final JTextField tAct = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(lId);
		panel.add(tId);
		panel.add(lContra);
		panel.add(tContra);
		panel.add(lEmail);
		panel.add(tEmail);
		panel.add(lAct);
		panel.add(tAct);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String id = tId.getText();
				String contra = tContra.getText();
				String email = tEmail.getText();
				boolean act = (tAct.getText().equals("1"));
				if (id.length() != 0 && contra.length() != 0 && email.length() != 0) {
					TUsuario tU = new TUsuario(id,"", contra, "", email, act);
					try {
						control.accion(Evento.ACTUALIZAR_USUARIO, tU);
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
