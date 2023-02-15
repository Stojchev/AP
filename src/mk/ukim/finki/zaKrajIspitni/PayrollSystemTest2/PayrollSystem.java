package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest2;

import java.util.*;
import java.util.stream.Collectors;

//public class PayrollSystem {
//    Map<String, Double> mapForHourlyEmployees;
//    Map<String, Double> mapForFreelancerEmployees;
//    Set<Employee> employeeSet;
//
//    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
//        this.mapForHourlyEmployees = hourlyRateByLevel;
//        this.mapForFreelancerEmployees = ticketRateByLevel;
//        this.employeeSet = new TreeSet<>(Comparator.comparing(Employee::getID));
//    }
//
//    public Employee createEmployee(String line) throws BonusNotAllowedException {
//        String[] lineSplit = line.split(";");
//        Employee employee;
//        String checkException = "";
//        if (lineSplit[lineSplit.length - 1].split(" ").length > 1) {
//            checkException = lineSplit[lineSplit.length - 1].split(" ")[1];
//            if (checkException.contains("%")) {
//                if (Integer.parseInt(checkException.replace("%", "")) > 20)
//                    throw new BonusNotAllowedException();
//            } else if (Integer.parseInt(checkException) > 1000) {
//                throw new BonusNotAllowedException();
//            }
//        }
//        if (lineSplit[0].equals("H")) {
//            employee = new HourlyEmployee(lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3].split(" ")[0]), mapForHourlyEmployees.get(lineSplit[2]), lineSplit[3].split(" ").length > 1 ? lineSplit[3].split(" ")[1] : "0");
//            employeeSet.add(employee);
//        } else {
//            employee = new FreelanceEmployee(lineSplit[1], lineSplit[2], countHourseForFreelancer(lineSplit), lineSplit.length - 3, mapForFreelancerEmployees.get(lineSplit[2]), lineSplit[lineSplit.length - 1].split(" ").length > 1 ? lineSplit[lineSplit.length - 1].split(" ")[1] : "0");
//            employeeSet.add(employee);
//        }
//        return employee;
//    }
//
//    private int countHourseForFreelancer(String[] lineSplit) {
//        int count = 0;
//        for (int i = 3; i < lineSplit.length - 1; i++) {
//            count += Integer.parseInt(lineSplit[i]);
//        }
//        count += Integer.parseInt(lineSplit[lineSplit.length - 1].split(" ")[0]);
//        return count;
//    }
//
//    public Map<String, Double> getOvertimeSalaryForLevels() {
//        Map<String, Double> tmp = new TreeMap<>();
//        for (Employee em : employeeSet) {
//            if (em.getType().equals("HourlyFreelancer")) {
//                tmp.putIfAbsent(em.getLevel(), 0.0);
//                Double tm = tmp.get(em.getLevel());
//                tmp.put(em.getLevel(), tm + em.getOverTimePayment());
//            }
//        }
//        return tmp;
//    }
//
//    public void printStatisticsForOvertimeSalary() {
//        Map<String, Double> tmp = getOvertimeSalaryForLevels();
//        double max = tmp.values().stream().max(Comparator.comparing(Double::valueOf)).get();
//        double min = tmp.values().stream().min(Comparator.comparing(Double::valueOf)).get();
//        double average = tmp.values().stream().mapToDouble(i -> i).average().getAsDouble();
//        double sum = tmp.values().stream().mapToDouble(i -> i).sum();
//        System.out.printf("Statistics for overtime salary: Min: %.2f Average: %.2f Max: %.2f Sum: %.2f%n", min, average, max, sum);
//    }
//
//    public Map<String, Integer> ticketsDoneByLevel() {
//        Map<String, Integer> tmp = new TreeMap<>();
//        for (Employee em : employeeSet) {
//            if (em.getType().equals("FreelancerEmployee")) {
//                tmp.putIfAbsent(em.getLevel(), 0);
//                Integer tm = tmp.get(em.getLevel());
//                tmp.put(em.getLevel(), tm + em.getTicketsCount());
//            }
//        }
//        return sortMap(tmp);
//    }
//
//    public static <K extends Comparable, V> Map<K, V> sortMap(Map<K, V> map) {
//        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
//            @Override
//            public int compare(K a, K b) {
//                return b.compareTo(a);
//            }
//        });
//        treeMap.putAll(map);
//        return treeMap;
//    }
//
//    Collection<Employee> getFirstNEmployeesByBonus(int n) {
//        return employeeSet.stream().sorted(Comparator.comparing(Employee::getBonusPoints).reversed()).collect(Collectors.toList());
//    }
//}
