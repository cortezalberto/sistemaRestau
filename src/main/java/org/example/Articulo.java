package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Articulo extends Base {
    private String denominacion;
    private double precioVenta;
    private UnidadMedida unidadMedida;

    @Builder.Default
    private HashSet<Imagen> imagenes = new HashSet<>();

    public void addImagen(Imagen imagen) {
        imagenes.add(imagen);
    }

    public void removeImagen(Imagen imagen) {
        imagenes.remove(imagen);
    }

}