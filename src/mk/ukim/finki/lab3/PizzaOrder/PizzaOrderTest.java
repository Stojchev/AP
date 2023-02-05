package mk.ukim.finki.lab3.PizzaOrder;

import java.util.ArrayList;
import java.util.Scanner;

enum PizzaType {
    Standard,
    Pepperoni,
    Vegetarian
}


class InvalidPizzaTypeException extends Exception {
    public InvalidPizzaTypeException() {
        super("InvalidPizzaTypeException");
    }
}

enum ExtraType {
    Coke,
    Ketchup
}

class InvalidExtraTypeException extends Exception {
    public InvalidExtraTypeException() {
        super("InvalidExtraTypeException");
    }
}

class ItemOutOfStockException extends Exception {
    public ItemOutOfStockException(int index) {
        super(index + " is out of bounds!");
    }
}

class ArrayIndexOutOfBоundsException extends Exception {
    public ArrayIndexOutOfBоundsException(int index) {
        super("ArrayIndexOutOfBоundsException");
    }
}

class OrderLockedException extends Exception {
    public OrderLockedException() {
        super("OrderLockedException");
    }
}

class EmptyOrderException extends Exception {
    public EmptyOrderException( ) {
        super("EmptyOrderException");
    }
}

class ExtraItem implements Item {

    ExtraType extraType;
    private static int counterCoke = 0;
    private static int counterKetchup = 0;

    public ExtraItem(String type) throws InvalidExtraTypeException {
        if (type.equals("Coke")) {
            extraType = ExtraType.Coke;
            counterCoke++;
        } else if (type.equals("Ketchup")) {
            extraType = ExtraType.Ketchup;
            counterKetchup++;
        } else throw new InvalidExtraTypeException();
    }

    public ExtraType getExtraType() {
        return extraType;
    }

    public int getPriceByName(String type) {
        if (type.equals("Coke"))
            return 5;
        if (type.equals("Ketchup"))
            return 3;
        else return 0;
    }

    @Override
    public int getPrice() {
        if (extraType.equals(ExtraType.Coke))
            return 5;
        else if (extraType.equals(ExtraType.Ketchup))
            return 3;
        else return 0;
    }

    @Override
    public String getType() {
        return extraType.name();
    }
}


class PizzaItem implements Item {

    PizzaType pizzaType;
    private static int counterStandard = 0;
    private static int counterPeperoni = 0;
    private static int counterVegetarian = 0;


    public PizzaItem(String type) throws InvalidPizzaTypeException {
        if (type.equals("Standard")) {
            pizzaType = PizzaType.Standard;
            counterStandard++;
        } else if (type.equals("Pepperoni")) {
            pizzaType = PizzaType.Pepperoni;
            counterPeperoni++;
        } else if (type.equals("Vegetarian")) {
            pizzaType = PizzaType.Vegetarian;
            counterVegetarian++;
        } else throw new InvalidPizzaTypeException();
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    @Override
    public int getPrice() {
        if (pizzaType.equals(PizzaType.Standard))
            return 10;
        if (pizzaType.equals(PizzaType.Pepperoni))
            return 12;
        if (pizzaType.equals(PizzaType.Vegetarian))
            return 8;
        else return 0;
    }

    public int getPriceByName(String type) {
        if (type.equals("Standard"))
            return 10;
        if (type.equals("Pepperoni"))
            return 12;
        if (type.equals("Vegetarian"))
            return 8;
        else return 0;
    }

    @Override
    public String getType() {
        return pizzaType.name();
    }
}


class Order {
    private ArrayList<Item> list = new ArrayList<>();

    int[] items = new int[7];
    String[] names = new String[7];
    Boolean isLocked = false;

    Order() {
        setListItemsToZero();
    }

    void addItem(Item item, int count) throws ItemOutOfStockException, OrderLockedException {
        if (isLocked)
            throw new OrderLockedException();
        if (count > 10) {
            throw new ItemOutOfStockException(count);
        }
        alreadyInOrder(item);
        for (int i = 0; i < count; i++) {
            list.add(item);
        }
    }

    void setListItems() {
        names = new String[]{"Standard", "Vegetarian", "Pepperoni", "Coke", "Ketchup"};
        for (Item item : list) {
            if (item.getType().equals("Standard")) {
                if (items[1] == 0)
                    items[0]++;
                items[1]++;
            } else if (item.getType().equals("Vegetarian")) {
                if (items[2] == 0)
                    items[0]++;
                items[2]++;
            } else if (item.getType().equals("Pepperoni")) {
                if (items[3] == 0)
                    items[0]++;
                items[3]++;
            } else if (item.getType().equals("Coke")) {
                if (items[4] == 0)
                    items[0]++;
                items[4]++;
            } else if (item.getType().equals("Ketchup")) {
                if (items[5] == 0)
                    items[0]++;
                items[5]++;
            }
        }
    }

