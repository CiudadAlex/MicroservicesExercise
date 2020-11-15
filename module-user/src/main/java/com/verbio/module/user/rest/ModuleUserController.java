package com.verbio.module.user.rest;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.verbio.module.common.dto.LoginStatusDTO;
import com.verbio.module.user.dao.UserDAO;
import com.verbio.module.user.dom.User;

/**
 * ModuleUserController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleUserController {

    private static final Logger LOG = Logger.getLogger(ModuleUserController.class.getName());

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/login/{login}/{password}")
    public LoginStatusDTO login(@PathVariable("login") final String login, @PathVariable("password") final String password) {

        LOG.log(Level.INFO, "login executed");

        final User user = userDAO.findByLogin(login);

        if (user != null && user.getPassword().equals(password)) {

            return new LoginStatusDTO(true);
        }

        return new LoginStatusDTO(false);
    }

}
