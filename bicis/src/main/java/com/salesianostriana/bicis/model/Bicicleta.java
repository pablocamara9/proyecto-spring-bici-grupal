package com.salesianostriana.bicis.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Bicicleta {

    //Atributos de la clase Bicicleta
    @Id
    @GeneratedValue
    private Long id;


    private String marca;
    private String modelo;
    private String estado;

    //Asociación BICICLETA-ESTACIÓN
    @ManyToOne
    @JoinColumn(name = "estacion_id")
    private Estacion estacion;

    //Asociación BICICLETA-USO
    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "bicicleta",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Uso> listaUsos = new ArrayList<>();

    //Métodos helpers para bicicleta - uso
    public void addUso(Uso u) {
        u.setBicicleta(this);
        this.listaUsos.add(u);
    }

    public void deleteUso(Uso u) {
        this.listaUsos.remove(u);
    }
    //Equals & hasCode (Bicileta)
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Bicicleta bicicleta = (Bicicleta) o;
        return getId() != null && Objects.equals(getId(), bicicleta.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
