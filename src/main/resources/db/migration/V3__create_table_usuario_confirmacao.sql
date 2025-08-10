CREATE TABLE usuario_confirmacao (
    id SERIAL PRIMARY KEY,
    usuario_pf_id INTEGER REFERENCES usuario_pf(id),
    usuario_pj_id INTEGER REFERENCES usuario_pj(id),
    token VARCHAR(255) NOT NULL UNIQUE,
    data_expiracao TIMESTAMP NOT NULL

    CONSTRAINT chk_usuario_confirmacao CHECK (
        (usuario_pf_id IS NOT NULL AND usuario_pj_id IS NULL)
        OR
        (usuario_pj_id IS NOT NULL AND usuario_pf_id IS NULL)
    )
);