import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            System.out.println("\n1 - Добавить дело\n2 - Показать дела\n3 - Удалить дело по номеру \n4 - Удалить дело по названию \nend - Выход");
            System.out.print("Введите пунк меню: ");
            String input = scanner.nextLine();

            if ("end".equals(input)) break;

            switch (input) {
                case "1":
                    System.out.print("Введите название задачи: ");
                    input = scanner.nextLine();
                    list.add(input);
                    System.out.println("Задача " + input + " добавлена!");
                    for(int i = 0; i < list.size(); i++){
                        System.out.println((i + 1) + " - " + list.get(i));
                    }
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
                    if(in <= list.size()) {
                        list.remove(in - 1);
                        System.out.println("Задача удалена!");
                    }
                    else
                        System.out.println("Задачи с таким номерм нет в списке! Количество дел в спске: "+ list.size());
                    break;
                case "4":
                    System.out.print("Введите задачу которую надо удалить: ");
                    input = scanner.nextLine();
                    String dealToDel = input;
                    for (int i = 0; i < list.size(); i++){
                        String word = list.get(i);
                        if(word.equals(dealToDel)){
                            System.out.println("Задача " + word + " успешно удалена!");
                            list.remove(word);
                            break;
                        }
                        else
                            System.out.println("Нет совпадений в списке задач, попробйте другой запрос");
                    }
                default:
            }
        }
        scanner.close();
    }
}