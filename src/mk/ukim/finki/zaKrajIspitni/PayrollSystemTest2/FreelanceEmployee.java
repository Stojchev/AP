package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest2;

//public class FreelanceEmployee implements Employee {
//    String ID;
//    String level;
//    int hours;
//    int days;
//    double hourlyPrice;
//    String bonus;
//    double bonusCalculated;
//
//
//    public FreelanceEmployee(String ID, String level, int hours, int days, double hourlyPrice, String bonus) {
//        this.ID = ID;
//        this.level = level;
//        this.hours = hours;
//        this.days = days;
//        this.hourlyPrice = hourlyPrice;
//        this.bonus = bonus;
//        getSalary();
//    }
//
//    @Override
//    public double getSalary() {
//        if (bonus.contains("%"))
//            bonusCalculated = (float) Integer.parseInt(bonus.replace("%", "")) / 100;
//        else bonusCalculated = Integer.parseInt(bonus);
//        return hours * hourlyPrice + bonusCalculated;
//    }
//
//    @Override
//    public String getID() {
//        return ID;
//    }
//
//    @Override
//    public double getOverTimePayment() {
//        return bonusCalculated;
//    }
//
//    @Override
//    public String getLevel() {
//        return level;
//    }
//
//    @Override
//    public String getType() {
//        return "FreelancerEmployee";
//    }
//
//    @Override
//    public int getTicketsCount() {
//        return days;
//    }
//
//    @Override
//    public double getBonusPoints() {
//        return bonusCalculated;
//    }
//
//    @Override
//    public String toString() {
//        //Employee ID: bca8f6 Level: level9 Salary: 1127.50 Tickets count: 9 Tickets points: 41
//        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("Employee ID: %s Level: %s Salary: %.2f Tickets count: %d Tickets points: %d", ID, level, getSalary(), days, hours));
//        if (bonusCalculated > 0)
//            sb.append(String.format(" Bonus: %.2f", bonusCalculated));
//        return sb.toString();
//    }
//}
