package com.verbio.module.user.dom;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Person.
 *
 * @author alciucam
 *
 */
@Entity
@Table(indexes = { @Index(name = "index_person_name", columnList = "name"),
        @Index(name = "index_person_firstName", columnList = "firstName"), @Index(name = "index_person_lastName", columnList = "lastName"),
        @Index(name = "index_person_legalId", columnList = "legalId"),
        @Index(name = "index_person_dateOfBirth", columnList = "dateOfBirth") })
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String legalId;

    private String phone;

    private String email;

    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Institution institution;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(final String legalId) {
        this.legalId = legalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(final Institution institution) {
        this.institution = institution;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
