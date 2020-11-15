package com.verbio.module.directrequest.engine;

import java.util.HashMap;
import java.util.Map;

import com.verbio.module.common.constants.Language;

/**
 * DirectRequestAnswererLoader.
 *
 * @author Alejandro
 *
 */
public class DirectRequestAnswererLoader {

    private static final Map<String, DirectRequestAnswerer> mapLangMAnswerer = buildMap();

    private static Map<String, DirectRequestAnswerer> buildMap() {

        final Map<String, DirectRequestAnswerer> mapLangModel = new HashMap<String, DirectRequestAnswerer>();
        mapLangModel.put(Language.EN.name(), new EnglishDirectRequestAnswerer());
        return mapLangModel;
    }

    public static DirectRequestAnswerer loadDirectRequestAnswerer(final String languageSelected) {
        return mapLangMAnswerer.get(languageSelected);
    }
}
