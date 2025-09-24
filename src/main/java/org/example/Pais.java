package org.example;
import  lombok.*;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor


    public class Pais extends Base {

    @Override
    public String getInfo() {
        return "País: " + getNombre();
    }
}