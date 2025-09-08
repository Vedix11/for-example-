package com.music.library.user.service;
import com.music.library.user.model.User;
import com.music.library.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        // In a real app, you'd add password encoding and validation here
        return userRepository.save(user);
    }
}