package com.users.randomuser.apiclient;

import com.users.randomuser.contract.UserResultsDto;

public interface IRandomUsersApiClient {
    UserResultsDto getRandomUsers(int howMany);
}
