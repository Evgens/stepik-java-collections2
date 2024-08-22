import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {

    private CarCollection carCollection;

    @BeforeEach
    void setUp() {
        carCollection = new CarArrayList();
//        carCollection = new CarLinkedList();
//        carCollection = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("Brand" + i, i));
        }
    }

    @Test
    void contains() {
        assertTrue(carCollection.contains(new Car("Brand5", 5)));
        assertFalse(carCollection.contains(new Car("BMW", 5)));
    }
}