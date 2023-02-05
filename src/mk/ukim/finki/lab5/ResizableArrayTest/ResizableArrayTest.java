package mk.ukim.finki.lab5.ResizableArrayTest;

import java.util.*;

class ResizableArray<T> {
    private T[] elements;
    private int size;
    private int count;

    public ResizableArray() {
        this.size = 10;
        this.count = 0;
        this.elements = (T[]) new Object[size];
    }

    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
        for (int i = 0; i < src.count; i++) {
            dest.addElement(src.elementAt(i));
        }
    }

    public void addElement(T element) {
        if (size == count) {
            size += 50;
            T[] temp = (T[]) new Object[size];
            for (int i = 0; i < count; i++) {
                temp[i] = elements[i];
            }
            elements = temp;
        }
        elements[count++] = element;
    }

    public boolean removeElement(T element) {
        int index = findElement(element);
        if (index == -1)
            return false;
        for (int i = index; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }
        count--;
        return true;
    }

    public int findElement(T element) {
        for (int i = 0; i < count; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return findElement(element) != -1;
    }

    public Object[] toArray() {
        return Arrays.stream(elements).toArray();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int count() {
        return count;
    }

    public T elementAt(int index) {
        if (index >= 0 && index < count()) {
            return elements[index];
        } else throw new ArrayIndexOutOfBoundsException();
    }
}

class IntegerArray extends ResizableArray<Integer> {

    public IntegerArray() {
        super();
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < count(); i++) {
            sum += elementAt(i);
        }
        return sum;
    }

    public double mean() {
        return sum() / count();
    }

    public int countNonZero() {
        int count = 0;
        for (int i = 0; i < count(); i++) {
            if (elementAt(i) != 0)
                count++;
        }
        return count;
    }

    public IntegerArray distinct() {
        IntegerArray ia = new IntegerArray();
        for (int i = 0; i < count(); i++) {
            if (ia.contains(this.elementAt(i)))
                continue;
            ia.addElement(this.elementAt(i));
        }
        return ia;
    }

    public IntegerArray increment(int offset) {
        IntegerArray ia = new IntegerArray();
        for (int i = 0; i < count(); i++) {
            ia.addElement(this.elementAt(i) + offset);
        }
        return ia;
    }
}

public class ResizableArrayTest {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        int test = jin.nextInt();
        if (test == 0) { //test ResizableArray on ints
            ResizableArray<Integer> a = new ResizableArray<Integer>();
            System.out.println(a.count());
            int first = jin.nextInt();
            a.addElement(first);
            System.out.println(a.count());
            int last = first;
            while (jin.hasNextInt()) {
                last = jin.nextInt();
                a.addElement(last);
            }
            System.out.println(a.count());
            System.out.println(a.contains(first));
            System.out.println(a.contains(last));
            System.out.println(a.removeElement(first));
            System.out.println(a.contains(first));
            System.out.println(a.count());
        }
        if (test == 1) { //test ResizableArray on strings
            ResizableArray<String> a = new ResizableArray<String>();
            System.out.println(a.count());
            String first = jin.next();
            a.addElement(first);
            System.out.println(a.count());
            String last = first;
            for (int i = 0; i < 4; ++i) {
                last = jin.next();
                a.addElement(last);
            }
            System.out.println(a.count());
            System.out.println(a.contains(first));
            System.out.println(a.contains(last));
            System.out.println(a.removeElement(first));
            System.out.println(a.contains(first));
            System.out.println(a.count());
            ResizableArray<String> b = new ResizableArray<String>();
            ResizableArray.copyAll(b, a);
            System.out.println(b.count());
            System.out.println(a.count());
            System.out.println(a.contains(first));
            System.out.println(a.contains(last));
            System.out.println(b.contains(first));
            System.out.println(b.contains(last));
            ResizableArray.copyAll(b, a);
            System.out.println(b.count());
            System.out.println(a.count());
            System.out.println(a.contains(first));
            System.out.println(a.contains(last));
            System.out.println(b.contains(first));
            System.out.println(b.contains(last));
            System.out.println(b.removeElement(first));
            System.out.println(b.contains(first));
            System.out.println(b.removeElement(first));
            System.out.println(b.contains(first));

            System.out.println(a.removeElement(first));
            ResizableArray.copyAll(b, a);
            System.out.println(b.count());
            System.out.println(a.count());
            System.out.println(a.contains(first));
            System.out.println(a.contains(last));
            System.out.println(b.contains(first));
            System.out.println(b.contains(last));
        }
        if (test == 2) { //test IntegerArray
            IntegerArray a = new IntegerArray();
            System.out.println(a.isEmpty());//1
            while (jin.hasNextInt()) {
                a.addElement(jin.nextInt());
            }
            jin.next();
            System.out.println(a.sum());//2
            System.out.println(a.mean());//3
            System.out.println(a.countNonZero());//4
            System.out.println(a.count());//5
            IntegerArray b = a.distinct();
            System.out.println(b.sum());//6
            IntegerArray c = a.increment(5);
            System.out.println(c.sum());//7
                ResizableArray.copyAll(a, b);
            System.out.println(a.sum());
            System.out.println(a.removeElement(jin.nextInt()));
            System.out.println(a.sum());
            System.out.println(a.removeElement(jin.nextInt()));
            System.out.println(a.sum());
            System.out.println(a.removeElement(jin.nextInt()));
            System.out.println(a.sum());
            System.out.println(a.contains(jin.nextInt()));
            System.out.println(a.contains(jin.nextInt()));
        }
        if (test == 3) { //test insanely large arrays
            LinkedList<ResizableArray<Integer>> resizable_arrays = new LinkedList<ResizableArray<Integer>>();
            for (int w = 0; w < 500; ++w) {
                ResizableArray<Integer> a = new ResizableArray<Integer>();
                int k = 2000;
                int t = 1000;
                for (int i = 0; i < k; ++i) {
                    a.addElement(i);
                }

                a.removeElement(0);
                for (int i = 0; i < t; ++i) {
                    a.removeElement(k - i - 1);
                }
                resizable_arrays.add(a);
            }
            System.out.println("You implementation finished in less then 3 seconds, well done!");
        }
    }

}
