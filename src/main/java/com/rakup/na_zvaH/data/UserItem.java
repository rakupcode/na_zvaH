package com.rakup.na_zvaH.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserItem {

    @Id
    private Long userId;

    @Column
    private String itemMap;

    @Column
    private String lastItem;
}
