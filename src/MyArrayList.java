import java.util.*;

public class MyArrayList<E>  {

    private static final int DEFAULT_SIZE = 15;   // я знаю что 10

    private static final Object[] DEFAULT_EMPTY_ELEMENTDATA = new Object[DEFAULT_SIZE];

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private int size;

    private Object[] elementData;

    public MyArrayList() {
        this.elementData = DEFAULT_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        }
        else if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        }
        else {
            throw new IllegalArgumentException("Capacity is < 0");
        }
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E element) {
        addElement(element, elementData, size);
        return true;
    }

    private void addElement(E element, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = increase();
        elementData[s] = element;
        size = s + 1;
    }

    private Object[] increase() {
        return elementData = Arrays.copyOf(elementData, newCapacity());
    }

    private int newCapacity() {
        int oldCapacity = elementData.length;
        return oldCapacity + (oldCapacity >> 1);
    }

    public E get(int index) {
        return elementData(index);
    }

    public void set(int index, E element) {
        elementData[index] = element;
    }
}
