package me.xhy.java.springcloud.s01.provider.album.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 唱片
 */
public class Album {

  private String name;
  private List<Track> tracks;
  private List<Artist> musicians;

  public Album() {}

  public Album(String name, List<Track> tracks, List<Artist> musicians) {
//    Objects.requireNonNull(name);
//    Objects.requireNonNull(tracks);
//    Objects.requireNonNull(musicians);

    this.name = name;
    this.tracks = new ArrayList<>(tracks);
    this.musicians = new ArrayList<>(musicians);
  }

  @Override
  public String toString() {
    return "Album{" +
        "name='" + name + '\'' +
        ", tracks=" + tracks +
        ", musicians=" + musicians +
        '}';
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Track> getTracks() {
    return tracks;
  }

  public void setTracks(List<Track> tracks) {
    this.tracks = tracks;
  }

  public List<Artist> getMusicians() {
    return musicians;
  }

  public void setMusicians(List<Artist> musicians) {
    this.musicians = musicians;
  }

}
