package mk.ukim.finki.lab5.ResizableArrayTest;

//public class IntegerArray extends ResizableArray<Integer> {
//
//    public IntegerArray() {
//        super();
//    }
//
//    public double sum() {
//        double sum = 0;
//        for (int i = 0; i < count(); i++) {
//            sum += elementAt(i);
//        }
//        return sum;
//    }
//
//    public double mean() {
//        return sum() / count();
//    }
//
//    public int countNonZero() {
//        int count = 0;
//        for (int i = 0; i < count(); i++) {
//            if (elementAt(i) != 0)
//                count++;
//        }
//        return count;
//    }
//
//    public IntegerArray distinct() {
//        IntegerArray ia = new IntegerArray();
//        for (int i = 0; i < count(); i++) {
//            if (ia.contains(this.elementAt(i)))
//                continue;
//            ia.addElement(this.elementAt(i));
//        }
//        return ia;
//    }
//    public IntegerArray increment(int offset){
//        IntegerArray ia = new IntegerArray();
//        for (int i = 0; i < count(); i++) {
//            if (ia.contains(this.elementAt(i)))
//                continue;
//            ia.addElement(this.elementAt(i)+offset);
//        }
//        return ia;
//    }
//}
