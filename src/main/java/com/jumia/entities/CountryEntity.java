package com.jumia.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = CountryEntity.ENTITY_NAME)
@Table(name = CountryEntity.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class CountryEntity {

    public static final String ENTITY_NAME = "Country";
    public static final String TABLE_NAME = "country";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "code", nullable = false)
    private String code;

    @NotBlank
    @Column(name = "regex", nullable = false)
    private String regex;
}
