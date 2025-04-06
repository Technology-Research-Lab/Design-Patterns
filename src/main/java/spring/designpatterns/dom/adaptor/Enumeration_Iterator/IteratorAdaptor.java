package spring.designpatterns.dom.adaptor.Enumeration_Iterator;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdaptor<T> implements Iterator<T> {
    Enumeration<T> enumeration;

    public IteratorAdaptor(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
