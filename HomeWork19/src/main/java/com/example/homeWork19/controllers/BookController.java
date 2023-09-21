package com.example.homeWork19.controllers;

import com.example.homeWork19.models.Book;
import com.example.homeWork19.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String startPage(Model model) {
        List<Book> bookList = bookService.listBook();
        model.addAttribute("listBook", bookList);
        return "index";
    }

    @PostMapping("/book/delete/{bookId}")
    public String bookDelete(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/";
    }

    @GetMapping("/book/edit/{bookId}")
    public String bookEdit(@PathVariable("bookId") int bookId, Model model) {
        Book book = bookService.findById(bookId);
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/book/save")
    public String bookUpdate(Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/findName", method = GET)
    public String bookFindName(@RequestParam("name") String name, Model model){
        List<Book> bookList = bookService.findByName(name);
        model.addAttribute("listBook", bookList);
        return "index";
    }
    @RequestMapping(value = "/findAuthor", method = GET)
    public String bookFindAuthor(@RequestParam("author") String author, Model model){
        List<Book> bookList = bookService.findByAuthor(author);
        model.addAttribute("listBook", bookList);
        return "index";
    }
    @RequestMapping(value = "/findYear", method = GET)
    public String bookFindYear(@RequestParam("year") int year, Model model){
        List<Book> bookList = bookService.findByYear(year);
        model.addAttribute("listBook", bookList);
        return "index";
    }
    @RequestMapping(value = "/findStyle", method = GET)
    public String bookFindStyle(@RequestParam("style") String style, Model model){
        List<Book> bookList = bookService.findByStyle(style);
        model.addAttribute("listBook", bookList);
        return "index";
    }
    @RequestMapping(value = "/findPageCount", method = GET)
    public String bookFindPageCount(@RequestParam("pageCount") int pageCount, Model model){
        List<Book> bookList = bookService.findByPageCount(pageCount);
        model.addAttribute("listBook", bookList);
        return "index";
    }
    @RequestMapping(value = "/findByDescriptionContains", method = GET)
    public String bookFindByDescriptionContains(@RequestParam("word") String word, Model model){
        List<Book> bookList = bookService.findByDescriptionContains(word);
        model.addAttribute("listBook", bookList);
        return "index";
    }
}
