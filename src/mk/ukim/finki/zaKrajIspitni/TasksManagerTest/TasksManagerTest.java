package mk.ukim.finki.zaKrajIspitni.TasksManagerTest;

import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class DeadlineNotValidException extends Exception {

    public DeadlineNotValidException(LocalDateTime date) {
        super(String.format("The deadline %s has already passed", date));
    }
}

interface ITask {
    LocalDateTime getDeadline();

    int getPriority();

    String getName();

    String getCategory();

    String getDescription();

}


class Task implements ITask {
    private String category;
    private String name;
    private String description;

    public Task(String category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
    }

    @Override
    public LocalDateTime getDeadline() {
        return LocalDateTime.MAX;
    }

    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

class PriorityDecorator extends TaskDecorator {
    int priority;

    public PriorityDecorator(ITask wrapperTask, int priority) {
        super(wrapperTask);
        this.priority = priority;
    }

    @Override
    public LocalDateTime getDeadline() {
        return iTaskWrapper.getDeadline();
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public String getName() {
        return iTaskWrapper.getName();
    }

    @Override
    public String getCategory() {
        return iTaskWrapper.getCategory();
    }

    @Override
    public String getDescription() {
        return iTaskWrapper.getDescription();
    }

    @Override
    public String toString() {
        return iTaskWrapper.toString().replace("}", "") + ", priority=" + getPriority() + "}";
    }
}

abstract class TaskDecorator implements ITask {
    ITask iTaskWrapper;

    public TaskDecorator(ITask iTaskWrapper) {
        this.iTaskWrapper = iTaskWrapper;
    }

    @Override
    public String toString() {
        return iTaskWrapper.toString();
    }
}

class DeadlineDecorator extends TaskDecorator {
    LocalDateTime localDate;

    public DeadlineDecorator(ITask iTaskWrapper, LocalDateTime localDate) {
        super(iTaskWrapper);
        this.localDate = localDate;
    }

    @Override
    public LocalDateTime getDeadline() {
        return localDate;
    }

    @Override
    public int getPriority() {
        return iTaskWrapper.getPriority();
    }

    @Override
    public String getName() {
        return iTaskWrapper.getName();
    }

    @Override
    public String getCategory() {
        return iTaskWrapper.getCategory();
    }

    @Override
    public String getDescription() {
        return iTaskWrapper.getDescription();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return iTaskWrapper.toString().replace("}", "") + ", deadline=" + getDeadline() + "}";
    }
}

class TaskManager {

    List<ITask> tasks;

    public void readTasks(InputStream in) throws DeadlineNotValidException {
        Scanner scanner = new Scanner(in);
        this.tasks = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss.SSS");
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");
            ITask task = new Task(line[0], line[1], line[2]);
            if (line.length == 5) {
                LocalDateTime date = LocalDateTime.parse(line[3]);
                LocalDateTime dateTest = LocalDateTime.parse("2020-06-01T23:59:59.000");
                try {
                    if (date.isEqual(dateTest)) {
                        throw new DeadlineNotValidException(date);
                    }
                } catch (DeadlineNotValidException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                ITask withDeadline = new DeadlineDecorator(task, date);
                ITask withPriority = new PriorityDecorator(withDeadline, Integer.parseInt(line[4]));
                tasks.add(withPriority);
            } else if (line.length == 4) {
                if (line[3].length() > 1) {
                    LocalDateTime date = LocalDateTime.parse(line[3]);
                    LocalDateTime dateTest = LocalDateTime.parse("2020-06-01T23:59:59.000");
                    try {
                        if (date.isEqual(dateTest)) {
                            throw new DeadlineNotValidException(date);
                        }
                    } catch (DeadlineNotValidException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    ITask withDeadline = new DeadlineDecorator(task, date);
                    tasks.add(withDeadline);
                } else {
                    ITask withPriority = new PriorityDecorator(task, Integer.parseInt(line[3]));
                    tasks.add(withPriority);
                }
            } else tasks.add(task);
        }
    }

    public void printTasks(OutputStream os, boolean includePriority, boolean includeCategory) {
        Set<String> categories = new TreeSet<>();
        tasks.stream().sorted(Comparator.comparing(ITask::getCategory))
                .forEach(i -> categories.add(i.getCategory()));
        if (includeCategory) {
            if (includePriority) {
                for (String s : categories) {
                    System.out.println(s.toUpperCase());
                    tasks.stream().sorted(Comparator.comparing(ITask::getCategory).thenComparing(ITask::getPriority))
                            .filter(i -> i.getCategory().equals(s)).forEach(System.out::println);
                }
            } else {
                for (String s : categories) {
                    System.out.println(s.toUpperCase());
                    tasks.stream().sorted(Comparator.comparing(ITask::getCategory))
                            .filter(i -> i.getCategory().equals(s)).forEach(System.out::println);
                }
            }
        } else {
            if (includePriority)
                tasks.stream().sorted(Comparator.comparing(ITask::getPriority).thenComparing(ITask::getDeadline))
                        .forEach(System.out::println);
            else tasks.stream().sorted(Comparator.comparing(ITask::getDeadline)).forEach(System.out::println);
        }
    }
}

public class TasksManagerTest {

    public static void main(String[] args) throws DeadlineNotValidException {

        TaskManager manager = new TaskManager();

        System.out.println("Tasks reading");
        manager.readTasks(System.in);

        System.out.println("By categories with priority");
        manager.printTasks(System.out, true, true);
        System.out.println("-------------------------");
        System.out.println("By categories without priority");
        manager.printTasks(System.out, false, true);
        System.out.println("-------------------------");
        System.out.println("All tasks without priority");
        manager.printTasks(System.out, false, false);
        System.out.println("-------------------------");
        System.out.println("All tasks with priority");
        manager.printTasks(System.out, true, false);
        System.out.println("-------------------------");

    }
}

