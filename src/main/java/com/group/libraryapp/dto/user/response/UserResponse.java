package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private long id;
    private String name;
    private int age;

    public UserResponse(long id, User user) {
        this.id = id;
        this.name = user.getName();;
        this.age = user.getAge();
    }
}