package effectiveJava.Chapter10.item67;

/**
 * Created by xiaokai on 2015/12/4.
 */
public interface SetObserver<E> {
    void added(ObservableSet set, E element);
}
