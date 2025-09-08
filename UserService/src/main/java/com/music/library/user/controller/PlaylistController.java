package com.music.library.user.controller;

import com.music.library.user.model.Playlist;
import com.music.library.user.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestParam String name, @RequestParam Long userId) {
        Playlist newPlaylist = playlistService.createPlaylist(name, userId);
        return new ResponseEntity<>(newPlaylist, HttpStatus.CREATED);
    }

    @PutMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        Playlist updatedPlaylist = playlistService.addSongToPlaylist(playlistId, songId);
        return new ResponseEntity<>(updatedPlaylist, HttpStatus.OK);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Playlist>> getUserPlaylists(@PathVariable Long userId) {
        List<Playlist> playlists = playlistService.getUserPlaylists(userId);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}