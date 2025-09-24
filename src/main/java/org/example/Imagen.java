package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Imagen extends Base {
    private String denominacion;

    @Override
    public String getInfo() {
        return "Imagen: " + denominacion;
    }
}
