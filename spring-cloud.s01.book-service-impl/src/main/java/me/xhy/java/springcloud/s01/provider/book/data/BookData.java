package me.xhy.java.springcloud.s01.provider.book.data;

import me.xhy.java.springcloud.ms02.support.instant.EastEightInstantUtil;
import me.xhy.java.springcloud.ms03.provider.book.entity.Book;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class BookData {

  public static final String instantStr = EastEightInstantUtil.getLocalDateTimeStr(2020, Month.FEBRUARY, 22, 22, 22,22, 987654321);

  public static List<Book> books = Arrays.asList(
      new Book("程序员的自我修养", new BigDecimal("222.22"), "a coder", "禁足出版社", instantStr),
      new Book("我变强了，也变秃了", new BigDecimal("111.11"), "superman", "禁足出版社", instantStr));
}
