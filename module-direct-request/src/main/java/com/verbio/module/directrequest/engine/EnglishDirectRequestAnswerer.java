package com.verbio.module.directrequest.engine;

import com.verbio.module.common.constants.IntentCode;
import com.verbio.module.common.constants.IntentParamCode;
import com.verbio.module.common.dto.IntentDTO;

/**
 * EnglishDirectRequestAnswerer.
 *
 * @author Alejandro
 *
 */
public class EnglishDirectRequestAnswerer implements DirectRequestAnswerer {

    @Override
    public String findAnswer(final IntentDTO intent) {

        if (IntentCode.NAME.name().equals(intent.getIntentCode())) {

            final String valueNombre = intent.getParamValue(IntentParamCode.NAME);

            if (valueNombre != null) {
                return "Hello " + valueNombre;
            }
        }

        return "I didn't understand, can you repeat it please?";
    }

}
