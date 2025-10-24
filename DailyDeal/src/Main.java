import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("\n1 - Добавить дело°\n2 - Показать дела\n3 - Удалить дело по номеру \n4 - Удалить дело по названию \nend - Выход");
            String input = scanner.nextLine();

            if ("end".equals(input)) break;

            switch (input) {
                case "1":
                    System.out.print("Введите название задачи: ");
                    input = scanner.nextLine();
                    list.add(input);
                    break;
                case "2":
                    for(int i = 0; i < list.size(); i++){
                        System.out.println((i + 1) + " - " + list.get(i));
                    }
                    break;
                case "3":
                    System.out.print("Введи номер задачи для удаления: ");
                    input = scanner.nextLine();
                    int in = Integer.parseInt(input);
                    list.remove(in - 1);
                    System.out.println("Задача удалена");
                    break;
                default:

            }
        }
        scanner.close();
    }
}
