package jdkSource.jmx.demo.apacheModule;

import org.apache.commons.lang.StringUtils;

import java.net.URL;

public class ResourcePathTester {
 
    public static void main(String[] args) {

        System.out.println(getResourcePath());
    }
     
    private static String getResourcePath() {
        String className = ResourcePathTester.class.getName();
        String classNamePath = className.replace(".", "/") + ".class";
        URL is = ResourcePathTester.class.getClassLoader().getResource(classNamePath);
        String path = is.getFile();
        path = StringUtils.replace(path, "%20", " ");

//        return StringUtils.removeStart(path, "/");
        return is.getPath();
    }
}