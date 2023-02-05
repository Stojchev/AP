package mk.ukim.finki.vtorKolokviumIspitni.StaduimTest;

import java.util.*;

class SeatTakenException extends Exception {
    public SeatTakenException() {
        super("SeatTakenException");
    }
}

class SeatNotAllowedException extends Exception {
    public SeatNotAllowedException() {
        super("SeatTakenException");
    }
}

class Stadium {
    private String name;
    private Set<Sector> sectors;

    public Stadium(String name) {
        this.name = name;
        this.sectors = new TreeSet<>(Comparator.comparing(Sector::getCode));
    }

    public void createSectors(String[] sectorNames, int[] sizes) {
        for (int i = 0; i < sectorNames.length; i++) {
            sectors.add(new Sector(sectorNames[i], sizes[i]));
        }
    }

    public void buyTicket(String part, int seat, int type) throws SeatNotAllowedException, SeatTakenException {
        for (Sector s : sectors) {
            if (Objects.equals(s.code, part)) {
                if (s.seats.get(seat) != 4) {
                    throw new SeatTakenException();
                }
                if (type != 0) {
                    int flag = s.ifItContains();
                    if (flag != 4 && flag != type)
                        throw new SeatNotAllowedException();
                }
                s.setSeat(seat, type);
            }
        }
    }

    public void showSectors() {
        sectors.stream().sorted(Comparator.comparing(Sector::getTakenSeats).reversed().thenComparing(Sector::getCode)).
                forEach(i -> System.out.println(i.toString()));
    }
}

class Sector {
    String code;
    HashMap<Integer, Integer> seats;
    boolean firstCustomer;

    public Sector(String code, int numberOfSeats) {
        this.code = code;
        this.seats = new HashMap<>();
        for (int i = 1; i < numberOfSeats + 1; i++) {
            seats.put(i, 4);
        }
        this.firstCustomer = true;
    }

    public String getCode() {
        return code;
    }

    public void setSeat(int i, int type) {
        seats.put(i, type);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int ifItContains() {
        if (firstCustomer) {
            firstCustomer = false;
            return 4;
        }

        for (int i = 1; i < seats.size() + 1; i++) {
            if (seats.get(i).equals(1)) {
                return 1;
            }
            if (seats.get(i).equals(2)) {
                return 2;
            }
        }
        return 0;
    }

    public int getTakenSeats() {
        int count = 0;
        for (int i = 1; i < seats.size() + 1; i++) {
            if (!seats.get(i).equals(4)) {
                count++;
            }
        }
        return seats.size() - count;
    }

    @Override
    public String toString() {
        return String.format("%s\t%d/%d\t%.1f%%", code, getTakenSeats(), seats.size(), 100 - (getTakenSeats() * 100.0f) / seats.size());
    }
}

public class StaduimTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] sectorNames = new String[n];
        int[] sectorSizes = new int[n];
        String name = scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            sectorNames[i] = parts[0];
            sectorSizes[i] = Integer.parseInt(parts[1]);
        }
        Stadium stadium = new Stadium(name);
        stadium.createSectors(sectorNames, sectorSizes);
        n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            try {
                stadium.buyTicket(parts[0], Integer.parseInt(parts[1]),
                        Integer.parseInt(parts[2]));
            } catch (SeatNotAllowedException e) {
                System.out.println("SeatNotAllowedException");
            } catch (SeatTakenException e) {
                System.out.println("SeatTakenException");
            }
        }
        stadium.showSectors();
    }
}
