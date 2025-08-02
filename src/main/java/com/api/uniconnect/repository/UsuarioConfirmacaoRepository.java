package com.api.uniconnect.repository;

import com.api.uniconnect.model.UsuarioConfirmacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioConfirmacaoRepository extends JpaRepository<UsuarioConfirmacao, Integer> {
    Optional<UsuarioConfirmacao> findByToken(String token);
}
