package mk.ukim.finki.zaKrajIspitni.StudentRecordsTest;

import java.io.*;
import java.util.*;

//public class StudentRecords {
//    Map<String, Program> studentsByClass;
//    int count;
//
//    public StudentRecords() {
//        this.studentsByClass = new TreeMap<>();
//        count = 0;
//    }
//
//    public int readRecords(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        while (scanner.hasNextLine()) {
//            String[] line = scanner.nextLine().split(" ");
//            Student student = new Student(line[0]);
//            for (int i = 2; i < line.length; i++) {
//                student.addGrade(Integer.valueOf(line[i]));
//            }
//            studentsByClass.putIfAbsent(line[1], new Program(line[1]));
//            studentsByClass.get(line[1]).addStudent(student);
//            count++;
//        }
//        return count;
//    }
//
//    public void writeTable(PrintStream out) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
//        StringBuilder sb = new StringBuilder();
//        studentsByClass.values().forEach(sb::append);
//        writer.write(sb.toString());
//        writer.flush();
//
//    }
//
//    public void writeDistribution(PrintStream out) throws IOException {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
//        StringBuilder sb = new StringBuilder();
//        studentsByClass.values().stream().sorted(Comparator.comparing(Program::countHighestGrades).reversed())
//                .forEach(program -> {
//                    sb.append(program.name).append("\n");
//                    for (int i = 6; i <= 10; i++) {
//                        sb.append(String.format("%2d | ", i));
//                        long counter = 0;
//                        for (Student student : program.studentSet) {
//                            counter += student.countNumberOfGrade(i);
//                        }
//                        for (int j = 1; j < counter; j += 10)
//                            sb.append("*");
//                        sb.append(String.format("(%d)\n", counter));
//                    }
//                });
//        writer.write(sb.toString());
//        writer.flush();
//        writer.close();
//    }
//}
