package Task1;

import java.util.*;


public class Task1 {
    private static LinkedList<Passenger> passengers = new LinkedList<>(); //Массив для хранения информации о приходящих пассажиров на остановку
    private static List<Passenger> smelledPassengers = new ArrayList<>(); //Для хранения информации о убывших (севших в катер) парражиров
    private static List<Statistic> statisticsCountPassenger = new ArrayList<>(); //Для хранения статистики количества пассажиров на остановке при пребывании катера на остановку.
    private static int countPassenger = 0; //Переменная для хранения информации об общем количестве пассажиров за день
    private static final int maxCountPassengerBoat = 20; //Максимальная вместимость пассажиров в катере.
    private static boolean endingStation = false; //Конечная остановка

    public static void main(String[] args) {
        /*Утреннее время с 8:00 до 12:00 (с 480 минуты по 720 минуты)*/
        /*Дневное время с 12:00 до 17:00 (c 720 минуты по 1020 минуты)*/
        /*Вечернее время с 17:00 до 21:00 (c 1020 минуты по 1260 минуты)*/
        int[] timeAppearancePassengersStop = new int[3]; //Массив, хранящий среднее время появления пассажиров на остановке в утреннее, дневное и вечернее время
        int[] timeAppearanceBoatStop = new int[3]; //Массив, хранящий среднее время появления катера на остановке


        int currentTime = 480; //480 минут. Это 8 утра.
        int averageTimePassengerStop = 2; //среднее время появления пассажира на остановке (в минутах)
        int averageTimeBoatStop = 10; //среднее время появления катера на остановке (в минутах)
        System.out.println("Имитационная модель «причал морских катеров»");
        System.out.println("Стартовое время: " + currentTime / 60 + ":" + (((currentTime % 60) < 10) ? "0" + currentTime % 60 : currentTime % 60));

        while (currentTime < 1020) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            currentTime++;
            if (currentTime % averageTimePassengerStop == 0) {
                Passenger passenger = new Passenger("Пассажир " + countPassenger, currentTime);
                passengers.add(passenger);
                System.out.println(passenger);
                countPassenger++;
            }
            if (currentTime % averageTimeBoatStop == 0) {
                int countFreePlace = (int) (Math.random() * maxCountPassengerBoat + 1);
                System.out.println("Внимание. Прибыл катер. Количество свободных мест: " + countFreePlace);
                System.out.print("Введите тип остановки (true - конечная, false - не конечная): ");
                try  {
                    Scanner scanner = new Scanner(System.in);
                    endingStation = scanner.nextBoolean();
                } catch (Exception e) {
                    System.out.println("Не корректный ввод. Остановку будем считать не конечной");
                    endingStation = false;
                }
                if (!endingStation) {
                    statisticsCountPassenger.add(new Statistic(currentTime, passengers.size())); //Добавляем информацию в статистику
                    while (countFreePlace > 0 && !passengers.isEmpty()) {
                        Passenger p = passengers.poll(); //Получаем и удаляем пассажира из остановки
                        p.setDepartureTimeStop(currentTime); //Присваиваем пассажиру время убытия из остановки
                        System.out.println(p.getName() + " сел в катер в " + currentTime / 60 + ":" + (((currentTime % 60) < 10) ? "0" + currentTime % 60 : currentTime % 60));
                        smelledPassengers.add(p); //Добавляем в массив убывших пассажиров
                        countFreePlace--;
                    }
                }
            }
        }
        System.out.println("Вывод статистической информации");
        System.out.println("================================================================");
        OptionalDouble averagePassengerWholeDay = smelledPassengers.stream()
                .mapToInt(value -> value.getDepartureTimeStop() - value.getArrivalTimeStop())
                .average();
        OptionalDouble averagePassengerMorningTime = smelledPassengers.stream()
                .filter(item -> item.getArrivalTimeStop() >= 480 && item.getArrivalTimeStop() < 720)
                .mapToInt(value -> value.getDepartureTimeStop() - value.getArrivalTimeStop())
                .average();
        OptionalDouble averagePassengerDayTime = smelledPassengers.stream()
                .filter(item -> item.getArrivalTimeStop() >= 720 && item.getArrivalTimeStop() < 1020)
                .mapToInt(value -> value.getDepartureTimeStop() - value.getArrivalTimeStop())
                .average();
        OptionalDouble averagePassengerEveningTime = smelledPassengers.stream()
                .filter(item -> item.getArrivalTimeStop() >= 1020 && item.getArrivalTimeStop() <= 1260)
                .mapToInt(value -> value.getDepartureTimeStop() - value.getArrivalTimeStop())
                .average();
        if (averagePassengerWholeDay.isPresent()) {
            System.out.println("Среднее время пребывания человека на остановке (в минутах) за целый день: " + Math.round(averagePassengerWholeDay.getAsDouble()));
        }
        if (averagePassengerMorningTime.isPresent()) {
            System.out.println("Среднее время пребывания человека на остановке (в минутах) в утреннее время суток (с 8:00 до 12:00): " + Math.round(averagePassengerMorningTime.getAsDouble()));
        }
        if (averagePassengerDayTime.isPresent()) {
            System.out.println("Среднее время пребывания человека на остановке (в минутах) в дневное время суток (с 12:00 до 17:00): " + Math.round(averagePassengerDayTime.getAsDouble()));
        }
        if (averagePassengerEveningTime.isPresent()) {
            System.out.println("Среднее время пребывания человека на остановке (в минутах) в вечернее время суток (с 17:00 до 21:00): " + Math.round(averagePassengerEveningTime.getAsDouble()));
        }
    }
}
