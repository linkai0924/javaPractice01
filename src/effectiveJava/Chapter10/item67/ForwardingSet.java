package effectiveJava.Chapter10.item67;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by xiaokai on 2015/12/4.
 */
public class ForwardingSet<E> implements Set<E> {
    public <E> ForwardingSet(Set<E> set) {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
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
//    private final Set<E> s;
//    public ForwardingSet(Set<E> s){this.s=s;}
//    public void clear(){s.clear();}
//    public boolean contains(Object o){return s.contains(o);}
//    public int size(){return s.size();}


}
