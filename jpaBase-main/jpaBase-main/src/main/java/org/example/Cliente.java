package org.example;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apellido;
    private int dni;
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_domicilio")
    private Domicilio domicilio;
}
