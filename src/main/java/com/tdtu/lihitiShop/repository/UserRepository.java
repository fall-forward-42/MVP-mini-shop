package com.tdtu.lihitiShop.repository;

import com.tdtu.lihitiShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
   // @Query(value = "select * from users where username =?1",nativeQuery = true)
    Optional<User> findByUsername(String username);
}
