package org.example;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        //Pais y provincia



         Pais argentina = Pais.builder()
                 .nombre("Argentina")
                 .build();

         Provincia mendoza = Provincia.builder().
                 nombre("Mendoza")
                 .pais(argentina)
                 .build();






        //Localidades


        Localidad maipu = Localidad.builder().
                nombre("Maipu")
                .provincia(mendoza)
                .build();

        Localidad godoyCruz = Localidad.builder()
                .nombre("Godoy Cruz")
                .provincia(mendoza)
                .build();

        Localidad guaymallen = Localidad.builder()
                .nombre("Guaymallen")
                .provincia(mendoza)
                .build();



        //Usuarios


        Usuario usuario1 = Usuario.builder()
                .auth0Id("001")
                .username("DavidLopez")
                .build();
        Usuario usuario2 = Usuario.builder()
                .auth0Id("002")
                .username("FerroTomi")
                .build();



        //direcciones
//
        Domicilio d1 = Domicilio.builder()
                .localidad(maipu)
                .nombre("San Martín")
                .cp(5501)
                .numero(1000)
                .build();



        Domicilio d2 = Domicilio.builder()
                .localidad(godoyCruz)
                .nombre("San Juan")
                .cp(5502)
                .numero(500)
                .build();


        //Imagen



        Imagen imagen1 = Imagen.builder()
                .denominacion("Imagenaz")
                .build();

        Imagen imagen2 = Imagen.builder()
                .denominacion("Imago")
                .build();





        //Unidad de Medida


        UnidadMedida unidadMedida = UnidadMedida.builder()
                .denominacion("Kg")
                .build();

        //Articulos



        ArticuloInsumo articuloInsumo1 = ArticuloInsumo.builder()
                .denominacion("Quilmes")
                .precioVenta(50)
                .unidadMedida(unidadMedida)
                .precioCompra(20)
                .stockActual(50)
                .stockMaximo(100)
                .esParaElaborar(false)
                .build();

        ArticuloInsumo articuloInsumo2 = ArticuloInsumo.builder()
                .denominacion("Pizza Especial")
                .precioVenta(500)
                .unidadMedida(unidadMedida)
                .precioCompra(210)
                .stockActual(500)
                .stockMaximo(10000)
                .esParaElaborar(true)
                .build();


             articuloInsumo1.addImagen(imagen1);
             articuloInsumo2.addImagen(imagen2);



        DetallePedido detallePedido1 = DetallePedido.builder()
                .cantidad(1)
                .subTotal(0.0)
                .articulo(articuloInsumo1)
                .build();

        DetallePedido detallePedido2 = DetallePedido.builder()
                .cantidad(2)
                .subTotal(0.0)
                .articulo(articuloInsumo2)
                .build();



        ArticuloManufacturadoDetalle articuloManufacturadoDetalle1 = ArticuloManufacturadoDetalle.builder()
                .cantidad(8)
                .articuloInsumo(articuloInsumo1)
                .build();


        articuloManufacturadoDetalle1.setArticuloInsumo(articuloInsumo1);

        ArticuloManufacturadoDetalle articuloManufacturadoDetalle2 = ArticuloManufacturadoDetalle.builder()
                .cantidad(15)
                .articuloInsumo(articuloInsumo2)
                .build();
        articuloManufacturadoDetalle2.setArticuloInsumo(articuloInsumo2);

// Articulo Manufacturado

        ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
                .descripcion("Esto es un art manufacturado")
                .tiempoEstimadoMinutos(50)
                .preparacion("Se hace de esta forma")
                .denominacion("esta es una denominacio")
                .precioVenta(50.5)
                .unidadMedida(unidadMedida)
                .build();


        articuloManufacturado1.addDetalle(articuloManufacturadoDetalle1);
        articuloManufacturado1.addImagen(imagen1);
        articuloManufacturado1.setUnidadMedida(unidadMedida);


        ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
                .descripcion("Esto es un art manufacturado")
                .tiempoEstimadoMinutos(50)
                .preparacion("Se hace de esta forma")
                .denominacion("esta es una denominacio")
                .precioVenta(50.5)
                .unidadMedida(unidadMedida)
                .build();
        articuloManufacturado2.addImagen(imagen2);
        articuloManufacturado2.setUnidadMedida(unidadMedida);

        // Categorias



        Categoria categoria1 = Categoria.builder()
                .denominacion("Galletas")
                .build();
        Categoria subCategoria1 = Categoria.builder()
                .denominacion("Galletas Dulces")
                .build();
        categoria1.agregarSubcategoria(subCategoria1);
        categoria1.agregarArticulo(articuloManufacturado1);
        categoria1.agregarArticulo(articuloManufacturado2);




        Categoria categoria2 = Categoria.builder()
                .denominacion("Congelados")
                .build();
        Categoria subCategoria2 = Categoria.builder()
                .denominacion("Congelados")
                .build();
        categoria2.agregarSubcategoria(subCategoria2);
        categoria2.agregarArticulo(articuloManufacturado1);
        categoria2.agregarArticulo(articuloManufacturado2);


        //Promociones



        Promocion promocion1 = Promocion.builder()
                .denominacion("Promo otoño")
                .fechaDesde(LocalDate.now())
                .fechaHasta(LocalDate.now())
                .horaDesde(LocalTime.now())
                .horaHasta(LocalTime.now())
                .precioDescuento(5.50)
                .precioPromocional(5.50)
                .tipoPromocion(TipoPromocion.PROMOCION1)
                .build();
        promocion1.addImagenes(imagen1);
        promocion1.addArticulos(articuloManufacturado1);

