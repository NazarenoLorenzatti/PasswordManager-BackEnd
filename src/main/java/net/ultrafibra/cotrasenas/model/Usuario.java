package net.ultrafibra.cotrasenas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private Integer pin;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_has_rol",
            joinColumns = @JoinColumn(name = "usuario_id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "rol_id_rol")
    )
    private List<Rol> roles;

    @OneToOne(mappedBy = "usuario")
    @JsonIgnore
    private Administrativo administrativo;

    public Usuario(String username, String password, List<Rol> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Usuario() {
    }

}
