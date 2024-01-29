package com.std.ec.model.dto;

import jakarta.persistence.Column;
/*import lombok.Builder;
import lombok.Data;
import lombok.ToString;
*/import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class VentaDto implements Serializable
{
    private Integer numventa;
    private String nombrecliente;
    private Integer id_cliente;
    private Integer sku;
    private String nombreproducto;
    private Integer cantidadventa;
    private Float precioventa;
    private Date fecha_venta;
}
