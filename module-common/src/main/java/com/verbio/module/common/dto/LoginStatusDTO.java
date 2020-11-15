package com.verbio.module.common.dto;

/**
 * LoginStatusDTO.
 *
 * @author Alejandro
 *
 */
public class LoginStatusDTO {

    private Boolean sucess;

    public LoginStatusDTO() {
    }

    public LoginStatusDTO(final boolean sucess) {
        this.sucess = sucess;
    }

    public Boolean getSucess() {
        return sucess;
    }

    public void setSucess(final Boolean sucess) {
        this.sucess = sucess;
    }

}
