package spring.designpatterns.dom.iterator;

public class MenuTestDrive {
    public static void main(String[] args) {
        DinnerMenu dinnerMenu = new DinnerMenu();
        LunchMenu lunchMenu = new LunchMenu();
        Waitress waitress = new Waitress(dinnerMenu, lunchMenu);

        waitress.printMenu();

    }
}
