package spring.designpatterns.dom.iterator;

import lombok.Getter;

@Getter
public class MenuItem {
    private String name;
    private String description;
    private double cost;
    private boolean isVegetarian;

    public MenuItem(String name, String description, double cost, boolean isVegetarian) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.isVegetarian = isVegetarian;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", isVegetarian=" + isVegetarian +
                '}';
    }
}
