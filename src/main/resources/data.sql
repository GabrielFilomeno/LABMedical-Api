INSERT INTO perfis (nome_perfil)
SELECT 'ADMIN' WHERE NOT EXISTS (SELECT 1 FROM perfis WHERE nome_perfil = 'ADMIN');

INSERT INTO perfis (nome_perfil)
SELECT 'MEDICO' WHERE NOT EXISTS (SELECT 1 FROM perfis WHERE nome_perfil = 'MEDICO');

INSERT INTO perfis (nome_perfil)
SELECT 'PACIENTE' WHERE NOT EXISTS (SELECT 1 FROM perfis WHERE nome_perfil = 'PACIENTE');
