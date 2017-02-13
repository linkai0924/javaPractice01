package leader.service;

import leader.dao.AbstractDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CompletedService {
    @Autowired
    private Map<String, AbstractDAO> allDaos;

    public Map<String, AbstractDAO> getAllDaos() {
        return allDaos;
    }

}
