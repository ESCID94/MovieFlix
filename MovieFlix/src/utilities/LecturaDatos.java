package utilities;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class LecturaDatos.
 *
 * @author Antonio
 */
public class LecturaDatos {

    /**
     * Leer string.
     *
     * @return the string
     */
    public static String leerString() {
        return new Scanner(System.in).nextLine();
    }

    /**
     * Leer string.
     *
     * @param msg the msg
     * @return the string
     */
    public static String leerString(String msg) {
        System.out.println(msg);
        return leerString();
    }

    /**
     * Leer int.
     *
     * @return the int
     */
    public static int leerInt() {
        return new Scanner(System.in).nextInt();
    }
    
        /**
         * Leer int.
         *
         * @param msg the msg
         * @return the int
         */
        public static int leerInt(String msg) {
        System.out.println(msg);
        return leerInt();
    }

}
