package GasAndFood.interfaz.vistaEstablecimiento;

import GasAndFood.business.Establecimiento.TEstablecimiento;
import GasAndFood.business.Establecimiento.TipoEstablecimiento;
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

public class VistaEAlta extends JFrame {

	private Controlador control;

	public VistaEAlta(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Alta Establecimiento");
		JPanel panel = new JPanel();
		JLabel lNombre = new JLabel("Nombre:");
		final JTextField tNombre = new JTextField(20);
		JLabel lDireccion = new JLabel("Dirección:");
		final JTextField tDireccion = new JTextField(20);
		JLabel lCP = new JLabel("CP:");
		final JTextField tCP = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		TipoEstablecimiento[] est = { TipoEstablecimiento.ALIMENTACION, TipoEstablecimiento.GASOLINERA };
		final JComboBox estList = new JComboBox(est);
		estList.setSelectedIndex(0);

		panel.add(lNombre);
		panel.add(tNombre);
		panel.add(estList);
		panel.add(lDireccion);
		panel.add(tDireccion);
		panel.add(lCP);
		panel.add(tCP);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String nombre = tNombre.getText();
				String CP = tCP.getText();
				TipoEstablecimiento tipo = (TipoEstablecimiento) estList.getSelectedItem();
				String direccion = tDireccion.getText();
				if (nombre.length() != 0 && CP.length() != 0 && direccion.length() != 0) {
					TEstablecimiento tE = new TEstablecimiento("", nombre, direccion, CP, true, tipo);
					try {
						control.accion(Evento.ALTA_ESTABLECIMIENTO, tE);
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
