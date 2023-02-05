package mk.ukim.finki.vtorKolokviumIspitni.ComponentTest;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

//public class Component {
//    private String color;
//    private int weight;
//    private Set<Component> componentSet;
//
//    public Component(String color, int weight) {
//        this.color = color;
//        this.weight = weight;
//        this.componentSet = new HashSet<>();
//    }
//
//    public void swap(String color, int weight) {
//        this.color = color;
//        this.weight = weight;
//    }
//
//    public void addComponent(Component component) {
//        componentSet.add(component);
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public int getWeight() {
//        return weight;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public String format(String crti) {
//        String s = String.format("%s%d:%s\n", crti, weight, color);
//        for (Component component : componentSet) {
//            s += component.format(crti + "---");
//        }
//        return s;
//    }
//
//    public void changeColor(int weight, String color) {
//        if (this.weight < weight)
//            this.color = color;
//        componentSet.forEach(component -> component.changeColor(weight, color));
//    }
//
//    @Override
//    public String toString() {
//        return format("");
//    }
//}
