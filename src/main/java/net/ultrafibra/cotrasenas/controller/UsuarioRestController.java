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
     *
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("/crear-usuario")
    public ResponseEntity<UsuarioResponseRest> crearUsuario(@RequestBody Usuario usuario) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.guardarUsuario(usuario);
        return respuesta;
    }

    /**
     * Actualizar Usuario
     *
     * @param usuario
     * @return
     * @throws Exception
     */
    @PostMapping("/actualizar-usuario")
    public ResponseEntity<UsuarioResponseRest> actualizarUsuario(@RequestBody Usuario usuario) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.actualizarUsuario(usuario);
        return respuesta;
    }

    /**
     * Buscar usuario por Username
     *
     * @param username
     * @return
     * @throws Exception
     */
    @GetMapping("/buscar-usuario/{username}")
    public ResponseEntity<UsuarioResponseRest> buscarUsuario(@PathVariable String username) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.buscarUsuario(username);
        return respuesta;
    }

    /**
     * Buscar Usuario por ID
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/buscar-usuario/{id}")
    public ResponseEntity<UsuarioResponseRest> buscarUsuario(@PathVariable Long id) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.buscarUsuarioPorId(id);
        return respuesta;
    }
    
    /**
     * Eliminar Usuario por ID
     * 
     * @param id
     * @return
     * @throws Exception 
     */
    @GetMapping("/eliminar-usuario/{id}")
    public ResponseEntity<UsuarioResponseRest> eliminarUsuario(@PathVariable Long id) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.eliminarUsuarioPorId(id);
        return respuesta;
    }
    /**
     * Eliminar usuario
     * 
     * @param usuario
     * @return
     * @throws Exception 
     */
    @PostMapping("/eliminar-usuario")
    public ResponseEntity<UsuarioResponseRest> eliminarUsuario(@RequestBody Usuario usuario) throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.eliminarUsuario(usuario);
        return respuesta;
    }
    
    /**
     * Listar todos los Usuarios
     * 
     * @return
     * @throws Exception 
     */
    @GetMapping("/listar-usuarios")
        public ResponseEntity<UsuarioResponseRest> listarUsuarios() throws Exception {
        ResponseEntity<UsuarioResponseRest> respuesta = usuarioService.listarUsuarios();
        return respuesta;
    }
    
}
