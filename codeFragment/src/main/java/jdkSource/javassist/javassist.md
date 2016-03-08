Java反射机制
========
JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
对于任意一个对象，都能够调用它的任意一个方法；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

>
获取Class对象有三种方式：
1.通过Object类的getClass()方法。例如：
Class c1 = new String("").getClass();
2.通过Class类的静态方法——forName()来实现：
Class c2 = Class.forName("MyObject");
3.如果T是一个已定义的类型的话，在java中，它的.class文件名：T.class就代表了与其匹配的Class对象，例如：
Class c3 = Manager.class;
Class c4 = int.class;
Class c5 = Double[].class;