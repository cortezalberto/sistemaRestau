package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor


public class Pedido {
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


    public void addDetallesPedido(DetallePedido detallePedido) {
        if (detallePedidos == null) {
            detallePedidos = new HashSet<>();
        }
        detallePedidos.add(detallePedido);
    }

    public void removeDetallesPedido(DetallePedido detallePedido) {
        detallePedidos.remove(detallePedido);
    }







    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(double totalCosto) {
        this.totalCosto = totalCosto;
    }




}