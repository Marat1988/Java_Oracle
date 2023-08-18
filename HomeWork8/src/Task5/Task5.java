package Task5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Task5 {
    private static final File allEmployeesFromFile = new File("employees.txt"); //по-умолчанию в корне каталога будут храниться все сотрудники
    private static  Set<Employee> allEmployees = new HashSet<>(); //Для хранения всех сотрудников корпорации
    public static Set<Employee> chooseUserEmployees = new HashSet<>(); //Для сохранения выбранных сотрудников пользователя по критерию и записи (при необходимости) информации в файл

    public static void main(String[] args) {
        createFilesWithEmployees();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу для загрузки списка сотрудников: ");
        String pathFile = scanner.next();

        try {
            System.out.println("Автозагрузка списка всех пользователей......");
            Thread.sleep(1000);
            allEmployees = autoLoadingFromFile(allEmployeesFromFile);
            System.out.println("Автозагрузка списка пользователей из выбранного Вами файла......");
            Thread.sleep(1000);
            chooseUserEmployees = autoLoadingFromFile(new File(pathFile));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Меню модификации данных сотрудников корпорации: ");
        System.out.println("Введите пункт выбора меню:\n" +
                "1 - Для показа списка всех сотрудников из выбранного вами файла;\n" +
                "2 - Для полного показа списка всех сотрудников корпорации;\n" +
                "3 - Для ввода нового сотрудника;\n" +
                "4 - Для редактирования данных сотрудника;\n" +
                "5 - Для удаления сотрудника;\n" +
                "6 - Для выхода из меню");
        int chooseUserMenuAddEditDeleteEmployee = scanner.nextInt();
        //Меню добавления, удаления,  изменения данных сотрудника
        while (chooseUserMenuAddEditDeleteEmployee != 6) {
            switch (chooseUserMenuAddEditDeleteEmployee) {
                case 1 -> chooseUserEmployees.forEach(System.out::println);
                case 2 -> allEmployees.forEach(System.out::println);
                case 3 -> addEmployee();
                case 4 -> updateInfoEmployee();
                case 5 -> deleteEmployee();
                default -> System.out.println("Не корректный пункт выбора меню");
            }
            System.out.print("Выберите пукнт меню: ");
            chooseUserMenuAddEditDeleteEmployee = scanner.nextInt();
        }
        System.out.println("Меню поиска информации по критериям: ");
        //Меню поиска информации по критериям
        System.out.println("1 - Поиск сотрудника по фамилии;\n" +
                "2 - Поиск сотрудника по возрасту;\n" +
                "3 - Поиск по первой букве сотрудника;\n" +
                "4 - Для выхода из меню");
        int chooseUserMenuShowInfo = scanner.nextInt();
        while (chooseUserMenuShowInfo != 4) {
            switch (chooseUserMenuShowInfo) {
                case 1 -> searchEmployeeLastName();
                case 2 -> searchEmployeeAge();
                case 3 -> searchEmployeeLastNameFirstLetter();
                default -> System.out.println("Не корректный пункт выбора меню");
            }
            System.out.print("Выберите пукнт меню: ");
            chooseUserMenuShowInfo = scanner.nextInt();
        }
        saveInformationInFile(allEmployees, allEmployeesFromFile); //Автоматически сохраняем всех сотрудников в файл
        System.out.println("Введите \"да\" если хотите сохранить список сотрудников в файл по последнему выбранному Вами критерию. Если не хотите сохранять,  то введите что-нибудь другое: ");
        String inputUser = scanner.next();
        if (inputUser.equals("да")) {
            saveInformationInFile(chooseUserEmployees, new File(pathFile)); //Сохранение списка сотрдников в файл по критерию пользовтаеля
        }
    }

    //Если нет файла, то создаю
    private static void createFilesWithEmployees() {
        if (!allEmployeesFromFile.exists()) {
            try {
                allEmployeesFromFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Set<Employee> autoLoadingFromFile(File file) {  //Загружаю сотрудников из файла в коллекцию
        HashSet<Employee> employees = new HashSet<>();
        if (file.length() > 0) { //Проверка,   является ли файл пустым
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                employees = (HashSet<Employee>) objectInputStream.readObject();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return employees;
    }

    private static void addEmployee() { //Добавление информации сотрудника
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код сотрудника: ");
            int personalCode = scanner.nextInt();
            System.out.print("Введите имя сотрудника: ");
            String firstName = scanner.next();
            System.out.print("Введите фамилию сотрудника: ");
            String lastName = scanner.next();
            System.out.print("Введите возраст сотрудника: ");
            int age = scanner.nextInt();
            allEmployees.add(new Employee(personalCode, firstName, lastName, age));
            System.out.println("Сотрудник добавлен");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateInfoEmployee() { //Обновление информации о сотруднике
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код сотрудника: ");
            int personalCode = scanner.nextInt();
            Optional<Employee> chooseUserEmployee = allEmployees.stream()
                    .filter(item -> item.getPersonalCode() == personalCode)
                    .findFirst();
            if (chooseUserEmployee.isPresent()) {
                Employee employee = chooseUserEmployee.get();
                System.out.println("Сотрудник найден! " + employee);
                System.out.print("Введите новое имя сотрудника: ");
                String newFirstname = scanner.next();
                System.out.print("Введите новую фамилию сотрудника: ");
                String newLastName = scanner.next();
                System.out.print("Введите возраст сотрудника: ");
                int newAge = scanner.nextInt();
                employee.setFirstName(newFirstname);
                employee.setLastName(newLastName);
                employee.setAge(newAge);
                System.out.println("Информация обновлена!");
            } else {
                System.out.println("Сотрудник не найден");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код сотрудника: ");
            int personalCode = scanner.nextInt();
            Optional<Employee> chooseUserEmployee = allEmployees.stream()
                    .filter(item -> item.getPersonalCode() == personalCode)
                    .findFirst();
            if (chooseUserEmployee.isPresent()) {
                Employee employee = chooseUserEmployee.get();
                System.out.println("Сотрудник найден! " + employee);
                allEmployees.remove(employee);
                System.out.println("Сотрудник удален!");
            } else {
                System.out.println("Сотрудник не найден");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchEmployeeLastName() { //Поиск информации по фамилии
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите фамилию сотрудника для поиска: ");
            String findLastName = scanner.next();
            if (allEmployees.stream().anyMatch(item -> item.getLastName().equals(findLastName))) {
                chooseUserEmployees.clear(); //Удаляю  элементы
                chooseUserEmployees = allEmployees.stream()
                        .filter(item -> item.getLastName().equals(findLastName))
                        .collect(Collectors.toSet()); //И записываю новые
                System.out.println("Список сотрудников: ");
                chooseUserEmployees.forEach(System.out::println);
            } else {
                System.out.println("Сотрудники по выбраному критерию не были найдены!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchEmployeeAge() { //Поиск информации по возрасту
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите возраст сотрудника для поиска: ");
            int findAge = scanner.nextInt();
            if (allEmployees.stream().anyMatch(item -> item.getAge() == findAge)) {
                chooseUserEmployees.clear(); //Удаляю  элементы
                chooseUserEmployees = allEmployees.stream()
                        .filter(item -> item.getAge() == findAge)
                        .collect(Collectors.toSet()); //И записываю новые
                System.out.println("Список сотрудников: ");
                chooseUserEmployees.forEach(System.out::println);
            } else {
                System.out.println("Сотрудники по выбраному критерию не были найдены!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void searchEmployeeLastNameFirstLetter() { //Поиск по первой букве фамилии
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите первую букву фамилии для поиска: ");
            String firstLetter = scanner.next();
            if (allEmployees.stream().anyMatch(item -> item.getLastName().startsWith(firstLetter))) {
                chooseUserEmployees.clear(); //Удаляю  элементы
                chooseUserEmployees = allEmployees.stream()
                        .filter(item -> item.getLastName().startsWith(firstLetter))
                        .collect(Collectors.toSet()); //И записываю новые
                System.out.println("Список сотрудников: ");
                chooseUserEmployees.forEach(System.out::println);
            } else {
                System.out.println("Сотрудники по выбраному критерию не были найдены!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void saveInformationInFile(Set<Employee> employees, File file) { //Сохранение объектов в файл
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(employees);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
