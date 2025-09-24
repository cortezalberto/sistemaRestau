package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Domicilio extends Base{
    private String nombre;
    private int numero;
    private int cp;
    private Localidad localidad;


    @Override
    public String getInfo() {
        return "";
    }
}