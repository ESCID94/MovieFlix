package GasAndFood.interfaz.vistaRelaciones.estProd;


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

public class VistaRVerG extends JFrame {
	
	private Controlador control;


	public VistaRVerG(Controlador controlador) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		control = controlador;

		setTitle("Ver Relaciones GASOLINA");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID de Gasolina a buscar:");
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
						control.accion(Evento.VER_RELACION_G, id);
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