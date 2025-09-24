package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Domicilio extends Base {
    private int numero;
    private int cp;
    private Localidad localidad;

    @Override
    public String getInfo() {
        return "Domicilio: " + getNombre() + " " + numero + " - CP: " + cp;
    }
}