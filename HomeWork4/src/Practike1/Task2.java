package Practike1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> maps = new HashMap<>();
        maps.put("Марат", "1234");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Нажмите:\n1. Для добавления нового пользователя;" +
                    "\n2. Для удаления пользователя;" +
                    "\n3. Для проверки существования пользователя;" +
                    "\n4. Для изменения логина пользователя;" +
                    "\n5. Для изменения пароля пользователя;" +
                    "\n6. Для выхода из программы");
            int ChooseUser = scanner.nextInt();
            if (ChooseUser == 6) {
                break;
            } else {
                switch (ChooseUser) {
                    case 1:
                        System.out.print("Введите логин: ");
                        String newAddLogin = scanner.next();
                        System.out.print("Введите пароль: ");
                        String newAddPassword = scanner.next();
                        maps.put(newAddLogin, newAddPassword);
                        break;
                    case 2:
                        System.out.print("Введите логин пользователя, который вы хотите удалить ");
                        String deleteLogin = scanner.next();
                        if (maps.containsKey(deleteLogin)) {
                            maps.remove(deleteLogin);
                        }
                        break;
                    case 3:
                        System.out.print("Введите логин пользователя для проверки существования ");
                        String findUser = scanner.next();
                        if (maps.containsKey(findUser)) {
                            System.out.println("Пользователь найден");
                        } else {
                            System.out.println("Пользователь не найден");
                        }
                        break;
                    case 4:
                        System.out.print("Введите логин пользователя для проверки существования ");
                        String findUser2 = scanner.next();
                        if (maps.containsKey(findUser2)) {
                            String password = maps.get(findUser2);
                            System.out.println("Введите новый логин пользователя: ");
                            String newLogin = scanner.next();
                            maps.put(newLogin, password);
                        }
                        break;
                    case 5:
                        System.out.print("Введите логин пользователя для проверки существования ");
                        String findUser3 = scanner.next();
                        if (maps.containsKey(findUser3)) {
                            System.out.println("Введите новый пароль пользователя: ");
                            String password = maps.get(findUser3);
                            String passwordNew = scanner.next();
                            maps.replace(findUser3, password, passwordNew);
                        }
                        break;
                }
            }
        }
        System.out.println(maps);
    }
}
