package com.api.controlebiblioteca.requestdto;

import com.api.controlebiblioteca.entity.user.Roles;

public record RegistrarRequestDTO(String login, String senha, Roles role) {
}
