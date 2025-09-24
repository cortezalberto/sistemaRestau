package org.example;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Imagen extends Base  {
    private String denominacion;

    @Override
    public String getInfo() {
        return "";
    }
}

