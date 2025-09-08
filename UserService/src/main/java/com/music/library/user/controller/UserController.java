package com.music.library.user.controller;

import com.music.library.user.config.JwtTokenProvider;
import com.music.library.user.dto.LoginRequest;
import com.music.library.user.dto.SongDTO;
import com.music.library.user.model.User;
import com.music.library.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Inject the token provider

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
    
    @GetMapping("/songs")
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        // This endpoint calls the AdminService
        String adminServiceUrl = "http://admin-service/api/songs";
        ResponseEntity<List<SongDTO>> response = restTemplate.exchange(
            adminServiceUrl,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<SongDTO>>() {}
        );
        return response;
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        // --- This is a simplified login for demonstration ---
        // In a real application, you would first validate the user's password.
        
        // The controller's job is now very clean:
        // It asks the JwtTokenProvider to create a token for the given username.
        String token = jwtTokenProvider.createToken(loginRequest.getUsername());

        return ResponseEntity.ok(token);
    }
}
