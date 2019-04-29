package control;

import gui.Menu;
import model.Catalog;
import model.Movie;
import model.Subscription;
import model.User;
import model.Watchlist;
import services.IServices;
import services.ServicesImp;
import utilities.ReadData;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlMenu.
 *
 * @param <T> the generic type
 */
public class ControlMenu {
	
	
	
    /**
     * Open menu.
     */
    public static void openMenu() {
        boolean contin = true;
        do {
            Menu.showMenu();
            contin = optionSelection();
        } while (contin);
        System.out.println("   --- Adiós muy buenas ---");
    }

    /**
     * Option selection.
     *
     * @return true, if successful
     */
    public static <T> boolean optionSelection() {
    	/** The services. */
    	ServicesImp<T> services = new ServicesImp<T>();
    	
    	User user = new User();
    	Movie movie = new Movie();
    	Catalog catalog = new Catalog();
    	Subscription sub = new Subscription();
    	Watchlist watchlist = new Watchlist();
    	
        boolean contin = true;
       
        try {
            switch (ReadData.leerInt()) {
                case 1:
                    //ALTA DE UN USUARIO
                    services.add((T) user);
                    break;

                case 2:
                    //ELIMINAR UN USUARIO
                    services.drop((T) user);
                    break;

                case 3:
                    //MODIFICAR UN USUARIO
                    services.update((T) user);
                    break;

                case 4:
                    //ALTA DE UNA PELICULA
                    services.add((T) movie);
                    break;

                case 5:
                    //ELIMINAR UNA PELICULA
                    services.drop((T) movie);
                    break;

                case 6:
                    //MODIFICAR UNA PELICULA
                    services.update((T) movie);
                    break;

                case 7:
                    //ALTA DE UNA SUBSCRIPCION
                    services.add((T) sub);
                    break;

                case 8:
                    //ELIMINAR UNA SUBSCRIPCION
                    services.drop((T) sub);
                    break;
                    
                case 9:
                    //MODIFICAR UNA SUBSCRIPCION
                    services.update((T) sub);
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
    private static boolean salir() throws Exception {
        String sino = ReadData.leerString("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }


}
