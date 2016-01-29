package outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * 自己编写各种outofmemory，stackoverflow程序
 * HeapOutOfMemory
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 在运行该代码时，需要设置堆size的最小值和最大值，
 * 同时使用-XX:+PrintGCDetails参数开启GC日志打印，
 * 使用-XX:+HeapDumpOnOutOfMemoryError参数当OOM时转储堆数据
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * <p/>
 * 结论：
 * 使用JVM参数-XX:+PrintGCDetails可以打印GC日志
 * 使用JVM参数-XX:+HeapDumpOnOutOfMemoryError可以在OOM时打印堆转储文件
 * 使用eclipse插件Memory Analyzer可以分析对转储文件
 * OOM的原因，是Old区在FULL GC之后的剩余空间，仍然无法承载Young区要晋升的对象大小
 * Created by xiaokai on 2016/1/29.
 */
public class HeapOutOfMemoryDemo {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

    static class OOMObject {
    }

}
