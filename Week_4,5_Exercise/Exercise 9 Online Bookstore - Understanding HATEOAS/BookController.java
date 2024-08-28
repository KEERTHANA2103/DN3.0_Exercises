package com.bookstore.controller;

import com.bookstore.dto.BookDTO;
import com.bookstore.mapper.BookMapper;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<EntityModel<BookDTO>> createBook(@Valid @RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        BookDTO responseDTO = BookMapper.INSTANCE.bookToBookDTO(savedBook);
        
        EntityModel<BookDTO> resource = EntityModel.of(responseDTO);
        resource.add(linkTo(methodOn(BookController.class).getBookById(savedBook.getId())).withSelfRel());
        resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));

        return new ResponseEntity<>(resource, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BookDTO>> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
                    EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
                    resource.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());
                    resource.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
                    return new ResponseEntity<>(resource, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<BookDTO>>> getAllBooks() {
        List<EntityModel<BookDTO>> books = bookRepository.findAll().stream()
                .map(book -> {
                    BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
                    EntityModel<BookDTO> resource = EntityModel.of(bookDTO);
                    resource.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
                    return resource;
                })
                .collect(Collectors.toList());
        
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}