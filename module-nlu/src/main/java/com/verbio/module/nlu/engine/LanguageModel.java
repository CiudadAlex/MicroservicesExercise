package com.verbio.module.nlu.engine;

import com.verbio.module.common.dto.IntentDTO;

/**
 * LanguageModel.
 *
 * @author usuario
 *
 */
public interface LanguageModel {

    public IntentDTO guessIntent(String textInput);
}
