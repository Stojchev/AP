package mk.ukim.finki.prvKolokIspitni.Shapes1Test;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.LinkedList;
import java.util.Scanner;

//public class ShapesApplication {
//    LinkedList<Shape> shapes;
//
//    ShapesApplication() {
//        this.shapes = new LinkedList<>();
//    }
//
//    public int readCanvases(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        int count = 0;
//        String line;
//        while (scanner.hasNext()) {
//            line = scanner.nextLine();
//            String[] lineSplit = line.split(" ");
//            String[] windows = new String[lineSplit.length - 1];
//            System.arraycopy(lineSplit, 1, windows, 0, lineSplit.length - 1);
//            count += windows.length;
//            String name = lineSplit[0];
//            shapes.add(new Shape(name, windows));
//        }
//        return count;
//    }
//
//    public void printLargestCanvasTo(PrintStream out) {
//        PrintWriter writer = new PrintWriter(out);
//        writer.write(shapes.get(0).getId());
//        writer.write(shapes.get(0).calculatePlostina());
//    }
//}
//
