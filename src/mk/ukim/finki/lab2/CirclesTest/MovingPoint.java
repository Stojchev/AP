//package mk.ukim.finki.lab2.CirclesTest;
//
//public class MovingPoint implements Movable {
//    private int x;
//    private int y;
//    private int xSpeed;
//    private int ySpeed;
//
//    public MovingPoint(int x, int y, int xSpeed, int ySpeed) {
//        this.x = x;
//        this.y = y;
//        this.xSpeed = xSpeed;
//        this.ySpeed = ySpeed;
//    }
//
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
//        return x;
//    }
//
//    @Override
//    public int getCurrentYPosition() {
//        return y;
//    }
//
//    @Override
//    public String getType() {
//        return "MovingPoint";
//    }
//
//    @Override
//    public int getRadius() {
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        return "Movable point with coordinates (" + x + "," + y + ")";
//    }
//}
