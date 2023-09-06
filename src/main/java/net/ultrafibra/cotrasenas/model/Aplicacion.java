package net.ultrafibra.cotrasenas.model;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name = "aplicaciones")
public class Aplicacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aplicacion")
    private Long idAplicacion;

    @Column(name = "nombre_aplicacion")
    private String nombreAplicacion;
    
    private String url;   

    public Aplicacion() {
    }

    public Aplicacion(Long idAplicacion, String nombreAplicacion, String url) {
        this.idAplicacion = idAplicacion;
        this.nombreAplicacion = nombreAplicacion;
        this.url = url;
    }
    
}
