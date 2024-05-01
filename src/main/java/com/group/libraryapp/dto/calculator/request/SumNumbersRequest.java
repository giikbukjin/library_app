package com.group.libraryapp.dto.calculator.request;

import lombok.Getter;

import java.util.List;

@Getter
public class SumNumbersRequest {
    private List<Integer> numbers;

    public SumNumbersRequest() {
    }

    public SumNumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
