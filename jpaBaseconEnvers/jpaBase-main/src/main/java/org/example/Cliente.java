package org.example;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
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
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String apellido;
    private int dni;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_domicilio")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "cliente")
    private Set<Factura> facturas = new HashSet<>();




}
