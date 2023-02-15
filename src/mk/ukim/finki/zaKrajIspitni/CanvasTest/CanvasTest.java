package mk.ukim.finki.zaKrajIspitni.CanvasTest;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class InvalidDimensionException extends Throwable {
    public String message() {
        return "Dimension 0 is not allowed!";
    }
}

class InvalidIDException extends Exception {

    public InvalidIDException() {
    }

    public String message(String id) {
        return "ID " + id + " is not valid";
    }
}

abstract class Shape {
    private char[] ID;

    public Shape(char[] ID) {
        this.ID = ID;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract double getRadius();

    public abstract void scaleShapes(double coef);

    public abstract double getSides(int n);

    public String getId() {
        return String.valueOf(ID);
    }

    public abstract String getType();

    public String toString() {
        if (getType().equals("Circle")) {
            //Circle -> Radius: 4.88 Area: 74.92 Perimeter: 30.68
            return String.format("Circle -> Radius: %.2f Area: %.2f Perimeter: %.2f", getRadius(), getArea(), getPerimeter());
        } else if (getType().equals("Rectangle")) {
            //Rectangle: -> Sides: 6.80, 7.63 Area: 51.86 Perimeter: 28.85
            return String.format("Rectangle: -> Sides: %.2f, %.2f Area: %.2f Perimeter: %.2f", getSides(1), getSides(2), getArea(), getPerimeter());
        } else {
            //Square: -> Side: 11.68 Area: 136.44 Perimeter: 46.72
            return String.format("Square: -> Side: %.2f Area: %.2f Perimeter: %.2f", getSides(1), getArea(), getPerimeter());
        }
    }

}

class Rectangle extends Shape {

    double side1;
    double side2;

    public Rectangle(char[] ID, double side1, double side2) {
        super(ID);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1 + side2);
    }

    @Override
    public double getRadius() {
        return 0;
    }

    @Override
    public void scaleShapes(double coef) {
        side1 *= coef;
        side2 *= coef;
    }

    @Override
    public double getSides(int n) {
        if (n == 1) return side1;
        else return side2;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }

}

class Square extends Shape {
    private double side;

