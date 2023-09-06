package net.ultrafibra.cotrasenas.model;

import lombok.Data;

@Data
public class JwtResponse2 {

    private String token;

    public JwtResponse2(String token) {
        this.token = token;
    }

    public JwtResponse2() {
    }

}
