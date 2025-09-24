package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Base {
    private Long id;
    private String nombre;

    @Builder.Default
    private boolean eliminado = false;

    public abstract String getInfo();
}
