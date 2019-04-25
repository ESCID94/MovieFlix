package control;

import gui.Menu;
import services.IServices;
import services.ServicesUser;
import utilities.LecturaDatos;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlMenu.
 *
 * @param <T> the generic type
 */
public class ControlMenu<T> {
	
	/** The services. */
	IServices <T> services = new ServicesUser<T>();

    /**
     * Open menu.
     */
    public void openMenu() {
        boolean contin = true;
        do {
            Menu.showMenu();
            contin = this.optionSelection();
        } while (contin);
        System.out.println("   --- Adiós muy buenas ---");
    }

    /**
     * Option selection.
     *
     * @return true, if successful
     */
    public boolean optionSelection() {

        boolean contin = true;

        try {
            switch (LecturaDatos.leerInt()) {
                case 1:
                    //ALTA DE UN USUARIO
                    services.add(null);
                    break;

                case 2:
                    //ELIMINAR UN USUARIO
                    services.drop(null);
                    break;

                case 3:
                    //MODIFICAR UN USUARIO
                    services.alter(null);
                    break;

                case 4:
                    //ALTA DE UNA PELICULA
                    services.add(null);
                    break;

                case 5:
                    //ELIMINAR UNA PELICULA
                    services.drop(null);
                    break;

                case 6:
                    //MODIFICAR UNA PELICULA
                    services.alter(null);
                    break;

                case 7:
                    //ALTA DE UNA CATEGORIA
                    services.add(null);
                    break;

                case 8:
                    //ELIMINAR UNA CATEGORIA
                    services.drop(null);
                    break;
                    
                case 9:
                    //MODIFICAR UNA CATEGORIA
                    services.alter(null);
                    break;
               

                case 0:
                    contin = salir();
                    break;
            }
        } catch (Exception e) {
            System.out.println("error: " + e.toString());
        }
        return contin;
    }

    /**
     * Salir.
     *
     * @return true, if successful
     * @throws Exception the exception
     */
    private boolean salir() throws Exception {
        String sino = LecturaDatos.leerString("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }


}
