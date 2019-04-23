package GasAndFood.Launcher;

import GasAndFood.business.Factorias.FactoriaBussines;
import GasAndFood.interfaz.Vista;
import GasAndFood.interfaz.controlador.Controlador;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FactoriaBussines modelo = FactoriaBussines.getInstance();
        Controlador controlador = new Controlador(modelo);
        Vista vista = new Vista(controlador);
    }
}
