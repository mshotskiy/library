package ua.tntu.library.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.tntu.library.dao.GenreDao;
import ua.tntu.library.domain.Genre;
import ua.tntu.library.spring.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

public class GenreService implements GenreDao {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre get(long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        return genre.orElse(null);
    }

    @Override
    public Genre save(Genre obj) {
        return genreRepository.save(obj);
    }

    @Override
    public void delete(Genre obj) {
        genreRepository.delete(obj);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    public List<Genre> getAll(Sort sort){
        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0],
                PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public List<Genre> search(String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }
}
