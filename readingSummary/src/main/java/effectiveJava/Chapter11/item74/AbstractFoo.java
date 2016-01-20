package main.java.effectiveJava.Chapter11.item74;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AbstractFoo中所有公有的和受保护的实例方法在开始做任何其他工作之前
 * 都必须先调用checkinit这样可以确保如果有编写不好的子类没有初始化实例。
 *
 * Created by xiaokai on 2015/12/9.
 */
public class AbstractFoo {
    private int x, y;

    private enum State {NEW, INITIALIZING, INITIALIZED}

    public final AtomicReference<State> init = new AtomicReference<State>(State.NEW);

    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }

    protected AbstractFoo() {
    }

    protected final void initialize(int x, int y) {
        //在遇到特定的情况时，确保对象的完整性是很有必要的。
        //用compareSet方法来操作枚举的原子引用，这是一个很好的线程安全状态机的通用实现。
        //如果有了这样的机制做保证，实现一个可序列化的子类就非常简单明了
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Already initialized");
        }
        this.x = x;
        this.y = y;
        init.set(State.INITIALIZED);
    }

    protected final int getX() {
        checkInt();
        return x;
    }

    protected final int getY() {
        checkInt();
        return y;
    }

    private void checkInt() {
        if (init.get() != State.INITIALIZED) {
            throw new IllegalStateException("Uninitialized");
        }
    }
}
