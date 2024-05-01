package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.*;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.stream;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/api/v1/calc")
    public CalculatorRequest calcTwoNumbers(@RequestParam int num1, @RequestParam int num2) {
        CalculatorRequest request = new CalculatorRequest();

        request.setAdd(num1 + num2);
        request.setMinus(num1 - num2);
        request.setMultiply(num1 * num2);

        return request;
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfWeekRequest dateToDayOfWeek(@RequestParam String date) {
        // String to LocalDate
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);

        //DayOfWeekRequest 객체 생성
        DayOfWeekRequest request = new DayOfWeekRequest();

        // LocalDate에서 요일 추출
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        // "MON"과 같은 표기 설정
        request.setDayOfTheWeek(
                dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase()
        );
        return request;
    }

    @PostMapping("/api/v1/sum")
    public int sumNumbers(@RequestBody SumNumbersRequest request) {
        List<Integer> numList = request.getNumbers();

        return numList.stream().mapToInt(Integer::intValue).sum();
    }
}
