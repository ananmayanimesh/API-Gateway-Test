package com.animesh.rest.controller;

import com.animesh.rest.dao.BookRepository;
import com.animesh.rest.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping("/addRE")
    public ResponseEntity addNewBookRE(@RequestBody Book book){
        ResponseEntity<Book> bookResponseEntity = ResponseEntity.of(Optional.of(bookRepository.save(book)));
        return bookResponseEntity;
    }

    @PostMapping("/add")
    public Book addNewBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("/view")
    public List<Book> viewBooks(){
        return bookRepository.findAll();
    }

}
