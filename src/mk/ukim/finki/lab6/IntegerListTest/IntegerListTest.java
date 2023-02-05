package mk.ukim.finki.lab6.IntegerListTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

class ArrayIndexOutOfBoundsException extends Exception {
}

class IntegerList {

    private LinkedList<Integer> list;

    public IntegerList(LinkedList<Integer> list) {
        this.list = list;
    }

    public IntegerList(Integer... numbers) {
        list = new LinkedList<>();
        list.addAll(Arrays.asList(numbers));
    }

    public void add(int el, int idx) throws ArrayIndexOutOfBoundsException {
        if (idx < 0)
            throw new ArrayIndexOutOfBoundsException();
        if (idx > list.size()) {
            int length = idx - list.size();
            for (int i = 0; i < length; i++) {
                list.add(0);
            }
            list.add(el);
        } else {
            list.add(idx, el);
        }
    }

    public void remove(int index) {
        list.remove(index);
    }

    public int size() {
        return list.size();
    }

    public int count(int element) {
        return (int) list.stream().filter(integer -> integer == element).count();
    }

    public void removeDuplicates() {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) == list.get(j)) {
                    list.remove(i);
                    i = -1;
                    j = list.size();
                }
            }
        }

    }

    public int sumFirst(int k) {
        k=Math.min(k,list.size());
        return list.stream().limit(k).mapToInt(Integer::valueOf).sum();
    }

    public int sumLast(int k) {
        k=Math.min(k,list.size());
        return list.stream().skip(k).mapToInt(Integer::valueOf).sum();
    }

    public IntegerList addValue(int value) throws ArrayIndexOutOfBoundsException {
        IntegerList tmp = new IntegerList();
        for (int i = 0; i < list.size(); i++) {
            tmp.add(list.get(i) + value, i);
        }
        return tmp;
    }

    public void shiftLeft(int index, int k) {
        k = k % list.size();
        int length = list.size() - k;
        if (length < 0)
            length += list.size();
        Integer tmp = list.get(index);
        list.remove(index);
        list.add(length, tmp);
    }

    public void shiftRight(int index, int k) {
        k = k % list.size();
        int length = list.size() - k;
        if (length >= list.size())
            length -= list.size();
        Integer tmp = list.get(index);
        list.remove(index);
        list.add(length, tmp);
    }

    public int get(int i) {
        return list.get(i);
    }
}

public class IntegerListTest {

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        Scanner jin = new Scanner(System.in);
        int k = jin.nextInt();
        if (k == 0) { //test standard methods
            int subtest = jin.nextInt();
            if (subtest == 0) {
                IntegerList list = new IntegerList();
                while (true) {
                    int num = jin.nextInt();
                    if (num == 0) {
                        list.add(jin.nextInt(), jin.nextInt());
                    }
                    if (num == 1) {
                        list.remove(jin.nextInt());
                    }
                    if (num == 2) {
                        print(list);
                    }
                    if (num == 3) {
                        break;
                    }
                }
            }
            if (subtest == 1) {
                int n = jin.nextInt();
                Integer a[] = new Integer[n];
                for (int i = 0; i < n; ++i) {
                    a[i] = jin.nextInt();
                }
                IntegerList list = new IntegerList(a);
                print(list);
            }
        }
        if (k == 1) { //test count,remove duplicates, addValue
            int n = jin.nextInt();
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; ++i) {
                a[i] = jin.nextInt();
            }
            IntegerList list = new IntegerList(a);
            while (true) {
                int num = jin.nextInt();
                if (num == 0) { //count
                    System.out.println(list.count(jin.nextInt()));
                }
                if (num == 1) {
                    list.removeDuplicates();
                }
                if (num == 2) {
                    print(list.addValue(jin.nextInt()));
                }
                if (num == 3) {
                    list.add(jin.nextInt(), jin.nextInt());
                }
                if (num == 4) {
                    print(list);
                }
                if (num == 5) {
                    break;
                }
            }
        }
        if (k == 2) { //test shiftRight, shiftLeft, sumFirst , sumLast
            int n = jin.nextInt();
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; ++i) {
                a[i] = jin.nextInt();
            }
            IntegerList list = new IntegerList(a);
            while (true) {
                int num = jin.nextInt();
                if (num == 0) { //count
                    list.shiftLeft(jin.nextInt(), jin.nextInt());
                }
                if (num == 1) {
                    list.shiftRight(jin.nextInt(), jin.nextInt());
                }
                if (num == 2) {
                    System.out.println(list.sumFirst(jin.nextInt()));
                }
                if (num == 3) {
                    System.out.println(list.sumLast(jin.nextInt()));
                }
                if (num == 4) {
                    print(list);
                }
                if (num == 5) {
                    break;
                }
            }
        }
    }

    public static void print(IntegerList il) {
        if (il.size() == 0) System.out.print("EMPTY");
        for (int i = 0; i < il.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(il.get(i));
        }
        System.out.println();
    }

}