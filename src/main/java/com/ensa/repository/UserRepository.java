package com.ensa.repository;

import com.ensa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
     User findByemailLike(String email);
}