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
@Table(name = "notasdeventa")
public class Venta implements Serializable {

    @Id
    @Column(name = "numventa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numventa;
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Column(name = "id_cliente")
    private Integer id_cliente;
    @Column(name = "sku")
    private Integer sku;
    @Column(name = "nombreproducto")
    private String nombreproducto;
    @Column(name = "cantidadventa")
    private Integer cantidadventa;
    @Column(name = "precioventa")
    private Float precioventa;
    @Column(name = "fecha_venta")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date fecha_venta;
    @PrePersist
    protected void onCreate() {
        fecha_venta = new Date();
    }


}
