package com.music.library.admin.controller;
import com.music.library.admin.model.Song;
import com.music.library.admin.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.addSong(song), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }
}