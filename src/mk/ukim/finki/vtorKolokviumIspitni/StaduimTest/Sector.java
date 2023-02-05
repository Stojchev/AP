package mk.ukim.finki.vtorKolokviumIspitni.StaduimTest;

import java.util.HashMap;

//public class Sector {
//    String code;
//    HashMap<Integer, Integer> seats;
//    boolean firstCustomer;
//
//    public Sector(String code, int numberOfSeats) {
//        this.code = code;
//        this.seats = new HashMap<>();
//        for (int i = 1; i < numberOfSeats + 1; i++) {
//            seats.put(i, 4);
//        }
//        this.firstCustomer = true;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setSeat(int i, int type) {
//        seats.put(i, type);
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public int ifItContains() {
//        if (firstCustomer){
//            firstCustomer=false;
//            return 4;
//        }
//
//        for (int i = 1; i < seats.size() + 1; i++) {
//            if (seats.get(i).equals(1)) {
//                return 1;
//            }
//            if (seats.get(i).equals(2)) {
//                return 2;
//            }
//        }
//        return 0;
//    }
//
//    public int getTakenSeats(){
//        int count=0;
//        for (int i = 1; i < seats.size() + 1; i++){
//            if (!seats.get(i).equals(4)) {
//                count++;
//            }
//        }
//        return seats.size()-count;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s\t%d/%d\t%.1f%%", code, getTakenSeats(),seats.size(), 100-(getTakenSeats()  * 100.0f) / seats.size());
//    }
//}
