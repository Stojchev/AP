package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

//public class PayrollSystem {
//    Map<String, Double> mapForHourlyEmployees;
//    Map<String, Double> mapForFreelacnerEmolyees;
//    Set<Employee> employees;
//
//    public PayrollSystem() {
//        this.mapForFreelacnerEmolyees = new TreeMap<>();
//        this.mapForHourlyEmployees = new TreeMap<>();
//        this.employees = new TreeSet<>(Comparator.comparing(Employee::getID));
//    }
//
//    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
//        this.mapForFreelacnerEmolyees = new TreeMap<>();
//        this.mapForHourlyEmployees = new TreeMap<>();
//        this.employees = new TreeSet<>(Comparator.comparing(Employee::getID));
//        this.mapForFreelacnerEmolyees = ticketRateByLevel;
//        this.mapForHourlyEmployees = hourlyRateByLevel;
//    }
//
//    public void readEmployees(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        while (scanner.hasNextLine()) {
//            String[] line = scanner.nextLine().split(";");
//            if (line[0].equals("F")) {
//                employees.add(new FreelanceEmployee(line[1], line[2], countHoursForFreelancer(line), line.length - 3, mapForFreelacnerEmolyees.get(line[2])));
//            } else {
//                employees.add(new HourlyEmployee(line[1], line[2], Float.parseFloat(line[3]), mapForHourlyEmployees.get(line[2])));
//            }
//        }
//    }
//
//    public int countHoursForFreelancer(String[] employee) {
//        int count = 0;
//        for (int i = 3; i < employee.length; i++) {
//            count += Integer.parseInt(employee[i]);
//        }
//        return count;
//    }
//
//    public Map<String, Set<Employee>> printEmployeesByLevels(PrintStream out, Set<String> levels) {
//        Map<String, Set<Employee>> tmp = new TreeMap<>();
//        for (Employee employee : employees) {
//            if (levels.contains(employee.getLevel())) {
//                tmp.putIfAbsent(employee.getLevel(), new TreeSet<>(Comparator.comparing(Employee::getID)));
//                tmp.get(employee.getLevel()).add(employee);
//            }
//        }
//        return tmp;
//    }
//}
