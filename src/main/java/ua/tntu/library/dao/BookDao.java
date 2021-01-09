package ua.tntu.library.dao;

import ua.tntu.library.domain.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Book> {

    List<Book> findTopBooks(int limit);
}
