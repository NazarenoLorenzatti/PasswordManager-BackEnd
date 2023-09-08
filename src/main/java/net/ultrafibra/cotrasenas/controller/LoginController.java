package net.ultrafibra.cotrasenas.controller;

import net.ultrafibra.cotrasenas.model.Usuario;
import net.ultrafibra.cotrasenas.response.*;
import net.ultrafibra.cotrasenas.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * Primer Factor de autenticacion
     * 
     * @param loginRequest
     * @return
     * @throws Exception 
     */
    @PostMapping(path = "/primer-factor", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseRest> primerFactor(@RequestBody Usuario loginRequest) throws Exception {
        return loginService.primerFactor(loginRequest.getUsername(), loginRequest.getPassword());
    }

    /**
     * Segundo Factor de autenticacion y proporcion de TOKEN
     *
     * @param loginRequest
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JWTResponseRest> login(@RequestBody Usuario loginRequest) throws Exception {
        return loginService.login(loginRequest.getUsername(), loginRequest.getPassword(), loginRequest.getPin());
    }

}
