package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ArticuloManufacturadoDetalle extends Base {
    private Integer cantidad;
    private ArticuloInsumo articuloInsumo;

    @Override
    public String getInfo() {
        return "Detalle: " + cantidad + " x " + (articuloInsumo != null ? articuloInsumo.getDenominacion() : "N/A");
    }
}
