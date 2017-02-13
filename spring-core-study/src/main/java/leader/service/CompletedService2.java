package leader.service;

import leader.dao.AbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CompletedService2 {
    @Autowired
    private Collection<AbstractDAO> allDaos;

    public Collection<AbstractDAO> getAllDaos() {
        return allDaos;
    }


}
