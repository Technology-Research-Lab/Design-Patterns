package spring.designpatterns.dom.template.comparable;

import java.util.Arrays;

public class DuckSortTestDrive {
    public static void main(String[] args) {
        Duck[] ducks = {
                new Duck("Daffy1", 2),
                new Duck("Daffy2", 1),
                new Duck("Daffy3", 6),
                new Duck("Daffy4", 4)
        };

        System.out.println("정렬 전");
        display(ducks);

        Arrays.sort(ducks);

        System.out.println("정렬 후");
        display(ducks);

    }

    private static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}
