package ua.tntu.library.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.tntu.library.domain.Genre;

import java.util.List;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Page<Genre> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

    List<Genre> findByNameContainingIgnoreCaseOrderByName(String name);
}
