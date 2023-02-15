package mk.ukim.finki.zaKrajIspitni.PayrollSystemTest;

//public class HourlyEmployee implements Employee {
//    String ID;
//    String level;
//    float hours;
//    double hourlyPrice;
//
//    public HourlyEmployee(String ID, String level, float hours, Double hourlyPrice) {
//        this.ID = ID;
//        this.level = level;
//        this.hours = hours;
//        this.hourlyPrice = hourlyPrice;
//    }
//
//    @Override
//    public float getSalary() {
//        return (float) ((float) hours > 40 ? (40 * hourlyPrice + (hours - 40) * hourlyPrice * 1.5) : hours * hourlyPrice);
//    }
//
//    @Override
//    public String getType() {
//        return "HourlyEmployee";
//    }
//
//    @Override
//    public String getID() {
//        return ID;
//    }
//
//    @Override
//    public String toString() {
//        //Employee ID: 1ff293 Level: level7 Salary: 1089.53 Regular hours: 40.00 Overtime hours: 1.93
//        return String.format("Employee ID: %s Level: %s Salary: %.2f Regular hours: %.2f Overtime hours: %.2f", ID, level, getSalary(), hours > 40 ? 40 : hours, hours > 40 ? hours - 40 : 0);
//    }
//
//    @Override
//    public String getLevel() {
//        return level;
//    }
//}
