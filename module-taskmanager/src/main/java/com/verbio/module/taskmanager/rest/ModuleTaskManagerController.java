package com.verbio.module.taskmanager.rest;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ModuleProductController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleTaskManagerController {

    private static final Logger LOG = Logger.getLogger(ModuleTaskManagerController.class.getName());

    @GetMapping("/ping")
    public String ping() {

        LOG.info("ping");
        return "pong";
    }

}
