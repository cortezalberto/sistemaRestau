package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Localidad extends Base {
    private Provincia provincia;

    @Override
    public String getInfo() {
        return "Localidad: " + getNombre() + " - " + (provincia != null ? provincia.getNombre() : "N/A");
    }
}
