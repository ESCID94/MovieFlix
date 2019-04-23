package GasAndFood.interfaz;

import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.vistaAlimento.VistaA;
import GasAndFood.interfaz.vistaDescuento.VistaD;
import GasAndFood.interfaz.vistaEstablecimiento.VistaE;
import GasAndFood.interfaz.vistaGasolina.VistaG;
import GasAndFood.interfaz.vistaRelaciones.aliEst.VistaAVer;
import GasAndFood.interfaz.vistaRelaciones.estProd.VistaRAdd1;
import GasAndFood.interfaz.vistaRelaciones.estProd.VistaRDelete1;
import GasAndFood.interfaz.vistaRelaciones.estProd.VistaRVer1;
import GasAndFood.interfaz.vistaRelaciones.gasEst.VistaGVer;
import GasAndFood.interfaz.vistaRelaciones.usrDesc.VistaUAdd;
import GasAndFood.interfaz.vistaRelaciones.usrDesc.VistaUDelete;
import GasAndFood.interfaz.vistaRelaciones.usrDesc.VistaUVer;
import GasAndFood.interfaz.vistaUsuario.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")

public class Vista extends JFrame {
	

	private Container _panelPrincipal;
	private Controlador control;

	public Vista(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
	

			
			_panelPrincipal = this.getContentPane();  
			_panelPrincipal.setLayout(new BorderLayout());
			
			JPanel bigPanel = new JPanel();
			bigPanel.setLayout(new GridLayout(3,2));
			TitledBorder title = BorderFactory.createTitledBorder("ACCIONES");
			bigPanel.setBorder(title);
			
			JPanel _botones = new JPanel();
			_botones.setLayout(new GridLayout(3,1));

				JPanel _botones1 = new JPanel();
				_botones1.setLayout(new FlowLayout());
				
					JButton usuarios = new JButton("USUARIOS");
					_botones1.add(usuarios);
					JButton establecimientos = new JButton("ESTABLECIMIENTOS");
					_botones1.add(establecimientos);	
					JButton alimentos = new JButton("ALIMENTOS");
					_botones1.add(alimentos);
					JButton gasolina = new JButton("GASOLINA");
					_botones1.add(gasolina);
					JButton descuentos = new JButton("DESCUENTOS");
					_botones1.add(descuentos);
				_botones.add(_botones1);
				
			bigPanel.add(_botones);
			
			JPanel _botonesESTPROD = new JPanel();
			_botonesESTPROD.setLayout(new GridLayout(3,1));

				JPanel _botonesR1 = new JPanel();
				_botonesR1.setLayout(new FlowLayout());
				
					JButton addESTPROD = new JButton("AÑADIR RELACION EST-PROD");
					_botonesR1.add(addESTPROD);
					JButton deleteESTPROD = new JButton("ELIMINAR RELACION EST-PROD");
					_botonesR1.add(deleteESTPROD);	
					JButton verESTPROD = new JButton("BUSCAR EST-PROD");
					_botonesR1.add(verESTPROD);
					JButton verAliEst = new JButton("BUSCAR ALI-EST");
					_botonesR1.add(verAliEst);
					JButton verGasEst = new JButton("BUSCAR GAS-EST");
					_botonesR1.add(verGasEst);	
				
				_botonesESTPROD.add(_botonesR1);
				
				
			bigPanel.add(_botonesESTPROD);
			
			JPanel _botonesUSRDESC= new JPanel();
			_botonesUSRDESC.setLayout(new GridLayout(3,1));

			JPanel _botonesR2 = new JPanel();
			_botonesR2.setLayout(new FlowLayout());
			
				JButton addUSRDESC = new JButton("AÑADIR RELACION USR-DESC");
				_botonesR2.add(addUSRDESC);
				JButton deleteUSRDESC = new JButton("ELIMINAR RELACION USR-DESC");
				_botonesR2.add(deleteUSRDESC);	
				JButton verUSRDESC = new JButton("BUSCAR USR-DESC");
				_botonesR2.add(verUSRDESC);
				
				
			_botonesUSRDESC.add(_botonesR2);
				
				
		
			bigPanel.add(_botonesUSRDESC, BorderLayout.EAST);
			_panelPrincipal.add(bigPanel, BorderLayout.CENTER);
				
				
				
				//Acciones:
				
				usuarios.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaU vistau = new VistaU(control);
					}
				});
				
				establecimientos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaE vistae = new VistaE(control);
						
					}
				});
				
				alimentos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaA vistaa = new VistaA(control);
					}
				});
				
				
				gasolina.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaG vistag = new VistaG(control);
					}
				});
				
				//RELACIONES EST-PROD:
				
				descuentos.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaD vistad = new VistaD(control);
					}
				});
				
				addESTPROD.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaRAdd1 vistaradd = new VistaRAdd1(control);
					}
				});
				
				deleteESTPROD.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaRDelete1 vistardelete = new VistaRDelete1(control);
					}
				});
				
				verESTPROD.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaRVer1 vistarver = new VistaRVer1(control);
					}
				});
				
				//RELACIONES USR-DESC:
				
				addUSRDESC.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaUAdd vistaUadd = new VistaUAdd(control);
					}
				});
				
				deleteUSRDESC.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaUDelete vistaUdelete = new VistaUDelete(control);
					}
				});
				
				verUSRDESC.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaUVer vistaUver = new VistaUVer(control);
					}
				});
				
				verAliEst.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaAVer vistaAVer = new VistaAVer(control);
					}
				});
				
				verGasEst.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						VistaGVer vistaGVer = new VistaGVer(control);
					}
				});
				
				
				
				this.pack();       //la ventana se ajusta a las componentes que contiene
				this.setVisible(true);    //La hacemos visible
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				
			}
			
}
