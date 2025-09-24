package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Localidad extends Base{
    private String nombre;
    private Provincia provincia;

    @Override
    public String getInfo() {
        return "";
    }
}