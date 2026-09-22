package com.rakup.na_zvaH.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetail {
    private String item;
    private String description;
    private String status;
    private String category;
    private Date date;
}
