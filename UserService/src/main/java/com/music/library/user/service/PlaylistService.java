package com.music.library.user.service;
import com.music.library.user.model.Playlist;
import java.util.List;

public interface PlaylistService {
    Playlist createPlaylist(String name, Long userId);
    Playlist addSongToPlaylist(Long playlistId, Long songId);
    List<Playlist> getUserPlaylists(Long userId);
}