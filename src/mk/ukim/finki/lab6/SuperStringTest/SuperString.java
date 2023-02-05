package mk.ukim.finki.lab6.SuperStringTest;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

//public class SuperString {
//    LinkedList<String> list;
//
//    public SuperString() {
//        this.list = new LinkedList<>();
//    }
//
//    public void append(String next) {
//        list.add(next);
//    }
//
//    public void insert(String next) {
//        list.add(0, next);
//    }
//
//    public boolean contains(String next) {
//        StringBuilder str = new StringBuilder();
//        for (String str1 : list) {
//            str.append(str1);
//        }
//        return str.toString().contains(next);
//    }
//
//    public void reverse() {
//        Collections.reverse(list);
//        StringBuilder str=new StringBuilder();
//        for(int i=0;i<list.size();i++){
//            str= new StringBuilder(list.get(i));
//            list.remove(i);
//            list.add(i, String.valueOf(str.reverse()));
//        }
//    }
//
//    public void removeLast(int nextInt) {
//        for(int i=0;i<nextInt;i++){
//            list.removeLast();
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder str=new StringBuilder();
//        for(String str1:list)
//            str.append(list.toString());
//        return str.toString();
//    }
//}
