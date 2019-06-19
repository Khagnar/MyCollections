import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static final float DEFAULT_LOADFACTOR = 0.75f;

    private static final int MAX_CAPACITY = 1073741824;

    private static class Entry<K, V> {

        final int hash;
        final K key;
        V value;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final void setValue(V newValue) {
            value = newValue;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>) o;
                return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
            }
            return false;
        }
    }

    static final int hash(Object key) {
        int h;
        if (key == null) return 0;
        else return (h = key.hashCode()) ^ (h >>> 16);
    }

    private int size;

    private float loadFactor;

    private Entry<K, V>[] table;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOADFACTOR;
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOADFACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        if (loadFactor <= 0 || Float.isNaN(loadFactor)) {
            throw new IllegalArgumentException();
        }
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("capacity is < 0");
        }

        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
