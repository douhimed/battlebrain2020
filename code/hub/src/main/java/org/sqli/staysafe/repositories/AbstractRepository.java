package org.sqli.staysafe.repositories;

public interface AbstractRepository<T> {

    T findById(long id);

}
