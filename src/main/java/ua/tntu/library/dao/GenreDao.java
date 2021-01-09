package ua.tntu.library.dao;

import ua.tntu.library.domain.Genre;

import java.util.List;

public interface GenreDao extends AbstractDao<Genre> {

    List<Genre> search(String... searchString);
}
