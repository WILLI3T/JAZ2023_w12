package com.users.webapi.contract;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data
@Accessors(fluent = true, chain = true)
public class AddressDto {
    private LocationDto location;
    private String street;
    private int number;

}
