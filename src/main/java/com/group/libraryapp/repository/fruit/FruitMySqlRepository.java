package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.FruitRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class FruitMySqlRepository implements FruitRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(FruitRequest request) {
        String sql = "insert into fruit (name, warehousingDate, price) values (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Override
    public Boolean isFruitNotExitById(FruitRequest request) {
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
    }

    @Override
    public Boolean isFruitNotExitByName(String name) {
        String readSql = "SELECT * FROM fruit WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    @Override
    public void fruitUpdate(FruitRequest request) {
        String sql = "UPDATE fruit SET sold = 'SOLD' WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @Override
    public long getSoldSum() {
        String soldSql = "SELECT COALESCE(SUM(price), 0) FROM fruit WHERE sold = 'SOLD'";
        return jdbcTemplate.queryForObject(soldSql, Long.class);
    }

    @Override
    public long getNotSoldSum() {
        String notSoldSql = "SELECT COALESCE(SUM(price), 0) FROM fruit WHERE sold = 'NOT_SOLD'";
        return jdbcTemplate.queryForObject(notSoldSql, Long.class);
    }
}
