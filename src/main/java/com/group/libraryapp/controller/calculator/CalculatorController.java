package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 해당 클래스를 Controller(API의 진입 지점)로 만들어 줌
@RestController
public class CalculatorController {
    // HTTP Method가 GET이고 path가 /add인 API로 지정
    @GetMapping("/add")
    public int addTwoNumbers(
        // 쿼리를 통해 넘어온 데이터를 함수 파라미터에 연결
        // GET /add?number1=10&number2=20 호출 시 파라미터에 값이 들어감
//        @RequestParam int number1,
//        @RequestParam int number2

        // @RequestParam이 너무 길어지면 dto 객체 사용
        // 쿼리가 객체에 있는 값에 들어가게 됨
        CalculatorAddRequest request
    ) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        // @RequestBody가 있어야 HTTP Body 안에 있는 JSON을 객체로 변환 가능
        return request.getNumber1() * request.getNumber2();
    }
}
