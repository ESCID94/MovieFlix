package GasAndFood.interfaz.vistaGasolina;

import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.io.IOException;

import javax.swing.JFrame;

public class VistaGLeerTodo extends JFrame {

	private Controlador control;

	public VistaGLeerTodo(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
		try {
			control.accion(Evento.LEER_TODO_GASOLINA, 0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
