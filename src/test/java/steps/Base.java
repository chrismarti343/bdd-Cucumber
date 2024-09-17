package steps;

import org.fusesource.jansi.Ansi;

public class Base {

    public static void colorGreen(String text){
        System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a(text).reset());
    }
}
