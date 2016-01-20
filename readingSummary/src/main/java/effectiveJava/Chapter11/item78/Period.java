package main.java.effectiveJava.Chapter11.item78;

import java.util.Date;

/**
 * Created by xiaokai on 2015/12/10.
 */
public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date();
        this.end = new Date();
    }

    public Date start(){
        return new Date(start.getTime());
    }
    public Date end(){
        return new Date(start.getTime());
    }
    public String toString(){
        return start+"-"+end;
    }

}
