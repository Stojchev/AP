package mk.ukim.finki.zaKrajIspitni.CanvasTest;

import java.io.*;
import java.util.*;

//public class Canvas {
//    Set<Shape> shapes;
//
//    public Canvas() {
//        this.shapes = new TreeSet<>(Comparator.comparing(Shape::getPerimeter));
//    }
//
//    public void readShapes(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        while (scanner.hasNextLine()) {
//            String[] lineSPlit = scanner.nextLine().split(" ");
//            //Circle!!!
//            String ID = "";
//            try {
//                ID = checkForID(lineSPlit[1]);
//            } catch (InvalidIDException e) {
//                System.out.println(e.getMessage());
//                continue;
//            }
//            switch (lineSPlit[0]) {
//                case "1" -> createCircle(ID, lineSPlit[2]);
//                case "2" -> createSquare(ID, lineSPlit[2]);
//                case "3" -> createRectangle(ID, lineSPlit[2], lineSPlit[3]);
//            }
//        }
//    }
//
//    public void createCircle(String id, String radius) {
//        shapes.add(new Circle(id.toCharArray(), Double.parseDouble(radius)));
//    }
//
//    public void createSquare(String id, String side) {
//        shapes.add(new Square(id.toCharArray(), Double.parseDouble(side)));
//    }
//
//    public void createRectangle(String ID, String side1, String side2) {
//        shapes.add(new Rectangle(ID.toCharArray(), Double.parseDouble(side1), Double.parseDouble(side2)));
//    }
//
//    public String checkForID(String ID) throws InvalidIDException {
//        if (ID.length() > 6)
//            throw new InvalidIDException();
//        return ID.replaceAll("[^a-zA-Z_0-9]", "");
//    }
//
//    public void printAllShapes(PrintStream out) {
//        shapes.forEach(System.out::println);
//    }
//
//    public void scaleShapes(String s, double v) {
//        shapes.stream().filter(shape -> {
//            return shape.getId().equals(s);
//        }).forEach(i -> i.scaleShapes(v));
//    }
//
//    public void printByUserId(PrintStream out) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
//        StringBuilder sb = new StringBuilder();
//        Map<String, Set<Shape>> shapesByID = new TreeMap<>();
//        shapes.forEach(shape -> {
//            shapesByID.putIfAbsent(shape.getId(), new HashSet<>());
//            shapesByID.get(shape.getId()).add(shape);
//        });
//        shapesByID.keySet().forEach(ID -> {
//            sb.append("Shapes of user:").append(ID).append("\n");
//            shapesByID.get(ID).stream().filter(shape -> shape.getId().equals(ID))
//                    .forEach(i -> sb.append(i).append("\n"));
//        });
//        writer.write(sb.toString());
//        writer.flush();
//    }
//
//    public void statistics(PrintStream out) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("count: %d", shapes.size()));
//        sb.append(String.format("\nsum: %.2f", shapes.stream().mapToDouble(Shape::getArea).sum()));
//        sb.append(String.format("\nmin: %.2f",shapes.stream().mapToDouble(Shape::getArea).min().getAsDouble()));
//        sb.append(String.format("\naverage: %.2f", shapes.stream().mapToDouble(Shape::getArea).average().getAsDouble()));
//        sb.append(String.format("\nmax: %.2f", shapes.stream().mapToDouble(Shape::getArea).max().getAsDouble()));
//        writer.write(sb.toString());
//        writer.flush();
//    }
//}
