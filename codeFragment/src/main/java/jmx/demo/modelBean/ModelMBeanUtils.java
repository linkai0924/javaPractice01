package jmx.demo.modelBean;

import jmx.demo.helloworld.Hello;

import javax.management.MBeanOperationInfo;
import javax.management.MBeanParameterInfo;
import javax.management.modelmbean.*;

/**
 * 6、模型Bean：Model Bean
 * 在上一节是用apache的commons-modeler来开发的一个model，只不过commons-modeler帮助我们实现了很多的代码，而我们只需要写描述XML文件就行了。
 * 这一节，来一个实打实的Model Bean，不借助任何第三方工具包。例子还是沿用Hello这个类，以便于和以前的实现相比较。
 * <p/>
 * 3、ModelMbeanUtils这个类是要我们自己来实现的，也是写model Bean最麻烦的地方，
 * 它主要是返回一个RequiredModelMBean类，此类主要包括了一个ModelMBeanInfo类的信息。
 * 在ModelMBeanInfo中定义了所有对需要管理的属性和方法的描述。具体代码如下：
 * <p/>
 * 二、总结
 * <p/>
 * 我们发现模型Mbean(Model MBean)要比标准MBean(standard mbean)复杂多了，那有什么理由让我们选择使用模型MBean吗？我认为，最大的理由就是模型MBean可以动态配置。试想一下这个应用场景：由于安全或其他原因，系统要把某个MBean公开的可管理方法隐藏起来。这时，如果你是用标准MBean，这需要修改接口类，然后重新编译发布；如果用Apache commons-modeler来写的模型MBean，则只需要修改XML文件就行了，不需要重新编译发布（可能要重启一下系统）。这就是模型Mbean优势之所在了。
 * 细心的人会发现动态MBean和这一节的模型Mbean非常相似，但它们还是有很大不同的：动态MBean没有Hello类，它要自己实现Hello类中的方法逻辑。
 * 二、总结
 * <p/>
 * 我们发现模型Mbean(Model MBean)要比标准MBean(standard mbean)复杂多了，那有什么理由让我们选择使用模型MBean吗？我认为，最大的理由就是模型MBean可以动态配置。试想一下这个应用场景：由于安全或其他原因，系统要把某个MBean公开的可管理方法隐藏起来。这时，如果你是用标准MBean，这需要修改接口类，然后重新编译发布；如果用Apache commons-modeler来写的模型MBean，则只需要修改XML文件就行了，不需要重新编译发布（可能要重启一下系统）。这就是模型Mbean优势之所在了。
 * <p/>
 * 细心的人会发现动态MBean和这一节的模型Mbean非常相似，但它们还是有很大不同的：动态MBean没有Hello类，它要自己实现Hello类中的方法逻辑。
 */
public class ModelMBeanUtils {
    private static final boolean READABLE = true;
    private static final boolean WRITABLE = true;
    private static final boolean BOOLEAN = true;
    private static final String STRING_CLASS = "java.lang.String";

    public static RequiredModelMBean createModlerMBean() {
        RequiredModelMBean model = null;
        try {
            model = new RequiredModelMBean();
            model.setManagedResource(new Hello(), "ObjectReference");
            ModelMBeanInfo info = createModelMBeanInfo();
            model.setModelMBeanInfo(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    private static ModelMBeanInfo createModelMBeanInfo() {
        /**属性*/
        // 构造name属性信息
        ModelMBeanAttributeInfo nameAttrInfo = new ModelMBeanAttributeInfo(//
                "Name", // 属性名        
                STRING_CLASS, //属性类型     
                "people name", // 描述文字       
                READABLE, WRITABLE, !BOOLEAN, // 读写       
                null // 属性描述子
        );
        /**方法*/
        //构造 printHello()操作的信息
        ModelMBeanOperationInfo print1Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null, //   
                null, //
                "void", //   
                MBeanOperationInfo.INFO, //
                null //
        );
        // 构造printHello(String whoName)操作信息      
        ModelMBeanOperationInfo print2Info;
        MBeanParameterInfo[] param2 = new MBeanParameterInfo[1];
        param2[0] = new MBeanParameterInfo("whoName", STRING_CLASS, "say hello to who");
        print2Info = new ModelMBeanOperationInfo(//
                "printHello", //
                null,//
                param2,//
                "void", //
                MBeanOperationInfo.INFO, //
                null//
        );
        /**最后总合*/
        // create ModelMBeanInfo
        ModelMBeanInfo mbeanInfo = new ModelMBeanInfoSupport(//
                RequiredModelMBean.class.getName(), // MBean类
                null, // 描述文字      
                new ModelMBeanAttributeInfo[]{ // 所有的属性信息（数组）
                        nameAttrInfo},//只有一个属性
                null, // 所有的构造函数信息   
                new ModelMBeanOperationInfo[]{ // 所有的操作信息（数组）
                        print1Info,
                        print2Info},//
                null, // 所有的通知信息(本例无)
                null//MBean描述子
        );
        return mbeanInfo;
    }
}