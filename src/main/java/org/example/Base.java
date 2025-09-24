package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder

@Getter @Setter @ToString
public abstract class Base {
    private Long id;
    private String nombre;
    @Builder.Default
    private boolean eliminado = false;

    public Base() {}

    public Base(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public abstract String getInfo();
}