CREATE TABLE vinculo_usuarios (
    id SERIAL PRIMARY KEY,
    usuario_pj_id INT REFERENCES usuario_pj(id) NOT NULL,
    usuario_pf_id INT REFERENCES usuario_pf(id) NOT NULL,
    tipo_vinculo_id INT REFERENCES tipo_vinculo(id) NOT NULL,
    data_inicio TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_fim TIMESTAMP WITHOUT TIME ZONE DEFAULT NULL,
    status VARCHAR(15)
)