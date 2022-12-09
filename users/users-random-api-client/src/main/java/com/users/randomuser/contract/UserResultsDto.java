package com.users.randomuser.contract;


import java.util.List;

public class UserResultsDto {

    private List<UserDto> results;

    public List<UserDto> getResults() {
        return results;
    }

    public void setResults(List<UserDto> results) {
        this.results = results;
    }
}
