package com.sebastian.tienda_musical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "idioma")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LanguageEntity {
    @Id
    @Column(name = "id_idioma", nullable = false)
    private Integer id;

    @Column(name = "desc_idioma", nullable = false, length = 50)
    private String description;

}
