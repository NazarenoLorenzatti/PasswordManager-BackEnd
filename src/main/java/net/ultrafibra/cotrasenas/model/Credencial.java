package net.ultrafibra.cotrasenas.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Entity
@Data
@Table(name = "credenciales")
public class Credencial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Long idCredencial;

    private String usuario;

    private String contraseña;

    @Column(name = "ultima_actualizacion")
    private Date ultimaActualizacion;

    @Column(name = "proxima_actualizacion")
    private Date proximaActualizacion;

    @OneToOne
    @JoinColumn(name = "aplicaciones_id_aplicacion")
    private Aplicacion aplicacion;

    @OneToOne
    @JoinColumn(name = "estado_id_estado")
    private EstadoCredencial estadoCredencial;

    @OneToOne
    @JoinColumn(name = "administrativos_id_administrativo")
    private Administrativo administrativo;

    public Credencial() {
    }

    public Credencial(String usuario, String contraseña, Date ultimaActualizacion, Date proximaActualizacion, Aplicacion aplicacion, EstadoCredencial estadoCredencial) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.ultimaActualizacion = ultimaActualizacion;
        this.proximaActualizacion = proximaActualizacion;
        this.aplicacion = aplicacion;
        this.estadoCredencial = estadoCredencial;
    }

}
