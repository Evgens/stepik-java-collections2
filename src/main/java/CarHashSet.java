import java.util.Iterator;

public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private int size = 0;
    private Entry[] array = new Entry[INITIAL_CAPACITY];

    @Override
    public boolean add(Car car) {
        if (size >= (array.length * LOAD_FACTOR)) increaseArray();
        boolean added = add(car, array);
        if (added) size++;
        return added;
    }

    private boolean add(Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if (dst[position] == null) {
            dst[position] = new Entry(car, null);
            return true;
        }
        Entry existElement = dst[position];
        while (true) {
            if (existElement.value.equals(car)) {
                return false;
            } else if (existElement.next == null) {
                existElement.next = new Entry(car, null);
                return true;
            } else {
                existElement = existElement.next;
            }
        }
    }

    @Override
    public boolean remove(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            array[position] = last;
            size--;
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            } else {
                secondLast = last;
                last = last.next;
            }
        }

        return false;
    }

    @Override
    public boolean contains(Car car) {
        int position = getElementPosition(car, array.length);
        if (array[position] == null) {
            return false;
        }
        Entry secondLast = array[position];
        Entry last = secondLast.next;
        if (secondLast.value.equals(car)) {
            return true;
        }
        while (last != null) {
            if (last.value.equals(car)) {
                return true;
            } else {
                last = last.next;
            }
        }

        return false;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        array = new Entry[INITIAL_CAPACITY];
    }

    private void increaseArray() {
        Entry[] newArray = new Entry[array.length * 2];
        for (Entry entry : array) {
            Entry existedElement = entry;
            while (existedElement != null) {
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        array = newArray;
    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car car, Entry next) {
            this.value = car;
            this.next = next;
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {

            int index = 0;
            int count = 0;
            Entry entryNext;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Car next() {
                Car car;
                while (array[index] == null) {
                    index++;
                }

                if (entryNext == null) {
                    entryNext = array[index];
                }
                car = entryNext.value;
                count++;
                entryNext = entryNext.next;
                if (entryNext==null) index++;

                return car;
            }
        };
    }
}
