package me.xhy.java.springcloud.s01.support.instant;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class EastEightInstantUtil {

  public static ZoneId chinaTimeZone = ZoneId.of("Asia/Shanghai");
  public static Clock eastEightClock = Clock.offset(Clock.systemUTC(), Duration.ofHours(+8));
  private static DateTimeFormatter dateTimeFormatterMillis = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(eastEightClock.getZone());
  private static DateTimeFormatter dateTimeFormatterSecond = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(eastEightClock.getZone());

  /**
   * 获取指定时间字符串，形如：2020-01-02T03:04:05.123456789Z
   * 1秒 = 1_000毫秒 = 1_000_000微秒 = 1_000_000_000纳秒
   * @param year 指定的年份
   * @param month 指定的月份，枚举类型
   * @param day 指定日期，确定该月是否有该日
   * @param hour 指定小时
   * @param minute 指定分钟
   * @param second 指定秒
   * @param nano 指定纳秒，如不需要可传入 0。
   * @return LocalDateTime 或 Instant 的时间字符串，形如： 2020-01-02T03:04:05.123456789Z
   */
  public static String getLocalDateTimeStr(int year, Month month, int day, int hour, int minute, int second, int nano) {
    return LocalDateTime.of(year, month, day, hour, minute, second, nano).toString() + "Z";
  }

  public static LocalDateTime getLocalDateTime(int year, Month month, int day, int hour, int minute, int second, int nano) {
    return LocalDateTime.of(year, month, day, hour, minute, second, nano);
  }

  public static Instant nowInstant() {
    return Instant.now(eastEightClock);
  }

  public static long getNowEpochSecond() {
    return Instant.now(eastEightClock).getEpochSecond();
  }

  public static long getNowEpochMilli() {
    return Instant.now(eastEightClock).toEpochMilli();
  }

  public static long getNowEpochNano() {
    return Instant.now(eastEightClock).getNano();
  }

  public static Instant fromLocalDateTimeStr(String str) {
    return Instant.parse(str);
  }

  public static String nowDateTimeWithMillisStr() {
    return dateTimeFormatterMillis.format(Instant.now(eastEightClock));
  }

  public static String nowDateTimeWithSecondStr() {
    return dateTimeFormatterSecond.format(Instant.now(eastEightClock));
  }

/*  public static void main(String[] args) {
    System.out.println(chinaTimeZone);
    System.out.println(eastEightClock);

    System.out.println(Instant.now(eastEightClock));
    System.out.println(nowDateTimeWithSecondStr());
    String str = getLocalDateTimeStr(2020, Month.FEBRUARY, 2, 1, 2,3, 123456789);
    System.out.println(str);
    System.out.println(fromLocalDateTimeStr(str));
    System.out.println(dateTimeFormatterSecond.format(fromLocalDateTimeStr(str)));
    System.out.println(dateTimeFormatterMillis.format(fromLocalDateTimeStr(str)));

  }*/

}
