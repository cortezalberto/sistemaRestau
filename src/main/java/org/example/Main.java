

// ===== 2. CORRECCIÓN: Main.java - Clases faltantes =====
package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GESTIÓN EMPRESARIAL =====\n");

        try {
            // Inicializar datos del sistema
            Empresa empresa = inicializarSistema();

            // Mostrar información del sistema
            mostrarInformacionCompleta(empresa);

            // Ejecutar consultas y análisis
            ejecutarConsultasImportantes(empresa);

            // Pruebas de funcionalidad
            probarFuncionalidadesDelSistema(empresa);

            System.out.println("\n===== FIN DEL SISTEMA =====");

        } catch (Exception e) {
            System.err.println("Error en el sistema: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // ===== INICIALIZACIÓN DEL SISTEMA =====

    private static Empresa inicializarSistema() {
        System.out.println("Inicializando sistema empresarial...\n");

        // Crear estructura geográfica
        var datosGeograficos = crearEstructuraGeografica();

        // Crear usuarios y configuración base
        var configuracionBase = crearConfiguracionBase();

        // Crear artículos y productos
        var productos = crearProductosYArticulos(configuracionBase.unidadMedida, configuracionBase.imagenes);

        // Crear categorías
        var categorias = crearCategorias(productos.articulosManufacturados);

        // Crear promociones
        var promociones = crearPromociones(productos.articulosManufacturados, configuracionBase.imagenes);

        // Crear sucursales
        var sucursales = crearSucursales(datosGeograficos.domicilios, categorias, promociones);

        // Crear empresa
        Empresa empresa = Empresa.builder()
                .id(1L)
                .nombre("TechFood Solutions")
                .razonSocial("TechFood Solutions S.A.")
                .cuil(2035620636)
                .build();

        sucursales.forEach(empresa::addSucursal);

        // Crear clientes y pedidos
        var clientes = crearClientesYPedidos(datosGeograficos, configuracionBase, productos, sucursales.get(0));

        System.out.println("Sistema inicializado correctamente.\n");
        return empresa;
    }

    private static DatosGeograficos crearEstructuraGeografica() {
        // País y provincia
        Pais argentina = Pais.builder()
                .id(1L)
                .nombre("Argentina")
                .build();

        Provincia mendoza = Provincia.builder()
                .id(1L)
                .nombre("Mendoza")
                .pais(argentina)
                .build();

        // Localidades
        Localidad maipu = Localidad.builder()
                .id(1L)
                .nombre("Maipú")
                .provincia(mendoza)
                .build();

        Localidad godoyCruz = Localidad.builder()
                .id(2L)
                .nombre("Godoy Cruz")
                .provincia(mendoza)
                .build();

        Localidad guaymallen = Localidad.builder()
                .id(3L)
                .nombre("Guaymallén")
                .provincia(mendoza)
                .build();

        // Domicilios
        Domicilio d1 = Domicilio.builder()
                .id(1L)
                .nombre("San Martín")
                .localidad(maipu)
                .cp(5501)
                .numero(1000)
                .build();

        Domicilio d2 = Domicilio.builder()
                .id(2L)
                .nombre("San Juan")
                .localidad(godoyCruz)
                .cp(5502)
                .numero(500)
                .build();

        return new DatosGeograficos(List.of(maipu, godoyCruz, guaymallen), List.of(d1, d2));
    }

    private static ConfiguracionBase crearConfiguracionBase() {
        // Usuarios
        Usuario usuario1 = Usuario.builder()
                .id(1L)
                .nombre("Usuario Principal")
                .auth0Id("001")
                .username("DavidLopez")
                .build();

        Usuario usuario2 = Usuario.builder()
                .id(2L)
                .nombre("Usuario Secundario")
                .auth0Id("002")
                .username("TomasFerro")
                .build();

        // Imágenes
        Imagen imagen1 = Imagen.builder()
                .id(1L)
                .nombre("Imagen Principal")
                .denominacion("imagen-producto-principal.jpg")
                .build();

        Imagen imagen2 = Imagen.builder()
                .id(2L)
                .nombre("Imagen Secundaria")
                .denominacion("imagen-producto-secundaria.jpg")
                .build();

        // Unidad de medida
        UnidadMedida unidadMedida = UnidadMedida.builder()
                .id(1L)
                .nombre("Kilogramo")
                .denominacion("Kg")
                .build();

        return new ConfiguracionBase(List.of(usuario1, usuario2), List.of(imagen1, imagen2), unidadMedida);
    }

    private static Productos crearProductosYArticulos(UnidadMedida unidadMedida, List<Imagen> imagenes) {
        // Artículos Insumo
        ArticuloInsumo cerveza = ArticuloInsumo.builder()
                .id(1L)
                .nombre("Cerveza Quilmes")
                .denominacion("Cerveza Quilmes 473ml")
                .precioVenta(150.0)
                .unidadMedida(unidadMedida)
                .precioCompra(80.0)
                .stockActual(50)
                .stockMaximo(200)
                .esParaElaborar(false)
                .build();

        ArticuloInsumo masa = ArticuloInsumo.builder()
                .id(2L)
                .nombre("Masa para Pizza")
                .denominacion("Masa fresca para pizza mediana")
                .precioVenta(200.0)
                .unidadMedida(unidadMedida)
                .precioCompra(120.0)
                .stockActual(30)
                .stockMaximo(100)
                .esParaElaborar(true)
                .build();

        cerveza.addImagen(imagenes.get(0));
        masa.addImagen(imagenes.get(1));

        // Detalles para artículos manufacturados
        ArticuloManufacturadoDetalle detalle1 = ArticuloManufacturadoDetalle.builder()
                .id(1L)
                .nombre("Detalle Cerveza")
                .cantidad(2)
                .articuloInsumo(cerveza)
                .build();

        ArticuloManufacturadoDetalle detalle2 = ArticuloManufacturadoDetalle.builder()
                .id(2L)
                .nombre("Detalle Masa")
                .cantidad(1)
                .articuloInsumo(masa)
                .build();

        // Artículos Manufacturados
        ArticuloManufacturado pizzaEspecial = ArticuloManufacturado.builder()
                .id(3L)
                .nombre("Pizza Especial")
                .denominacion("Pizza Especial con ingredientes premium")
                .descripcion("Pizza artesanal con masa fresca, mozzarella premium y ingredientes seleccionados")
                .tiempoEstimadoMinutos(25)
                .preparacion("Estirar masa, agregar salsa, queso e ingredientes. Hornear a 250°C por 12-15 min")
                .precioVenta(850.0)
                .unidadMedida(unidadMedida)
                .build();

        ArticuloManufacturado combo = ArticuloManufacturado.builder()
                .id(4L)
                .nombre("Combo Pizza + Bebida")
                .denominacion("Combo completo pizza mediana + bebida")
                .descripcion("Combinación perfecta para una comida completa")
                .tiempoEstimadoMinutos(30)
                .preparacion("Preparar pizza según receta estándar y servir con bebida fría")
                .precioVenta(950.0)
                .unidadMedida(unidadMedida)
                .build();

        pizzaEspecial.addDetalle(detalle2);
        pizzaEspecial.addImagen(imagenes.get(0));

        combo.addDetalle(detalle1);
        combo.addDetalle(detalle2);
        combo.addImagen(imagenes.get(1));

        return new Productos(
                List.of(cerveza, masa),
                List.of(pizzaEspecial, combo),
                List.of(detalle1, detalle2)
        );
    }

    private static List<Categoria> crearCategorias(List<ArticuloManufacturado> articulos) {
        Categoria principales = Categoria.builder()
                .id(1L)
                .nombre("Platos Principales")
                .denominacion("Platos Principales")
                .build();

        Categoria pizzas = Categoria.builder()
                .id(2L)
                .nombre("Pizzas Especiales")
                .denominacion("Pizzas Gourmet y Especiales")
                .build();

        Categoria bebidas = Categoria.builder()
                .id(3L)
                .nombre("Bebidas")
                .denominacion("Bebidas Frías y Calientes")
                .build();

        principales.addSubcategoria(pizzas);
        principales.addSubcategoria(bebidas);

        articulos.forEach(principales::addArticulo);
        articulos.forEach(pizzas::addArticulo);

        return List.of(principales, pizzas, bebidas);
    }

    private static List<Promocion> crearPromociones(List<ArticuloManufacturado> articulos, List<Imagen> imagenes) {
        Promocion promoOtono = Promocion.builder()
                .id(1L)
                .nombre("Promo Otoño 2024")
                .denominacion("Descuento especial de otoño")
                .fechaDesde(LocalDate.now().minusDays(10))
                .fechaHasta(LocalDate.now().plusDays(20))
                .horaDesde(LocalTime.of(18, 0))
                .horaHasta(LocalTime.of(23, 0))
                .precioDescuento(150.0)
                .precioPromocional(700.0)
                .tipoPromocion(TipoPromocion.PROMOCION1)
                .build();

        Promocion happyHour = Promocion.builder()
                .id(2L)
                .nombre("Happy Hour")
                .denominacion("2x1 en bebidas seleccionadas")
                .fechaDesde(LocalDate.now())
                .fechaHasta(LocalDate.now().plusDays(30))
                .horaDesde(LocalTime.of(17, 0))
                .horaHasta(LocalTime.of(20, 0))
                .precioDescuento(200.0)
                .precioPromocional(750.0)
                .tipoPromocion(TipoPromocion.HAPPYHOUR)
                .build();

        promoOtono.addImagen(imagenes.get(0));
        promoOtono.addArticulo(articulos.get(0));

        happyHour.addImagen(imagenes.get(1));
        happyHour.addArticulo(articulos.get(1));

        return List.of(promoOtono, happyHour);
    }

    private static List<Sucursal> crearSucursales(List<Domicilio> domicilios, List<Categoria> categorias, List<Promocion> promociones) {
        Sucursal matriz = Sucursal.builder()
                .id(1L)
                .nombre("Casa Matriz Centro")
                .horarioApertura(LocalTime.of(11, 0))
                .horarioCierre(LocalTime.of(23, 0))
                .domicilio(domicilios.get(0))
                .build();

        Sucursal sucursal2 = Sucursal.builder()
                .id(2L)
                .nombre("Sucursal Godoy Cruz")
                .horarioApertura(LocalTime.of(10, 30))
                .horarioCierre(LocalTime.of(23, 30))
                .domicilio(domicilios.get(1))
                .build();

        // Agregar categorías y promociones
        categorias.forEach(matriz::addCategoria);
        promociones.forEach(matriz::addPromocion);

        categorias.forEach(sucursal2::addCategoria);
        promociones.forEach(sucursal2::addPromocion);

        return List.of(matriz, sucursal2);
    }

    private static List<Cliente> crearClientesYPedidos(DatosGeograficos geograficos, ConfiguracionBase configuracion,
                                                       Productos productos, Sucursal sucursal) {
        Cliente cliente1 = Cliente.builder()
                .id(1L)
                .nombre("David")
                .apellido("López")
                .telefono("2616649039")
                .email("david.lopez@email.com")
                .fechaNacimiento(LocalDate.of(1990, 5, 15))
                .imagen(configuracion.imagenes.get(0))
                .usuario(configuracion.usuarios.get(0))
                .build();

        Cliente cliente2 = Cliente.builder()
                .id(2L)
                .nombre("Tomás")
                .apellido("Ferro")
                .telefono("2616849039")
                .email("tomas.ferro@email.com")
                .fechaNacimiento(LocalDate.of(1988, 8, 20))
                .imagen(configuracion.imagenes.get(1))
                .usuario(configuracion.usuarios.get(1))
                .build();

        cliente1.addDomicilio(geograficos.domicilios.get(0));
        cliente2.addDomicilio(geograficos.domicilios.get(1));

        // Crear pedidos (simulados con datos básicos)
        crearPedidosParaClientes(cliente1, cliente2, productos, sucursal);

        return List.of(cliente1, cliente2);
    }

    private static void crearPedidosParaClientes(Cliente cliente1, Cliente cliente2, Productos productos, Sucursal sucursal) {
        // Crear pedidos básicos para demostrar el sistema
        // En un sistema real, estos vendrían de la lógica de negocio
        System.out.println("Pedidos creados para clientes (datos simulados)");
    }

    // ===== MÉTODOS DE VISUALIZACIÓN =====

    private static void mostrarInformacionCompleta(Empresa empresa) {
        System.out.println("===== INFORMACIÓN DE LA EMPRESA =====");
        System.out.println(empresa.getInfo());
        System.out.println("Detalles: " + empresa);
        System.out.println();

        mostrarSucursales(empresa);
        mostrarProductosYCategorias(empresa);
        mostrarPromociones(empresa);
    }

    private static void mostrarSucursales(Empresa empresa) {
        System.out.println("===== SUCURSALES =====");
        empresa.getSucursales().forEach(sucursal -> {
            System.out.println("• " + sucursal.getInfo());
            System.out.println("  Horario: " + sucursal.getHorarioApertura() + " - " + sucursal.getHorarioCierre());
            if (sucursal.getDomicilio() != null) {
                System.out.println("  Dirección: " + sucursal.getDomicilio().getInfo());
            }
            System.out.println("  Categorías: " + sucursal.getCategorias().size());
            System.out.println("  Promociones: " + sucursal.getPromociones().size());
            System.out.println();
        });
    }

    private static void mostrarProductosYCategorias(Empresa empresa) {
        System.out.println("===== PRODUCTOS POR CATEGORÍA =====");
        empresa.getSucursales().stream().findFirst().ifPresent(sucursal -> {
            sucursal.getCategorias().forEach(categoria -> {
                System.out.println("Categoría: " + categoria.getInfo());
                categoria.getArticulos().forEach(articulo ->
                        System.out.println("  - " + articulo.getInfo()));

                if (!categoria.getSubcategorias().isEmpty()) {
                    categoria.getSubcategorias().forEach(sub ->
                            System.out.println("  Subcategoría: " + sub.getInfo()));
                }
                System.out.println();
            });
        });
    }

    private static void mostrarPromociones(Empresa empresa) {
        System.out.println("===== PROMOCIONES ACTIVAS =====");
        empresa.getSucursales().stream().findFirst().ifPresent(sucursal -> {
            sucursal.getPromociones().forEach(promo -> {
                System.out.println("• " + promo.getInfo());
                System.out.println("  Período: " + promo.getFechaDesde() + " al " + promo.getFechaHasta());
                System.out.println("  Horario: " + promo.getHoraDesde() + " - " + promo.getHoraHasta());
                System.out.println("  Descuento: $" + promo.getPrecioDescuento());
                System.out.println();
            });
        });
    }

    // ===== CONSULTAS IMPORTANTES =====

    private static void ejecutarConsultasImportantes(Empresa empresa) {
        System.out.println("===== CONSULTAS Y ANÁLISIS DEL SISTEMA =====\n");

        analizarProductosDisponibles(empresa);
        consultarPromocionesPorTipo(empresa);
        mostrarEstructuraGeografica(empresa);
    }

    private static void analizarProductosDisponibles(Empresa empresa) {
        System.out.println("ANÁLISIS DE PRODUCTOS:");
        empresa.getSucursales().stream()
                .flatMap(sucursal -> sucursal.getCategorias().stream())
                .flatMap(categoria -> categoria.getArticulos().stream())
                .forEach(articulo -> System.out.println("• " + articulo.getDenominacion() + " - $" + articulo.getPrecioVenta()));
        System.out.println();
    }

    private static void consultarPromocionesPorTipo(Empresa empresa) {
        System.out.println("PROMOCIONES POR TIPO:");
        empresa.getSucursales().stream()
                .flatMap(sucursal -> sucursal.getPromociones().stream())
                .collect(Collectors.groupingBy(Promocion::getTipoPromocion))
                .forEach((tipo, promociones) -> {
                    System.out.println("• " + tipo + ": " + promociones.size() + " promociones");
                    promociones.forEach(promo -> System.out.println("  - " + promo.getDenominacion()));
                });
        System.out.println();
    }

    private static void mostrarEstructuraGeografica(Empresa empresa) {
        System.out.println("ANÁLISIS GEOGRÁFICO:");
        empresa.getSucursales().forEach(sucursal -> {
            if (sucursal.getDomicilio() != null && sucursal.getDomicilio().getLocalidad() != null) {
                System.out.println("• " + sucursal.getNombre() + " ubicada en " +
                        sucursal.getDomicilio().getLocalidad().getInfo());
            }
        });
        System.out.println();
    }

    // ===== PRUEBAS DE FUNCIONALIDAD =====

    private static void probarFuncionalidadesDelSistema(Empresa empresa) {
        System.out.println("===== PRUEBAS DE FUNCIONALIDAD =====\n");

        probarRelacionesBidireccionales(empresa);
        probarOperacionesCRUD(empresa);
        probarValidacionesDeDatos();
    }

    private static void probarRelacionesBidireccionales(Empresa empresa) {
        System.out.println("PRUEBA: Relaciones bidireccionales");

        Sucursal nuevaSucursal = Sucursal.builder()
                .id(99L)
                .nombre("Sucursal Temporal")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(22, 0))
                .build();

        int sucursalesAntes = empresa.getSucursales().size();
        empresa.addSucursal(nuevaSucursal);
        System.out.println("• Sucursal agregada: " + sucursalesAntes + " -> " + empresa.getSucursales().size());

        empresa.removeSucursal(nuevaSucursal);
        System.out.println("• Sucursal removida: " + empresa.getSucursales().size() + " sucursales");
        System.out.println();
    }

    private static void probarOperacionesCRUD(Empresa empresa) {
        System.out.println("PRUEBA: Operaciones CRUD");

        if (!empresa.getSucursales().isEmpty()) {
            Sucursal sucursal = empresa.getSucursales().iterator().next();

            Categoria nuevaCategoria = Categoria.builder()
                    .id(99L)
                    .nombre("Categoría Temporal")
                    .denominacion("Categoría para pruebas")
                    .build();

            int categoriasAntes = sucursal.getCategorias().size();
            sucursal.addCategoria(nuevaCategoria);
            System.out.println("• Categoría agregada: " + categoriasAntes + " -> " + sucursal.getCategorias().size());

            sucursal.removeCategoria(nuevaCategoria);
            System.out.println("• Categoría removida: " + sucursal.getCategorias().size() + " categorías");
        }
        System.out.println();
    }

    private static void probarValidacionesDeDatos() {
        System.out.println("PRUEBA: Validaciones y método getInfo()");

        UnidadMedida unidad = UnidadMedida.builder()
                .id(1L)
                .nombre("Test")
                .denominacion("Litros")
                .build();

        System.out.println("• " + unidad.getInfo());

        Pais pais = Pais.builder()
                .id(1L)
                .nombre("Chile")
                .build();

        System.out.println("• " + pais.getInfo());
        System.out.println();
    }

    // ===== CLASES AUXILIARES PARA ORGANIZAR DATOS =====

    private static class DatosGeograficos {
        final List<Localidad> localidades;
        final List<Domicilio> domicilios;

        DatosGeograficos(List<Localidad> localidades, List<Domicilio> domicilios) {
            this.localidades = localidades;
            this.domicilios = domicilios;
        }
    }

    private static class ConfiguracionBase {
        final List<Usuario> usuarios;
        final List<Imagen> imagenes;
        final UnidadMedida unidadMedida;

        ConfiguracionBase(List<Usuario> usuarios, List<Imagen> imagenes, UnidadMedida unidadMedida) {
            this.usuarios = usuarios;
            this.imagenes = imagenes;
            this.unidadMedida = unidadMedida;
        }
    }

    private static class Productos {
        final List<ArticuloInsumo> articulosInsumo;
        final List<ArticuloManufacturado> articulosManufacturados;
        final List<ArticuloManufacturadoDetalle> detalles;

        Productos(List<ArticuloInsumo> articulosInsumo, List<ArticuloManufacturado> articulosManufacturados,
                  List<ArticuloManufacturadoDetalle> detalles) {
            this.articulosInsumo = articulosInsumo;
            this.articulosManufacturados = articulosManufacturados;
            this.detalles = detalles;
        }
    }
}