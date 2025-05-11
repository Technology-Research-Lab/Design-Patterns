package spring.designpatterns.dom.iterator;


import lombok.Getter;

import java.util.Iterator;

@Getter
public class DinnerMenu implements Menu{
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu() {
        this.menuItems = new MenuItem[MAX_ITEMS];

        menuItems[0] = addItem("BLT", "맛없음",  2.99, true);
        menuItems[1] = addItem("채식주의", "그럭저럭",  2.99, true);
        menuItems[2] = addItem("고기", "돈많으면 사셈",  4.99, false);
        menuItems[3] = addItem("핫도그", "명량보다나음",  5.99, false);
    }

    public MenuItem addItem(String name, String description, double price, boolean vegetarian) {
        return new MenuItem(name, description, price, vegetarian);
    }

    @Override
    public Iterator<Object> getMenu(){
        return new DinnerMenuIterator(menuItems);
    }

}
