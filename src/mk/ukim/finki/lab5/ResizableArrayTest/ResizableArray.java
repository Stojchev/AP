package mk.ukim.finki.lab5.ResizableArrayTest;

import java.lang.reflect.Array;
import java.util.Arrays;

//public class ResizableArray<T> {
//    private T[] elements;
//    private int size;
//    private int count;
//
//    public ResizableArray() {
//        this.size = 10;
//        this.count = 0;
//        this.elements = (T[]) new Object[size];
//    }
//
//    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src) {
//        for (int i = 0; i < src.count; i++) {
//            dest.addElement(src.elementAt(i));
//        }
//    }
//
//    public void addElement(T element) {
//        if (size == count) {
//            size *= 2;
//            T[] tmp = (T[]) new Object[size];
//            System.arraycopy(elements, 0, tmp, 0, count);
//            elements = tmp;
//        }
//        elements[count++] = element;
//    }
//
//    public boolean removeElement(T element) {
//        int index = findElement(element);
//        if (index == -1)
//            return false;
//        for (int i = index; i < count - 1; i++) {
//            elements[i] = elements[i + 1];
//        }
//        count--;
//        return true;
//    }
//
//    public int findElement(T element) {
//        for (int i = 0; i < count; i++) {
//            if (elements[i].equals(element)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public boolean contains(T element) {
//        return findElement(element) != -1;
//    }
//
//    public Object[] toArray() {
//        return Arrays.stream(elements).toArray();
//    }
//
//    public boolean isEmpty() {
//        return count == 0;
//    }
//
//    public int count() {
//        return count;
//    }
//
//    public T elementAt(int index) {
//        if (index >= 0 && index < count()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//        return elements[index];
//    }
//}
