package com.minh.labweek06.Repository;

import com.minh.labweek06.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByEmailAndPasswordHash(String email,String passwordHash);

}
