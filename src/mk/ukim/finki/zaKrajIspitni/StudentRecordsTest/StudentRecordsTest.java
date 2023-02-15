package mk.ukim.finki.zaKrajIspitni.StudentRecordsTest;

import java.io.*;
import java.util.*;

class Student {
    String id;
    List<Integer> grades;

    public String getId() {
        return id;
    }

    public Student(String id) {
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(Integer grade) {
        grades.add(grade);
    }

    public double getAverage() {
        return grades.stream().mapToInt(a -> a).average().orElse(0);
    }

    public long countNumberOfGrade(int n) {
        return grades.stream().filter(grades -> grades.equals(n)).count();
    }

    public long countNumberOfHighestGrade() {
        return grades.stream().filter(grades -> grades.equals(10)).count();
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", id, getAverage());
    }
}

class StudentRecords {
    Map<String, Program> studentsByClass;
    int count;

    public StudentRecords() {
        this.studentsByClass = new TreeMap<>();
        count = 0;
    }

    public int readRecords(InputStream in) {
        Scanner scanner = new Scanner(in);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            Student student = new Student(line[0]);
            for (int i = 2; i < line.length; i++) {
                student.addGrade(Integer.valueOf(line[i]));
            }
            studentsByClass.putIfAbsent(line[1], new Program(line[1]));
            studentsByClass.get(line[1]).addStudent(student);
            count++;
        }
        return count;
    }

    public void writeTable(PrintStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        StringBuilder sb = new StringBuilder();
        studentsByClass.values().forEach(sb::append);
        writer.write(sb.toString());
        writer.flush();

    }

    public void writeDistribution(PrintStream out) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        StringBuilder sb = new StringBuilder();
        studentsByClass.values().stream().sorted(Comparator.comparing(Program::countHighestGrades).reversed())
                .forEach(program -> {
                    sb.append(program.name).append("\n");
                    for (int i = 6; i <= 10; i++) {
                        sb.append(String.format("%2d | ", i));
                        long counter = 0;
                        for (Student student : program.studentSet) {
                            counter += student.countNumberOfGrade(i);
                        }
                        for (int j = 1; j <= counter; j += 10)
                            sb.append("*");
                        sb.append(String.format("(%d)\n", counter));
                    }
                });
        writer.write(sb.toString());
        writer.flush();
        writer.close();
    }
}

class Program {
    Set<Student> studentSet;
    String name;

    public Program(String name) {
        this.studentSet = new HashSet<>();
        this.name = name;
    }

    public void addStudent(Student student) {
        studentSet.add(student);
    }

    public long countHighestGrades() {
        return studentSet.stream().mapToLong(Student::countNumberOfHighestGrade).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        studentSet.stream().sorted(Comparator.comparing(Student::getAverage).reversed().thenComparing(Student::getId)).forEach(i -> sb.append(i).append("\n"));
        return sb.toString();
    }
}

public class StudentRecordsTest {
    public static void main(String[] args) throws IOException {
        System.out.println("=== READING RECORDS ===");
        StudentRecords studentRecords = new StudentRecords();
        int total = studentRecords.readRecords(System.in);
        System.out.printf("Total records: %d\n", total);
        System.out.println("=== WRITING TABLE ===");
        studentRecords.writeTable(System.out);
        System.out.println("=== WRITING DISTRIBUTION ===");
        studentRecords.writeDistribution(System.out);
    }
}

// your code here