package com.music.library.admin.service;
import com.music.library.admin.model.Song;
import java.util.List;

public interface SongService {
    Song addSong(Song song);
    List<Song> getAllSongs();
}