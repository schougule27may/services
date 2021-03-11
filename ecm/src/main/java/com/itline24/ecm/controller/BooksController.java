package com.itline24.ecm.controller;

import com.itline24.ecm.entity.Books;
import com.itline24.ecm.entity.ClientEntity;
import com.itline24.ecm.repositories.ClientRepository;
import com.itline24.ecm.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Mark class as Controller
@RestController
public class BooksController {


    //Autowire the bookService Class
    @Autowired
    BooksService booksService;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private Books getBookById(@PathVariable("bookid") int bookId) {
        return booksService.getBooksById(bookId);
    }


    @DeleteMapping("/book/{bookid}")
    private void deleteBookById(@PathVariable("bookid") int bookId) {
         booksService.delete(bookId);
    }

    @PostMapping("/books")
    private int saveBook(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }



    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }

    @GetMapping("/clients")
    private List<ClientEntity> getaa() {

        List<ClientEntity> clientEntities1 = new ArrayList<>();
        clientRepository.findAll().forEach(books1 -> clientEntities1.add(books1
        ));
        return clientEntities1;
    }

}
