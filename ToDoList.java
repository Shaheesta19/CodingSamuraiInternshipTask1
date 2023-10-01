import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }
    
    
    public String getName() { //to get name of current task you set as done or removed
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + name;
    }
}

public class ToDoList {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoList() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String taskName) {
        Task task = new Task(taskName);
        tasks.add(task);
        System.out.println("Task added: " + taskName);
    }

    public void markTaskAsDone(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            Task task = tasks.get(taskIndex);
            task.markAsDone();
            System.out.println("Marked task as done: " + task.getName());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    public void removeTask(int taskIndex) {
        if (isValidIndex(taskIndex)) {
            Task removedTask = tasks.remove(taskIndex);
            System.out.println("Removed task: " + removedTask.getName());
        } else {
            System.out.println("Invalid task index.");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }

    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    todoList.addTask(taskName);
                    break;
                case 2:
                    System.out.print("Enter task index to mark as done: ");
                    int taskIndex = scanner.nextInt();
                    todoList.markTaskAsDone(taskIndex);
                    break;
                case 3:
                    todoList.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter task index to remove: ");
                    int removeIndex = scanner.nextInt();
                    todoList.removeTask(removeIndex);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
