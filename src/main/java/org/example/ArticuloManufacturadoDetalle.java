package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder

public class ArticuloManufacturadoDetalle extends Base {
    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;

    @Override
    public String getInfo() {
        return "";
    }
}
