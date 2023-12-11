package com.users.randomuser.contract;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateOfBirthDto {
    private LocalDateTime date;
    private int age;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
