package com.music.library.user.model;

import jakarta.persistence.*; // Using jakarta package
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    private List<Long> songIds = new ArrayList<>();
}