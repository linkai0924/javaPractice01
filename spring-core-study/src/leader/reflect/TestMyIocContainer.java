package leader.reflect;

import org.reflections.Reflections;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class TestMyIocContainer {

    public static void main(String[] args) throws IOException {
        Reflections reflections = new Reflections("leader.reflect");
        Set<Class<?>> allLeaderBeanCls = reflections.getTypesAnnotatedWith(LeaderComonent.class);
        System.out.println(allLeaderBeanCls.size());
        File[] clsses = ClassUtil.getPackageContent("leader.reflect");
        System.out.println(Arrays.toString(clsses));
    }

}
