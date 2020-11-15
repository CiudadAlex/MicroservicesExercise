package com.verbio.module.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verbio.module.user.dom.Role;
import com.verbio.module.user.dom.UserRole;

/**
 * UserRoleDAO.
 *
 * @author Alejandro
 *
 */
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    @Query("SELECT r FROM UserRole ur inner join ur.user u inner join ur.role r WHERE u.id = ?1")
    List<Role> findRoleByUser(Long userId);
}
