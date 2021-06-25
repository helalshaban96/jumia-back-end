package com.jumia.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity(name = CustomerEntity.ENTITY_NAME)
@Table(name = CustomerEntity.TABLE_NAME)
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class CustomerEntity {

    public static final String ENTITY_NAME = "Customer";
    public static final String TABLE_NAME = "customer";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone")
    private String phone;
}
