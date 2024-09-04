package org.example;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.*;
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private int numero;
    private int Total;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

        @OneToMany(mappedBy="factura" ,cascade = CascadeType.ALL,orphanRemoval = true)
        @JoinColumn(name = "factura_id")
    @Builder.Default
    private Set<DetalleFactura> detalles = new HashSet<>();
}
