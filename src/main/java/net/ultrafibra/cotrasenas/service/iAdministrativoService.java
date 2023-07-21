package net.ultrafibra.cotrasenas.service;

import net.ultrafibra.cotrasenas.model.Administrativo;
import net.ultrafibra.cotrasenas.response.AdministrativoResponseRest;
import org.springframework.http.ResponseEntity;

public interface iAdministrativoService {
    
    public ResponseEntity<AdministrativoResponseRest> listarAdministrativos();
    public ResponseEntity<AdministrativoResponseRest> buscarAdministrativoPorId(Administrativo administrativo);
    public ResponseEntity<AdministrativoResponseRest> guardarAdministrativo(Administrativo administrativo);
    public ResponseEntity<AdministrativoResponseRest> editarAdministrativo(Administrativo administrativo);
    public ResponseEntity<AdministrativoResponseRest> eliminarAdministrativo(Long idAdministrativo);
}
