package me.xhy.java.springcloud.s01.provider.book.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.xhy.java.springcloud.s01.provider.book.data.BookData;
import me.xhy.java.springcloud.s01.provider.book.entity.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookProviderServiceImpl {

  @HystrixCommand
  public List<Book> fetchBooks() {
    return BookData.books;
  }

  @HystrixCommand
  public List<Book> fetchBooksByName(Book book) {
    return BookData.books.stream()
        .filter(item -> item.getName().contains(book.getName()))
        .collect(Collectors.toList());
  }

}