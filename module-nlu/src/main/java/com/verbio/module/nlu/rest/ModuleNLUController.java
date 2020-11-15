package com.verbio.module.nlu.rest;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.verbio.module.common.constants.IntentCode;
import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.IntentParamDTO;
import com.verbio.module.common.dto.TextInputDTO;
import com.verbio.module.nlu.engine.LanguageModel;
import com.verbio.module.nlu.engine.LanguageModelLoader;

/**
 * ModuleProductController.
 *
 * @author Alejandro
 *
 */
@RestController
public class ModuleNLUController {

    private static final Logger LOG = Logger.getLogger(ModuleNLUController.class.getName());

    @PostMapping(path = "/intentRecognizer", consumes = "application/json", produces = "application/json")
    public IntentDTO intentRecognizer(@RequestBody final TextInputDTO textInputDTO) {

        final String textInput = textInputDTO.getTextInput();
        final String languageSelected = textInputDTO.getLanguageSelected();
        final LanguageModel languageModel = LanguageModelLoader.loadLanguageModel(languageSelected);

        if (languageModel == null) {
            // If language is unknown then the intent is unknown
            return new IntentDTO(IntentCode.UNKNOWN.name(), new ArrayList<IntentParamDTO>(), languageSelected);
        }

        final IntentDTO intent = languageModel.guessIntent(textInput);

        LOG.info("Intent = " + intent.getIntentCode());

        return intent;
    }

}
