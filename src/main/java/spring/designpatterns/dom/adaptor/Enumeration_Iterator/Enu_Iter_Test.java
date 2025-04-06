package spring.designpatterns.dom.adaptor.Enumeration_Iterator;

import java.util.*;

public class Enu_Iter_Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("1","2","3","4"));
        Enumeration<String> enumeration = Collections.enumeration(list);
        Iterator<String> iterator = list.iterator();

        testEnumeration(enumeration);
        testIterator(iterator);
    }

    public static <T> void testEnumeration(Enumeration<T> enumeration) {
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement() + " ");
        }
        System.out.println();
    }
    public static <T> Iterator<T> testIterator(Iterator<T> iterator) {
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        return iterator;
    }
}
