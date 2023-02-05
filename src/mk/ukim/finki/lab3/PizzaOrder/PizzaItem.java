package mk.ukim.finki.lab3.PizzaOrder;

//public class PizzaItem implements Item {
//
//    PizzaType pizzaType;
//    private static int counterStandard = 0;
//    private static int counterPeperoni = 0;
//    private static int counterVegetarian = 0;
//
//
//    public PizzaItem(String type) throws InvalidPizzaTypeException {
//        if (type.equals("Standard")) {
//            pizzaType = PizzaType.Standard;
//            counterStandard++;
//        } else if (type.equals("Pepperoni")) {
//            pizzaType = PizzaType.Pepperoni;
//            counterPeperoni++;
//        } else if (type.equals("Vegetarian")) {
//            pizzaType = PizzaType.Vegetarian;
//            counterVegetarian++;
//        } else throw new InvalidPizzaTypeException();
//    }
//
//    public PizzaType getPizzaType() {
//        return pizzaType;
//    }
//
//    @Override
//    public int getPrice() {
//        if (pizzaType.equals(PizzaType.Standard))
//            return 10;
//        if (pizzaType.equals(PizzaType.Pepperoni))
//            return 12;
//        if (pizzaType.equals(PizzaType.Vegetarian))
//            return 8;
//        else return 0;
//    }
//    public int getPriceByName(String type){
//        if (type.equals("Standard"))
//            return 10;
//        if (type.equals("Pepperoni"))
//            return 12;
//        if (type.equals("Vegetarian"))
//            return 8;
//        else return 0;
//    }
//    @Override
//    public String getType() {
//        return pizzaType.name();
//    }
//}
