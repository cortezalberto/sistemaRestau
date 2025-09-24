package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Categoria extends Base {
    private String denominacion;

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @Builder.Default
    private Set<Categoria> subcategorias = new HashSet<>();

    private Categoria categoriaPadre;

    public void addArticulo(Articulo articulo) {
        articulos.add(articulo);
    }

    public void removeArticulo(Articulo articulo) {
        articulos.remove(articulo);
    }

    public void addSubcategoria(Categoria subcategoria) {
        subcategoria.setCategoriaPadre(this);
        subcategorias.add(subcategoria);
    }

    public void removeSubcategoria(Categoria subcategoria) {
        subcategoria.setCategoriaPadre(null);
        subcategorias.remove(subcategoria);
    }

    @Override
    public String getInfo() {
        return "Categoria: " + denominacion + " - " + articulos.size() + " artículos";
    }
}