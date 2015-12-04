package effectiveJava.Chapter10.item67;

import effectiveJava.Chapter04.InstrumentedHashSet;

/**
 * 第67条避免过度同步
 * 过度同步可能会导致性能降低、死锁，甚至不确定的行为。
 * Created by xiaokai on 2015/12/1.
 */
public class item67 {
    /**
     * 为了避免活跃性失败和安全性失败，在一个被同步的方法或者代码块中，永远不要放弃对客户端的控制
     * 换句话说，
     * 在一个被同步的区域内部，不要调用设计成要被覆盖的方法，或者是由客户端以函数对象的形式提供的方法
     *
     * */


}
