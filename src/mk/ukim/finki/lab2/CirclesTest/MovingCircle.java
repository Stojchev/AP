//package mk.ukim.finki.lab2.CirclesTest;
//
//public class MovingCircle implements Movable {
//
//    private int radius;
//    MovingPoint center;
//
//    public MovingCircle(int radius, MovingPoint center) {
//        this.radius = radius;
//        this.center = center;
//    }
//
//    @Override
//    public void moveUp() {
//
//    }
//
//    @Override
//    public void moveDown() {
//
//    }
//
//    @Override
//    public void moveRight() {
//
//    }
//
//    @Override
//    public void moveLeft() {
//
//    }
//
//    @Override
//    public Movable moveInDirection(String direction) throws ObjectCanNotBeMovedException {
//        if (direction.equals("UP")) {
//            moveUp();
//        } else if (direction.equals("DOWN")) {
//            moveDown();
//        } else if (direction.equals("LEFT")) {
//            moveLeft();
//        } else if (direction.equals("RIGHT")) {
//            moveRight();
//        }
//        return this;
//    }
//
//    @Override
//    public int getCurrentXPosition() {
//        return 0;
//    }
//
//    @Override
//    public int getCurrentYPosition() {
//        return 0;
//    }
//
//    @Override
//    public String getType() {
//        return "MovingCircle";
//    }
//
//    public int getRadius() {
//        return radius;
//    }
//
//    public void setRadius(int radius) {
//        this.radius = radius;
//    }
//
//    @Override
//    public String toString() {
//        return "Movable circle with center coordinates " + center.getCurrentXPosition() + "," + center.getCurrentYPosition() + ") and radius" + radius;
//    }
//}
