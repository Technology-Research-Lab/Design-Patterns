package spring.designpatterns.dom.iterator;

import java.util.Iterator;
import java.util.List;

public class LunchMenuIterator implements Iterator<Object> {

    List<MenuItem> menuItems;
    int position = 0;

    public LunchMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return menuItems.size() <= position || menuItems.get(position) == null;
    }

    @Override
    public Object next() {
        return menuItems.get(position++);
    }
}
