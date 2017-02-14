package leader.service;

import leader.bean.MyDataSourceParamBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyDataSource {
    @Autowired
    private MyDataSourceParamBean dsPramBean;

    public MyDataSourceParamBean getDsPramBean() {
        return dsPramBean;
    }

}
