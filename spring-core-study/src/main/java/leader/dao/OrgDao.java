package leader.dao;

import leader.domain.Org;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Lazy
@Order(100)
@Component("orgDao")
public class OrgDao implements AbstractDAO<Org> {
    public OrgDao() {
        System.out.println(this + " order " + 100);
    }
}
