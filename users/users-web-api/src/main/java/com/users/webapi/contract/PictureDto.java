package com.users.webapi.contract;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PictureDto {
    private long id;
    private String thumbnail;
    private String medium;
    private String large;
}
