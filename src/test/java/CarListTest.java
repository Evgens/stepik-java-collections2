import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {
//    private CarList carList;
    private CarList<Car> carList;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        carList = new CarArrayList<>();
//        carList = new CarLinkedList<>();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustDe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }


    @Test //(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrownException() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->
                carList.get(100));
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirst() {
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLast() {
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void testContains(){
        assertTrue(carList.contains(new Car("Brand5", 5)));
        assertFalse(carList.contains(new Car("BMW", 5)));
    }
}