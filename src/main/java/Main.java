import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        // Заполнение массива машин - участников
        for (int i = 0; i < race.cars.length; i++) {
            String name = "";
            int speed = -1;

            while (name.isBlank()) {
                System.out.println("Введите название машины №" + (i + 1));
                name = scanner.next();
            }

            while (speed <= 0 || speed > 250) {
                System.out.printf("Введите скорость машины '%s' В диапазоне от 1 до 250 \n", name);

                // Проверка введенной скорости на тип данных и диапазон
                try {
                    speed = Integer.parseInt(scanner.next());
                    if (speed <= 0 || speed > 250) {
                        System.out.println("Ошибка. Введенная скорость вне диапазона 1 - 250");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введенное значение должно быть типа Integer. Ошибка: " + e.getMessage());
                }
            }

            race.cars[i] = new Car (name, speed);
        }

        Car leader = race.getLeader();
        ArrayList<Car> contenders = race.getDrawList(leader);   //Список машин, финишировавших одновременно с лидером

        if (contenders.size() > 1) {
            System.out.println("Первое место делят машины: ");
            for (Car contender : contenders) {
                System.out.println(contender.name);
            }
        } else {
            System.out.println("Самая быстрая машина: " + leader.name);
        }

        scanner.close();
    }
}