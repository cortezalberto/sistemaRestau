package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Usuario extends Base {
    private String auth0Id;
    private String username;


@Override
    public String getInfo() {
        return "";
    }

}