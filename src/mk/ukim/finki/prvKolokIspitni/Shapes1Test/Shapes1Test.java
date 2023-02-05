package mk.ukim.finki.prvKolokIspitni.Shapes1Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Shape {
    String id;
    ArrayList<String> list;

    public Shape() {
        this.list = new ArrayList<>();
    }

    public Shape(String name, String[] shapes) {
        this.list = new ArrayList<>();
        this.id = name;
        this.list.addAll(Arrays.asList(shapes));
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return list.size();
    }

    public int calculatePlostina() {
        int count = 0;
        for (String window : list) {
            count += Integer.parseInt(window);
        }
        return count * 4;
    }
}

class ShapesApplication {
    ArrayList<Shape> shapes;

    ShapesApplication() {
        this.shapes = new ArrayList<>();
    }

    public int readCanvases(InputStream in) {
        Scanner scanner = new Scanner(in);
        int count = 0;
        String line;
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            String[] windows = new String[lineSplit.length - 1];
            System.arraycopy(lineSplit, 1, windows, 0, lineSplit.length - 1);
            count += windows.length;
            String name = lineSplit[0];
            shapes.add(new Shape(name, windows));
        }
        return count;
    }

    public void printLargestCanvasTo(PrintStream out) {
        PrintWriter writer = new PrintWriter(out);
        writer.write(shapes.get(largetPerimeter()).getId() + " ");
        writer.write(shapes.get(largetPerimeter()).getSize() + " ");
        writer.write(shapes.get(largetPerimeter()).calculatePlostina() + "");
        writer.flush();
        writer.close();
    }

    public int largetPerimeter() {
        int flag = 0;
        for (int i = 1; i < shapes.size(); i++) {
            if (shapes.get(flag).calculatePlostina() < shapes.get(i).calculatePlostina()) {
                flag = i;
            }
        }
        return flag;
    }
}


public class Shapes1Test {

    public static void main(String[] args) {
        ShapesApplication shapesApplication = new ShapesApplication();

        System.out.println("===READING SQUARES FROM INPUT STREAM===");
        System.out.println(shapesApplication.readCanvases(System.in));
        System.out.println("===PRINTING LARGEST CANVAS TO OUTPUT STREAM===");
        shapesApplication.printLargestCanvasTo(System.out);

    }
}