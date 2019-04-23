package GasAndFood.interfaz.vistaGasolina;

import GasAndFood.business.Gasolina.TGasolina;
import GasAndFood.business.Gasolina.TipoGasolina;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class VistaGActualizar extends JFrame {

	private Controlador control;

	public VistaGActualizar(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Actualizar gasolina");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID:");
		final JTextField tId = new JTextField(20);
		JLabel lNombre = new JLabel("Nombre:");
		final JTextField tNombre = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		TipoGasolina[] gas = { TipoGasolina.BIOGASOLINA, TipoGasolina.GASOLINA, TipoGasolina.DIESEL };
		final JComboBox gasList = new JComboBox(gas);
		gasList.setSelectedIndex(0);

		panel.add(lId);
		panel.add(tId);
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
				String id = tId.getText();
				String nombre = tNombre.getText();
				TipoGasolina tipo = (TipoGasolina) gasList.getSelectedItem();
				if (id.length() != 0 && nombre.length() != 0) {
					TGasolina TG = new TGasolina(id, nombre, true, tipo);
					try {
						control.accion(Evento.ACTUALIZAR_GASOLINA, TG);
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
