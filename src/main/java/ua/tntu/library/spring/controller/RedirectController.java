package ua.tntu.library.spring.controller;

import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.tntu.library.domain.Author;
import ua.tntu.library.domain.Book;
import ua.tntu.library.spring.repository.AuthorRepository;
import ua.tntu.library.spring.repository.BookRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log
@Controller
public class RedirectController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public RedirectController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        //Page<Book> authors =  bookRepository.findAllWithoutContent(PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name")));
        Page<Book> books =  bookRepository.findByGenre(11L, PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "name")));
        return "ok";
    }
}
