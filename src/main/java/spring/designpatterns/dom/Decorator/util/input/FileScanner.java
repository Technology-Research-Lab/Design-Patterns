package spring.designpatterns.dom.Decorator.util.input;

import java.util.Scanner;

public class FileScanner {
    public static String scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
