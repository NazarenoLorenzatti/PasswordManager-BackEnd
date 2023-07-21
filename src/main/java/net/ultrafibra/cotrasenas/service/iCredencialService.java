package net.ultrafibra.cotrasenas.service;

import net.ultrafibra.cotrasenas.model.Credencial;
import net.ultrafibra.cotrasenas.response.CredencialResponseRest;
import org.springframework.http.ResponseEntity;

public interface iCredencialService {

    public ResponseEntity<CredencialResponseRest> listarCredenciales();

    public ResponseEntity<CredencialResponseRest> buscarCredencialPorId(Credencial credencial);

    public ResponseEntity<CredencialResponseRest> nuevaCredencial(Credencial credencial);

    public ResponseEntity<CredencialResponseRest> editarCredencial(Credencial credencial);
    
    public ResponseEntity<CredencialResponseRest> actualizarContraseña(Credencial credencial);

    public ResponseEntity<CredencialResponseRest> eliminarCredencial(Long idCredencial);
}
