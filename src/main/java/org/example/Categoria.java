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
public class Categoria extends Base {

    private String denominacion;

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @Builder.Default
    private Set<Categoria> subcategorias = new HashSet<>();

    private Categoria categoriaPadre;

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public void agregarSubcategoria(Categoria subcategoria) {
        subcategoria.setCategoriaPadre(this);
        this.subcategorias.add(subcategoria);
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "denominacion='" + denominacion + '\'' +
                ", articulos=" + articulos +
                ", subcategorias=" + subcategorias +
                '}';
    }
}
