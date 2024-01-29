package com.std.ec.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {
    @Id
    @Column(name = "sku")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sku;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "preciocompra")
    private Float preciocompra;

    @Column(name = "precioventa")
    private Float precioventa;

    @Column(name = "fecha_registro")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date fecha_registro;
    @PrePersist
    protected void onCreate() {
        fecha_registro = new Date();
    }
}
