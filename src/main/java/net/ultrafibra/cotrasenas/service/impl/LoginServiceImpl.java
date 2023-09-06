package net.ultrafibra.cotrasenas.service.impl;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import net.ultrafibra.cotrasenas.model.Jwt;
import net.ultrafibra.cotrasenas.response.JWTResponseRest;
import net.ultrafibra.cotrasenas.security.JwtUtil;
import net.ultrafibra.cotrasenas.security.UserDetailsServiceImp;
import net.ultrafibra.cotrasenas.service.iLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Data
public class LoginServiceImpl implements iLoginService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImp userDetails;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<JWTResponseRest> login(String userName, String password) {
        JWTResponseRest respuesta = new JWTResponseRest();
        List<Jwt> listaJWT = new ArrayList<>();

        try {
            UserDetails userDetails = this.userDetails.loadUserByUsername(userName);

            if (this.passwordEncoder.matches(password, userDetails.getPassword())) {
                listaJWT.add(new Jwt(this.jwtUtil.encode(userDetails.getUsername())));
                respuesta.getJwtResponse().setJwt(listaJWT);
                respuesta.setMetadata("Respuesta ok", "00", "Login correcto");
                return new ResponseEntity<JWTResponseRest>(respuesta, HttpStatus.OK);
            } else {
                respuesta.setMetadata("Respuesta nok", "-1", "credenciales incorrectas");
                return new ResponseEntity<JWTResponseRest>(respuesta, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            respuesta.setMetadata("Respuesta nok", "-1", "Error al itentar en el servidor al intentar acceder");
            e.getStackTrace();
            return new ResponseEntity<JWTResponseRest>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
