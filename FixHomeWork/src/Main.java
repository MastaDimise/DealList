import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();
        boolean isRunning = true;

        System.out.println("***Планировщик***");

        while (isRunning) {
            printMenu();
            System.out.print("Выберите пункт меню: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    addTask(scanner, tasks);
                case "2":
                    showTasks(tasks);
                case "3":
                    removeTaskByNumber(scanner, tasks);
                case "4":
                    removeTaskByName(scanner, tasks);
                case "end": {
                    isRunning = false;
                    System.out.println("Выход из программы");
                }
                default:
                    System.out.println("Не верный  пункт меню!");
            }
        }
        scanner.close();
    }


    private static void printMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("1 - Добавить дело");
        System.out.println("2 - Показать дела");
        System.out.println("3 - Удалить дело по номеру");
        System.out.println("4 - Удалить дело по названию");
        System.out.println("end - Выход из программы");
        System.out.println("=".repeat(40));
    }


    private static void addTask(Scanner scanner, List<String> tasks) {
        System.out.print("Введите название задачиЖ ");
        String taskName = scanner.nextLine().trim();

        if (taskName.isEmpty()) {
            System.out.println("Название задачи не может быть пустым");
            return;
        }
        tasks.add(taskName);
        System.out.println(" Задача " + taskName + " добавлена");
        showTasks(tasks);
    }

    private static void showTasks(List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }
        System.out.println("\n Список задач: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + " - " + tasks.get(i));
        }
    }

    private static void removeTaskByNumber(Scanner scanner, List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }
        System.out.print("ВВедите номер задачи для удаления: ");
        String input = scanner.nextLine().trim();
        try {
            int taskNumber = Integer.parseInt(input);
            if (taskNumber >= 1 && taskNumber <= tasks.size()) {
                String removedTask = tasks.remove(taskNumber - 1);
                System.out.println("Задача " + removedTask + " удалена!");
            } else {
                System.out.println("Задачи с номером " + taskNumber + " не существует!");
                System.out.println("Доступные номера задач: " + tasks.size());
            }
        } catch (NumberFormatException e) {
            System.out.println("ОШИБКА: Введите корректный номер задачи!");
        }
    }

    private static void removeTaskByName(Scanner scanner, List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст!");
            return;
        }
        System.out.print("Введите название задачи для удаления: ");
        String taskName = scanner.nextLine().trim();
        boolean found = false;
        Iterator<String> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            String task = iterator.next();
            if (task.equalsIgnoreCase(taskName)) {
                iterator.remove();
                System.out.println("Задача " + task + " удалена!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Задача " + taskName + " не найдена!");
        }
    }
}

