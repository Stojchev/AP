//package mk.ukim.finki.lab5.IntegerListTest;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//import java.util.stream.Collectors;
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
//        return (int) arrayList.stream().filter(integer -> integer.equals(el)).count();
//    }
//
//    public void removeDuplicates() {
//        for (int i = 0; i < arrayList.size(); i++) {
//            Integer integer = arrayList.get(i);
//            for (int j = 0; j < i; j++) {
//                if (integer.equals(arrayList.get(j))) {
//                    arrayList.remove(j);
//                    i--;
//                    break;
//                }
//            }
//        }
//    }
//
//    public boolean validateIndex(int index) {
//        if (index < 0 || index > arrayList.size()) {
//            throw new ArrayIndexOutOfBoundsException();
//        }
//        return true;
//    }
//
//    private int validateCount(int count) {
//        return Math.min(count, arrayList.size());
//    }
//
//    public int sumFirst(int count) {
//        count = validateCount(count);
//        return arrayList.stream().limit(count).mapToInt(Integer::valueOf).sum();
//    }
//
//    public int sumLast(int count) {
//        count = validateCount(count);
//        return (int) arrayList.stream().skip(arrayList.size() - count).mapToInt(Integer::valueOf).sum();
//    }
//
//    public void shiftRight(int index, int count) {
////        validateIndex(index);
////        int shiftIndex = (index + count) % arrayList.size();
////        Integer element = arrayList.remove(index);
////        arrayList.add(shiftIndex, element);
//        count=count%arrayList.size();
//        Integer temp = arrayList.get(index);
//        arrayList.remove(index);
//        int len = index + count ;
//        if (index + count > arrayList.size())
//            len -= arrayList.size()+1;
//        arrayList.add(len, temp);
//    }
//
//    public void shiftLeft(int index, int count) { validateIndex(index);
//
////        int shiftIndex = (index - count) % arrayList.size();
////        if (shiftIndex < 0) {
////            shiftIndex = arrayList.size() + shiftIndex;
////        }
////        Integer element = arrayList.remove(index);
////        arrayList.add(shiftIndex, element);
//        count=count%arrayList.size();
//        Integer temp = arrayList.get(index);
//        arrayList.remove(index);
//        int len = index - count;
//        if (len < 0)
//            len += arrayList.size()+1 ;
//        arrayList.add(len, temp);
//    }
//
//    public IntegerList addValue(int value) {
////        IntegerList integerList = new IntegerList();
////        for (int i = 0; i < this.arrayList.size(); i++) {
////            integerList.add(this.arrayList.get(i) + value, i);
////        }
////        return integerList;
//        return new IntegerList(
//                arrayList.stream()
//                        .map(objectInteger -> new Integer(objectInteger + value))
//                        .collect(Collectors.toCollection(ArrayList::new)) //.collect(Collectors.toList()))
//        );
//    }
//
//    IntegerList(List<Integer> list) {
//        this.arrayList = (ArrayList<Integer>) list;
//    }
//}
//
//public class IntegerListTest {
//
//    public static void main(String[] args) {
//        Scanner jin = new Scanner(System.in);
//        int k = jin.nextInt();
//        if (k == 0) { //test standard methods
//            int subtest = jin.nextInt();
//            if (subtest == 0) {
//                IntegerList list = new IntegerList();
//                while (true) {
//                    int num = jin.nextInt();
//                    if (num == 0) {
//                        list.add(jin.nextInt(), jin.nextInt());
//                    }
//                    if (num == 1) {
//                        list.remove(jin.nextInt());
//                    }
//                    if (num == 2) {
//                        print(list);
//                    }
//                    if (num == 3) {
//                        break;
//                    }
//                }
//            }
//            if (subtest == 1) {
//                int n = jin.nextInt();
//                Integer a[] = new Integer[n];
//                for (int i = 0; i < n; ++i) {
//                    a[i] = jin.nextInt();
//                }
//                IntegerList list = new IntegerList(a);
//                print(list);
//            }
//        }
//        if (k == 1) { //test count,remove duplicates, addValue
//            int n = jin.nextInt();
//            Integer a[] = new Integer[n];
//            for (int i = 0; i < n; ++i) {
//                a[i] = jin.nextInt();
//            }
//            IntegerList list = new IntegerList(a);
//            while (true) {
//                int num = jin.nextInt();
//                if (num == 0) { //count
//                    System.out.println(list.count(jin.nextInt()));
//                }
//                if (num == 1) {
//                    list.removeDuplicates();
//                }
//                if (num == 2) {
//                    print(list.addValue(jin.nextInt()));
//                }
//                if (num == 3) {
//                    list.add(jin.nextInt(), jin.nextInt());
//                }
//                if (num == 4) {
//                    print(list);
//                }
//                if (num == 5) {
//                    break;
//                }
//            }
//        }
//        if (k == 2) { //test shiftRight, shiftLeft, sumFirst, sumLast
//            int n = jin.nextInt();
//            Integer a[] = new Integer[n];
//            for (int i = 0; i < n; ++i) {
//                a[i] = jin.nextInt();
//            }
//            IntegerList list = new IntegerList(a);
//            while (true) {
//                int num = jin.nextInt();
//                if (num == 0) { //count
//                    list.shiftLeft(jin.nextInt(), jin.nextInt());
//                }
//                if (num == 1) {
//                    list.shiftRight(jin.nextInt(), jin.nextInt());
//                }
//                if (num == 2) {
//                    System.out.println(list.sumFirst(jin.nextInt()));
//                }
//                if (num == 3) {
//                    System.out.println(list.sumLast(jin.nextInt()));
//                }
//                if (num == 4) {
//                    print(list);
//                }
//                if (num == 5) {
//                    break;
//                }
//            }
//        }
//    }
//
//    public static void print(IntegerList il) {
//        if (il.size() == 0) System.out.print("EMPTY");
//        for (int i = 0; i < il.size(); ++i) {
//            if (i > 0) System.out.print(" ");
//            System.out.print(il.get(i));
//        }
//        System.out.println();
//    }
//
//}
