package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest2;

import java.util.*;
import java.util.stream.Collectors;

class BonusNotAllowedException extends Exception {
    public BonusNotAllowedException(double bonus) {
        super(String.format("Bonus of %.2f is not allowed", bonus));
    }
}

interface Employee {
    double getSalary();

    String getID();

    double getOverTimePayment();

    String getLevel();

    String getType();

    int getTicketsCount();

    double getBonusPoints();

}

class FreelanceEmployee implements Employee {
    String ID;
    String level;
    int hours;
    int days;
    double hourlyPrice;
    String bonus;
    double bonusCalculated;


    public FreelanceEmployee(String ID, String level, int hours, int days, double hourlyPrice, String bonus) {
        this.ID = ID;
        this.level = level;
        this.hours = hours;
        this.days = days;
        this.hourlyPrice = hourlyPrice;
        this.bonus = bonus;
        getSalary();
    }

    @Override
    public double getSalary() {
        if (bonus.contains("%"))
            bonusCalculated =Double.parseDouble(bonus.replace("%", "")) / 100;
        else bonusCalculated = Integer.parseInt(bonus);
        return hours * hourlyPrice + bonusCalculated;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public double getOverTimePayment() {
        return bonusCalculated;
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public String getType() {
        return "FreelancerEmployee";
    }

    @Override
    public int getTicketsCount() {
        return days;
    }

    @Override
    public double getBonusPoints() {
        return bonusCalculated;
    }

    @Override
    public String toString() {
        //Employee ID: bca8f6 Level: level9 Salary: 1127.50 Tickets count: 9 Tickets points: 41
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employee ID: %s Level: %s Salary: %.2f Tickets count: %d Tickets points: %d", ID, level, getSalary(), days, hours));
        if (bonusCalculated > 0)
            sb.append(String.format(" Bonus: %.2f", bonusCalculated));
        return sb.toString();
    }
}

class HourlyEmployee implements Employee {
    String ID;
    String level;
    double hours;
    double hourlyPrice;
    String bonus;
    double bonusCalculated;

    public HourlyEmployee(String ID, String level, double hours, double hourlyPrice, String bonus) {
        this.ID = ID;
        this.level = level;
        this.hours = hours;
        this.hourlyPrice = hourlyPrice;
        this.bonus = bonus;
        getSalary();
    }

    @Override
    public double getSalary() {
        double salary = hours > 40 ? (40 * hourlyPrice) + ((hours - 40) * hourlyPrice * 1.5) : hours * hourlyPrice;
        if (bonus.contains("%")) {
            bonusCalculated = (salary * (Double.parseDouble(bonus.replace("%", "")) / 100));
            salary += bonusCalculated;
        } else {
            bonusCalculated = Integer.parseInt(bonus);
            salary += bonusCalculated;
        }
        return salary;
    }

    @Override
    public String getLevel() {
        return level;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public double getOverTimePayment() {
        if (hours > 40)
            return hourlyPrice * (hours - 40) * 1.5;
        return 0;
    }

    @Override
    public int getTicketsCount() {
        return 0;
    }

    @Override
    public double getBonusPoints() {
        return bonusCalculated;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Employee ID: %s Level: %s Salary: %.2f Regular hours: %.2f Overtime hours: %.2f", ID, level, getSalary(), hours > 40 ? 40 : hours, hours > 40 ? hours - 40 : 0));
        if (bonusCalculated > 0)
            sb.append(String.format(" Bonus: %.2f", bonusCalculated));
        return sb.toString();
    }

    @Override
    public String getType() {
        return "HourlyFreelancer";
    }
}

class PayrollSystem {
    Map<String, Double> mapForHourlyEmployees;
    Map<String, Double> mapForFreelancerEmployees;
    Set<Employee> employeeSet;

    public PayrollSystem(Map<String, Double> hourlyRateByLevel, Map<String, Double> ticketRateByLevel) {
        this.mapForHourlyEmployees = hourlyRateByLevel;
        this.mapForFreelancerEmployees = ticketRateByLevel;
        this.employeeSet = new TreeSet<>(Comparator.comparing(Employee::getID));
    }

    public Employee createEmployee(String line) throws BonusNotAllowedException {
        String[] lineSplit = line.split(";");
        Employee employee;
        String checkException = "";
        if (lineSplit[lineSplit.length - 1].split(" ").length > 1) {
            checkException = lineSplit[lineSplit.length - 1].split(" ")[1];
            if (checkException.contains("%")) {
                if (Double.parseDouble(checkException.replace("%", "")) > 20)
                    throw new BonusNotAllowedException(Double.parseDouble(checkException.replace("%", "")));
            } else if (Integer.parseInt(checkException) > 1000) {
                throw new BonusNotAllowedException(Double.parseDouble(checkException));
            }
        }
        if (lineSplit[0].equals("H")) {
            employee = new HourlyEmployee(lineSplit[1], lineSplit[2], Double.parseDouble(lineSplit[3].split(" ")[0]), mapForHourlyEmployees.get(lineSplit[2]), lineSplit[3].split(" ").length > 1 ? lineSplit[3].split(" ")[1] : "0");
            employeeSet.add(employee);
        } else {
            employee = new FreelanceEmployee(lineSplit[1], lineSplit[2], countHourseForFreelancer(lineSplit), lineSplit.length - 3, mapForFreelancerEmployees.get(lineSplit[2]), lineSplit[lineSplit.length - 1].split(" ").length > 1 ? lineSplit[lineSplit.length - 1].split(" ")[1] : "0");
            employeeSet.add(employee);
        }
        return employee;
    }

    private int countHourseForFreelancer(String[] lineSplit) {
        int count = 0;
        for (int i = 3; i < lineSplit.length - 1; i++) {
            count += Integer.parseInt(lineSplit[i]);
        }
        count += Integer.parseInt(lineSplit[lineSplit.length - 1].split(" ")[0]);
        return count;
    }

    public Map<String, Double> getOvertimeSalaryForLevels() {
        Map<String, Double> tmp = new TreeMap<>();
        for (Employee em : employeeSet) {
            if (em.getType().equals("HourlyFreelancer") && em.getOverTimePayment() > 0) {
                tmp.putIfAbsent(em.getLevel(), 0.0);
                Double tm = tmp.get(em.getLevel());
                tmp.remove(em.getLevel());
                tmp.put(em.getLevel(), tm + em.getOverTimePayment());
            }
        }
        return tmp;
    }

    public static <K extends Comparable, V> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
            @Override
            public int compare(K o1, K o2) {
                return o2.compareTo(o1);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }

    public void printStatisticsForOvertimeSalary() {
        Map<String, Double> tmp = getOvertimeSalaryForLevels();
        double max = tmp.values().stream().max(Comparator.comparing(Double::valueOf)).get();
        double min = tmp.values().stream().min(Comparator.comparing(Double::valueOf)).get();
        double average = tmp.values().stream().mapToDouble(i -> i).average().getAsDouble();
        double sum = tmp.values().stream().mapToDouble(i -> i).sum();
        System.out.printf("Statistics for overtime salary: Min: %.2f Average: %.2f Max: %.2f Sum: %.2f%n", min, average, max, sum);
    }

    public Map<String, Integer> ticketsDoneByLevel() {
        Map<String, Integer> tmp = new TreeMap<>();
        for (Employee em : employeeSet) {
            if (em.getType().equals("FreelancerEmployee")) {
                tmp.putIfAbsent(em.getLevel(), 0);
                Integer tm = tmp.get(em.getLevel());
                tmp.put(em.getLevel(), tm + em.getTicketsCount());
            }
        }
        return sortMap(tmp);
    }

    public static <K extends Comparable, V> Map<K, V> sortMap(Map<K, V> map) {
        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
            @Override
            public int compare(K a, K b) {
                return b.compareTo(a);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }

    Collection<Employee> getFirstNEmployeesByBonus(int n) {
        return employeeSet.stream().sorted(Comparator.comparing(Employee::getBonusPoints).reversed()).collect(Collectors.toList()).subList(0, n);
    }
}


public class PayrollSystemTest2 {

    public static void main(String[] args) {

        Map<String, Double> hourlyRateByLevel = new LinkedHashMap<>();
        Map<String, Double> ticketRateByLevel = new LinkedHashMap<>();
        for (int i = 1; i <= 10; i++) {
            hourlyRateByLevel.put("level" + i, 11 + i * 2.2);
            ticketRateByLevel.put("level" + i, 5.5 + i * 2.5);
        }

        Scanner sc = new Scanner(System.in);

        int employeesCount = Integer.parseInt(sc.nextLine());

        PayrollSystem ps = new PayrollSystem(hourlyRateByLevel, ticketRateByLevel);
        Employee emp = null;
        for (int i = 0; i < employeesCount; i++) {
            try {
                emp = ps.createEmployee(sc.nextLine());
            } catch (BonusNotAllowedException e) {
                System.out.println(e.getMessage());
            }
        }

        int testCase = Integer.parseInt(sc.nextLine());

        switch (testCase) {
            case 1: //Testing createEmployee
                if (emp != null)
                    System.out.println(emp);
                break;
            case 2: //Testing getOvertimeSalaryForLevels()
                ps.getOvertimeSalaryForLevels().forEach((level, overtimeSalary) -> {
                    System.out.printf("Level: %s Overtime salary: %.2f\n", level, overtimeSalary);
                });
                break;
            case 3: //Testing printStatisticsForOvertimeSalary()
                ps.printStatisticsForOvertimeSalary();
                break;
            case 4: //Testing ticketsDoneByLevel
                ps.ticketsDoneByLevel().forEach((level, overtimeSalary) -> {
                    System.out.printf("Level: %s Tickets by level: %d\n", level, overtimeSalary);
                });
                break;
            case 5: //Testing getFirstNEmployeesByBonus (int n)
                ps.getFirstNEmployeesByBonus(Integer.parseInt(sc.nextLine())).forEach(System.out::println);
                break;
        }

    }
}