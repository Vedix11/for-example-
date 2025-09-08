package com.music.library.user.service;

import com.music.library.user.model.Playlist;
import com.music.library.user.model.User;
import com.music.library.user.repository.PlaylistRepository;
import com.music.library.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Playlist createPlaylist(String name, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setUser(user);
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist addSongToPlaylist(Long playlistId, Long songId) {
        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist not found with id: " + playlistId));
        // Note: Here you could call AdminService to verify the songId exists
        playlist.getSongIds().add(songId);
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getUserPlaylists(Long userId) {
        return playlistRepository.findByUserId(userId);
    }
}