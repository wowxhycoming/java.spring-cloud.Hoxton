package me.xhy.java.springcloud.s01.provider.album.entity;

/**
 * 曲目
 */
public class Track {

  private String name;
  private int length;

  public Track() {}

  public Track(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public Track copy() {
    return new Track(name, length);
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

}
