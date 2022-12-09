package com.users.randomuser.contract;

public class UserDto {

    private UserNameDto name;
    private LocationDto location;
    private LoginDto login;
    private String phone;
    private String email;
    private PictureDto picture;
    private String gender;

    public UserNameDto getName() {
        return name;
    }

    public void setName(UserNameDto name) {
        this.name = name;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public LoginDto getLogin() {
        return login;
    }

    public void setLogin(LoginDto login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PictureDto getPicture() {
        return picture;
    }

    public void setPicture(PictureDto picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
