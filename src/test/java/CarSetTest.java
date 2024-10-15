import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet<Car> carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car("Brand" + i, i);
            carSet.add(car);
        }
    }

    @Test
    void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertEquals(101, carSet.size());
    }

    @Test
    void remove() {
        assertTrue(carSet.remove(new Car("Brand5", 5)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand5", 5)));
        assertEquals(99, carSet.size());
    }

    @Test
    void size() {
        assertEquals(100, carSet.size());
    }

    @Test
    void clear() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void testContains() {
        assertTrue(carSet.contains(new Car("Brand5", 5)));
        assertFalse(carSet.contains(new Car("BMW", 5)));
    }


}