    void removeItem(int index) throws ArrayIndexOutOfBоundsException, OrderLockedException {
        if (isLocked)
            throw new OrderLockedException();
        if (index < 0 || index > list.size())
            throw new ArrayIndexOutOfBоundsException(index);
        else {
            ArrayList<Item> tmp = new ArrayList<>();
            for (Item item : list) {
                if (!item.equals(list.get(index)))
                    tmp.add(item);
            }
            list.clear();
            list = tmp;
        }

    }

    public void alreadyInOrder(Item item) {
        ArrayList<Item> tmp=new ArrayList<>();
        for (Item item1 : list) {
            if (!item1.getType().equals(item.getType())){
                tmp.add(item1);
            }
        }
        list.clear();
        list=tmp;
    }

    void lock() throws EmptyOrderException {
        if (list.size() == 0)
            System.out.println("EmptyOrder");
        else this.isLocked = true;
    }

    int getPrice() {
        int sum = 0;
        for (Item item : list) {
            sum += item.getPrice();
        }
        return sum;
    }

    int countSameType(String string) {
        int count = 0;
        for (Item item : list) {
            if (item.getType().equals(string))
                count++;
        }
        return count;
    }

    public int getPriceByName(String type) {
        if (type.equals("Coke"))
            return 5;
        if (type.equals("Ketchup"))
            return 3;
        if (type.equals("Standard"))
            return 10;
        if (type.equals("Pepperoni"))
            return 12;
        if (type.equals("Vegetarian"))
            return 8;
        else return 0;
    }

    void displayOrder() {
        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 1; i <= 5; i++) {
//            int count = countSameType("Standard");
//            stringBuilder.append(String.format("%3d.%-15sx%2d%5d$\n", i + 1, list.get(i).getType(), 1, list.get(i).getPrice()));
//        }
        setListItems();
        int j = 1;
        for (int i = 1; i <= items[0]; i++) {
            if (items[i] != 0) {
                stringBuilder.append(String.format("%3d.%-15sx%2d%5d$\n", j, names[i - 1], items[i], getPriceByName(names[i - 1]) * items[i]));
                j++;
            }
        }
        stringBuilder.append(String.format("Total:%21d$", getPrice()));
        System.out.println(stringBuilder.toString());
        setListItemsToZero();
    }

    private void setListItemsToZero() {
        for (int i = 1; i < 6; i++) {
            items[i] = 0;
        }
        items[0] = 1;
    }

}


interface Item {
    public int getPrice();

    public String getType();
}

public class PizzaOrderTest {

    public static void main(String[] args) {
        Scanner jin = new Scanner(System.in);
        int k = jin.nextInt();
        if (k == 0) { //test Item
            try {
                String type = jin.next();
                String name = jin.next();
                Item item = null;
                if (type.equals("Pizza")) item = new PizzaItem(name);
                else item = new ExtraItem(name);
                System.out.println(item.getPrice());
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
        }
        if (k == 1) { // test simple order
            Order order = new Order();
            while (true) {
                try {
                    String type = jin.next();
                    String name = jin.next();
                    Item item = null;
                    if (type.equals("Pizza")) item = new PizzaItem(name);
                    else item = new ExtraItem(name);
                    if (!jin.hasNextInt()) break;
                    order.addItem(item, jin.nextInt());
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
            jin.next();
            System.out.println(order.getPrice());
            order.displayOrder();
            while (true) {
                try {
                    String type = jin.next();
                    String name = jin.next();
                    Item item = null;
                    if (type.equals("Pizza")) item = new PizzaItem(name);
                    else item = new ExtraItem(name);
                    if (!jin.hasNextInt()) break;
                    order.addItem(item, jin.nextInt());
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
            System.out.println(order.getPrice());
            order.displayOrder();
        }
        if (k == 2) { // test order with removing
            Order order = new Order();
            while (true) {
                try {
                    String type = jin.next();
                    String name = jin.next();
                    Item item = null;
                    if (type.equals("Pizza")) item = new PizzaItem(name);
                    else item = new ExtraItem(name);
                    if (!jin.hasNextInt()) break;
                    order.addItem(item, jin.nextInt());
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
            jin.next();
            System.out.println(order.getPrice());
            order.displayOrder();
            while (jin.hasNextInt()) {
                try {
                    int idx = jin.nextInt();
                    order.removeItem(idx);
                } catch (Exception e) {
                    System.out.println(e.getClass().getSimpleName());
                }
            }
            System.out.println(order.getPrice());
            order.displayOrder();
        }
        if (k == 3) { //test locking & exceptions
            Order order = new Order();
            try {
                order.lock();
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.addItem(new ExtraItem("Coke"), 1);
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.lock();
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
            try {
                order.removeItem(0);
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
        }
    }

}