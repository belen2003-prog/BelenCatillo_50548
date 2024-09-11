package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try{
            entityManager.getTransaction().begin();
            /* aca creo las tablas con las relaciones

                Factura f1= Factura.builder()
                        .numero(2)
                        .fecha("10/05/2025")
                        .build();
                Domicilio domicilio = Domicilio.builder()
                    .nombreCalle("av san martin")
                    .numero(4)
                    .build();
                Cliente cliente = Cliente.builder()
                    .nombre("belen")
                    .apellido("castillo")
                    .dni(665748)
                    .build();
                cliente.setDomicilio(domicilio);
                f1.setCliente(cliente);
                Categoria perecederos = Categoria.builder()
                                .denominacion("perecederos")
                                .build();

                Categoria lacteos = Categoria.builder()
                    .denominacion("lacteos")
                    .build();

            Categoria limpieza = Categoria.builder()
                    .denominacion("limpieza")
                    .build();

            Articulo a1 = Articulo.builder()
                            .cantidad(5)
                            .denominacion("crema de leche")
                            .precio(2000)
                            .build();
            Articulo a2 = Articulo.builder()
                    .cantidad(80)
                    .denominacion("lavandina")
                    .precio(4000)
                    .build();

            a1.getCategorias().add(perecederos);
            a1.getCategorias().add(lacteos);
            lacteos.getArticulos().add(a1);
            perecederos.getArticulos().add(a1);


            a2.getCategorias().add(limpieza);
            limpieza.getArticulos().add(a2);

            DetalleFactura df1 = DetalleFactura.builder()
                    .cantidad(3)
                    .subtotal(6000)
                    .build();

            df1.setArticulo(a1);

            a1.getDetalle().add(df1);
            f1.getDetalles().add(df1);

            df1.setFactura(f1);

            DetalleFactura df2 =DetalleFactura.builder()
                    .cantidad(2)
                    .subtotal(12000)
                    .build();

            df2.setArticulo(a2);

            a2.getDetalle().add(df2);
            f1.getDetalles().add(df2);
            df2.setFactura(f1);


            f1.setTotal(18000);
            entityManager.persist(f1);
            aca persisito los articulos?

             */

          /* esto hace una actualizacion
            Factura f1 =entityManager.find(Factura.class,1L);
            f1.setNumero(77);
            entityManager.merge(f1);
           */
            /*aca elimino una factura , en factura_audme van a aparecer null porq la borre
            Factura f1 =entityManager.find(Factura.class,1L);
            entityManager.remove(f1);

             */





            entityManager.flush();

            entityManager.getTransaction().commit();
            System.out.println("ddd");
        }catch(Exception e){
        entityManager.getTransaction().rollback();
            System.out.println("no se pudo gravar");

        }








        // Cerrar el EntityManager y el EntityManagerFactory
        entityManager.close();
        entityManagerFactory.close();


    }
}
