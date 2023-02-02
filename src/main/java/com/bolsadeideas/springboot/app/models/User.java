package com.bolsadeideas.springboot.app.models;

import lombok.Getter;
import lombok.Setter;

public class User {

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
