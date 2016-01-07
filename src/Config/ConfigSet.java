package Config;

import java.util.*;

/**
 * Created by gerard on 06-01-2016.
 */
public class ConfigSet<E> implements Set<E> {

    Map<Class<?>,E> map= new HashMap();
    Set<E> set = new HashSet<E>();

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public Object[] toArray() {
        return set.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return set.toArray(a);
    }

    @Override
    public boolean add(E t) {
        if (map.containsKey(t.getClass())){
            set.remove(map.get(t.getClass()));
        }
        set.add(t);
        map.put(t.getClass(),t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o.getClass());
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    public <T> T get(Class<T> type){
        return (T) map.get(type);
    }
}
