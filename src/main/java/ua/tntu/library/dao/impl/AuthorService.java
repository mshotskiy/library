package ua.tntu.library.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.tntu.library.dao.AuthorDao;
import ua.tntu.library.domain.Author;
import ua.tntu.library.spring.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

public class AuthorService implements AuthorDao {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public List<Author> getAll(Sort sort){
        return authorRepository.findAll(sort);
    }

    @Override
    public Author get(long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public Author save(Author obj) {
        return authorRepository.save(obj);
    }

    @Override
    public void delete(Author obj) {
        authorRepository.delete(obj);
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection,
                               String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(
                searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
