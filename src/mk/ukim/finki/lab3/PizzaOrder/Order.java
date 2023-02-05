package mk.ukim.finki.lab3.PizzaOrder;

import java.util.ArrayList;

//public class Order {
//    private ArrayList<Item> list = new ArrayList<>();
//
//    int[] items = new int[7];
//    String[] names = new String[7];
//    Boolean isLocked = false;
//
//    Order() {
//        setListItemsToZero();
//    }
//
//    void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
//        if (isLocked)
//            throw new OrderLockedException();
//        if (count > 10) {
//            throw new ItemOutOfStockException(count);
//        }
//        alreadyInOrder(item);
//        for (int i = 0; i < count; i++) {
//            list.add(item);
//        }
//    }
//
//    void setListItems() {
//        names = new String[]{"Standard", "Vegetarian", "Pepperoni", "Coke", "Ketchup"};
//        for (Item item : list) {
//            if (item.getType().equals("Standard")) {
//                if (items[1] == 0)
//                    items[0]++;
//                items[1]++;
//            } else if (item.getType().equals("Vegetarian")) {
//                if (items[2] == 0)
//                    items[0]++;
//                items[2]++;
//            } else if (item.getType().equals("Pepperoni")) {
//                if (items[3] == 0)
//                    items[0]++;
//                items[3]++;
//            } else if (item.getType().equals("Coke")) {
//                if (items[4] == 0)
//                    items[0]++;
//                items[4]++;
//            } else if (item.getType().equals("Ketchup")) {
//                if (items[5] == 0)
//                    items[0]++;
//                items[5]++;
//            }
//        }
//    }
//
//    void removeItem(int index) throws ArrayIndexOutOfBоundsException, OrderLockedException {
//        if (isLocked)
//            throw new OrderLockedException();
//        if (index < 0 || index > list.size())
//            throw new ArrayIndexOutOfBоundsException(index);
//        else list.remove(index);
//    }
//
//    public void alreadyInOrder(Item item) {
//        for (Item item1 : list) {
//            if (item1.getType().equals(item.getType()))
//                list.remove(item1);
//        }
//    }
//
//    void lock() throws EmptyOrderException {
//        if (list.size() == 0)
//            throw new EmptyOrderException();
//        else this.isLocked = true;
//    }
//
//    int getPrice() {
//        int sum = 0;
//        for (Item item : list) {
//            sum += item.getPrice();
//        }
//        return sum;
//    }
//
//    int countSameType(String string) {
//        int count = 0;
//        for (Item item : list) {
//            if (item.getType().equals(string))
//                count++;
//        }
//        return count;
//    }
//
//    public int getPriceByName(String type) {
//        if (type.equals("Coke"))
//            return 5;
//        if (type.equals("Ketchup"))
//            return 3;
//        if (type.equals("Standard"))
//            return 10;
//        if (type.equals("Pepperoni"))
//            return 12;
//        if (type.equals("Vegetarian"))
//            return 8;
//        else return 0;
//    }
//
//    void displayOrder() {
//        StringBuilder stringBuilder = new StringBuilder();
////        for (int i = 1; i <= 5; i++) {
////            int count = countSameType("Standard");
////            stringBuilder.append(String.format("%3d.%-15sx%2d%5d$\n", i + 1, list.get(i).getType(), 1, list.get(i).getPrice()));
////        }
//        setListItems();
//        int j = 1;
//        for (int i = 1; i <= items[0]; i++) {
//            if (items[i] != 0) {
//                stringBuilder.append(String.format("%3d.%-15sx%2d%5d$\n", j, names[i - 1], items[i], getPriceByName(names[i - 1]) * items[i]));
//                j++;
//            }
//        }
//        stringBuilder.append(String.format("Total:%21d$", getPrice()));
//        System.out.println(stringBuilder.toString());
//        setListItemsToZero();
//    }
//
//    private void setListItemsToZero() {
//        for (int i = 1; i < 6; i++) {
//            items[i] = 0;
//        }
//        items[0] = 1;
//    }
//
//}
