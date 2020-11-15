package com.verbio.module.nlu.engine;

import java.util.HashMap;
import java.util.Map;

import com.verbio.module.common.constants.Language;

/**
 * LanguageModelLoader.
 *
 * @author Alejandro
 *
 */
public class LanguageModelLoader {

    private static final Map<String, LanguageModel> mapLangModel = buildMap();

    private static Map<String, LanguageModel> buildMap() {

        final Map<String, LanguageModel> mapLangModel = new HashMap<String, LanguageModel>();
        mapLangModel.put(Language.EN.name(), new EnglishLanguageModel());
        return mapLangModel;
    }

    public static LanguageModel loadLanguageModel(final String languageSelected) {
        return mapLangModel.get(languageSelected);
    }
}
