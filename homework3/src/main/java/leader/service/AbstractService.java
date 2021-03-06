package leader.service;

import leader.dao.AbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractService<T> {

    @Autowired
    private AbstractDAO<T> dao;

    public boolean saveDomain(T domain) {
        System.out.println("check domain obj " + domain);
        doCheckDomain(domain);
        System.out.println("save domain obj " + domain);
        dao.createDomainObj(domain);
        return true;
    }

    public AbstractDAO<T> getDao() {
        return dao;
    }

    protected void doCheckDomain(T domain) {
        // child can override
    }
}
