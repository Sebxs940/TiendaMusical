package com.sebastian.tienda_musical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "nacionalidad")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class NationalityEntity {
    @Id
    @Column(name = "id_nacionalidad", nullable = false)
    private Integer id;

    @Column(name = "desc_nacionalidad", nullable = false, length = 60)
    private String description;

    @Column(name = "abreviacion", nullable = false, unique = true, length = 4)
    private String abbreviation;
}
