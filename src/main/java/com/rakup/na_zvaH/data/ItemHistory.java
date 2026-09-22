package com.rakup.na_zvaH.data;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class ItemHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @ManyToOne
    private Item item;

    @Column
    private String status;

    @DateTimeFormat
    private Date date;

    @Column
    private Boolean isActive;
}
