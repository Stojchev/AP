package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

class FreelanceEmployee implements Employee {
    String ID;
    String level;
    int hours;
    int days;
    double hourlyPrice;

    public FreelanceEmployee(String ID, String level, int hours, int days, Double hourlyPrice) {
        this.ID = ID;
        this.level = level;
        this.hours = hours;
        this.days = days;
        this.hourlyPrice = hourlyPrice;
    }

    @Override
    public double getSalary() {
        return (double) (hours * hourlyPrice);
    }

    @Override
    public String getType() {
        return "FreelanceEmployee";
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public int compareTo(Employee em1, Employee em2) {
        if (em1.getSalary() == em2.getSalary())
            return 0;
        else return Double.compare(em1.getSalary(), em2.getSalary());
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        //Employee ID: bca8f6 Level: level9 Salary: 1127.50 Tickets count: 9 Tickets points: 41
        return String.format("Employee ID: %s Level: %s Salary: %.2f Tickets count: %d Tickets points: %d", ID, level, getSalary(), days, hours);
    }

    @Override
    public int compareTo(Employee o) {
        if (getSalary() == o.getSalary())
            return 0;
        else return Double.compare(getSalary(), o.getSalary());
    }
}

class HourlyEmployee implements Employee{
    String ID;
    String level;
    double hours;
    double hourlyPrice;

    public HourlyEmployee(String ID, String level, double hours, Double hourlyPrice) {
        this.ID = ID;
        this.level = level;
        this.hours = hours;
        this.hourlyPrice = hourlyPrice;
    }

    @Override
    public double getSalary() {
        return (double) ((double) hours > 40 ? (40 * hourlyPrice + (hours - 40) * hourlyPrice * 1.5) : hours * hourlyPrice);
    }

    @Override
    public String getType() {
        return "HourlyEmployee";
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        //Employee ID: 1ff293 Level: level7 Salary: 1089.53 Regular hours: 40.00 Overtime hours: 1.93
        return String.format("Employee ID: %s Level: %s Salary: %.2f Regular hours: %.2f Overtime hours: %.2f", ID, level, getSalary(), hours > 40 ? 40 : hours, hours > 40 ? hours - 40 : 0);
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public int compareTo(Employee em1, Employee em2) {
        if (em1.getSalary() == em2.getSalary())
            return 0;
        else return Double.compare(em1.getSalary(), em2.getSalary());
    }


    @Override
    public int compareTo(Employee o) {
        if (getSalary() == o.getSalary())
            return 0;
        else return Double.compare(getSalary(), o.getSalary());
    }
}


interface Employee extends Comparable<Employee> {
    double getSalary();

    String getType();

    String getID();

    String toString();

    String getLevel();

    int compareTo(Employee em1, Employee em2);
}

class PayrollSystem {
    Map<String, Double> mapForHourlyEmployees;
    Map<String, Double> mapForFreelacnerEmolyees;
    Set<Employee> employees;

    public PayrollSystem() {
        this.mapForFreelacnerEmolyees = new TreeMap<>();
        this.mapForHourlyEmployees = new TreeMap<>();
        this.employees = new TreeSet<>(Comparator.comparing(Employee::getID));
    }

    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.mapForFreelacnerEmolyees = new TreeMap<>();
        this.mapForHourlyEmployees = new TreeMap<>();
        this.employees = new TreeSet<>(Comparator.comparing(Employee::getID));
        this.mapForFreelacnerEmolyees = ticketRateByLevel;
        this.mapForHourlyEmployees = hourlyRateByLevel;
    }

    public void readEmployees(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(";");
            if (line[0].equals("F")) {
                employees.add(new FreelanceEmployee(line[1], line[2], countHoursForFreelancer(line), line.length - 3, mapForFreelacnerEmolyees.get(line[2])));
            } else {
                employees.add(new HourlyEmployee(line[1], line[2], Double.parseDouble(line[3]), mapForHourlyEmployees.get(line[2])));
            }
        }
    }

    public int countHoursForFreelancer(String[] employee) {
        int count = 0;
        for (int i = 3; i < employee.length; i++) {
            count += Integer.parseInt(employee[i]);
        }
        return count;
    }

    public Map<String, Set<Employee>> printEmployeesByLevels(PrintStream out, Set<String> levels) {
        Map<String, Set<Employee>> tmp = new TreeMap<>();
        for (Employee employee : employees) {
            if (levels.contains(employee.getLevel())) {
                tmp.putIfAbsent(employee.getLevel(), new TreeSet<>(Comparator.comparing(Employee::getSalary).reversed()));
                tmp.get(employee.getLevel()).add(employee);
            }
        }
        return tmp;
    }
}


public class PayrollSystemTest {

    public static void main(String[] args) {

        Map<String, Double> hourlyRateByLevel = new LinkedHashMap<>();
        Map<String, Double> ticketRateByLevel = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            hourlyRateByLevel.put("level" + i, 10 + i * 2.2);
            ticketRateByLevel.put("level" + i, 5 + i * 2.5);
        }

        PayrollSystem payrollSystem = new PayrollSystem(hourlyRateByLevel, ticketRateByLevel);

        System.out.println("READING OF THE EMPLOYEES DATA");
        payrollSystem.readEmployees(System.in);

        System.out.println("PRINTING EMPLOYEES BY LEVEL");
        Set<String> levels = new LinkedHashSet<>();
        for (int i = 5; i <= 10; i++) {
            levels.add("level" + i);
        }
        Map<String, Set<Employee>> result = payrollSystem.printEmployeesByLevels(System.out, levels);
        result.forEach((level, employees) -> {
            System.out.println("LEVEL: " + level);
            System.out.println("Employees: ");
            employees.forEach(System.out::println);
            System.out.println("------------");
        });


    }
}