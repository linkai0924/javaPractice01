package outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by xiaokai on 2016/3/17.
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    static class OOMObject {
    }
}
