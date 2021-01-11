package ua.tntu.library.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ua.tntu.library.domain.Book;

import java.util.List;

public interface BookDao extends AbstractDao<Book> {

    List<Book> findTopBooks(int limit);

    byte[] getContent(long id);

    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);
}
