package com.bolsadeideas.springboot.app.models;

import lombok.Getter;
import lombok.Setter;

public class User {

    public User() {}

    public User(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String apellido;

    @Getter
    @Setter
    private String email;

}
