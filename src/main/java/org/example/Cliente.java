package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente extends Base {
    private String nombre;
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







    public void addPedidos(Pedido pedido) {
        if (pedidos == null) {
            pedidos = new HashSet<>();
        }
        pedidos.add(pedido);
    }
    public void removePedidos(Pedido pedido) {
        pedidos.remove(pedido);
    }
    public void addDomicilios(Domicilio domicilio) {
        if (domicilios == null) {
           domicilios = new HashSet<>();
        }
        domicilios.add(domicilio);
        }
        public void removeDomicilios(Domicilio domicilio) {
        domicilios.remove(domicilio);
        }


    @Override
    public String getInfo() {
        return "";
    }


}