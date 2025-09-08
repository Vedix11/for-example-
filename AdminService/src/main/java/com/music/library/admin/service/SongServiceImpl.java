package com.music.library.admin.service;
import com.music.library.admin.model.Song;
import com.music.library.admin.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;

    @Override
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
}