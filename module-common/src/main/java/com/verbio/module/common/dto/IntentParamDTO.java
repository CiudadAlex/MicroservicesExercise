package com.verbio.module.common.dto;

/**
 * IntentParamDTO.
 *
 * @author Alejandro
 *
 */
public class IntentParamDTO {

    private String param;
    private String value;

    public IntentParamDTO() {
    }

    public IntentParamDTO(final String param, final String value) {
        this.param = param;
        this.value = value;
    }

    public String getParam() {
        return param;
    }

    public void setParam(final String param) {
        this.param = param;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

}
