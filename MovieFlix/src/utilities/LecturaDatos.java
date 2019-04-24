package utilities;

import java.util.Scanner;

/**
 *
 * @author Antonio
 */
public class LecturaDatos {

    public static String leerString() {
        return new Scanner(System.in).nextLine();
    }

    public static String leerString(String msg) {
        System.out.println(msg);
        return leerString();
    }

    public static int leerInt() {
        return new Scanner(System.in).nextInt();
    }
    
        public static int leerInt(String msg) {
        System.out.println(msg);
        return leerInt();
    }

}
