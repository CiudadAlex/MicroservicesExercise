package com.verbio.module.common.dto;

import java.util.List;

import com.verbio.module.common.constants.IntentParamCode;

/**
 * IntentDTO.
 *
 * @author Alejandro
 *
 */
public class IntentDTO {

    private String intentCode;
    private List<IntentParamDTO> listIntentParam;
    private String languageSelected;

    public IntentDTO() {
    }

    public IntentDTO(final String intentCode, final List<IntentParamDTO> listIntentParam, final String languageSelected) {
        this.intentCode = intentCode;
        this.listIntentParam = listIntentParam;
        this.languageSelected = languageSelected;
    }

    public String getIntentCode() {
        return intentCode;
    }

    public List<IntentParamDTO> getListIntentParam() {
        return listIntentParam;
    }

    public void setIntentCode(final String intentCode) {
        this.intentCode = intentCode;
    }

    public void setListIntentParam(final List<IntentParamDTO> listIntentParam) {
        this.listIntentParam = listIntentParam;
    }

    public String getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(final String languageSelected) {
        this.languageSelected = languageSelected;
    }

    public String getParamValue(final IntentParamCode intentParamCode) {

        for (final IntentParamDTO intentParamDTO : listIntentParam) {

            if (intentParamCode.name().equals(intentParamDTO.getParam())) {
                return intentParamDTO.getValue();
            }
        }

        return null;
    }

}
