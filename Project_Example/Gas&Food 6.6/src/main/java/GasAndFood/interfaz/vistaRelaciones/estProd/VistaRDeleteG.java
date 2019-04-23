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

public class VistaRDeleteG extends JFrame {
	
	private Controlador control;

	public VistaRDeleteG(Controlador controlador) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		control = controlador;
		setTitle("Eliminar Relacion");
		JPanel panel = new JPanel();
		JLabel lId1 = new JLabel("ID 1:");
		final JTextField tId1 = new JTextField(20);
		JLabel lId2 = new JLabel("ID 2:");
		final JTextField tId2 = new JTextField(20);
			
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(lId1);
		panel.add(tId1);
		panel.add(lId2);
		panel.add(tId2);
				
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String id1 = tId1.getText();
				String id2 = tId2.getText();
			
				
				if (id1.length() != 0 && id2.length() != 0 ) {
		
					try {
						control.relacionE(Evento.DELETE_RELACION_G, id1, id2,0,0);
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



