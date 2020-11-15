package com.verbio.module.common.constants;

/**
 * Language.
 *
 * @author Alejandro
 *
 */
public enum Language {

    EN, ES, FR, CA;

    public static Language getByName(final String name) {

        for (final Language language : values()) {

            if (language.name().equals(name)) {
                return language;
            }
        }

        return null;
    }
}
