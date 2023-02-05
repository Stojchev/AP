//package mk.ukim.finki.lab2.CirclesTest;
//
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MovablesCollection {
//    private List<Movable> movables;
//    public static int x_Max = 0;
//    public static int y_Max = 0;
//
//    public MovablesCollection(int x_Max, int y_Max) {
//        MovablesCollection.x_Max = x_Max;
//        MovablesCollection.y_Max = y_Max;
//        List<Movable> movables = new ArrayList<>();
//    }
//
//    void addMovableObject(Movable m) throws MovableObjectNotFittableException {
//
//        if (m.getType().equals("")) {
//            if (m.getCurrentXPosition() >= 0 && m.getCurrentXPosition() <= x_Max &&
//                    m.getCurrentYPosition() >= 0 && m.getCurrentYPosition() <= y_Max) {
//                movables.add(m);
//            } else
//                throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition(), m.getRadius());
//        } else if (m.getType().equals("MovingCircle")) {
//            if (m.getCurrentXPosition() - m.getRadius() >= 0 && m.getCurrentXPosition() + m.getRadius() <= x_Max &&
//                    m.getCurrentYPosition() - m.getRadius() >= 0 && m.getCurrentYPosition() + m.getRadius() <= y_Max)
//                movables.add(m);
//        } else
//            throw new MovableObjectNotFittableException(m.getCurrentXPosition(), m.getCurrentYPosition(), m.getRadius());
//    }
//
//    void moveObjectsFromTypeWithDirection(TYPE type, DIRECTION direction) {
//        if (type.equals(TYPE.CIRCLE)) {
//            for (int i = 0; i < movables.size(); i++) {
//                if (movables.get(i).getType().equals("MovingCircle")) {
//                    try {
//                        movables.set(i, movables.get(i).moveInDirection(direction.name()));
//                    } catch (ObjectCanNotBeMovedException e) {
//                        System.out.println(e.getMessage());
//                    }
//                }
//            }
//        }
//        if (type.equals(TYPE.POINT)) {
//            for (int i = 0; i < movables.size(); i++) {
//                if (movables.get(i).getType().equals("MovingPoint")) {
//                    try {
//                        movables.set(i, movables.get(i).moveInDirection(direction.name()));
//                    } catch (ObjectCanNotBeMovedException e) {
//                        System.out.println(e.getMessage());
//                        ;
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder("Collection of movable objects with size " + movables.size());
//        for (int i = 0; i < movables.size(); i++) {
//            str.append(movables.toString());
//        }
//        return str.toString();
//    }
//}
