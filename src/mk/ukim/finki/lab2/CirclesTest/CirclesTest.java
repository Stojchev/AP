package mk.ukim.finki.lab2.CirclesTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

enum TYPE {
    POINT,
    CIRCLE
}

enum DIRECTION {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class MovableObjectNotFittableException extends Exception {

    public MovableObjectNotFittableException(int x, int y, int r) {
        super(String.format("Movable circle with center (%d,%d) and radius %d can not be fitted into the collection", x, y, r));
    }
}

class MovablesCollection {
    private List<Movable> movables;
    public static int x_Max = 0;
    public static int y_Max = 0;

    public MovablesCollection(int x_Max, int y_Max) {
        MovablesCollection.x_Max = x_Max;
        MovablesCollection.y_Max = y_Max;
        this.movables = new ArrayList<>();
    }

    public static void setX_MAX(int i) {
        x_Max = i;
    }

    public static void setY_MAX(int i) {
        y_Max = i;
    }


    void addMovableObject(Movable m) throws MovableObjectNotFittableException {
        if (m.getType().equals("MovingPoint")) {
            if (m.getCurrentXPosition() >= 0 && m.getCurrentXPosition() <= x_Max
                    && m.getCurrentYPosition() >= 0 && m.getCurrentYPosition() <= y_Max) {
                movables.add(m);
            } else {
                throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition(), m.getRadius());
            }
        } else if (m.getType().equals("MovingCircle")) {
            if (m.getCurrentXPosition() - m.getRadius() >= 0 && m.getCurrentXPosition() + m.getRadius() <= x_Max &&
                    m.getCurrentYPosition() - m.getRadius() >= 0 && m.getCurrentYPosition() + m.getRadius() <= y_Max) {
                movables.add(m);
            }else{
                throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition(), m.getRadius());
            }
        }
    }

    void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
        if (type.equals(TYPE.CIRCLE)) {
            for (int i = 0; i < movables.size(); i++) {
                if (movables.get(i).getType().equals("MovingCircle")) {
                    try {
                        movables.set(i, movables.get(i).moveInDirection(direction.name()));
                    } catch (ObjectCanNotBeMovedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if (type.equals(TYPE.POINT)) {
            for (int i = 0; i < movables.size(); i++) {
                if (movables.get(i).getType().equals("MovingPoint")) {
                    try {
                        movables.set(i, movables.get(i).moveInDirection(direction.name()));
                    } catch (ObjectCanNotBeMovedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Collection of movable objects with size " + movables.size()+":");
        str.append("\n");
        for (int i = 0; i < movables.size(); i++) {
            str.append(movables.get(i).toString());
            str.append("\n");
        }
        return str.toString();
    }
}

class ObjectCanNotBeMovedException extends Exception {
    public ObjectCanNotBeMovedException(int x, int y) {
        super(String.format("Point (%d,%d) is out of bounds", x, y));
    }
}

interface Movable {
    public void moveUp() throws ObjectCanNotBeMovedException;

    public void moveDown() throws ObjectCanNotBeMovedException;

    public void moveRight() throws ObjectCanNotBeMovedException;

    public void moveLeft() throws ObjectCanNotBeMovedException;

    Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException;

    public int getCurrentXPosition();

    public int getCurrentYPosition();

    public String getType();

    int getRadius();
}

class MovablePoint implements Movable {
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;

    public MovablePoint() {
    }

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }


    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        if (y + ySpeed > MovablesCollection.x_Max)
            throw new ObjectCanNotBeMovedException(x, y + ySpeed);
        y = y + ySpeed;

    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        if (y - ySpeed < 0)
            throw new ObjectCanNotBeMovedException(x, y - ySpeed);
        y = y - ySpeed;
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        if (x + xSpeed > MovablesCollection.x_Max)
            throw new ObjectCanNotBeMovedException(x + xSpeed, y);
        x = x + xSpeed;
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        if (x - xSpeed < 0)
            throw new ObjectCanNotBeMovedException(x - xSpeed, y);
        x = x - xSpeed;
    }

    @Override
    public Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException {
        if (direction.equals("UP")) {
            moveUp();
        } else if (direction.equals("DOWN")) {
            moveDown();
        } else if (direction.equals("LEFT")) {
            moveLeft();
        } else if (direction.equals("RIGHT")) {
            moveRight();
        }
        return this;
    }

    @Override
    public int getCurrentXPosition() {
        return x;
    }

    @Override
    public int getCurrentYPosition() {
        return y;
    }

    @Override
    public String getType() {
        return "MovingPoint";
    }

    @Override
    public int getRadius() {
        return 0;
    }

    @Override
    public String toString() {
        return "Movable point with coordinates (" + x + "," + y + ")";
    }
}

class MovableCircle implements Movable {

    private int radius;
    MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    @Override
    public void moveUp() throws ObjectCanNotBeMovedException {
        center.moveUp();
    }

    @Override
    public void moveDown() throws ObjectCanNotBeMovedException {
        center.moveDown();
    }

    @Override
    public void moveRight() throws ObjectCanNotBeMovedException {
        center.moveRight();
    }

    @Override
    public void moveLeft() throws ObjectCanNotBeMovedException {
        center.moveLeft();
    }

    @Override
    public Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException {
        if (direction.equals("UP")) {
            moveUp();
        } else if (direction.equals("DOWN")) {
            moveDown();
        } else if (direction.equals("LEFT")) {
            moveLeft();
        } else if (direction.equals("RIGHT")) {
            moveRight();
        }
        return this;
    }

    @Override
    public int getCurrentXPosition() {
        return center.getCurrentXPosition();
    }

    @Override
    public int getCurrentYPosition() {
        return center.getCurrentYPosition();
    }

    @Override
    public String getType() {
        return "MovingCircle";
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Movable circle with center coordinates (" + center.getCurrentXPosition() + "," + center.getCurrentYPosition() + ") and radius " + radius;
    }
}

public class CirclesTest {
    public static void main(String[] args) throws ObjectCanNotBeMovedException {

        System.out.println("===COLLECTION CONSTRUCTOR AND ADD METHOD TEST===");
        MovablesCollection collection = new MovablesCollection(100, 100);
        Scanner sc = new Scanner(System.in);
        int samples = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < samples; i++) {
            String inputLine = sc.nextLine();
            String[] parts = inputLine.split(" ");

            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            int xSpeed = Integer.parseInt(parts[3]);
            int ySpeed = Integer.parseInt(parts[4]);

            if (Integer.parseInt(parts[0]) == 0) { //point
                try {
                    collection.addMovableObject(new MovablePoint(x, y, xSpeed, ySpeed));
                } catch (MovableObjectNotFittableException e) {
                    System.out.println(e.getMessage());
                }
            } else { //circle
                int radius = Integer.parseInt(parts[5]);
                try {
                    collection.addMovableObject(new MovableCircle(radius, new MovablePoint(x, y, xSpeed, ySpeed)));
                } catch (MovableObjectNotFittableException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        System.out.println(collection.toString());

        System.out.println("MOVE POINTS TO THE LEFT");

        collection.moveObjectsFromTypeWithDirection(TYPE.POINT, DIRECTION.LEFT);

        System.out.println(collection.toString());

        System.out.println("MOVE CIRCLES DOWN");
        collection.moveObjectsFromTypeWithDirection(TYPE.CIRCLE, DIRECTION.DOWN);
        System.out.println(collection.toString());

        System.out.println("CHANGE X_MAX AND Y_MAX");
        MovablesCollection.setX_MAX(90);
        MovablesCollection.setY_MAX(90);

        System.out.println("MOVE POINTS TO THE RIGHT");
        collection.moveObjectsFromTypeWithDirection(TYPE.POINT, DIRECTION.RIGHT);
        System.out.println(collection.toString());

        System.out.println("MOVE CIRCLES UP");
        collection.moveObjectsFromTypeWithDirection(TYPE.CIRCLE, DIRECTION.UP);
        System.out.println(collection.toString());

    }

}
