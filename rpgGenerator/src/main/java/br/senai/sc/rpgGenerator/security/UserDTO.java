package br.senai.sc.rpgGenerator.security;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserDTO {

    @NonNull
    private String email;

    @NonNull
    private String senha;
}
