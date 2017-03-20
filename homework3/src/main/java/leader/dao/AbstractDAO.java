package leader.dao;

public interface AbstractDAO<T> {


    default boolean createDomainObj(T domainObj) {
        return true;
    }

    default T selectDomainObj(String objId) {
        return null;
    }

    boolean deleteDomainObj(String userName);
}
