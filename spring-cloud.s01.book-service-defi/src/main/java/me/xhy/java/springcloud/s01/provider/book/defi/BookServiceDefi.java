package me.xhy.java.springcloud.s01.provider.book.defi;

import me.xhy.java.springcloud.s01.provider.book.entity.Book;

import java.util.List;

public interface BookServiceDefi {

  public static final String BOOK_SERVICE_NAME = "book-provider";
  public static final String GET_FETCH_BOOKS = "/book/books";
  public static final String POST_FETCH_BOOKS_BY_NAME = "/book/books/name";

  public List<Book> fetchBooks();
  public List<Book> fetchBooksByName(Book book);

}
