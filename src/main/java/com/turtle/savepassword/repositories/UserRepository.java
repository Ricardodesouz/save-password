package com.turtle.savepassword.repositories;

import com.turtle.savepassword.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
