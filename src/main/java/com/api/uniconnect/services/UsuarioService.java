package com.api.uniconnect.services;

import com.api.uniconnect.repository.UsuarioConfirmacaoRepository;
import com.api.uniconnect.repository.UsuarioPfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioPfRepository usuarioPfRepository;
    @Autowired
    private UsuarioConfirmacaoRepository usuarioConfirmacaoRepository;


}
