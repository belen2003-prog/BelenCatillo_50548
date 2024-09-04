package org.example;

import javax.persistence.*;
import lombok.*;

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
public class Articulo implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private int cantidad;
        private String denominacion;
        private int precio;
        @OneToMany(mappedBy = "Articulo" , cascade = CascadeType.PERSIST)
        @Builder.Default
        private Set<DetalleFactura> detalle =new HashSet<>();

        @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
        @JoinTable(name = "aticulo_categoria",
                joinColumns = @JoinColumn(name ="articulo_id"),
                inverseJoinColumns = @JoinColumn(name = "categoria_id")
        )
        @Builder.Default
                private Set<Categoria> categorias = new HashSet<>();

}
