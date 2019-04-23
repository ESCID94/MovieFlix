package GasAndFood.interfaz.vistaEstablecimiento;

import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.io.IOException;

import javax.swing.JFrame;

public class VistaELeerTodo extends JFrame {

	private Controlador control;

	public VistaELeerTodo(Controlador controlador) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		control = controlador;
		try {
			control.accion(Evento.LEER_TODO_ESTABLECIMIENTO, 0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
