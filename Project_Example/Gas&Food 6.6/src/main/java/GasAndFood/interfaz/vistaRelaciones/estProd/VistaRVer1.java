package GasAndFood.interfaz.vistaRelaciones.estProd;


import GasAndFood.interfaz.controlador.Controlador;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;



@SuppressWarnings("serial")

public class VistaRVer1 extends JFrame {
	
	private Controlador control;

	public VistaRVer1(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
		setTitle("Añadir Relacion");
		JPanel panel = new JPanel();
				
		JButton alimento = new JButton("Alimento");
		JButton gasolina = new JButton("Gasolina");

		
		panel.add(alimento);
		panel.add(gasolina);
		getContentPane().add(panel);
		this.pack(); // la ventana se ajusta a las componentes que contiene
		this.setVisible(true); // La hacemos visible

		alimento.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				VistaRVer vistarverA = new VistaRVer(control);
			}
		});
		
		gasolina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRVerG vistarverG = new VistaRVerG(control);
					
			}
		});
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
