package spring.designpatterns.dom.iterator;

import java.util.Iterator;

public class DinnerMenuIterator implements Iterator<Object> {
    MenuItem[] items;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return items.length > position && items[position] != null;
    }

    @Override
    public Object next() {
        return items[position++];
    }

    @Override
    public void remove() {


    }
}
