package com.jumia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {

    private Long id;

    private String name;

    private String phone;
}
