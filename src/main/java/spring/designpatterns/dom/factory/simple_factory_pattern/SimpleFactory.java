package spring.designpatterns.dom.factory.simple_factory_pattern;

class SimpleFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ProductA();
        } else if (type.equals("B")) {
            return new ProductB();
        }
        return null;
    }
}

interface Product {
    void use();
}

class ProductA implements Product {
    public void use() {
        System.out.println("Using Product A");
    }
}

class ProductB implements Product {
    public void use() {
        System.out.println("Using Product B");
    }
}
