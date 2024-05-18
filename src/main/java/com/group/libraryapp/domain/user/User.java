package com.group.libraryapp.domain.user;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name")
    private String name;

    private Integer age;

    protected User() {}

    public User(String name, Integer age) {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException(
                    String.format("잘못된 name(%s)이 들어왔습니다.", name)
            );
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
