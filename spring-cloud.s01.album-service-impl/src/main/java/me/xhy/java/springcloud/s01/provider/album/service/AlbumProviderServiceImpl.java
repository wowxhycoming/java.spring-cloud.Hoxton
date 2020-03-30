package me.xhy.java.springcloud.s01.provider.album.service;

import me.xhy.java.springcloud.s01.provider.album.data.MusicData;
import me.xhy.java.springcloud.s01.provider.album.defi.AlbumServiceDefi;
import me.xhy.java.springcloud.s01.provider.album.entity.Album;
import me.xhy.java.springcloud.s01.provider.album.entity.Artist;
import me.xhy.java.springcloud.s01.provider.album.entity.Track;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class AlbumProviderServiceImpl implements AlbumServiceDefi {

  public Track fetchATrack() {
    return MusicData.bakai;
  }

  public List<Track> fetchTracks() {
    return MusicData.getSomeTracks();
  }

  @Override
  public List<Artist> fetchArtists() {
    return MusicData.getThreeArtists();
  }

  public List<Album> fetchAlbums() {
    return MusicData.getSomeAlbums();
  }

  public List<Album> fetchAlbumsByName(Album album) {
    return MusicData.getSomeAlbums().stream()
        .filter(item -> item.getName().contains(album.getName()))
        .map(item -> new Album(null, item.getTracks(), item.getMusicians()))
        .collect(toList());
  }



}
