package Traitement;

import java.io.IOException;

public class ScreenEvent {
    

    public static void clear()
    {
            System.out.println("\033[H\033[2J");
            System.out.flush();


    }

    public static void  pauseScreen()
    {
        System.out.println("\nPress Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
