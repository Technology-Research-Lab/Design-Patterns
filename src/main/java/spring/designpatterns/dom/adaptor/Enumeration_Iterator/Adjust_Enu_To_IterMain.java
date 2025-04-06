package spring.designpatterns.dom.adaptor.Enumeration_Iterator;

import java.util.*;

public class Adjust_Enu_To_IterMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4"));

        Iterator<String> iterator = list.iterator();
        Enu_Iter_Test.testIterator(iterator);

        Enumeration<String> enumeration = Collections.enumeration(list);
        IteratorAdaptor<String> iteratorAdaptor = new IteratorAdaptor<>(enumeration);
        Enu_Iter_Test.testIterator(iteratorAdaptor);

    }
}
