package GasAndFood.interfaz.vistaDescuento;

import GasAndFood.business.Descuento.TDescuento;
import GasAndFood.business.Descuento.TipoDescuento;
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

public class VistaDAlta extends JFrame {

	private Controlador control;

	public VistaDAlta(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Alta descuento");
		JPanel panel = new JPanel();
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		TipoDescuento[] des = { TipoDescuento.D_1, TipoDescuento.D_2, TipoDescuento.D_3 , TipoDescuento.D_4 , TipoDescuento.D_5 };
		final JComboBox desList = new JComboBox(des);
		desList.setSelectedIndex(0);

		panel.add(desList);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				TipoDescuento tipo = (TipoDescuento) desList.getSelectedItem();
					TDescuento tD = new TDescuento("", tipo, true);
					try {
						control.accion(Evento.ALTA_DESCUENTO, tD);
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						dispose();
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
