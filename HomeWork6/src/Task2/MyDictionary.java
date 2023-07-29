package Task2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MyDictionary {
    public static HashMap<Word, TreeSet<String>> wordStringHashMap = new HashMap<>();

    public static void main(String[] args) {
        wordStringHashMap.put(new Word("выбирать", (int) (Math.random() * 10)), new TreeSet<>(Arrays.asList("select", "choose")));
        wordStringHashMap.put(new Word("билет", (int) (Math.random() * 10)), new TreeSet<>(List.of("ticket")));
        wordStringHashMap.put(new Word("зима", (int) (Math.random() * 10)), new TreeSet<>(List.of("winter")));
        wordStringHashMap.put(new Word("кот", (int) (Math.random() * 10)), new TreeSet<>(List.of("cat")));
        wordStringHashMap.put(new Word("мама", (int) (Math.random() * 10)), new TreeSet<>(List.of("mother")));
        wordStringHashMap.put(new Word("молоко", (int) (Math.random() * 10)), new TreeSet<>(List.of("milk")));
        wordStringHashMap.put(new Word("игра", (int) (Math.random() * 10)), new TreeSet<>(List.of("game")));
        wordStringHashMap.put(new Word("пират", (int) (Math.random() * 10)), new TreeSet<>(List.of("pirate")));
        wordStringHashMap.put(new Word("автомобиль", (int) (Math.random() * 10)), new TreeSet<>(List.of("car")));
        wordStringHashMap.put(new Word("море", (int) (Math.random() * 10)), new TreeSet<>(List.of("sea")));
        wordStringHashMap.put(new Word("письмо", (int) (Math.random() * 10)), new TreeSet<>(List.of("letter")));
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int chooseUser = scanner.nextInt();
            if (chooseUser == 11) {
                break;
            } else {
                switch (chooseUser) {
                    case 1 -> showWord(wordStringHashMap.size(), true);
                    case 2 -> insertWordAndTranslate();
                    case 3 -> updateWord();
                    case 4 -> deleteWord();
                    case 5 -> findTranslateWord();
                    case 9 -> showWord(10, true);
                    case 10 -> showWord(10, false);
                    default -> System.out.println("Не корректный выбор пункта меню");
                }
            }
        }
        scanner.close();
//        String searchWord = "Марат";
//
//        System.out.println(wordStringHashMap.get(new Word("Марат")));
//
//        wordStringHashMap.get(new Word("Марат"));
//
//
//        Optional<Map.Entry<Word, TreeSet<String>>> findWord = wordStringHashMap
//                .entrySet()
//                .stream()
//                .filter(item -> item.getKey().getWord(searchWord))
//                .findFirst();
//
//        if (findWord.isPresent()) {
//            System.out.println("Найденное значение: " + findWord.get());
//            TreeSet<String> strings = findWord.get().getValue();
//            strings.add("Марат");
//            findWord.get().setValue(strings);
//        }
//
//
//        wordStringHashMap
//                .entrySet()
//                .stream()
//                .sorted((o2, o1) -> Integer.compare(o1.getKey().getPopularCount(), o2.getKey().getPopularCount()))
//                .forEach(e -> {
//                    System.out.println(e.getKey());
//                });
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
            if (wordStringHashMap.containsKey(new Word(userWord))) {
                System.out.println("Слово уже присутствует в словаре");
            } else {
                wordStringHashMap.put(new Word(userWord), new TreeSet<>(List.of(userTranslate)));
                System.out.println("Слово и перевод успешно добавлено в словарь");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
    }

    public static void updateWord() { //Для обновления слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для обновления: ");
        String userWord = scanner.next();
        if (wordStringHashMap.containsKey(new Word(userWord))) {
            try {
                System.out.print("Введите новое слово: ");
                String newUserWord = scanner.next();
                Optional<Map.Entry<Word, TreeSet<String>>> findWord = wordStringHashMap
                        .entrySet()
                        .stream()
                        .filter(item -> item.getKey().getWord(userWord)) //Для увеличения счетчика обращений. Считаю, что если вызван метод getWord с передачей параметра, то счетчик обращений в классе увеличивается
                        .findFirst();
                Word updateWord = new Word(newUserWord, findWord.get().getKey().getPopularCount());
                TreeSet<String> translateWords = findWord.get().getValue();
                wordStringHashMap.remove(new Word(userWord));
                wordStringHashMap.put(updateWord, translateWords);
                System.out.println("Обновление слова выполнено.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Искомое слово не найдено");
        }
        scanner.close();
    }

    public static void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для удаления: ");
        String wordFindUser = scanner.next();
        try {
            if (wordStringHashMap.containsKey(new Word(wordFindUser))) {
                wordStringHashMap.remove(new Word(wordFindUser));
                System.out.println("Удаление слова выполнено");
            } else {
                System.out.println("Искомое слово для удаления не найдено");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Отображение слов.
    // long limit - сколько слов нужно отобразить.
    // boolean orderPopular - сортировать по популярности слов на основе счетчика обращений
    public static void showWord(long limit, boolean orderPopular) {
        System.out.println("===================================================================");
        wordStringHashMap
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(orderPopular ? o2.getKey().getPopularCount() : o1.getKey().getPopularCount(), orderPopular ? o1.getKey().getPopularCount() : o2.getKey().getPopularCount()))
                .limit(limit)
                .forEach(item -> System.out.println(item.getKey() + " Переводы: " + item.getValue()));
        System.out.println("===================================================================");
    }

    public static void findTranslateWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String userWord = scanner.next();
        if (wordStringHashMap.containsKey(new Word(userWord))) {
            Optional<Map.Entry<Word, TreeSet<String>>> findWord = wordStringHashMap
                    .entrySet()
                    .stream()
                    .filter(item -> item.getKey().getWord(userWord)) //Для увеличения счетчика обращений. Считаю, что если вызван метод getWord с передачей параметра, то счетчик обращений в классе увеличивается
                    .findFirst();
            System.out.println(findWord.get().getValue());
        } else {
            System.out.println("Искомое слово в словаре не найдено");
        }
        scanner.close();
    }
}
