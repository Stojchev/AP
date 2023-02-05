package mk.ukim.finki.vtorKolokviumIspitni.ComponentTest;

import java.util.*;

class InvalidPositionException extends Exception {
    public InvalidPositionException(int position) {
        super(String.format("Invalid position %d, alredy taken!", position));
    }
}

class Window {
    private String name;
    private Map<Integer, Component> componentsByID;

    public Window(String name) {
        this.name = name;
        this.componentsByID = new TreeMap<>();
    }

    public void addComponent(int position, Component component) throws InvalidPositionException {
        if (componentsByID.containsKey(position))
            throw new InvalidPositionException(position);
        componentsByID.put(position, component);
    }

    public void changeColor(int weight, String color) {
        componentsByID.values().forEach(component -> component.changeColor(weight, color));
    }

    public void swichComponents(int pos1, int pos2) {
        Component tmp = componentsByID.get(pos1);
        componentsByID.put(pos1, componentsByID.get(pos2));
        componentsByID.put(pos2, tmp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WINDOW " + name + "\n");
        componentsByID.entrySet().forEach(entry -> sb.append(entry.getKey() + ":" + entry.getValue()));
        return sb.toString();
    }
}

class Component {
    private String color;
    private int weight;
    private Set<Component> componentSet;

    public Component(String color, int weight) {
        this.color = color;
        this.weight = weight;
        this.componentSet = new HashSet<>();
    }

    public void swap(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public void addComponent(Component component) {
        componentSet.add(component);
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String format(String crti) {
        String s = String.format("%s%d:%s\n", crti, weight, color);
        for (Component component : componentSet) {
            s += component.format(crti + "---");
        }
        return s;
    }

    public void changeColor(int weight, String color) {
        if (this.weight < weight)
            this.color = color;
        componentSet.forEach(component -> component.changeColor(weight, color));
    }

    @Override
    public String toString() {
        return format("");
    }
}

public class ComponentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Window window = new Window(name);
        Component prev = null;
        while (true) {
            try {
                int what = scanner.nextInt();
                scanner.nextLine();
                if (what == 0) {
                    int position = scanner.nextInt();
                    window.addComponent(position, prev);
                } else if (what == 1) {
                    String color = scanner.nextLine();
                    int weight = scanner.nextInt();
                    Component component = new Component(color, weight);
                    prev = component;
                } else if (what == 2) {
                    String color = scanner.nextLine();
                    int weight = scanner.nextInt();
                    Component component = new Component(color, weight);
                    prev.addComponent(component);
                    prev = component;
                } else if (what == 3) {
                    String color = scanner.nextLine();
                    int weight = scanner.nextInt();
                    Component component = new Component(color, weight);
                    prev.addComponent(component);
                } else if (what == 4) {
                    break;
                }

            } catch (InvalidPositionException e) {
                System.out.println(e.getMessage());
            }
            scanner.nextLine();
        }

        System.out.println("=== ORIGINAL WINDOW ===");
        System.out.println(window);
        int weight = scanner.nextInt();
        scanner.nextLine();
        String color = scanner.nextLine();
        window.changeColor(weight, color);
        System.out.println(String.format("=== CHANGED COLOR (%d, %s) ===", weight, color));
        System.out.println(window);
        int pos1 = scanner.nextInt();
        int pos2 = scanner.nextInt();
        System.out.println(String.format("=== SWITCHED COMPONENTS %d <-> %d ===", pos1, pos2));
        window.swichComponents(pos1, pos2);
        System.out.println(window);
    }
}

// вашиот код овде