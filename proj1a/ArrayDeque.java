/**
 * ArrayDeque
 */
public class ArrayDeque<T> {

    private static final int RFACTOR = 2;

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 7;
        nextLast = 0;
        size = 0;
    }

    private void resize(int capacity) {
        if (size > capacity) {
            System.out.println("size (" + size + ") larger than capacity (" + capacity + ")!");
        }

        T[] a = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            a[i] = get(i);
        }
        nextFirst = capacity - 1;
        nextLast = size;
        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * RFACTOR);
        }

        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size = size + 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * RFACTOR);
        }

        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if (size >= 16 && size < items.length / 4) {
            resize(items.length / RFACTOR);
        }

        T result = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size = size - 1;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (size >= 16 && size < items.length / 4) {
            resize(items.length / RFACTOR);
        }

        T result = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size = size - 1;
        return result;
    }

    public T get(int index) {
        return items[(nextFirst + index + 1) % items.length];
    }

    private int minusOne(int index) {
        if (index - 1 >= 0) {
            return index - 1;
        } else {
            return items.length - 1;
        }
    }

    private int plusOne(int index) {
        if (index + 1 < items.length) {
            return index + 1;
        } else {
            return 0;
        }
    }

}
