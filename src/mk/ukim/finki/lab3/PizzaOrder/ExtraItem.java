package mk.ukim.finki.lab3.PizzaOrder;

//public class ExtraItem implements Item {
//
//    ExtraType extraType;
//    private static int counterCoke = 0;
//    private static int counterKetchup = 0;
//
//    public ExtraItem(String type) throws InvalidExtraTypeException {
//        if (type.equals("Coke")) {
//            extraType = ExtraType.Coke;
//            counterCoke++;
//        } else if (type.equals("Ketchup")) {
//            extraType = ExtraType.Ketchup;
//            counterKetchup++;
//        } else throw new InvalidExtraTypeException();
//    }
//
//    public ExtraType getExtraType() {
//        return extraType;
//    }
//
//    public int getPriceByName(String type) {
//        if (type.equals("Coke"))
//            return 5;
//        if (type.equals("Ketchup"))
//            return 3;
//        else return 0;
//    }
//
//    @Override
//    public int getPrice() {
//        if (extraType.equals(ExtraType.Coke))
//            return 5;
//        else if (extraType.equals(ExtraType.Ketchup))
//            return 3;
//        else return 0;
//    }
//
//    @Override
//    public String getType() {
//        return extraType.name();
//    }
//}
