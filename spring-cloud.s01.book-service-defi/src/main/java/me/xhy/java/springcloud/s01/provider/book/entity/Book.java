package me.xhy.java.springcloud.s01.provider.book.entity;

import java.math.BigDecimal;

public class Book {
  private String name;
  private BigDecimal price;
  private String author;
  private String publisher;
  private String publicationDate;

  public Book(String name, BigDecimal price, String author, String publisher, String publicationDate) {
    this.name = name;
    this.price = price;
    this.author = author;
    this.publisher = publisher;
    this.publicationDate = publicationDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

}
