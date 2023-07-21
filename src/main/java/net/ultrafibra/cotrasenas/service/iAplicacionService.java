package net.ultrafibra.cotrasenas.service;

import net.ultrafibra.cotrasenas.model.Aplicacion;
import net.ultrafibra.cotrasenas.response.AplicacionResponseRest;
import org.springframework.http.ResponseEntity;

public interface iAplicacionService {

    public ResponseEntity<AplicacionResponseRest> listarAplicaciones();

    public ResponseEntity<AplicacionResponseRest> buscarAplicacionPorId(Aplicacion aplicacion);

    public ResponseEntity<AplicacionResponseRest> guardarAplicacion(Aplicacion aplicacion);

    public ResponseEntity<AplicacionResponseRest> editarAplicacion(Aplicacion aplicacion);

    public ResponseEntity<AplicacionResponseRest> eliminarAplicacion(Long idAplicacion);
}
