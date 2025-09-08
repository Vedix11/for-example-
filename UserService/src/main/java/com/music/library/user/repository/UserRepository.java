package com.music.library.user.repository;
import com.music.library.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}