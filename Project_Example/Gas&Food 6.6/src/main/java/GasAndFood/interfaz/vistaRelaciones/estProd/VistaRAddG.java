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

public class VistaRAddG extends JFrame {
	
	private Controlador control;

	public VistaRAddG(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
		setTitle("Añadir Relacion");
		JPanel panel = new JPanel();
		JLabel lId1 = new JLabel("ID 1:");
		final JTextField tId1 = new JTextField(20);
		JLabel lId2 = new JLabel("ID 2:");
		final JTextField tId2 = new JTextField(20);
		
		JLabel lParam1 = new JLabel("Precio:");
		final JTextField tParam1 = new JTextField(20);
		
		JLabel lParam2 = new JLabel("Descuento:");
		final JTextField tParam2 = new JTextField(20);
		
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");

		panel.add(lId1);
		panel.add(tId1);
		panel.add(lId2);
		panel.add(tId2);
		panel.add(lParam1);
		panel.add(tParam1);
		panel.add(lParam2);
		panel.add(tParam2);
		
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
				String param1 = tParam1.getText();
				String param2 = tParam2.getText();
				
				if (id1.length() != 0 && id2.length() != 0 && param1.length() != 0 && param2.length() != 0) {
		
					try {
						control.relacionE(Evento.ADD_RELACION_G, id1, id2, Float.parseFloat(param1),Integer.parseInt(param2));
					} catch (NumberFormatException | IOException e1) {
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
