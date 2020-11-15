package com.verbio.module.knowledgeserver.rest;

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
public class ModuleKnowledgeServerController {

    private static final Logger LOG = Logger.getLogger(ModuleKnowledgeServerController.class.getName());

    @GetMapping("/ping")
    public String ping() {

        LOG.info("ping");
        return "pong";
    }

}
