package mk.ukim.finki.zaKrajIspitni.TasksManagerTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


//public class TaskManager {
//
//    List<ITask> tasks;
//
//    public void readTasks(InputStream in) {
//        Scanner scanner = new Scanner(in);
//        this.tasks = new ArrayList<>();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
//        while (scanner.hasNextLine()) {
//            String[] line = scanner.nextLine().split(",");
//            ITask task = new Task(line[0], line[1], line[2]);
//            if (line.length == 5) {
//                LocalDate date = LocalDate.from(formatter.parse(line[3]));
//                ITask withDeadline = new DeadlineDecorator(task, date);
//                ITask withPriority = new PriorityDecorator(withDeadline, Integer.parseInt(line[4]));
//                tasks.add(withPriority);
//            } else if (line.length == 4) {
//                if (line[3].length() > 1) {
//                    LocalDate date = LocalDate.from(formatter.parse(line[3]));
//                    ITask withDeadline = new DeadlineDecorator(task, date);
//                    tasks.add(withDeadline);
//                } else {
//                    ITask withPriority = new PriorityDecorator(task, Integer.parseInt(line[3]));
//                    tasks.add(withPriority);
//                }
//            } else tasks.add(task);
//        }
//    }
//
//    public void printTasks(OutputStream os, boolean includePriority, boolean includeCategory) {
//        if (includeCategory) {
//            if (includePriority)
//                tasks.stream().sorted(Comparator.comparing(ITask::getCategory).thenComparing(ITask::getPriority))
//                        .forEach(System.out::println);
//            else tasks.stream().sorted(Comparator.comparing(ITask::getCategory))
//                    .forEach(System.out::println);
//        } else {
//            if (includePriority)
//                tasks.stream().sorted(Comparator.comparing(ITask::getPriority))
//                        .forEach(System.out::println);
//            else tasks.forEach(System.out::println);
//        }
//    }
//}
