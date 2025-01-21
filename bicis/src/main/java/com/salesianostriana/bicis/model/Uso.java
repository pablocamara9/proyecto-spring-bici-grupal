package com.salesianostriana.bicis.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Uso {

    //Atributos de la clase (Uso)
    @Id  @GeneratedValue
    private Long id;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private double coste;

    //Asociación USUARIO_BICILETA
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Asociación USO-BICICLETA
    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;


    //Equals & Code
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Uso uso = (Uso) o;
        return getId() != null && Objects.equals(getId(), uso.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
