package com.std.ec.model.dto;

import jakarta.persistence.Column;
/*
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
*/import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class InventarioDto implements Serializable {
    private Integer sku;
    private String nombre;
    private Integer cantidad;
    private Float preciocompra;
    private Float precioventa;
    private Date fecha_registro;
}
