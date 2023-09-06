package net.ultrafibra.cotrasenas.controller;

import net.ultrafibra.cotrasenas.model.Usuario;
import net.ultrafibra.cotrasenas.response.JWTResponseRest;
import net.ultrafibra.cotrasenas.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;
    
    /**
     * Login de Usuario
     * 
     * @param loginRequest
     * @return
     * @throws Exception 
     */    
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTResponseRest> login(@RequestBody Usuario loginRequest) throws Exception {
         return  loginService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

}
