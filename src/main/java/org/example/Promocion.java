package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.awt.geom.Area;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

public class Promocion extends Base {

    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private double precioDescuento;
    private double precioPromocional;
    private TipoPromocion tipoPromocion;
    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();




    public void addImagenes(Imagen imagen) {
        if (imagenes == null) {
            imagenes = new HashSet<>();
        }
        imagenes.add(imagen);
    }

    public void removeImagen(Imagen imagen) {
        imagenes.remove(imagen);
    }

    public void addArticulos(Articulo articulo) {
        if (articulos == null) {
            articulos = new HashSet<>();
        }
        articulos.add(articulo);
    }

    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }
    @Override
    public String getInfo() {
        return "";
    }

}