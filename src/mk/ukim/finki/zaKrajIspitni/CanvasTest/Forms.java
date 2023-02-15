package mk.ukim.finki.zaKrajIspitni.CanvasTest;

import java.util.HashSet;
import java.util.Set;

public class Forms {
    Set<Shape> shapeSet;

    public Forms() {
        this.shapeSet = new HashSet<>();
    }
    public void addShape(Shape shape){
        this.shapeSet.add(shape);
    }
}
