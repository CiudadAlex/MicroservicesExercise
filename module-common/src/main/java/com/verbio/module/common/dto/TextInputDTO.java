package com.verbio.module.common.dto;

/**
 * TextInputDTO.
 *
 * @author Alejandro
 *
 */
public class TextInputDTO {

    private String textInput;
    private String languageSelected;

    private String userName;
    private String password;

    public String getTextInput() {
        return textInput;
    }

    public void setTextInput(final String textInput) {
        this.textInput = textInput;
    }

    public String getLanguageSelected() {
        return languageSelected;
    }

    public void setLanguageSelected(final String languageSelected) {
        this.languageSelected = languageSelected;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

}
