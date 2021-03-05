package com.itline24.ecm.service;

import com.itline24.ecm.entity.Books;
import com.itline24.ecm.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//business logic
@Service
public class BooksService {

    @Autowired
    BooksRepository booksRepository;

    public List<Books> getAllBooks() {
        List<Books> books = new ArrayList<>();
        booksRepository.findAll().forEach(books1 -> books.add(books1
        ));
         return books;
    }

    public Books getBooksById(int id) {
        return booksRepository.findById(id).get();
    }

    public void saveOrUpdate(Books books) {
        booksRepository.save(books);
    }

    public void delete(int id) {
        booksRepository.deleteById(id);
    }
}
