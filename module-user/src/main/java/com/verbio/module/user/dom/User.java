package com.verbio.module.user.dom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    private String alternateId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date leavingDate;

    private String leavingCause;

    private String language;

    private String typeOfUser;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Person person;

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getAlternateId() {
        return alternateId;
    }

    public void setAlternateId(final String alternateId) {
        this.alternateId = alternateId;
    }

    public Date getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(final Date signUpDate) {
        this.signUpDate = signUpDate;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(final Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public String getLeavingCause() {
        return leavingCause;
    }

    public void setLeavingCause(final String leavingCause) {
        this.leavingCause = leavingCause;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(final String language) {
        this.language = language;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    public boolean isActive() {
        return leavingDate != null;
    }

    public String getTypeOfUser() {
        return typeOfUser;
    }

    public void setTypeOfUser(final String type) {
        this.typeOfUser = type;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
