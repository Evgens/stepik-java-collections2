public interface CarCollection<T> extends Iterable<T> {
    boolean add(T car);

    boolean remove(T car);

    void clear();

    int size();

    boolean contains(T car);
}
