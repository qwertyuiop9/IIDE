package File;

import java.util.Scanner;

public class KeyboardInputHandler {

    /**
     * @return the next number read from the keyboard
     */
    public static int getIntInputFromKeyboard() {

        Scanner keyboard_scanner = new Scanner(System.in);
        return keyboard_scanner.nextInt();

    }

    /**
     * @return a String catched from the keyboard
     */
    public static String getStringInputFromKeyboard() {

        Scanner keyboard_scanner = new Scanner(System.in);
        return keyboard_scanner.next();
    }

}
