package com.verbio.module.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.verbio.module.user.dom.Permission;
import com.verbio.module.user.dom.RolePermission;

/**
 * RolePermissionDAO.
 *
 * @author Alejandro
 *
 */
public interface RolePermissionDAO extends JpaRepository<RolePermission, Long> {

    @Query("SELECT p FROM RolePermission rp inner join rp.permission p inner join rp.role r WHERE r.id = ?1")
    List<Permission> findPermissionByRole(Long roleId);
}
