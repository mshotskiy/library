package ua.tntu.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AbstractDao<T> {
    List<T> getAll();

    T get(long id);

    T save(T obj);

    void delete(T obj);

    List<T> search(String... searchString);

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);
}
