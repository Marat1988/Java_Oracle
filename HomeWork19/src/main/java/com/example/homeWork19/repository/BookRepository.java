package com.example.homeWork19.repository;

import com.example.homeWork19.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);
    List<Book> findByStyle(String style);
    List<Book> findByPageCount(int pageCount);
    List<Book> findByYear(int year);
    List<Book> findByDescriptionContains(String word);

}
