package org.example;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.*;
@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString

@Audited
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fecha;
    private int numero;
    private int Total;

  @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;

        @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
        @JoinColumn(name = "factura_id")
    @Builder.Default
    private Set<DetalleFactura> detalles = new HashSet<>();




}
