package mk.ukim.finki.lab5.IntegerListTest;

import java.util.*;
import java.util.stream.Collectors;
//
//public class IntegerList {
//    ArrayList<Integer> arrayList;
//
//    public IntegerList() {
//        this.arrayList = new ArrayList<>();
//    }
//
//    IntegerList(Integer... numbers) {
//        arrayList = new ArrayList<>(Arrays.asList(numbers));
//    }
//
//    public void add(int el, int idx) {
//        if (idx > arrayList.size()) {
//            int length = idx - arrayList.size();
//            for (int i = 0; i < length; i++) {
//                arrayList.add(0);
//            }
//            arrayList.add(el);
//        } else {
//            arrayList.add(idx, el);
//        }
//    }
//
//    public int remove(int index) {
//        return arrayList.remove(index);
//    }
//
//    public void set(int el, int idx) {
//        arrayList.set(idx, el);
//    }
//
//    public int get(int idx) {
//        return arrayList.get(idx);
//    }
//
//    public int size() {
//        return arrayList.size();
//    }
//
//    public int count(int el) {
//        int count = 0;
//        for (Integer integer : arrayList)
//            if (integer.equals(el))
//                count++;
//        return count;
//    }
//
//    public void removeDuplicates() {
//        for (int i = 0; i < arrayList.size(); i++) {
//            for (int j = i; j < arrayList.size(); i++) {
//                if (arrayList.get(i).equals(arrayList.get(j)))
//                    arrayList.remove(i--);
//            }
//        }
//    }
//
//    public int sumFirst(int k) {
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += arrayList.get(i);
//        }
//        return sum;
//    }
//
//    public int sumLast(int k) {
//        int sum = 0;
//        for (int i = k; i < arrayList.size(); i++) {
//            sum += arrayList.get(i);
//        }
//        return sum;
//    }
//
//    public void shiftRight(int idx, int k) {
//        Integer temp = arrayList.get(idx);
//        int len = idx + k + 1;
//        if (idx + k + 1 > arrayList.size())
//            len -= arrayList.size();
//        arrayList.add(len, temp);
//        arrayList.remove(idx);
//    }
//
//    public void shiftLeft(int idx, int k) {
//        Integer temp = arrayList.get(idx);
//        int len = idx - k;
//        if (len < 0)
//            len += arrayList.size() + 1;
//        arrayList.add(len, temp);
//        arrayList.remove(idx);
//    }
//
//    public IntegerList addValue(int value) {
//        return new IntegerList(
//                arrayList.stream()
//                        .map(objectInteger -> objectInteger + value)
//                        .collect(Collectors.toCollection(ArrayList::new)) //.collect(Collectors.toList()))
//        );
//    }
//
//    IntegerList(List<Integer> list) {
//        this.arrayList = (ArrayList<Integer>) list;
//    }
//}
