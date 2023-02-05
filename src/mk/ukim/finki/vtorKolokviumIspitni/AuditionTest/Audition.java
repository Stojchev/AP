package mk.ukim.finki.vtorKolokviumIspitni.AuditionTest;

import java.util.*;
import java.util.stream.Collectors;

//public class Audition {
//    Map<String, Set<Candidate>> candidatsByCity;
//
//    public Audition() {
//        this.candidatsByCity = new HashMap<>();
//    }
//
//    public void addParticpant(String city, String code, String name, int age) {
//        candidatsByCity.putIfAbsent(city, new TreeSet<>(Comparator.comparing(Candidate::getCode)));
//        Candidate candidate = new Candidate(code, name, age);
//        candidatsByCity.get(city).add(candidate);
//
//    }
//
//    public void listByCity(String city) {
//        TreeSet<Candidate> tmp = (TreeSet<Candidate>) candidatsByCity.get(city);
//        tmp.stream().sorted(Comparator.comparing(Candidate::getName).thenComparing(Candidate::getAge))
//                .forEach(i -> System.out.println(i.toString()));
//    }
//}
