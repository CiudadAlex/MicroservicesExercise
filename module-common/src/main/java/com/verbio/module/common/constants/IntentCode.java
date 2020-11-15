package com.verbio.module.common.constants;

/**
 * IntentCode.
 *
 * @author Alejandro
 *
 */
public enum IntentCode {

    NAME,

    UNKNOWN;

    public static IntentCode getByName(final String name) {

        for (final IntentCode intentCode : values()) {

            if (intentCode.name().equals(name)) {
                return intentCode;
            }
        }

        return null;
    }
}
