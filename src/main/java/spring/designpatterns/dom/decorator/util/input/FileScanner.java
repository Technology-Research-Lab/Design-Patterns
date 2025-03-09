package spring.designpatterns.dom.decorator.util.input;

import java.util.Scanner;

/**
 * 이름 : 스캐너
 * 역할 : 사용자의 글을 입력받는 역할
 */

public class FileScanner {
    public String scan() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        return input;
    }
}
