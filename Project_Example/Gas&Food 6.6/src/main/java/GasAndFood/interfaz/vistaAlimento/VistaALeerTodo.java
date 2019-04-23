package GasAndFood.interfaz.vistaAlimento;

import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.io.IOException;

import javax.swing.JFrame;

public class VistaALeerTodo extends JFrame {

	private Controlador control;

	public VistaALeerTodo(Controlador controlador) {
		// TODO Ap�ndice de constructor generado autom�ticamente
		control = controlador;
		try {
			control.accion(Evento.LEER_TODO_ALIMENTO, 0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
