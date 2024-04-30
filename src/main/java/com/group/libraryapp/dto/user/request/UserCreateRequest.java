package com.group.libraryapp.dto.user.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {
    private String name;

    // Integer : NULL을 표현할 수 있는 자료형
    private Integer age;
}
