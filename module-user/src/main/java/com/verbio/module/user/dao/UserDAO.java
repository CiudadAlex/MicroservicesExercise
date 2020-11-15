package com.verbio.module.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verbio.module.user.dom.User;

/**
 * UserDAO.
 *
 * @author Alejandro
 *
 */
public interface UserDAO extends JpaRepository<User, Long> {

    User findByLogin(String login);

    @Query("SELECT u.id FROM User u WHERE leavingDate is not null and u.typeOfUser = ?1")
    List<Long> findInactiveUsersIdByType(String typeOfUser);
}
