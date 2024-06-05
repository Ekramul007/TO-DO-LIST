import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}

public class ToDoApp {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public ToDoApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markAsCompleted();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void showTasks() {
        System.out.println("Your To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Add Task\n2. Mark Task as Completed\n3. Show Tasks\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    addTask(description);
                    System.out.println("Task added!");
                    break;
                case 2:
                    System.out.print("Enter task number to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    markTaskAsCompleted(taskIndex - 1); // Adjusting for 0-based index
                    break;
                case 3:
                    showTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.run();
    }
}
