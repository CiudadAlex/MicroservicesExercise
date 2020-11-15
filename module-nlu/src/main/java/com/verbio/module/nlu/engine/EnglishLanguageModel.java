package com.verbio.module.nlu.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.verbio.module.common.constants.IntentCode;
import com.verbio.module.common.constants.IntentParamCode;
import com.verbio.module.common.constants.Language;
import com.verbio.module.common.dto.IntentDTO;
import com.verbio.module.common.dto.IntentParamDTO;

/**
 * EnglishLanguageModel.
 *
 * @author Alejandro
 *
 */
public class EnglishLanguageModel implements LanguageModel {

    @Override
    public IntentDTO guessIntent(final String textInput) {

        final String patternNameIntent = "my name is ";
        final String textInputLower = textInput.toLowerCase();

        if (textInputLower.contains(patternNameIntent)) {

            final int indexBeginName = textInputLower.indexOf(patternNameIntent) + patternNameIntent.length();

            int indexEndName = textInputLower.indexOf(" ", indexBeginName);
            indexEndName = indexEndName != -1 ? indexEndName : textInputLower.length();

            final String name = textInput.substring(indexBeginName, indexEndName);

            final List<IntentParamDTO> listIntentParam = Arrays.asList(new IntentParamDTO(IntentParamCode.NAME.name(), name));

            return new IntentDTO(IntentCode.NAME.name(), listIntentParam, Language.EN.name());
        }

        return new IntentDTO(IntentCode.UNKNOWN.name(), new ArrayList<IntentParamDTO>(), Language.EN.name());
    }

}
