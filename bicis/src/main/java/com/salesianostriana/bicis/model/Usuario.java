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
public class Usuario {

    @Id @GeneratedValue
    private Long id;

    private String nombre;

    private int numTarjeta;

    private String pin;

    private double saldo;

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "usuario",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                orphanRemoval = true
    )
    private List<Uso> listaUsos = new ArrayList<>();

    public void addUso(Uso u){
        u.setUsuario(this);
        this.getListaUsos().add(u);
    }

    public void deleteUso(Uso u){
        this.getListaUsos().remove(u);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Usuario usuario = (Usuario) o;
        return getId() != null && Objects.equals(getId(), usuario.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
