package ua.tntu.library.dao;

import java.util.List;

public interface AbstractDao<T> {
    List<T> getAll();

    T get(long id);

    T save(T obj);

    void delete(T obj);

    List<T> search(String... searchString);
}
