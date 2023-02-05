//package mk.ukim.finki.lab2.ContactsTester;
//
//public class PhoneContact extends Contact {
//
//    Operator operator;
//    String phoneNumber;
//
//    public PhoneContact(String date, String phoneNumber) {
//        super(date);
//        this.phoneNumber = phoneNumber;
//        switch (phoneNumber.charAt(2)) {
//            case '1':
//                this.operator = Operator.TMOBILE;
//            case '2':
//                this.operator = Operator.TMOBILE;
//            case '3':
//                this.operator = Operator.TMOBILE;
//            case '5':
//                this.operator = Operator.ONE;
//            case '6':
//                this.operator = Operator.ONE;
//            case '7':
//                this.operator = Operator.VIP;
//            case '8':
//                this.operator = Operator.VIP;
//        }
//    }
//
//    public String getPhone() {
//        return phoneNumber;
//    }
//
//    public Operator getOperator() {
//        return operator;
//    }
//
//    @Override
//    public String getType() {
//        return "Phone";
//    }
//
//    @Override
//    public String toString() {
//        return phoneNumber;
//    }
//}
