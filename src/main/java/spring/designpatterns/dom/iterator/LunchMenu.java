package spring.designpatterns.dom.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LunchMenu implements Menu{
    List<MenuItem> menuItems;

    public LunchMenu() {
        this.menuItems = new ArrayList<>();

        addItem("BLT", "맛없음",  2.99, true);
        addItem("채식주의", "그럭저럭",  2.99, true);
        addItem("고기", "돈많으면 사셈",  4.99, false);
        addItem("핫도그", "명량보다나음",  5.99, false);
    }

    public void addItem(String name, String description, double price, boolean vegetarian) {
        menuItems.add(new MenuItem(name, description, price, vegetarian));
    }

    @Override
    public Iterator<MenuItem> getMenu(){
        return menuItems.iterator();
    }

}
