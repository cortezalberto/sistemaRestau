// ===== 1. CORRECCIÓN: Pais.java =====
package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter

@AllArgsConstructor
@ToString(callSuper = true)  // FALTABA: callSuper = true
public class Pais extends Base {

    @Override
    public String getInfo() {
        return "País: " + getNombre();
    }
}