package Practike1;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите набор чисел через запятую (например 1,2,3): ");
        String line = scanner.next();
        int[] numbers = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        while (true) {
            System.out.println("Нажмите:\n1. Для добавления элемента в список;" +
                    "\n2. Для удаления элемента из списка;" +
                    "\n3. Для показа содержимого списка;" +
                    "\n4. Для проверки значения в списке;" +
                    "\n5. Замены значения в списке;" +
                    "\n6. Для выхода из программы");
            int ChooseUser = scanner.nextInt();
            if (ChooseUser == 6) {
                break;
            } else {
                switch (ChooseUser) {
                    case 1:
                        System.out.print("Введите значение: ");
                        int userNumber = scanner.nextInt();
                        list.add(userNumber);
                        break;
                    case 2:
                        System.out.print("Введите индекс элемента, который вы хотите удалить: ");
                        int userDeleteIndexNumber = scanner.nextInt();
                        list.remove(userDeleteIndexNumber);
                        break;
                    case 3:
                        list.forEach(System.out::println);
                        break;
                    case 4:
                        System.out.print("Введите значение, который вы хотите найти: ");
                        int userSearchNumber = scanner.nextInt();
                        if (list.stream().anyMatch(integer -> (integer == userSearchNumber))) {
                            System.out.println("Такое значение есть в списке");
                        } else {
                            System.out.println("Такого значения нет в списке");
                        }
                        break;
                    case 5:
                        System.out.println("Введите значение, которое вы хотите заменить: ");
                        int userFindForReplaceNumber = scanner.nextInt();
                        System.out.println("Введите значение, на которое вы хотите заменить: ");
                        int userNewNumber = scanner.nextInt();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i) == userFindForReplaceNumber) {
                                list.set(i, userNewNumber);
                            }
                        }
                        break;
                    default:
                        System.out.println("Не верно задан номер выбора");
                        break;
                }
            }
        }
    }
}
