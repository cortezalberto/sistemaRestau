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
@ToString(callSuper = true, exclude = {"sucursales"}) // EXCLUIR colecciones
public class Empresa extends Base {
    private String razonSocial;
    private Integer cuil;

    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    public void addSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public void removeSucursal(Sucursal sucursal) {
        sucursales.remove(sucursal);
    }

    @Override
    public String getInfo() {
        return "Empresa: " + getNombre() + " - " + razonSocial + " - " + sucursales.size() + " sucursales";
    }
}
