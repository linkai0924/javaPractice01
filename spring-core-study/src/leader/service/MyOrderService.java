package leader.service;

import leader.bean.MyServiceLocalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOrderService {
    @Autowired
    private MyServiceLocalStorage localStorage;

    public MyServiceLocalStorage getLocalStorage() {
        return localStorage;
    }


}
