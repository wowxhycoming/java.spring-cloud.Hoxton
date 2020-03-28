package me.xhy.java.springcloud.s01.provider.album.defi;

import me.xhy.java.springcloud.s01.provider.album.entity.Album;
import me.xhy.java.springcloud.s01.provider.album.entity.Artist;
import me.xhy.java.springcloud.s01.provider.album.entity.Track;

import java.util.List;

public interface AlbumServiceDefi {
  public static final String ALBUM_SERVICE_NAME = "album-provider";

  public static final String GET_FETCH_A_TRACK = "/album/track";
  public static final String GET_FETCH_TRACKS = "/album/tracks";

  public static final String GET_FETCH_ARTISTS = "/album/artists";

  public static final String GET_FETCH_ALBUMS = "/album/albums";
  public static final String POST_FETCH_ALBUMS_BY_NAME = "/album/albums/name";

  public Track fetchATrack();
  public List<Track> fetchTracks();
  public List<Artist> fetchArtists();
  public List<Album> fetchAlbums();
  public List<Album> fetchAlbumsByName(Album album);
}
