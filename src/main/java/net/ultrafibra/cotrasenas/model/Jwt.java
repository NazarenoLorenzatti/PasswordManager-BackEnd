package net.ultrafibra.cotrasenas.model;

import lombok.Data;

@Data
public class Jwt {

    private String token;

    public Jwt(String token) {
        this.token = token;
    }

    public Jwt() {
    }

}
