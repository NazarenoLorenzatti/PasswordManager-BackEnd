package net.ultrafibra.cotrasenas.service;

import net.ultrafibra.cotrasenas.response.JWTResponseRest;
import org.springframework.http.ResponseEntity;



public interface iLoginService {
    
    public ResponseEntity<JWTResponseRest> login(String userName, String password);
}
