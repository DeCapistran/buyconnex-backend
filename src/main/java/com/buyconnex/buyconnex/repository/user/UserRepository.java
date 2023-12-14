package com.buyconnex.buyconnex.repository.user;

import com.buyconnex.buyconnex.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users WHERE u.login =:login AND u.password =:password")
    Optional<Users> login(String login, String password);

    @Query("SELECT u FROM Users u WHERE u.login =:login")
    Optional<Users> findByLogin(String login);

    @Query("SELECT u FROM Users u"+
            "INNER JOIN Contacts c ON c.id = u.id_contact"+
            "WHERE c.email =:email")
    Optional<Users> findUserByEmail(String email);

    @Query("SELECT u FROM Users u"+
            "WHERE u.password IS NULL AND u.isLocked = true")
    List<Users> findUserToCreate();

    @Query("SELECT u FROM Users u"+
            "INNER JOIN Contacts c ON u.id_contact = c.id"+
            "WHERE u.login <> u.contacts.email")
    List<Users> findUserToUpdate();
}
