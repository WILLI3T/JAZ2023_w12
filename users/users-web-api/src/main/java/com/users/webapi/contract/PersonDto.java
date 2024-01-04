package com.users.webapi.contract;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class PersonDto {

    private String phone;
    private String firstname;
    private String lastname;
    private String gender;
    private String email;
    private LocalDateTime dateOfBirth;
    private Integer age;
    private long id;
}
