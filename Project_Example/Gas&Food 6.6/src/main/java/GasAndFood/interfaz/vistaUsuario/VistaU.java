package GasAndFood.interfaz.vistaUsuario;

import GasAndFood.interfaz.controlador.Controlador;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")

public class VistaU extends JFrame {
	

	private Container _panelPrincipal;
	private Controlador control;

	public VistaU(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
	

			
			_panelPrincipal = this.getContentPane();  //Panel de la ventana
			_panelPrincipal.setLayout(new BorderLayout());
			
			JPanel bigPanel = new JPanel();
			bigPanel.setLayout(new GridLayout(1,2));
			TitledBorder title = BorderFactory.createTitledBorder("ACCIONES USUARIOS");
			bigPanel.setBorder(title);
		
				
			JPanel _botones = new JPanel();
			_botones.setLayout(new GridLayout(2,1));
				JPanel _botones1 = new JPanel();
				_botones1.setLayout(new FlowLayout());
				
					JButton altaU = new JButton("Dar de Alta");
					_botones1.add(altaU);
					JButton bajaU = new JButton("Dar de baja");
					_botones1.add(bajaU);	
					JButton modificarU = new JButton("Modificar");
					_botones1.add(modificarU);
					JButton leerU = new JButton("Ver");
					_botones1.add(leerU);
					JButton leerUTodo = new JButton("Ver todo");
					_botones1.add(leerUTodo);
				_botones.add(_botones1);
				
				
			bigPanel.add(_botones);
								
				
				_panelPrincipal.add(bigPanel, BorderLayout.CENTER);
				
				
				
				//Acciones:
				
				altaU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
							VistaUAlta vistauAlta = new VistaUAlta(control);
						
					}
				});
				
				bajaU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaUBaja vistauBaja = new VistaUBaja(control);
						
					}
				});
				
				modificarU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaUActualizar vistauAct = new VistaUActualizar(control);
						
					}
				});
				
				
				leerU.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaULeer vistauLeer = new VistaULeer(control);
						
					}
				});
				leerUTodo.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaULeerTodo vistauLeerTodo = new VistaULeerTodo(control);
						
					}
				});

				
				
				
				this.pack();       //la ventana se ajusta a las componentes que contiene
				this.setVisible(true);    //La hacemos visible
				this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
			}
			
}


