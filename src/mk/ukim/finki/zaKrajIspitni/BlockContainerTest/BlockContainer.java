package mk.ukim.finki.zaKrajIspitni.BlockContainerTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//public class BlockContainer<T extends Comparable<T>> {
//    int size;
//    List<Block<T>> blocks;
//    int count;
//
//    public BlockContainer(int size) {
//        this.size = size;
//        this.blocks = new ArrayList<>();
//    }
//
//    public void add(T element) {
//        if(blocks.size()==0)
//            blocks.add(new Block<>());
//        if (blocks.get(blocks.size() - 1).getSize() == size) {
//            blocks.add(new Block<>());
//        }
//        blocks.get(blocks.size() - 1).block.add(element);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        blocks.forEach(sb::append);
//        return sb.toString();
//    }
//
//    public void remove(T lastInteger) {
//        blocks.remove(blocks.get(blocks.size() - 1));
//    }
//
//    public void sort() {
//        ArrayList<T> el = new ArrayList<>();
//        blocks.forEach(blocks -> el.addAll(blocks.block));
//        el.sort(T::compareTo);
//        blocks.clear();
//        for(T element:el){
//            this.add(element);
//        }
//    }
//}
