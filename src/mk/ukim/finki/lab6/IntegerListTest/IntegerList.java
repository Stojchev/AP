package mk.ukim.finki.lab6.IntegerListTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//public class IntegerList {
//
//    private LinkedList<Integer> list;
//
//    public IntegerList(LinkedList<Integer> list) {
//        this.list = list;
//    }
//
//    public IntegerList(Integer... numbers) {
//        list = new LinkedList<>();
//        list.addAll(Arrays.asList(numbers));
//    }
//
//    public void add(int el, int index) throws ArrayIndexOutOfBoundsException {
//        if (index < 0)
//            throw new ArrayIndexOutOfBoundsException();
//        if (index > list.size()) {
//            for (int i = 0; i < index - list.size(); i++)
//                list.add(0);
//            list.add(el);
//        }
//        else{
//            list.add(index, el);
//        }
//    }
//
//    public void remove(int index) {
//        list.remove(index);
//    }
//
//    public int size() {
//        return list.size();
//    }
//
//    public int count(int element) {
//        return (int) list.stream().filter(integer -> integer == element).count();
//    }
//
//    public void removeDuplicates() {
//        list.stream().distinct().collect(Collectors.toList());
//    }
//
//    public int sumFirst(int k) {
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += list.get(i);
//        }
//        return sum;
//    }
//
//    public int sumLast(int k) {
//        int sum = 0;
//        for (int i = k; i < list.size(); i++) {
//            sum += list.get(i);
//        }
//        return sum;
//    }
//
//    public IntegerList addValue(int value) throws ArrayIndexOutOfBoundsException {
//        IntegerList tmp = new IntegerList();
//        for (int i = 0; i < list.size(); i++) {
//            tmp.add(list.get(i) + value, i);
//        }
//        return tmp;
//    }
//
//    public void shiftLeft(int index, int k) {
//        k = k % list.size();
//        int length = list.size() - k;
//        if (length < 0)
//            length += list.size();
//        Integer tmp = list.get(index);
//        list.remove(index);
//        list.add(length, tmp);
//    }
//
//    public void shiftRight(int index, int k) {
//        k = k % list.size();
//        int length = list.size() - k;
//        if (length >= list.size())
//            length -= list.size();
//        Integer tmp = list.get(index);
//        list.remove(index);
//        list.add(length, tmp);
//    }
//
//    public int get(int i) {
//        return list.get(i);
//    }
//}
