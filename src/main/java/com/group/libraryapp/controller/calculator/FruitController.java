package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.FruitRequest;
import com.group.libraryapp.dto.calculator.response.FruitResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request) {
        String sql = "insert into fruit (name, warehousingDate, price) values (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        boolean isFruitNotExit
                = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExit) {
            throw new IllegalStateException();
        }

        String sql = "UPDATE fruit SET sold = 'SOLD' WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitResponse getFruitStat(@RequestParam String name) {
        String readSql = "SELECT * FROM fruit WHERE name = ?";
        boolean isFruitNotExit
                = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if (isFruitNotExit) {
            throw new IllegalStateException();
        }

        FruitResponse response = new FruitResponse();

        String soldSql = "SELECT COALESCE(SUM(price), 0) FROM fruit WHERE sold = 'SOLD'";
        String notSoldSql = "SELECT COALESCE(SUM(price), 0) FROM fruit WHERE sold = 'NOT_SOLD'";

        long soldSum = jdbcTemplate.queryForObject(soldSql, Long.class);
        long notSoldSum = jdbcTemplate.queryForObject(notSoldSql, Long.class);

        response.setSalesAmount(soldSum);
        response.setNotSalesAmount(notSoldSum);

        return response;
    }
}
