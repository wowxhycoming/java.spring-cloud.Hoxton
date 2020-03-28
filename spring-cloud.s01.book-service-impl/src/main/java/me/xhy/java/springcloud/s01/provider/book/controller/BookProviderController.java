package me.xhy.java.springcloud.s01.provider.book.controller;

import me.xhy.java.springcloud.ms03.provider.book.entity.Book;
import me.xhy.java.springcloud.s01.provider.book.service.BookProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookProviderController {

  @Autowired
  BookProviderServiceImpl bookProviderService;

  @GetMapping("/books")
  public List<Book> fetchBooks() {
    System.out.println("============fetchBooks");
    return bookProviderService.fetchBooks();
  }

  @PostMapping("/books/name")
  public List<Book> fetchBooksByName(@RequestBody Book book) {
    System.out.println("============fetchBooksByName");
    return bookProviderService.fetchBooksByName(book);
  }

}
