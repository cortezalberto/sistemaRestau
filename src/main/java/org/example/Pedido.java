package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Pedido extends Base {
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoDeEnvio tipoDeEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();

    private Sucursal sucursal;
    private Domicilio domicilio;
    private Factura factura;

    public void addDetallePedido(DetallePedido detallePedido) {
        detallePedidos.add(detallePedido);
    }

    public void removeDetallePedido(DetallePedido detallePedido) {
        detallePedidos.remove(detallePedido);
    }

    @Override
    public String getInfo() {
        return "Pedido: " + getId() + " - " + estado + " - $" + total;
    }
}