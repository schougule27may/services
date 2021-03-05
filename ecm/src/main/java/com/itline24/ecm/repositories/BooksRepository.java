package com.itline24.ecm.repositories;

import com.itline24.ecm.entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer> {
}
