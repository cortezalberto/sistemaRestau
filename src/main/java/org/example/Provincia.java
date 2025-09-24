package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Provincia extends Base {
    private Pais pais;

    @Override
    public String getInfo() {
        return "Provincia: " + getNombre() + " - " + (pais != null ? pais.getNombre() : "N/A");
    }
}