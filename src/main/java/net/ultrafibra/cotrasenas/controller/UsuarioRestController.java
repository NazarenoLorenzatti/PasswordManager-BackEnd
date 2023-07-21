package net.ultrafibra.cotrasenas.controller;

import net.ultrafibra.cotrasenas.model.Usuario;
import net.ultrafibra.cotrasenas.response.UsuarioResponseRest;
import net.ultrafibra.cotrasenas.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/api/v1")
public class UsuarioRestController {

    @Autowired
    private UsuarioServiceImpl usuarioService;
    
    /**
     * Guardar Usuario
     * @param usuario
     * @return
     * @throws Exception 
     */
    @PostMapping("/crear-usuario")
    public ResponseEntity<UsuarioResponseRest> crearUsuario(@RequestBody Usuario usuario) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.guardarUsuario(usuario);
        return respuesta;
    }
    
    
}
