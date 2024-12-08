import java.util.ArrayList;

public class Race {
    static int raceDuration = 24;
    static Car[] cars = new Car[3];

    public static Car getLeader () {
        Car leader = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].speed * raceDuration > leader.speed * raceDuration) {
                leader = cars[i];
            }
        }
        return leader;
    }

    public static ArrayList<Car> getDrawList (Car car) {
        // Составляет список из машин в массиве, финишировавших одновременно с машиной car
        // Добавит в список хотя бы 1 элемент (car)
        ArrayList<Car> draw = new ArrayList<>();
        for (Car currentCar : cars) {
            if (currentCar.speed * raceDuration == car.speed * raceDuration) {
                draw.add(currentCar);
            }
        }
        return draw;
    }
}
