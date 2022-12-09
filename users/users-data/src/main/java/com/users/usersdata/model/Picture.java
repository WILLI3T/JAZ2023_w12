package com.users.usersdata.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Person person;

    private String thumbnail;
    private String medium;
    private String large;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return id == picture.id && Objects.equals(person, picture.person) && Objects.equals(thumbnail, picture.thumbnail) && Objects.equals(medium, picture.medium) && Objects.equals(large, picture.large);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, thumbnail, medium, large);
    }
}
