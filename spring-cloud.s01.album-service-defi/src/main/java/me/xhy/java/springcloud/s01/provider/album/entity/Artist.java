package me.xhy.java.springcloud.s01.provider.album.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 艺术家（个人或乐队），members 为乐队成员
 */
public class Artist {

  private String name;
  private List<Artist> members;
  private String nationality;

  public Artist() {}

  public Artist(String name, String nationality) {
    this(name, Collections.emptyList(), nationality);
  }

  public Artist(String name, List<Artist> members, String nationality) {
//    Objects.requireNonNull(name);
//    Objects.requireNonNull(members);
//    Objects.requireNonNull(nationality);
    this.name = name;
    this.members = new ArrayList<>(members);
    this.nationality = nationality;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Artist> getMembers() {
    return members;
  }

  public void setMembers(List<Artist> members) {
    this.members = members;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }
}
