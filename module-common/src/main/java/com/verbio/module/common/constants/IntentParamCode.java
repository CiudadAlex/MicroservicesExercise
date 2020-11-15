package com.verbio.module.common.constants;

/**
 * IntentParamCode.
 *
 * @author usuario
 *
 */
public enum IntentParamCode {

    NAME;

    public static IntentParamCode getByName(final String name) {

        for (final IntentParamCode intentParamCode : values()) {

            if (intentParamCode.name().equals(name)) {
                return intentParamCode;
            }
        }

        return null;
    }
}
