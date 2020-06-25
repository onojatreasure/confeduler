package com.pluralsight.confeduler.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "organisations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organisation_id;
    private String organisation_name;
    private String organisation_address;
    private String organisation_website;
    private String organisation_email;
    private String organisation_phone;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] organisation_photo;

    //Relationship with conference table
    @OneToMany
    @JoinTable(
            name = "organisation_conferences",
            joinColumns = @JoinColumn(name = "organisation_id"),
            inverseJoinColumns = @JoinColumn(name = "conference_id")
    )
    private List<Conference> conferences;

    public  Organisation() {

    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    public Long getOrganisation_id() {
        return organisation_id;
    }

    public void setOrganisation_id(Long organisation_id) {
        this.organisation_id = organisation_id;
    }

    public String getOrganisation_name() {
        return organisation_name;
    }

    public void setOrganisation_name(String organisation_name) {
        this.organisation_name = organisation_name;
    }

    public String getOrganisation_address() {
        return organisation_address;
    }

    public void setOrganisation_address(String organisation_address) {
        this.organisation_address = organisation_address;
    }

    public String getOrganisation_website() {
        return organisation_website;
    }

    public void setOrganisation_website(String organisation_website) {
        this.organisation_website = organisation_website;
    }

    public String getOrganisation_email() {
        return organisation_email;
    }

    public void setOrganisation_email(String organisation_email) {
        this.organisation_email = organisation_email;
    }

    public String getOrganisation_phone() {
        return organisation_phone;
    }

    public void setOrganisation_phone(String organisation_phone) {
        this.organisation_phone = organisation_phone;
    }

    public byte[] getOrganisation_photo() {
        return organisation_photo;
    }

    public void setOrganisation_photo(byte[] organisation_photo) {
        this.organisation_photo = organisation_photo;
    }
}
