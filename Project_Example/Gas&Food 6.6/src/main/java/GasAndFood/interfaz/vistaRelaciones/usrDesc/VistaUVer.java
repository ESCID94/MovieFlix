package GasAndFood.interfaz.vistaRelaciones.usrDesc;


import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")

public class VistaUVer extends JFrame {
	
	private Controlador control;


	public VistaUVer(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Ver Relaciones USR-DESC");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID a buscar:");
		final JTextField tId = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(lId);
		panel.add(tId);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible


		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String id = tId.getText();
				if (id.length() != 0) {
					try {
						control.accion(Evento.VER_RELACION_U, id);
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