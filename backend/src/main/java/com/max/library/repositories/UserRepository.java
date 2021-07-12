package com.max.library.repositories;

import com.max.library.entities.Book;
import com.max.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
