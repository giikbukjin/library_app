package com.group.libraryapp.dto.fruit;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FruitRequest {
    private long id;
    private String name;
    private LocalDate warehousingDate;
    private long price;
}
