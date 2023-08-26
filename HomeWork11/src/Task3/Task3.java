package Task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Task3 {

    private static final List<Device> devices = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        devices.add(new Device("Клавиатура", 2022, 85.5, "Белый", TYPE_DEVICE.inputDevice));
        devices.add(new Device("Микрофон", 2021, 150.5, "Черный", TYPE_DEVICE.inputDevice));
        devices.add(new Device("Сканер", 2015, 1400.5, "Серый", TYPE_DEVICE.inputDevice));
        devices.add(new Device("Принтер", 2020, 15456.5, "Черный", TYPE_DEVICE.outputDevice));
        devices.add(new Device("Наушники", 2019, 1500, "Синий", TYPE_DEVICE.outputDevice));
        devices.add(new Device("Монитор", 2023, 25000, "Черный", TYPE_DEVICE.outputDevice));

        System.out.println("Введите:\n" +
                "1). Показать все устройства;\n" +
                "2). Показать все устройства заданного цвета;\n" +
                "3). Показать все устройства заданного года выпуска;\n" +
                "4). Показать все устройства дороже заданной цены;\n" +
                "5). Показать все устройства заданного типа;\n" +
                "6). Показать все устройства, чей год выпуска находится в указанном диапазоне\n" +
                "7). Для выхода\n");

        int inputUser = scanner.nextInt();
        while (inputUser != 7) {
            switch (inputUser) {
                case 1 -> devices.forEach(System.out::println);
                case 2 -> showInfoDeviceColor();
                case 3 -> showInfoDeviceYearRelease();
                case 4 -> showInfoDevicePrice();
                case 5 -> showInfoDeviceFindTypeDevice();
                case 6 -> showInfoDeviceRangeYearRelease();
                default -> System.out.println("Не корректный ввод");
            }
            System.out.print("Введите следующий пункт меню или введите 7 для выхода: ");
            inputUser = scanner.nextInt();
        }
    }

    private static void showInfoDeviceColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цвет для поиска: ");
        String color = scanner.next();
        showInfo(devices, device -> device.getColor().equals(color));
    }

    private static void showInfoDeviceYearRelease() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год выпуска для поиска: ");
        int yearRelease = scanner.nextInt();
        showInfo(devices, device -> device.getYearRelease() == yearRelease);
    }

    private static void showInfoDevicePrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цену для поиска дороже заданной цены: ");
        double price = scanner.nextDouble();
        showInfo(devices, device -> device.getPrice() > price);
    }

    private static void showInfoDeviceFindTypeDevice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(TYPE_DEVICE.values()).toList());
        System.out.print("Введите числовой тип устройства: ");
        int typeDevice = scanner.nextInt();
        showInfo(devices, device -> device.getTypeDeviceCode() == typeDevice);
    }

    private static void showInfoDeviceRangeYearRelease() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало диапазона: ");
        int yearReleaseBegin = scanner.nextInt();
        System.out.print("Введите конец диапазона: ");
        int yearReleaseEnd = scanner.nextInt();
        showInfo(devices, device -> device.getYearRelease() >= Math.min(yearReleaseBegin, yearReleaseEnd) && device.getYearRelease() <= Math.max(yearReleaseBegin, yearReleaseEnd));
    }

    private static void showInfo(List<Device> devices, Predicate<Device> predicate) {
        for (Device device : devices) {
            if (predicate.test(device)) {
                System.out.println(device);
            }
        }
    }
}
