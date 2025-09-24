package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class DetallePedido extends Base {
    private Integer cantidad;
    private Double subTotal;
    private Articulo articulo;

    @Override
    public String getInfo() {
        return "DetallePedido: " + cantidad + " x " + (articulo != null ? articulo.getDenominacion() : "N/A");
    }
}