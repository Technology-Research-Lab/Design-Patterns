package spring.designpatterns.dom.iterator;

import java.util.Iterator;

public class Waitress {
    private final DinnerMenu dinnerMenu;
    private final LunchMenu lunchMenu;

    public Waitress(DinnerMenu dinnerMenu, LunchMenu lunchMenu) {
        this.dinnerMenu = dinnerMenu;
        this.lunchMenu = lunchMenu;
    }

    public void printMenu(){
        Iterator<Object> dinner = dinnerMenu.getMenu();
        Iterator<MenuItem> lunch = lunchMenu.getMenu();

        System.out.println(dinner.next());
        System.out.println(lunch.next());
    }
}
