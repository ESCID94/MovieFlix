package GasAndFood.interfaz.vistaDescuento;

import GasAndFood.interfaz.controlador.Controlador;
import GasAndFood.interfaz.controlador.Evento;

import java.io.IOException;

import javax.swing.JFrame;

public class VistaDLeerTodo extends JFrame {

	private Controlador control;

	public VistaDLeerTodo(Controlador controlador) {
		// TODO Apéndice de constructor generado automáticamente
		control = controlador;
		try {
			control.accion(Evento.LEER_TODO_DESCUENTO, 0);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
