package effectiveJava.Chapter10.item71;

/**
 * 第71条 谨慎使用延迟初始化
 * 简而言之 大多数的域应该正常的进行初始化，而不是延迟初始化。
 * 如果为了达到性能目标，或者为了破坏有害的初始化循环，而必须延迟初始化一个域
 * 就可以使用相应的延迟初始化方法。
 * 对于实例域：就是用双重检查模式
 * 对于静态域就使用lazy initialization holder class idiom
 * 对于可以接受重复初始化的实例域，可可以考虑使用单重检查模式
 * Created by xiaokai on 2015/12/8.
 */
public class item71 {
}
