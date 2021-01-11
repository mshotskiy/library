package ua.tntu.library.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.tntu.library.dao.BookDao;
import ua.tntu.library.domain.Book;
import ua.tntu.library.spring.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService implements BookDao {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book get(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book save(Book obj) {
        return bookRepository.save(obj);
    }

    @Override
    public void delete(Book obj) {
        bookRepository.delete(obj);
    }

    @Override
    public List<Book> search(String... searchString) {
        return null;
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        //TODO SearchString[1]
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(
                searchString[0],searchString[0], PageRequest.of(pageNumber,pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0, limit, Sort.by(Sort.Direction.DESC, "viewCount")));
    }

    @Override
    public byte[] getContent(long id) {
        return bookRepository.getContentById(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection,sortField)));
    }
}
