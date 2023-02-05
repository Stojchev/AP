package mk.ukim.finki.vtorKolokviumIspitni.AuditionTest;

import java.util.*;

class Candidate implements Comparator<Candidate> {
    String code;
    String name;
    int age;

    public Candidate(String code, String name, int age) {
        this.code = code;
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compare(Candidate o1, Candidate o2) {
        if (o1.getName().equals(o2.getName()))
            return Integer.compare(o1.getAge(), o2.getAge());
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", code, name, age);
    }
}

class Audition {
    Map<String, Set<Candidate>> candidatsByCity;

    public Audition() {
        this.candidatsByCity = new HashMap<>();
    }

    public void addParticpant(String city, String code, String name, int age) {
        candidatsByCity.putIfAbsent(city, new TreeSet<>(Comparator.comparing(Candidate::getCode)));
        Candidate candidate = new Candidate(code, name, age);
        candidatsByCity.get(city).add(candidate);

    }

    public void listByCity(String city) {
        TreeSet<Candidate> tmp = (TreeSet<Candidate>) candidatsByCity.get(city);
        tmp.stream().sorted(Comparator.comparing(Candidate::getName).thenComparing(Candidate::getAge))
                .forEach(i -> System.out.println(i.toString()));
    }
}


public class AuditionTest {
    public static void main(String[] args) {
        Audition audition = new Audition();
        List<String> cities = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");
            if (parts.length > 1) {
                audition.addParticpant(parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]));
            } else {
                cities.add(line);
            }
        }
        for (String city : cities) {
            System.out.printf("+++++ %s +++++\n", city);
            audition.listByCity(city);
        }
        scanner.close();
    }
}