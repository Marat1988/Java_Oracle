package Task3;

import java.util.*;

public class Task3 {
    private static Set<Person> peoples = new HashSet<>();

    public static void main(String[] args) {
        /*Добавление тестовых данных*/
        Fine fine = new Fine(new GregorianCalendar(2020, Calendar.FEBRUARY, 1), "Административный штраф", 2000, TypeFine.ADMINISTRATIVE);
        Fine fine2 = new Fine(new GregorianCalendar(2021, Calendar.MAY, 2), "Криминальный штраф", 3000, TypeFine.CRIMINAL);
        Fine fine3 = new Fine(new GregorianCalendar(2022, Calendar.JULY, 3), "Штраф", 3000, TypeFine.CUSTOM);
        Fine fine4 = new Fine(new GregorianCalendar(2023, Calendar.APRIL, 4), "Административный штраф", 2000, TypeFine.ADMINISTRATIVE);

        Person student1 = new Person(1234, "Макс Панама", "Калининград");
        student1.addFine(fine);
        student1.addFine(fine2);

        Person student2 = new Person(5678, "Иван Иванович", "Москва");
        student2.addFine(fine3);
        student2.addFine(fine4);

        peoples.add(student1);
        peoples.add(student2);
        /*Работа с меню*/
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Выберите пункт меню: ");
            int chooseUser = scanner.nextInt();
            if (chooseUser == 9) {
                break;
            } else {
                switch (chooseUser) {
                    case 1 -> printInfo();
                    case 2 -> printInfoByPersonalCode();
                    case 3 -> printInfoByTypeCode();
                    case 4 -> printInfoByCity();
                    case 5 -> addNewPeople();
                    case 6 -> addFineForPerson();
                    case 7 -> deleteFineForPerson();
                    case 8 -> updateInformationPeopleAndHisFines();
                    default -> System.out.println("Не корректтный выбор пункта меню");
                }
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Меню");
        System.out.println("===================================================================");
        System.out.println("Введите 1 для полной распечатки базы данных;\n" +
                "Введите 2 для распечатки по персональному коду;\n" +
                "Введите 3 для полной распечатки по типу штрафа;\n" +
                "Введите 4 для распечатки по городу;\n" +
                "Введите 5 для добавление нового человека и информацией о нем;\n" +
                "Введите 6 для добавление новых штрафов для существующей записи;\n" +
                "Введите 7 для удаления штрафа;\n" +
                "Введите 8 для замены информации о человеке и его штрафах;\n" +
                "Введите 9 для выхода из программы");
        System.out.println("===================================================================");
    }

    private static void printInfo() { //Полная распечатка базы
        Person lastElement = null;
        for (Person people : peoples) {
            lastElement = people;
        }
        final int code = lastElement.getPersonalCode();
        System.out.println("{");
        peoples.forEach(person -> System.out.println("\"" + person.getPersonalCode() + "\":" + person + (person.getPersonalCode() == code ? "" : ",")));
        System.out.println("}");
    }

    private static void printInfoByPersonalCode() { //Распечатка по персональному коду
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите персональный код человека: ");
        try {
            int personalCode = scanner.nextInt();
            System.out.println("{");
            peoples.stream().filter(person -> person.getPersonalCode() == personalCode).forEach(person -> System.out.println("\"" + person.getPersonalCode() + "\":" + person));
            System.out.println("}");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printInfoByTypeCode() { //Распечатка по типу штрафа. Т.е. распечатываются те люди, у кого присутствует выбранный тип штрафа
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(Arrays.stream(TypeFine.values()).toList());
            System.out.print("Введите числовой тип штрафа из массива: ");
            int typeFine = scanner.nextInt();
            System.out.println("Распечатываются люди, у кого присутствует выбранный Вами тип штрафа");
            System.out.println("{");
            List<Person> choosePersons = peoples.stream().filter(person -> person.getFines().stream().anyMatch(fine -> fine.getTypeFineCode() == typeFine)).toList();
            if (!choosePersons.isEmpty()) {
                final int lastCode = choosePersons.get(choosePersons.size() - 1).getPersonalCode();
                choosePersons.forEach(person -> System.out.println("\"" + person.getPersonalCode() + "\":" + person + (person.getPersonalCode() == lastCode ? "" : ",")));
            }
            System.out.println("}");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printInfoByCity() { //Распечатываются люди из введенного Вами города
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите город: ");
            String city = scanner.next();
            System.out.println("{");
            List<Person> choosePersons = peoples.stream().filter(person -> person.getCity().equals(city)).toList();
            if (!choosePersons.isEmpty()) {
                final int lastCode = choosePersons.get(choosePersons.size() - 1).getPersonalCode();
                choosePersons.forEach(person -> System.out.println("\"" + person.getPersonalCode() + "\":" + person + (person.getPersonalCode() == lastCode ? "" : ",")));
            }
            System.out.println("}");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addNewPeople() { //Добавление нового человека
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код: ");
            int personalCode = scanner.nextInt();
            System.out.print("Введите полное ФИО: ");
            String fullname = scanner.next();
            System.out.print("Введите город: ");
            String city = scanner.next();
            peoples.add(new Person(personalCode, fullname, city));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addFineForPerson() { //Добавление штрафа для существующей записи
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код: ");
            int personalCode = scanner.nextInt();
            Optional<Person> choosePerson = peoples.stream().filter(person -> person.getPersonalCode() == personalCode).findFirst();
            if (choosePerson.isPresent()) {
                System.out.print("Введите год щтрафа: ");
                int yearFine = scanner.nextInt();
                System.out.print("Введите месяц штрафа (от 0 до 11): ");
                int monthFine = scanner.nextInt();
                System.out.print("Введите день штрафа: ");
                int dayFine = scanner.nextInt();
                System.out.print("Введите описание штрафа: ");
                String fineDescription = scanner.next();
                System.out.println(Arrays.stream(TypeFine.values()).toList());
                System.out.print("Введите числовой тип штрафа из массива: ");
                int typeFine = scanner.nextInt();
                System.out.print("Введите сумму штрафа: ");
                double amountFine = scanner.nextDouble();
                choosePerson.get().addFine(new Fine(new GregorianCalendar(yearFine, monthFine, dayFine), fineDescription, amountFine, TypeFine.values()[typeFine]));
            } else {
                System.out.println("Запись не найдена");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void deleteFineForPerson() { //Удаление щтрафа для существующей записи
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите персональный код: ");
            int personalCode = scanner.nextInt();
            Optional<Person> choosePerson = peoples.stream().filter(person -> person.getPersonalCode() == personalCode).findFirst();
            if (choosePerson.isPresent()) {
                for (int i = 0; i < choosePerson.get().getFines().size(); i++) {
                    System.out.println("Номер штрафа: " + i + " " + choosePerson.get().getFines().get(i));
                }
                System.out.print("Введите номер штрафа для удаления: ");
                int indexFine = scanner.nextInt();
                choosePerson.get().removeFine(indexFine);
            } else {
                System.out.println("Запись не найдена");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void updateInformationPeopleAndHisFines() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите персональный код: ");
        int personalCode = scanner.nextInt();
        Optional<Person> choosePerson = peoples.stream().filter(person -> person.getPersonalCode() == personalCode).findFirst();
        if (choosePerson.isPresent()) {
            System.out.print("Введите новое значение города человека: ");
            String newCity = scanner.next();
            choosePerson.get().setCity(newCity);
            for (int i = 0; i < choosePerson.get().getFines().size(); i++) {
                System.out.println("Номер штрафа: " + i + " " + choosePerson.get().getFines().get(i));
            }
            System.out.print("Введите номер штрафа для обновления информации: ");
            int indexFine = scanner.nextInt();
            System.out.print("Введите новую сумму выбранного штрафа: ");
            double newAmountFine = scanner.nextDouble();
            System.out.print("Введите новое описание штрафа: ");
            String newDescriptionFine = scanner.next();
            choosePerson.get().getFines().get(indexFine).setAmountFine(newAmountFine);
            choosePerson.get().getFines().get(indexFine).setDescription(newDescriptionFine);
        } else {
            System.out.println("Запись не найдена");
        }
    }
}
