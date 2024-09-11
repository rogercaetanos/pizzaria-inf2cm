package com.itb.inf2cm.pizzaria.repository;

import com.itb.inf2cm.pizzaria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

