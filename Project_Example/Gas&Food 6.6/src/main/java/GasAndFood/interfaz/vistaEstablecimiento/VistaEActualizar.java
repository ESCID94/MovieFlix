package GasAndFood.interfaz.vistaEstablecimiento;

import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
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

public class VistaEActualizar extends JFrame {

	private Controlador control;

	public VistaEActualizar(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Actualizar Establecimiento");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID:");
		final JTextField tId = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		TipoEstablecimiento[] est = { TipoEstablecimiento.ALIMENTACION, TipoEstablecimiento.GASOLINERA };
		final JComboBox estList = new JComboBox(est);
		estList.setSelectedIndex(0);

		panel.add(lId);
		panel.add(tId);
		panel.add(estList);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String id = tId.getText();
				TipoEstablecimiento tipo = (TipoEstablecimiento) estList.getSelectedItem();
				if (id.length() != 0) {
					TEstablecimiento tE = new TEstablecimiento(id, "", "", "", true, tipo);
					try {
						control.accion(Evento.ACTUALIZAR_ESTABLECIMIENTO, tE);
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