//        Promocion promocion2 = new Promocion("Promo cena", LocalDate.now(), LocalDate.now(), LocalTime.now(), LocalTime.now(), 51.50, 2.2, TipoPromocion.HAPPYHOUR);
        Promocion promocion2 = Promocion.builder()
                .denominacion("Promo cena")
                .fechaDesde(LocalDate.now())
                .fechaHasta(LocalDate.now())
                .horaDesde(LocalTime.now())
                .horaHasta(LocalTime.now())
                .precioDescuento(51.50)
                .precioPromocional(55.50)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();

        promocion2.addImagenes(imagen2);
        promocion2.addArticulos(articuloManufacturado2);


        // Sucursales


        Sucursal sucursal1 = Sucursal.builder()
                .nombre("Casa Matriz")
                .horarioApertura(LocalTime.now())
                .horarioCierre(LocalTime.now().plus(Duration.ofHours(8)))
                .build();
        sucursal1.setDomicilio(d1);
        sucursal1.addCategoria(categoria1);

        sucursal1.addPromocion(promocion1);
        sucursal1.addPromocion(promocion2);



        Sucursal sucursal2 = Sucursal.builder()
                .nombre("Sucursal 2")
                .horarioApertura(LocalTime.now())
                .horarioCierre(LocalTime.now().plus(Duration.ofHours(8)))
                .build();

        sucursal2.setDomicilio(d2);
        sucursal2.addCategoria(categoria2);
        sucursal2.addPromocion(promocion1);
        sucursal2.addPromocion(promocion2);


        //Empresa


            Empresa empresa = Empresa.builder()
                    .nombre("Superempresa")
                    .razonSocial("Los Facultamigos S.A.")
                    .cuil(2035620636)
                    .build();
        empresa.addSucursal(sucursal1);
        empresa.addSucursal(sucursal2);






        //Facturas


        Factura factura1 = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .mpPaymentId(80)
                .mpMerchantOrderId("akeu")
                .mpPreferenceId("afafasrae")
                .mpPaymentType("fradrarar")
                .formaPago(FormaPago.MERCADOPAGO)
                .totalVenta(5.5)
                .build();

        Factura factura2 = Factura.builder()
                .fechaFacturacion(LocalDate.now())
                .mpPaymentId(81)
                .mpMerchantOrderId("gsvascva")
                .mpPreferenceId("vcxzvi")
                .mpPaymentType("yuhrsfsf")
                .formaPago(FormaPago.EFECTIVO)
                .totalVenta(5.5)
                .build();

        // Pedidos

        Pedido pedido1 = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.now())
                .total(5.5)
                .totalCosto(9.8)
                .estado(Estado.PREPARACION)
                .tipoDeEnvio(TipoDeEnvio.TAKEAWAY)
                .formaPago(FormaPago.EFECTIVO)
                .fechaPedido(LocalDate.now())
                .build();

        pedido1.setFactura(factura1);
        pedido1.setDomicilio(d1);
        pedido1.setSucursal(sucursal1);
        pedido1.addDetallesPedido(detallePedido1);

        Pedido pedido2 = Pedido.builder()
                .horaEstimadaFinalizacion(LocalTime.now())
                .total(5.5)
                .totalCosto(9.8)
                .estado(Estado.PENDIENTE)
                .tipoDeEnvio(TipoDeEnvio.DELIVERY)
                .formaPago(FormaPago.MERCADOPAGO)
                .fechaPedido(LocalDate.now())
                .build();

        pedido2.setFactura(factura2);
        pedido2.setDomicilio(d2);
        pedido2.setSucursal(sucursal2);
        pedido2.addDetallesPedido(detallePedido2);


        //Clientes
//        Cliente cliente1 = new Cliente("David","Lopez","2615848235","locolope@gmail.com",LocalDate.now(), imagen, usuario1);

        Cliente cliente1 = Cliente.builder()
                .nombre("David")
                .apellido("Lopez")
                .telefono("2616649039")
                .email("locolope@gmail.com")
                .fechaNacimiento(LocalDate.now())
                .imagen(imagen1)
                .usuario(usuario1)
                .build();

        cliente1.addDomicilios(d1);
        cliente1.setImagen(imagen1);
        cliente1.setUsuario(usuario1);
        cliente1.addPedidos(pedido1);
        cliente1.addPedidos(pedido2);




        Cliente cliente2 = Cliente.builder()
                .nombre("Fomas")
                .apellido("Terro")
                .telefono("2616849039")
                .email("elFomi_capo_de_mza_666@gmail.com")
                .fechaNacimiento(LocalDate.now())
                .imagen(imagen2)
                .usuario(usuario2)
                .build();
        cliente2.addDomicilios(d2);
        cliente2.setImagen(imagen2);
        cliente2.setUsuario(usuario2);
        cliente2.addPedidos(pedido1);
        cliente2.addPedidos(pedido2);


        System.out.println(empresa);



    }
}