package effectiveJava.Chapter11.item74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 不管选择哪种序列化形式，都要为自己编写的每个可序列化的类声明一个显示的序列版本UID
 * 这样可以避免序列版本UID成为潜在的不兼容根源。
 * 如果没有提供显示的序列版本UID，就需要在运行时通过一个高开销的计算过程产生一个序列版本UID
 * Created by xiaokai on 2015/12/9.
 */
public class Foo extends AbstractFoo implements Serializable {

    private static final long serialVersionUID = -5309147263386222347L;

    public Foo(int x, int y) {
        super(x, y);
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();

        int x = s.readInt();
        int y = s.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        s.writeInt(getX());
        s.writeInt(getY());
    }


}
