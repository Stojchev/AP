package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest2;

//public class HourlyEmployee implements Employee {
//    String ID;
//    String level;
//    double hours;
//    double hourlyPrice;
//    String bonus;
//    double bonusCalculated;
//
//    public HourlyEmployee(String ID, String level, double hours, double hourlyPrice, String bonus) {
//        this.ID = ID;
//        this.level = level;
//        this.hours = hours;
//        this.hourlyPrice = hourlyPrice;
//        this.bonus = bonus;
//        getSalary();
//    }
//
//    @Override
//    public double getSalary() {
//        double salary = hours > 40 ? (40 * hourlyPrice) + ((hours - 40) * hourlyPrice * 1.5) : hours * hourlyPrice;
//        if (bonus.contains("%")) {
//            bonusCalculated = (salary * (Float.parseFloat(bonus.replace("%", "")) / 100));
//            salary += bonusCalculated;
//        } else {
//            bonusCalculated = Integer.parseInt(bonus);
//            salary += bonusCalculated;
//        }
//        return salary;
//    }
//
//    @Override
//    public String getLevel() {
//        return level;
//    }
//
//    @Override
//    public String getID() {
//        return ID;
//    }
//
//    @Override
//    public double getOverTimePayment() {
//        if (hours > 40)
//            return hourlyPrice * (hours - 40) * 1.5;
//        return 0;
//    }
//
//    @Override
//    public int getTicketsCount() {
//        return 0;
//    }
//
//    @Override
//    public double getBonusPoints() {
//        return bonusCalculated;
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("Employee ID: %s Level: %s Salary: %.2f Regular hours: %.2f Overtime hours: %.2f", ID, level, getSalary(), hours > 40 ? 40 : hours, hours > 40 ? hours - 40 : 0));
//        if (bonusCalculated > 0)
//            sb.append(String.format(" Bonus: %.2f", bonusCalculated));
//        return sb.toString();
//    }
//
//    @Override
//    public String getType() {
//        return "HourlyFreelancer";
//    }
//}
