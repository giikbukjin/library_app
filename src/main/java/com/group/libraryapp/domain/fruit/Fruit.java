package com.group.libraryapp.domain.fruit;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(name = "warehousing_date")
    private LocalDate warehousingDate;

    private Long price;

    @Column(name = "is_sold")
    private boolean isSold;

    protected Fruit() {}

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException(
                    String.format("잘못된 name(%s)이 들어왔습니다.", name)
            );
        }
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = false;
    }

    public void updateIsSold(Boolean isSold) {
        this.isSold = isSold;
    }
}
