package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Usuario extends Base {
    private String auth0Id;
    private String username;

    @Override
    public String getInfo() {
        return "Usuario: " + username + " - " + auth0Id;
    }
}