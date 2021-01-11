package ua.tntu.library.dao.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ua.tntu.library.dao.PublisherDao;
import ua.tntu.library.domain.Publisher;
import ua.tntu.library.spring.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

public class PublisherService implements PublisherDao {

    private PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    public List<Publisher> getAll(Sort sort) {
        return publisherRepository.findAll(sort);
    }



    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Page<Publisher> search(
            int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection,
            String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0],
                PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher){
        publisherRepository.delete(publisher);
    }


    @Override
    public Publisher get(long id) {
        Optional<Publisher> bookmark = publisherRepository.findById(id);
        return bookmark.orElse(null);
    }
}
