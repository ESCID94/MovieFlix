package control;

import gui.Menu;
import services.IServices;
import services.ServicesUser;
import utilities.LecturaDatos;

public class ControlMenu {
	
	IServices <?> services = new ServicesUser();

    public void openMenu() {
        boolean contin = true;
        do {
            Menu.showMenu();
            contin = this.optionSelection();
        } while (contin);
        System.out.println("   --- Adiós muy buenas ---");
    }

    public boolean optionSelection() {

        boolean contin = true;

        try {
            switch (LecturaDatos.leerInt()) {
                case 1:
                    //ALTA DE UN USUARIO
                    services.add();
                    break;

                case 2:
                    //ELIMINAR UN USUARIO
                    services.drop();
                    break;

                case 3:
                    //MODIFICAR UN USUARIO
                    services.alter();
                    break;

                case 4:
                    //ALTA DE UNA PELICULA
                    services.add();
                    break;

                case 5:
                    //ELIMINAR UNA PELICULA
                    services.drop();
                    break;

                case 6:
                    //MODIFICAR UNA PELICULA
                    services.alter();
                    break;

                case 7:
                    //ALTA DE UNA CATEGORIA
                    services.add();
                    break;

                case 8:
                    //ELIMINAR UNA CATEGORIA
                    services.drop();
                    break;
                    
                case 9:
                    //MODIFICAR UNA CATEGORIA
                    services.alter();
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

    private boolean salir() throws Exception {
        String sino = LecturaDatos.leerString("   ¿Está seguro?(S/N)");
        return (sino.toUpperCase().charAt(0) != 'S');
    }


}
