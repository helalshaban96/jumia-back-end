package com.jumia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Country {

    private Long id;

    private String name;

    private String code;

    private String regex;
}
