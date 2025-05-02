package com.sebastian.tienda_musical.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "genero")
public class GenderEntity {
    @Id
    @Column(name = "id_genero", nullable = false)
    private Integer id;

    @Column(name = "desc_genero", nullable = false, length = 100)
    private String description;

}
