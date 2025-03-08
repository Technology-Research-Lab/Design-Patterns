package spring.designpatterns.dom.decorator.util.input;

import java.util.Scanner;

public class FileScanner {
    public String scan() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
