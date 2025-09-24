package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Sucursal extends Base {
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;

    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();

    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();

    private Domicilio domicilio;

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    public void addPromocion(Promocion promocion) {
        promociones.add(promocion);
    }

    public void removePromocion(Promocion promocion) {
        promociones.remove(promocion);
    }

    @Override
    public String getInfo() {
        return "Sucursal: " + getNombre() + " - " + categorias.size() + " categorías";
    }
}