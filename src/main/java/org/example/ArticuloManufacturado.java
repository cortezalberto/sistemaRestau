package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)

public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private int tiempoEstimadoMinutos;
    private String preparacion;

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detallesDeArticulo = new HashSet<>();

    public void addDetalle(ArticuloManufacturadoDetalle detalle) {
        detallesDeArticulo.add(detalle);
    }

    public void removeDetalle(ArticuloManufacturadoDetalle detalle) {
        detallesDeArticulo.remove(detalle);
    }

    @Override
    public String getInfo() {
        return "";
    }
}

