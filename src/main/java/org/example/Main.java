package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = emf.createEntityManager();
        System.out.println("en marcha Alberto");

        try {
            entityManager.getTransaction().begin(); // Persistir una nueva entidad Cliente

         /* Factura factura1 = Factura.builder()
                    .nro(15)
                    .fecha("05/09/2024")
                    .build();

            Domicilio dom1 = Domicilio.builder()
                    .nombreCalle("Concordia")
                    .numero(590)
                    .build();

            Cliente cliente1 = Cliente.builder()
                    .nombre("Martina")
                    .apellido("Nuñez")
                    .dni(45602188)
                    .build();

            cliente1.setDomicilio(dom1);
            dom1.setCliente(cliente1);

            factura1.setCliente(cliente1);

            //creacion de las categorias
            Categoria perecederos = Categoria.builder()
                    .denominacionC("perecederos")
                    .build();

            Categoria lacteos = Categoria.builder()
                    .denominacionC("lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacionC("limpieza")
                    .build();

            //creacion de los articulos
            Articulo art1 = Articulo.builder()
                    .cantidad(200)
                    .denominacion("Yogurt Frutilla")
                    .precio(1500)
                    .build();

            Articulo art2 = Articulo.builder()
                    .cantidad(300)
                    .denominacion("Detergente Magistral")
                    .precio(2500)
                    .build();

            //asigno categorias a los articulos y los articulos a la categoria
            art1.getCategorias().add(perecederos);
            art1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(art1);
            perecederos.getArticulos().add(art1);

            art2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(art2);

            //creo detalles de facturas
            DetalleFactura det1 = DetalleFactura.builder()
                    .build();

            det1.setArticulo(art1);
            det1.setCantidad(2);
            det1.setSubtotal(40);

            //bidireccionales
            art1.getDetalle().add(det1);
            factura1.getDetalleFacturas().add(det1);
            det1.setFactura(factura1);

            //creo otro detalle
            DetalleFactura det2 = DetalleFactura.builder()
                    .build();

            det2.setArticulo(art2);
            det2.setCantidad(1);
            det2.setSubtotal(80);

            art2.getDetalle().add(det2);
            factura1.getDetalleFacturas().add(det2);
            det2.setFactura(factura1);

            //seteo el total de la factura
            factura1.setTotal(120);*/

            Factura factura1 = entityManager.find(Factura.class, 1L);
            //factura1.setNro(85); Para actualizar uso merge
            entityManager.remove(factura1);
            entityManager.flush(); //para limpiar la conexion
            entityManager.getTransaction().commit();


        }catch (Exception e){

            entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
            System.out.println("No se pudo grabar la clase Persona");}

        // Cerrar el EntityManager y el EntityManagerFactory
             entityManager.close();
             emf.close();
    }
}
