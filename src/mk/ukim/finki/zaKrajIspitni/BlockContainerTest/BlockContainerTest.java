package mk.ukim.finki.zaKrajIspitni.BlockContainerTest;

import java.util.*;

class Block<T extends Comparable<T>> {
    public Set<T> block;

    public Block() {
        this.block = new TreeSet<>();
    }

    public void add(T element) {
        block.add(element);
    }

    public int getSize() {
        return block.size();
    }

    @Override
    public String toString() {
        return block.toString();
    }
}

class BlockContainer<T extends Comparable<T>> {
    int size;
    List<Block<T>> blocks;
    int count;

    public BlockContainer(int size) {
        this.size = size;
        this.blocks = new ArrayList<>();
    }

    public void add(T element) {
        if (blocks.size() == 0)
            blocks.add(new Block<>());
        if (blocks.get(blocks.size() - 1).getSize() == size) {
            blocks.add(new Block<>());
        }
        blocks.get(blocks.size() - 1).block.add(element);
    }


    public void remove(T lastInteger) {
        blocks.get(blocks.size()-1).block.remove(lastInteger);
        if(blocks.get(blocks.size()-1).getSize()==0)
            blocks.remove(blocks.size()-1);
    }

    public void sort() {
        ArrayList<T> el = new ArrayList<>();
        blocks.forEach(blocks -> el.addAll(blocks.block));
        el.sort(T::compareTo);
        blocks.clear();
        for (T element : el) {
            this.add(element);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        blocks.forEach(i->sb.append(i).append(','));
        return sb.substring(0,sb.length()-1);
    }
}


public class BlockContainerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = scanner.nextInt();
        BlockContainer<Integer> integerBC = new BlockContainer<Integer>(size);
        scanner.nextLine();
        Integer lastInteger = null;
        for (int i = 0; i < n; ++i) {
            int element = scanner.nextInt();
            lastInteger = element;
            integerBC.add(element);
        }
        System.out.println("+++++ Integer Block Container +++++");
        System.out.println(integerBC);
        System.out.println("+++++ Removing element +++++");
        integerBC.remove(lastInteger);
        System.out.println("+++++ Sorting container +++++");
        integerBC.sort();
        System.out.println(integerBC);
        BlockContainer<String> stringBC = new BlockContainer<String>(size);
        String lastString = null;
        for (int i = 0; i < n; ++i) {
            String element = scanner.next();
            lastString = element;
            stringBC.add(element);
        }
        System.out.println("+++++ String Block Container +++++");
        System.out.println(stringBC);
        System.out.println("+++++ Removing element +++++");
        stringBC.remove(lastString);
        System.out.println("+++++ Sorting container +++++");
        stringBC.sort();
        System.out.println(stringBC);
    }
}


