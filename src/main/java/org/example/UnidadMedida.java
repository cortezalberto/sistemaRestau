package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UnidadMedida extends Base {
    private String denominacion;

    @Override
    public String getInfo() {
        return "Unidad de Medida: " + denominacion;
    }
}
