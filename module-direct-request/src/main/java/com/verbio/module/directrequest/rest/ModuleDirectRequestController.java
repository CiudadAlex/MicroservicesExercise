package com.verbio.module.directrequest.rest;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.TextOutputDTO;
import com.verbio.module.directrequest.engine.DirectRequestAnswerer;
import com.verbio.module.directrequest.engine.DirectRequestAnswererLoader;

/**
 * ModuleProductController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleDirectRequestController {

    private static final Logger LOG = Logger.getLogger(ModuleDirectRequestController.class.getName());

    @PostMapping(path = "/intentRecognizer", consumes = "application/json", produces = "application/json")
    public TextOutputDTO findAnswer(@RequestBody final IntentDTO intent) {

        final String languageSelected = intent.getLanguageSelected();
        final DirectRequestAnswerer directRequestAnswerer = DirectRequestAnswererLoader.loadDirectRequestAnswerer(languageSelected);

        if (directRequestAnswerer == null) {
            // Language is unknown
            return new TextOutputDTO("Sorry I can't understand that language");
        }

        final String answer = directRequestAnswerer.findAnswer(intent);

        LOG.info(answer);

        return new TextOutputDTO(answer);
    }

}
