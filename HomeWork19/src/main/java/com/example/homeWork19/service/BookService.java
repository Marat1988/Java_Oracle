package com.example.homeWork19.service;

import com.example.homeWork19.models.Book;
import com.example.homeWork19.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> listBook(){
        return bookRepository.findAll();
    }

    public void deleteBook(int bookId){
        bookRepository.deleteById(bookId);
    }

    public Book findById(int bookId){
        return bookRepository.findById(bookId).orElse(null);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> findByName(String name){
        return bookRepository.findByName(name);
    }
    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }
    public List<Book> findByStyle(String style){
        return bookRepository.findByStyle(style);
    }
    public List<Book> findByYear(int year){
        return bookRepository.findByYear(year);
    }
    public List<Book> findByPageCount(int pageCount){
        return bookRepository.findByPageCount(pageCount);
    }

    public List<Book> findByDescriptionContains(String word){
        return bookRepository.findByDescriptionContains(word);
    }
}
