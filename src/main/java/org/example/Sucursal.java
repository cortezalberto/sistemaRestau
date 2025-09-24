package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

public class Sucursal extends Base {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
    @Builder.Default
    private Set<Categoria> categorias = new HashSet<>();
    private Domicilio domicilio;





    public void addCategoria(Categoria categoria) {
        if (categorias == null) {
            categorias = new HashSet<>();
        }
        categorias.add(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        categorias.remove(categoria);
    }

    public void addPromocion (Promocion promocion){
        this.promociones.add(promocion);
    }

    public void removePromocion(Promocion promocion) {
        promociones.remove(promocion);
    }

    @Override
    public String getInfo() {
        return "";
    }
}