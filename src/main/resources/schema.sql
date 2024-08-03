CREATE TABLE IF NOT EXISTS perfis (
    perfil_id SERIAL PRIMARY KEY,
    nome_perfil VARCHAR(255) UNIQUE
);

CREATE TABLE IF NOT EXISTS usuarios (
    usuario_id SERIAL PRIMARY KEY,
    cpf VARCHAR(255) UNIQUE,
    data_nascimento DATE,
    email_usuario VARCHAR(255) UNIQUE,
    nome_usuario VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS perfil_usuario (
    usuario_id INT,
    perfil_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (perfil_id) REFERENCES perfis(perfil_id),
    UNIQUE (usuario_id, perfil_id)
);