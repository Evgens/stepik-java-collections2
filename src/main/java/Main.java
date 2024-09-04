import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Set<Car> cars = new TreeSet<>(new Comparator<Car>() {
//            @Override
//            public int compare(Car o1, Car o2) {
//                return o1.getBrand().compareTo(o2.getBrand());
//            }
//        });
//        for (int i = 0; i < 100; i++) {
//            cars.add(new Car("Brand" + i, i));
//        }
//        for (Car car : cars) {
//            System.out.println(car);
//        }

        Set<Integer> numbers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (o1 > o2) return -1;
//                if (o1 < o2) return 1;
//                return 0;
                return -o1.compareTo(o2);
            }
        });
        for (int i = 0; i < 100; i++) {
            numbers.add((int) (Math.random() * 10));
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
