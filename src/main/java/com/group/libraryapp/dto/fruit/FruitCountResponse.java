package com.group.libraryapp.dto.fruit;

import lombok.Getter;

@Getter
public class FruitCountResponse {
    private long count;

    public FruitCountResponse(long count) {
        this.count = count;
    }
}
