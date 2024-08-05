INSERT INTO perfis (nome_perfil)
    VALUES('ADMIN')
    ON CONFLICT (nome_perfil) DO NOTHING;

INSERT INTO perfis (nome_perfil)
    VALUES('MEDICO')
    ON CONFLICT (nome_perfil) DO NOTHING;

INSERT INTO perfis (nome_perfil)
    VALUES('PACIENTE')
    ON CONFLICT (nome_perfil) DO NOTHING;

INSERT INTO usuarios (cpf, data_nascimento, email_usuario, nome_usuario, senha)
    VALUES ('111.111.111.11', '2000-01-01', 'admin@email.com', 'admin', '$2a$10$oq8NQZn9pFGaiz2fR1dLQeFIN3bXbB14QdjhGFnK.Y/RxxBoJi2yO')
    ON CONFLICT (cpf) DO NOTHING;

INSERT INTO perfil_usuario (usuario_id, perfil_id)
    VALUES(1, 1)
    ON CONFLICT (usuario_id, perfil_id) DO NOTHING;