    public Square(char[] ID, double side) {
        super(ID);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getRadius() {
        return 0;
    }

    @Override
    public void scaleShapes(double coef) {
        side *= coef;
    }

    @Override
    public double getSides(int n) {
        return side;
    }

    @Override
    public String getType() {
        return "Square";
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(char[] ID, double radius) {
        super(ID);
        this.radius = radius;
    }

    public Circle(char[] ID) {
        super(ID);
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public double getRadius() {
        return radius;
    }

    @Override
    public void scaleShapes(double coef) {
        radius *= coef;
    }

    @Override
    public double getSides(int n) {
        return 0;
    }

    @Override
    public String getType() {
        return "Circle";
    }

}

class Canvas {
    Set<Shape> shapes;

    public Canvas() {
        this.shapes = new TreeSet<>(Comparator.comparing(Shape::getArea));
    }

    public void readShapes(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String[] lineSPlit = scanner.nextLine().split(" ");
            //Circle!!!
            String ID = "";
            ID = lineSPlit[1];
            try {
                ID = checkForID(lineSPlit[1]);
            } catch (InvalidIDException e) {
                System.out.println(e.message(ID));
                continue;
            }
            if (lineSPlit[0].equals("1")) {
                if (lineSPlit[2].equals("0.0"))
                    try {
                        throw new InvalidDimensionException();
                    } catch (InvalidDimensionException e) {
                        System.out.println(e.message());
                        break;
                    }
                createCircle(ID, lineSPlit[2]);
            } else if (lineSPlit[0].equals("2")) {
                if (lineSPlit[2].equals("0.0"))
                    try {
                        throw new InvalidDimensionException();
                    } catch (InvalidDimensionException e) {
                        System.out.println(e.message());
                        break;
                    }
                createSquare(ID, lineSPlit[2]);
            } else if (lineSPlit[0].equals("3")) {
                if (lineSPlit[2].equals("0.0") || lineSPlit[3].equals("0.0"))
                    try {
                        throw new InvalidDimensionException();
                    } catch (InvalidDimensionException e) {
                        System.out.println(e.message());
                        break;
                    }
                createRectangle(ID, lineSPlit[2], lineSPlit[3]);
            }
//            switch (lineSPlit[0]) {
//                case "1" -> createCircle(ID, lineSPlit[2]);
//                case "2" -> createSquare(ID, lineSPlit[2]);
//                case "3" -> createRectangle(ID, lineSPlit[2], lineSPlit[3]);
//            }
        }
    }

    public void createCircle(String id, String radius) {
        shapes.add(new Circle(id.toCharArray(), Double.parseDouble(radius)));
    }

    public void createSquare(String id, String side) {
        shapes.add(new Square(id.toCharArray(), Double.parseDouble(side)));
    }

    public void createRectangle(String ID, String side1, String side2) {
        shapes.add(new Rectangle(ID.toCharArray(), Double.parseDouble(side1), Double.parseDouble(side2)));
    }

    public String checkForID(String ID) throws InvalidIDException {
        if (ID.replaceAll("[^a-zA-Z_0-9]", "").length() > 6 || ID.replaceAll("[^a-zA-Z_0-9]", "").length() == 0)
            throw new InvalidIDException();
        return ID.replaceAll("[^a-zA-Z_0-9]", "");
    }

    public void printAllShapes(PrintStream out) {
        shapes.forEach(System.out::println);
    }

    public void scaleShapes(String s, double v) {
        shapes.stream().filter(shape -> {
            return shape.getId().equals(s);
        }).forEach(i -> i.scaleShapes(v));
    }

    public void printByUserId(PrintStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        StringBuilder sb = new StringBuilder();
        Map<String, Set<Shape>> shapesByID = new TreeMap<>();
        Comparator<Map.Entry<String, Set<Shape>>> entryComparator
                = Comparator.comparing(entry -> {
            return entry.getValue().size();
        });
        shapes.forEach(shape -> {
            shapesByID.putIfAbsent(shape.getId(), new HashSet<>());
            shapesByID.get(shape.getId()).add(shape);
        });
        shapesByID.entrySet().stream().sorted(entryComparator.reversed().thenComparing(entry -> {
            return entry.getValue().stream().mapToDouble(Shape::getArea).sum();
        })).forEach(entry -> {
            sb.append("Shapes of user: ").append(entry.getKey()).append("\n");
            entry.getValue().stream().sorted(Comparator.comparing(Shape::getPerimeter)).forEach(shape -> {
                sb.append(shape.toString()).append("\n");
            });
        });
        writer.write(sb.toString());
        writer.flush();
    }

    public void statistics(PrintStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("count: %d", shapes.size()));
        sb.append(String.format("\nsum: %.2f", shapes.stream().mapToDouble(Shape::getArea).sum()));
        sb.append(String.format("\nmin: %.2f", shapes.stream().mapToDouble(Shape::getArea).min().getAsDouble()));
        sb.append(String.format("\naverage: %.2f", shapes.stream().mapToDouble(Shape::getArea).average().getAsDouble()));
        sb.append(String.format("\nmax: %.2f", shapes.stream().mapToDouble(Shape::getArea).max().getAsDouble()));
        writer.write(sb.toString());
        writer.flush();
    }
}

public class CanvasTest {

    public static void main(String[] args) throws IOException {
        Canvas canvas = new Canvas();

        System.out.println("READ SHAPES AND EXCEPTIONS TESTING");
        canvas.readShapes(System.in);

        System.out.println("BEFORE SCALING");
        canvas.printAllShapes(System.out);
        canvas.scaleShapes("123456", 1.5);
        System.out.println("AFTER SCALING");
        canvas.printAllShapes(System.out);

        System.out.println("PRINT BY USER ID TESTING");
        canvas.printByUserId(System.out);

        System.out.println("PRINT STATISTICS");
        canvas.statistics(System.out);
    }
}