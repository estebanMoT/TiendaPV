package com.std.ec.model.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    Integer id_Cliente;
    String nombre;
    String apellido;
    String correo;
    Date fechaRegistro;

    public int test(){
        return 0;
    }
}
