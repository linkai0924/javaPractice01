package effectiveJava.Chapter10.item67;

import java.util.*;

/**第66条 避免过度同步
 *
 * Created by xiaokai on 2015/12/1.
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set){super(set);}

    private final List<SetObserver<E>> observers=new ArrayList<SetObserver<E>>();

    public void addOberserver(SetObserver observer){
        synchronized (observers){
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver observer){
        synchronized (observers){
            return observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element){
        synchronized (observers){
            for(SetObserver observer:observers){

            }
//                observer.added
        }
    }

    @Override
    public boolean isEmpty() {
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
}
