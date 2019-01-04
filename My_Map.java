package java_final_project;

import java.util.*;

public class My_Map<K,V> implements Map{

    private static int sl=1;
    private K key;
    private V value;

    @Override
    public int size() {
        return (key != null) ? 1 : 0;
    }

    @Override
    public boolean isEmpty() {
        return (size()==0) ?true: false;
    }

    @Override
    public boolean containsKey(Object o) {
        return this.key.equals(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return this.value.equals(o);
    }

    @Override
    public Object get(Object o) {
        return this.get(o);
    }

    @Override
    public Object put(Object o, Object o2) {
        this.key= (K) o;
        this.value= (V) o2;
        return null;
    }

    @Override
    public Object remove(Object o) {
        if (key.equals(this.key))
        {
            final V oldValue = value;

            this.key = null;
            value = null;

            return oldValue;
        }

        return null;
    }

    @Override
    public void putAll(Map map) {
        if (map.size() <= sl)
        {
            put(map.get(key), map.get(value));
        }
    }

    @Override
    public void clear() {
        key = null;
        value = null;
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
