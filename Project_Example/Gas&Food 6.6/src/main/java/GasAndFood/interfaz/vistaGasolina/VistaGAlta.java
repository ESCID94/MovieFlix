package GasAndFood.interfaz.vistaGasolina;

import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;
import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class VistaGAlta extends JFrame {

	private Controlador control;

	public VistaGAlta(Controlador controlador) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		control = controlador;

		setTitle("Alta gasolina");
		JPanel panel = new JPanel();
		JLabel lNombre = new JLabel("Nombre:");
		final JTextField tNombre = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		TipoGasolina[] gas = { TipoGasolina.BIOGASOLINA, TipoGasolina.GASOLINA, TipoGasolina.DIESEL };
		final JComboBox gasList = new JComboBox(gas);
		gasList.setSelectedIndex(0);

		panel.add(lNombre);
		panel.add(tNombre);
		panel.add(gasList);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String nombre = tNombre.getText();
				TipoGasolina tipo = (TipoGasolina) gasList.getSelectedItem();
				if (nombre.length() != 0 && tipo != null) {
					TGasolina tG = new TGasolina("", nombre, true, tipo);
					try {
						control.accion(Evento.ALTA_GASOLINA, tG);
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
