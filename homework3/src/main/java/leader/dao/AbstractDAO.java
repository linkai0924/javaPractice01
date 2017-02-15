package leader.dao;

public interface AbstractDAO<T> {


    default boolean createDomainObj(T domainObj) {
        return true;
    }

    default boolean deleteDomainObj(Integer objId) {
        return true;
    }

}
