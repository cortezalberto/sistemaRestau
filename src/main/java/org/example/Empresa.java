package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString

public class Empresa extends Base {
    
    private String nombre;
    private String razonSocial;
    private Integer cuil;
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();



    public void addSucursal(Sucursal sucursal){
        this.sucursales.add(sucursal);

    }

    public void removerSucursal(Sucursal sucursal){
        this.sucursales.remove(sucursal);
    }

    @Override
    public String getInfo() {
        return "";
    }

}