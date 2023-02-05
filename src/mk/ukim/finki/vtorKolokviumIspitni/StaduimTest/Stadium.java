package mk.ukim.finki.vtorKolokviumIspitni.StaduimTest;

import java.util.*;

//public class Stadium {
//    private String name;
//    private Set<Sector> sectors;
//
//    public Stadium(String name) {
//        this.name = name;
//        this.sectors = new TreeSet<>(Comparator.comparing(Sector::getCode));
//    }
//
//    public void createSectors(String[] sectorNames, int[] sizes) {
//        for (int i = 0; i < sectorNames.length; i++) {
//            sectors.add(new Sector(sectorNames[i], sizes[i]));
//        }
//    }
//
//    public void buyTicket(String part, int seat, int type) throws SeatNotAllowedException, SeatTakenException {
//        for (Sector s : sectors) {
//            if (Objects.equals(s.code, part)) {
//                if (s.seats.get(seat) != 4) {
//                    throw new SeatTakenException();
//                }
//                if (type != 0) {
//                    int flag = s.ifItContains();
//                    if (flag != 4 && flag != type)
//                        throw new SeatNotAllowedException();
//                }
//                s.setSeat(seat, type);
//            }
//        }
//    }
//
//    public void showSectors() {
//        sectors.stream().sorted(Comparator.comparing(Sector::getTakenSeats).reversed().thenComparing(Sector::getCode)).
//                forEach(i -> System.out.println(i.toString()));
//    }
//}
