package Task2;

import java.util.*;

public class Task2 {
    public static HashMap<Word, TreeSet<String>> dictionary = new HashMap<>();

    public static void main(String[] args) {
        dictionary.put(new Word("выбирать", (int) (Math.random() * 10)), new TreeSet<>(Arrays.asList("select", "choose")));
        dictionary.put(new Word("билет", (int) (Math.random() * 10)), new TreeSet<>(List.of("ticket")));
        dictionary.put(new Word("зима", (int) (Math.random() * 10)), new TreeSet<>(List.of("winter")));
        dictionary.put(new Word("кот", (int) (Math.random() * 10)), new TreeSet<>(List.of("cat")));
        dictionary.put(new Word("мама", (int) (Math.random() * 10)), new TreeSet<>(List.of("mother")));
        dictionary.put(new Word("молоко", (int) (Math.random() * 10)), new TreeSet<>(List.of("milk")));
        dictionary.put(new Word("игра", (int) (Math.random() * 10)), new TreeSet<>(List.of("game")));
        dictionary.put(new Word("пират", (int) (Math.random() * 10)), new TreeSet<>(List.of("pirate")));
        dictionary.put(new Word("автомобиль", (int) (Math.random() * 10)), new TreeSet<>(List.of("car")));
        dictionary.put(new Word("море", (int) (Math.random() * 10)), new TreeSet<>(List.of("sea")));
        dictionary.put(new Word("письмо", (int) (Math.random() * 10)), new TreeSet<>(List.of("letter")));
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Выберите пункт меню: ");
            int chooseUser = scanner.nextInt();
            if (chooseUser == 11) {
                break;
            } else {
                switch (chooseUser) {
                    case 1 -> showWord(dictionary.size(), true);
                    case 2 -> insertWordAndTranslate();
                    case 3 -> updateWord();
                    case 4 -> deleteWord();
                    case 5 -> findTranslateWord();
                    case 6 -> addTranslateWord();
                    case 7 -> updateTranslateWord();
                    case 8 -> clearAllTranslateWord();
                    case 9 -> showWord(10, true);
                    case 10 -> showWord(10, false);
                    default -> System.out.println("Не корректный выбор пункта меню");
                }
            }
        }
        scanner.close();
    }

    public static void showMenu() { //Отображение меню
        System.out.println("Меню");
        System.out.println("===================================================================");
        System.out.println("Введите 1 для отображения списка слов;\n" +
                "Введите 2 для добавления (начального ввода) слова и перевода;\n" +
                "Введите 3 для изменения слова;\n" +
                "Введите 4 для удаления слова;\n" +
                "Введите 5 для отображения перевода слова;\n" +
                "Введите 6 для добавления перевода слова;\n" +
                "Введите 7 для изменения перевода слова;\n" +
                "Введите 8 для удаления всех переводов у слова;\n" +
                "Введите 9 для отображения ТОП-10 самых популярных слов;\n" +
                "Введите 10 для отображения ТОП-10 самых не популярных слов;\n" +
                "Введите 11 для выхода из программы");
        System.out.println("===================================================================");
    }

    public static void insertWordAndTranslate() { //Добавления слова и перевода
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String userWord = scanner.next();
        System.out.print("Введите перевод слова: ");
        String userTranslate = scanner.next();
        try {
            if (dictionary.containsKey(new Word(userWord))) {
                System.out.println("Слово уже присутствует в словаре");
            } else {
                dictionary.put(new Word(userWord), new TreeSet<>(List.of(userTranslate)));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void updateWord() { //Для обновления слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для обновления: ");
        String userWord = scanner.next();
        if (dictionary.containsKey(new Word(userWord))) {
            try {
                System.out.print("Введите новое слово: ");
                String newUserWord = scanner.next();
                Optional<Map.Entry<Word, TreeSet<String>>> findWord = dictionary
                        .entrySet()
                        .stream()
                        .filter(item -> item.getKey().getWord().equals(userWord))
                        .findFirst();
                Word updateWord = new Word(newUserWord, findWord.get().getKey().getPopularCount());
                TreeSet<String> translateWords = findWord.get().getValue();
                dictionary.remove(new Word(userWord));
                dictionary.put(updateWord, translateWords);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Искомое слово не найдено");
        }
    }

    public static void deleteWord() { //Для удаления слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для удаления: ");
        String wordFindUser = scanner.next();
        try {
            if (dictionary.containsKey(new Word(wordFindUser))) {
                dictionary.remove(new Word(wordFindUser));
            } else {
                System.out.println("Искомое слово для удаления не найдено");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTranslateWord() { //Для добавления перевода слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String wordFindUser = scanner.next();
        try {
            if (dictionary.containsKey(new Word(wordFindUser))) {
                System.out.print("Введите перевод слова для добавления: ");
                String wordTranslate = scanner.next();
                dictionary.get(new Word(wordFindUser)).add(wordTranslate);
            } else {
                System.out.println("Искомое слово не найдено");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateTranslateWord() { //Для обновления перевода слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String wordFindUser = scanner.next();
        try {
            if (dictionary.containsKey(new Word(wordFindUser))) {
                System.out.print("Введите перевод слова для обновления: ");
                String findTranslateInWord = scanner.next();
                if (dictionary.get(new Word(wordFindUser)).contains(findTranslateInWord)) {
                    System.out.print("Введите новый перевод слова: ");
                    String newTranslateWord = scanner.next();
                    dictionary.get(new Word(wordFindUser)).remove(findTranslateInWord);
                    dictionary.get(new Word(wordFindUser)).add(newTranslateWord);
                } else {
                    System.out.println("Перевод у данного слова не найден!");
                }
            } else {
                System.out.println("Искомое слово не найдено");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearAllTranslateWord() { //Для удаления всех переводов слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String wordFindUser = scanner.next();
        try {
            if (dictionary.containsKey(new Word(wordFindUser))) {
                dictionary.get(new Word(wordFindUser)).clear();
            } else {
                System.out.println("Искомое слово не найдено");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void findTranslateWord() { //Для поиска перевода слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String userWord = scanner.next();
        if (dictionary.containsKey(new Word(userWord))) {
            Optional<Map.Entry<Word, TreeSet<String>>> findWord = dictionary
                    .entrySet()
                    .stream()
                    .filter(item -> item.getKey().getWord(userWord)) //Для увеличения счетчика обращений. Считаю, что если вызван метод getWord с передачей параметра, то счетчик обращений в классе увеличивается
                    .findFirst();
            System.out.println(findWord.get().getValue());
        } else {
            System.out.println("Искомое слово в словаре не найдено");
        }
    }

    //Отображение слов.
    // long limit - сколько слов нужно отобразить.
    // boolean orderPopular - сортировать по популярности слов на основе счетчика обращений
    public static void showWord(long limit, boolean orderPopular) {
        System.out.println("===================================================================");
        dictionary
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(orderPopular ? o2.getKey().getPopularCount() : o1.getKey().getPopularCount(), orderPopular ? o1.getKey().getPopularCount() : o2.getKey().getPopularCount()))
                .limit(limit)
                .forEach(item -> System.out.println(item.getKey() + " Переводы: " + item.getValue()));
        System.out.println("===================================================================");
    }
}
