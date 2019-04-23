package GasAndFood.interfaz.vistaAlimento;

import GasAndFood.business.Alimento.TAlimento;
import GasAndFood.business.Alimento.TipoAlimento;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VistaAActualizar extends JFrame {

	private Controlador control;

	public VistaAActualizar(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;

		setTitle("Actualizar Alimento");
		JPanel panel = new JPanel();
		JLabel lId = new JLabel("ID:");
		final JTextField tId = new JTextField(20);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");		
		TipoAlimento[] ali = { TipoAlimento.A_FRESCOS, TipoAlimento.BEBIDAS, TipoAlimento.BOLLERIA, TipoAlimento.CONGELADOS,
				TipoAlimento.DULCES, TipoAlimento.FRUTAS, TipoAlimento.SNACKS, TipoAlimento.VERDURAS };
		final JComboBox aliList = new JComboBox(ali);
		aliList.setSelectedIndex(0);


		panel.add(lId);
		panel.add(tId);
		panel.add(aliList);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(true);
				String id = tId.getText();
				TipoAlimento tipo = (TipoAlimento) aliList.getSelectedItem();
				if (id.length() != 0) {
					TAlimento tA = new TAlimento(id,"",true, tipo);
					try {
						control.accion(Evento.ACTUALIZAR_ALIMENTO, tA);
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
