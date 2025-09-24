package org.example;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Factura extends Base {
    private LocalDate fechaFacturacion;
    private Integer mpPaymentId;
    private String mpMerchantOrderId;
    private String mpPreferenceId;
    private String mpPaymentType;
    private FormaPago formaPago;
    private Double totalVenta;

    @Override
    public String getInfo() {
        return "Factura: " + getId() + " - $" + totalVenta + " - " + formaPago;
    }
}
