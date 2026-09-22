package com.rakup.na_zvaH.data;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

public class NaZvaH {
    @Value("${na_zvaH.version}")
    public static String VERSION;
}
