package mk.ukim.finki.vtorKolokviumIspitni.ComponentTest;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

//public class Window {
//    private String name;
//    private Map<Integer, Component> componentsByID;
//
//    public Window(String name) {
//        this.name = name;
//        this.componentsByID = new TreeMap<>();
//    }
//
//    public void addComponent(int position, Component component) throws InvalidPositionException {
//        if (componentsByID.containsKey(position))
//            throw new InvalidPositionException(position);
//        componentsByID.put(position, component);
//    }
//
//    public void changeColor(int weight, String color) {
//        componentsByID.values().forEach(component -> component.changeColor(weight, color));
//    }
//
//    public void swichComponents(int pos1, int pos2) {
//        Component tmp = componentsByID.get(pos1);
//        componentsByID.put(pos1, componentsByID.get(pos2));
//        componentsByID.put(pos2, tmp);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("WINDOW " + name + "\n");
//        componentsByID.entrySet().forEach(entry -> sb.append(entry.getKey() + ":" + entry.getValue()));
//        return sb.toString();
//    }
//}
