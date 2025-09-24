
// ===== CORRECCIÓN 4: Cliente.java =====
package org.example;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"pedidos", "domicilios", "usuario"}) // EXCLUIR colecciones y referencias
public class Cliente extends Base {
    private String apellido;
    private String telefono;
    private String email;
    private LocalDate fechaNacimiento;
    private Imagen imagen;

    @Builder.Default
    private Set<Pedido> pedidos = new HashSet<>();

    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();

    private Usuario usuario;

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removePedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public void addDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
    }

    public void removeDomicilio(Domicilio domicilio) {
        domicilios.remove(domicilio);
    }

    @Override
    public String getInfo() {
        return "Cliente: " + getNombre() + " " + apellido + " - " + email;
    }
}
