package main.java.effectiveJava.Chapter11.item78;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xiaokai on 2015/12/10.
 */
public class SerializationProxy implements Serializable {
    private static final long serialVersionUID = -1129317297328153148L;
    private final Date start;
    private final Date end;

    SerializationProxy(Period p){
        this.start=p.start();
        this.end=p.end();
    }

}
