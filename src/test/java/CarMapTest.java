import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarMapTest {

    private CarMap carMap;

    @BeforeEach
    void setUp() {
        carMap = new CarHashMap();
        for (int i = 0; i < 100; i++) {
            carMap.put(new CarOwner(i, "Name" + i, "lastName" + i), new Car("Brand" + i, i));
        }
    }

    @Test
    void put() {
        assertEquals(100, carMap.size());
        carMap.put(new CarOwner(999, "Иванов", "Иван"), new Car("BMW", 1));
        assertEquals(101, carMap.size());
    }

    @Test
    void get() {
        Car car = carMap.get(new CarOwner(1,"Name1", "lastName1"));
        assertEquals("Brand1", car.brand);
    }

    @Test
    void keySet() {
        Set<CarOwner> carOwnerSet = carMap.keySet();
        assertEquals(carOwnerSet.size(), 100);
    }

    @Test
    void values() {
        List<Car> carList = carMap.values();
        assertEquals(100, carList.size());
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
        carMap.clear();
        assertEquals(0, carMap.size());
    }
}