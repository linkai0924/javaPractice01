package leader.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LeaderComonent {
    CompType injectBy() default CompType.singleton;

    ;

    String name();

    boolean threadsafe() default false;

    public enum CompType {
        singleton, nonsingleton, customer
    }
}
