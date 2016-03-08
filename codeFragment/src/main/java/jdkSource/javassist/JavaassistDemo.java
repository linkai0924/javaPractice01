package jdkSource.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import java.lang.reflect.Modifier;

/**
 * javassist:增强型的java反射工具,获取方法参数名
 * Javassist是用来处理java字节码的类库。字节码保存在二进制文件中称为类文件。每个类文件夹包括一个java类或接口
 */
public class JavaassistDemo {
    public static void main(String[] args) {

        testReflectParamName();

    }

    /**
     * 反射获取方法参数名称
     */
    public static void testReflectParamName() {
        Class clazz = MyClass.class;
        try {
            /**
             * ClassPool是缓存CtClass对象的容器，所有的CtClass对象都在ClassPool中。
             * 所以，CtClass对象很多时，ClassPool会消耗很大的内存，为了避免内存的消耗，创建ClassPool对象时可以使用单例模式，
             * 或者对于CtClass对象，调用detach方法将其从ClassPool中移除。
             * */
            ClassPool pool = ClassPool.getDefault();
            /**
             * Javasssist.CtClass这个类是一个类文件的抽象表示。
             * 一个CtClass(compile-time class编译时类)对象处理一个类文件
             * */
            CtClass cc = pool.get(clazz.getName());
            CtMethod cm = cc.getDeclaredMethod("concatString");

            // 使用javaassist的反射方法获取方法的参数名
            MethodInfo methodInfo = cm.getMethodInfo();
            CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
            LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
            if (attr == null) {
                // exception
            }
            String[] paramNames = new String[cm.getParameterTypes().length];
            int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
            for (int i = 0; i < paramNames.length; i++)
                paramNames[i] = attr.variableName(i + pos);
            // paramNames即参数名
            for (int i = 0; i < paramNames.length; i++) {
                System.out.println("参数名" + i + ":" + paramNames[i]);
            }

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}

