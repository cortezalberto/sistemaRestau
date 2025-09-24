package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pais extends Base {
    private String nombre;


    @Override
    public String getInfo() {
        return "";
    }
}