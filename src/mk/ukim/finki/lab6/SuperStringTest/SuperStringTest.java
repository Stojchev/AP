package mk.ukim.finki.lab6.SuperStringTest;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class SuperString {
    LinkedList<StringOrder> list;

    public SuperString() {
        this.list = new LinkedList<StringOrder>();
    }

    public void append(String next) {
        list.add(new StringOrder(next, list.size()));
    }

    public void insert(String next) {
        list.add(0, new StringOrder(next, list.size()));
    }

    public boolean contains(String next) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            str.append(list.get(i).getStr());
        return str.toString().contains(next);
    }

    public void reverse() {
        Collections.reverse(list);
        StringBuilder str = new StringBuilder();
        int n;
        for (int i = 0; i < list.size(); i++) {
            str= new StringBuilder(list.get(i).getStr());
            n=list.get(i).getN();
            list.remove(i);
            list.add(i, new StringOrder(String.valueOf(str.reverse()),n));
        }
    }

    public void removeLast(int nextInt) {
        int flag = list.size()-1;
        int count = 0;
        for (int i = 0; i < list.size() && count < nextInt; i++) {
            if (list.get(i).getN() == flag) {
                list.remove(i);
                count++;
                flag--;
                i=-1;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        Iterator<StringOrder> it = this.list.iterator();
        while (it.hasNext())
            s += it.next();
        return s;
    }
}

class StringOrder {
    String str;
    int n;

    StringOrder(String str, int n) {
        this.str = str;
        this.n = n;
    }

    public String getStr() {
        return str;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return str.toString();
    }
}

public class SuperStringTest {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        int k = jin.nextInt();
        if (k == 0) {
            SuperString s = new SuperString();
            while (true) {
                int command = jin.nextInt();
                if (command == 0) {//append(String s)
                    s.append(jin.next());
                }
                if (command == 1) {//insert(String s)
                    s.insert(jin.next());
                }
                if (command == 2) {//contains(String s)
                    System.out.println(s.contains(jin.next()));
                }
                if (command == 3) {//reverse()
                    s.reverse();
                }
                if (command == 4) {//toString()
                    System.out.println(s);
                }
                if (command == 5) {//removeLast(int k)
                    s.removeLast(jin.nextInt());
                }
                if (command == 6) {//end
                    break;
                }
            }
        }
    }

}
