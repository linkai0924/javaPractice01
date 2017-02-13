package leader.service;

import leader.bean.MyDataSourceParamBean;
import leader.intf.MyMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Profile(value = "free_version")
@Configuration
@PropertySource(value = "classpath:myapp-freeversion.properties")
public class MyConfigForFreeVersion {
    @Autowired
    Environment env;

    public MyConfigForFreeVersion() {
        System.out.println("@Configuration MyConfigForFreeVersion created ");
    }

    @Bean
    MyDataSourceParamBean myDataSourceParamBean() {

        MyDataSourceParamBean bean = new MyDataSourceParamBean();
        System.out.println("get store file path:" + env.getProperty("system.storefile"));
        return bean;

    }

    @Bean
    MyMenuService myMenuService() {
        System.out.println("MyConfigForFreeVersion created MyMenuService ");
        return new MyMenuService4FreeVersion();
    }
}

class MyMenuService4FreeVersion implements MyMenuService {

    public String[] getMenus(String userRole) {
        return new String[]{"login", "try", "exit"};
    }

}
