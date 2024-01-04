package com.users.webapi.contract;

import lombok.Builder;

@Builder
public record UserDto (
    long id,
    String username,
    String password,
    String uuid,
    String salt,
    String md5,
    String sha1,
    String sha256
){}
