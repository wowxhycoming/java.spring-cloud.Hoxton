package me.xhy.java.springcloud.s01.provider.album.controller;

import me.xhy.java.springcloud.ms03.provider.album.entity.Album;
import me.xhy.java.springcloud.ms03.provider.album.entity.Artist;
import me.xhy.java.springcloud.ms03.provider.album.entity.Track;
import me.xhy.java.springcloud.s01.provider.album.service.AlbumProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumProviderController {

  @Autowired
  AlbumProviderServiceImpl albumProviderService;

  @RequestMapping("/track")
  public Track fetchATrack() {
    return albumProviderService.fetchATrack();
  }

  @GetMapping("/tracks")
  public List<Track> fetchTracks() {
    return albumProviderService.fetchTracks();
  }

  @GetMapping("/artists")
  public List<Artist> fetchArtists() {
    return albumProviderService.fetchArtists();
  }

  @GetMapping("/albums")
  public List<Album> fetchBooks() {
    return albumProviderService.fetchAlbums();
  }

  /*
   * 参数列表中增加了 @RequestBody
   */
  @PostMapping("/albums/name")
  public List<Album> fetchBooksByName(@RequestBody Album album) {
    return albumProviderService.fetchAlbumsByName(album);
  }
}
