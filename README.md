
# LABMedical API

### Projeto feito no curso do Lab 365

A ideia do projeto é ser uma API REST Back-End para um software de gestão de prontuários em ambiente hospitalar, baseado no cadastro, consulta, atualização e deleção de pacientes, consultas e exames. Para acessar os endpoints é necessário fazer login e cada usuário é vinculado a um perfil, ADMIN, MEDICO e PACIENTE.

#### Perfil de ADMIN:
Tem acesso completo a todos os endpoints, inclusive unico capaz de cadastrar novos usuários.

#### Perfil de MEDICO:
É responsavel pelo cadastro de pacientes, consultas e exames, ele também consegue consultar, atualizar ou deletar os respectivos dados cadastrados.

#### Perfil de PACIENTE: 
Só consegue consultar seus próprios dados.

### Tecnologias ultilizadas

- **Java: 21**
- **Spring:** Spring Boot 3.3.2, Maven, Spring Web, Spring Data, Spring Security, Spring Validation e CRUD Rest API.
- **Banco de Dados:** Modelo Relacional e SQL com PostgreSQL.


## Documentação da API

#### Autenticação

```
  Todos os endpoints precisam de autenticação com o token gerado no login, exceto o endpoint /login
  Quando a aplicação é iniciada pela primeira vez é cadastrado 3 perfis: ADMIN, MEDICO e PACIENTE.
  Um usuário admin é cadastrado automaticamente para administrar o sistema.
  Dados de login do admin
  {
      Email : "admin@email.com"
      Senha : "teste123"
  }
```

| Auth           | Tipo     |  Descrição                        |
| :------------- | :--------| :-------------------------------- |
| `Bearer Token` | `string` |  **Obrigatório**. Token de acesso |

----------------------
### Login

```http
  POST /api/login
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A         | N/A    | **Obrigatório**. Body: JSON com os dados de acesso de login |

```
{
	"emailUsuario" : "admin@email.com",
	"senha" : "teste123"
}
```
#### Respostas Possíveis:
- Código 200 (OK) - Login bem-sucedido. Retorna um token JWT (JSON Web Token) no corpo da resposta.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.

-------------------

### Cadastro de usuários
```http
  POST /api/usuarios/cadastro
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A | **Obrigatório**. Body: JSON com os dados para cadastrado do usuário |

```
{
	"nomeUsuario" : "paciente",
	"emailUsuario" : "teste@email.com",
	"dataNascimento" : "01/01/2000",
	"cpf" : "333.333.333-33",
	"senha" : "teste123",
	"nomePerfil" : "PACIENTE"
}
```
- nomeUsuario: uma string com máximo 255 caracteres e obrigatória
- emailUsuario: uma string com máximo de 255 caracteres, obrigatória e única
- dataNascimento: uma data no formato (dd/MM/yyyy) e obrigatória
- cpf: Uma string com máximo de 14 caracteres, obrigatória e única
- senha: uma string com máximo de 255 caracteres e obrigatório
- nomePerfil: obrigatório, nome do perfil ADMIN, MEDICO ou PACIENTE

#### Respostas Possíveis:
- Código 201 (Created) - Usuário cadastrado com sucesso. Retorna o JSON do usuário criado no corpo da resposta.
- Código 401 (Unauthorized) - Credenciais inválidas. O usuário não está autorizado a acessar o sistema.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.


----------------

### Cadastro de perfis
```http
  POST /api/perfis
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A | **Obrigatório**. Body: JSON com os dados para cadastrado de perfil |

```
{
	"nomePerfil" : "TESTE"
}
```
- nomePerfil : string
#### Respostas Possíveis:
- Código 201 (Created) - Perfil cadastrado com sucesso.
- Código 401 (Unauthorized) - Credenciais inválidas. O usuário não está autorizado a acessar o sistema.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.

----------------

### Cadastro de pacientes
```http
  POST /api/pacientes
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A | **Obrigatório**. Body: JSON com os dados para cadastrado de paciente |

#### Observação: O body json deve ter 2 objetos separados pacienteRequest e enderecoRequest como no exemplo abaixo, e para cadastrar um paciente é obrigatório vincular um usuário com perfil de PACIENTE, esse usuario não pode estar vinculado a outro paciente e o email, data de nascimento e cpf do paciente e usuario devem que ser iguais.

```
{
	"pacienteRequest" : {
		"nomePaciente" : "Teste Silva",
    "generoPaciente" : "Masculino",
    "dataNascimento" : "01/01/2000",
    "cpfPaciente" : "333.333.333-33",
    "rgPaciente" : "11 111 111-1/SC",
    "estadoCivil" : "Solteiro",
    "telefonePaciente" : "(48) 9 9999-9999",
    "emailPaciente" : "teste@email.com",
    "naturalidade" : "Florianópolis/SC",
    "contatoEmergencia" : "(48) 9 9999-9999",
    "alergias" : "Picada de abelha, camarão",
		"cuidados" : "Evitar camarão",
		"convenio" : "Não tem",
		"usuarioId" : 3
	},
	"enderecoRequest" : {
		"cep" : 11111111,
		"cidade" : "Cidade teste",
		"estado" : "Estado teste",
		"logradouro" : "Rua teste",
		"numero" : 100,
		"complemento" : "Complemento teste",
		"bairro" : "Bairro teste",
		"pontoReferencia" : "Referencia teste"
	}
}
```
- Nome Completo: Obrigatório, com máximo e mínimo de 64 e 8 caracteres, respectivamente
- Gênero: Obrigatório
- Data de Nascimento: Obrigatório, data válida e deve ser a mesma data de nascimento do usuario PACIENTE que vai ser vinculado
- CPF: Obrigatório com o formato 000.000.000-00 e deve ser o mesmo CPF do usuario PACIENTE que vai ser vinculado
- RG com órgão expedidor: Obrigatório, com máximo de 20 caracteres
- Estado Civil: Obrigatório
- Telefone: Obrigatório com o formato (99) 9 9999-9999
- E-mail: Obrigatório e deve ser o mesmo email do usuário PACIENTE que vai ser vinculado
- Naturalidade: Obrigatório, com máximo e mínimo de 64 e 8 caracteres, respectivamente
- Contato de Emergência: Obrigatório com o formato (99) 9 9999-9999
- Lista de Alergias: Não obrigatório
- Lista de Cuidados Específicos: Não obrigatório
- Convênio: Não obrigatório
- Número do Convênio: Não obrigatório
- Validade do Convênio: Não obrigatório
- Endereço: Cep, Cidade, Estado, Logradouro, Número, Complemento, Bairro e Ponto de Referência
- id_usuario: Identificador do usuário de acesso do paciente, esse usuário já deve estar criado e com o perfil de paciente

#### Respostas Possíveis:
- Código 201 (Created) - Paciente criado com sucesso. Retorna o JSON do paciente criado no corpo da resposta.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 409 (Conflict) - Falha ao cadastrar pois há algum dado duplicado.

----------------

### Obter Paciente por ID
```http
  GET /api/pacientes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /pacientes/1|

```
Retorna o JSON do paciente no corpo da resposta.
```
#### Respostas Possíveis:
- Código 200 (OK) - Paciente encontrado. Retorna o JSON do paciente no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Paciente não encontrado.

----------------

### Listar todos os pacientes com base nos filtros
```http
  GET /api/pacientes
```

| Parâmetros de query   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome, telefone, e-mail` | String |  Filtros opcionais, são parâmetros de query e caso não seja enviado nenhum, retorna todos os pacientes|
`Todos opcionais`
`Deve conter paginação (opcional)`


```
Retorna o JSON dos pacientes no corpo da resposta.
```
#### Respostas Possíveis:
- Código 200 (OK) - Retorna uma lista de todos os pacientes no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Não há pacientes cadastrados ou nenhum paciente encontrado com os filtros enviados.

----------------

### Atualizar paciente
```http
  PUT /api/pacientes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /pacientes/1 **Obrigatório** Body: JSON com os dados para atualizar paciente|

#### Observação: O body json deve ter 2 objetos separados pacienteRequest e enderecoRequest como no exemplo abaixo, e para atualiza o paciente é obrigatório vincular um usuário com perfil de PACIENTE, esse usuario não pode estar vinculado a outro paciente e o email, data de nascimento e cpf do paciente e usuario devem que ser iguais.
```
{
	"pacienteRequest" : {
		"nomePaciente" : "Nome Atualizado",
        "generoPaciente" : "Masculino",
        "dataNascimento" : "01/01/2000",
        "cpfPaciente" : "111.111.111-11",
        "rgPaciente" : "11 111 111-1/SC",
        "estadoCivil" : "Solteiro",
        "telefonePaciente" : "(48) 9 8888-8888",
        "emailPaciente" : "testee@email.com",
        "naturalidade" : "Florianópolis/SC",
        "contatoEmergencia" : "(48) 9 9999-9999",
        "alergias" : "alergias atualizadas",
		"cuidados" : "cuidados atualizados",
		"convenio" : "Unimed",
		"numeroConvenio" : 123456,
        "validadeConvenio" : "01/01/2025",
		"usuarioId" : 1
	},
	"enderecoRequest" : {
		"cep" : 11111111,
		"cidade" : "Cidade atualizada",
		"estado" : "Estado atualizado",
		"logradouro" : "Rua teste",
		"numero" : 1,
		"complemento" : "Complemento teste",
		"bairro" : "Bairro teste",
		"pontoReferencia" : "Referencia teste"
	}
}
```
#### Respostas Possíveis:
- Código 200 (OK) - Paciente atualizado com sucesso. Retorna o JSON do paciente atualizado no corpo da resposta.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Paciente não encontrado.

----------------

### Deletar paciente
```http
  DELETE /api/pacientes/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /pacientes/1|

```
Deleta o paciente com o id passado no parâmetro de url.
```
#### Respostas Possíveis:
- Código 204 (No Content) - Paciente excluído com sucesso.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Paciente não encontrado.

----------------

### Cadastro de consulta
```http
  POST /api/consultas
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A | **Obrigatório**. Body: JSON com os dados para cadastrado da consulta |

```
{
	"motivoConulta" : "Dor na perna",
    "dataConsulta" : "01/01/2024",
    "horaConsulta" : "14:30",
    "descricaoProblema" : "Dor na perna direita ao caminhar",
    "medicacaoReceitada" : "Dorflex",
    "dosagemPrecaucoes" : "Quando sentir dores fortes",
    "pacienteId" : 1
}
```
- Motivo da consulta: Obrigatório, com máximo e mínimo de 64 e 8 caracteres, respectivamente.
- Data da Consulta: Obrigatório.
- Horário da Consulta: Obrigatório.
- Descrição do Problema: Obrigatório, com máximo e mínimo de 1024 e 16 caracteres, respectivamente.
- Medicação Receitada: Não obrigatório.
- Dosagem e Precauções: Não obrigatório, com máximo e mínimo de 256 e 16 caracteres, respectivamente.
- Id do paciente: Obrigatório. Identificador do paciente consultado.

#### Respostas Possíveis:
- Código 201 (Created) - Consulta criada com sucesso. Retorna o JSON da consulta criada no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados 
----------------

### Obter consulta por ID
```http
  GET /api/consultas/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /consultas/1|

```
Retorna o JSON da consulta no corpo da resposta.
```
#### Respostas Possíveis:
- Código 200 (OK) - Consulta encontrada. Retorna o JSON da consulta no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Consulta não encontrada.
----------------

### Atualizar consulta
```http
  PUT /api/consultas/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /consultas/1 **Obrigatório** Body: JSON com os dados para atualizar consulta|

```
{
	"motivoConulta" : "Motivo atualizado",
    "dataConsulta" : "03/03/2024",
    "horaConsulta" : "10:40",
    "descricaoProblema" : "Dores de cabeça atualizada",
    "medicacaoReceitada" : "Dorflex",
    "dosagemPrecaucoes" : "Quando sentir dores fortes",
    "pacienteId" : 5
}
```
#### Respostas Possíveis:
- Código 200 (OK) - Consulta atualizada com sucesso. Retorna o JSON da consulta atualizada no corpo da resposta.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Consulta não encontrada.
----------------

### Deletar consulta
```http
  DELETE /api/consultas/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /consultas/1|

```
Deleta a consulta com o id passado no parâmetro de url.
```
#### Respostas Possíveis:
- Código 204 (No Content) - Consulta excluída com sucesso.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Consulta não encontrada.
----------------

### Cadastro de exame
```http
  POST /api/exames
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A | **Obrigatório**. Body: JSON com os dados para cadastrado do exame |

```
{
	"nomeExame" : "Exame teste",
	"dataExame" : "02/01/2024",
	"horaExame" : "12:30",
	"tipoExame" : "Tipo teste",
	"laboratorio" : "Lab 365",
	"urlDocumento" : "Url teste",
	"resultados" : "Testando resultado",
	"pacienteId" : 5
}
```
- Nome do Exame: Obrigatório, com máximo e mínimo de 64 e 8 caracteres, respectivamente.
- Data do Exame: Obrigatório. Dica: LocalDate.
- Horário do Exame: Obrigatório. Dica: LocalTime.
- Tipo do Exame: Obrigatório, com máximo e mínimo de 32 e 4 caracteres, respectivamente.
- Laboratório: Obrigatório, com máximo e mínimo de 32 e 4 caracteres, respectivamente.
- URL do Documento: Não obrigatório.
- Resultados: Não Obrigatório, com máximo e mínimo de 1024 e 16 caracteres, respectivamente.
- Id do paciente: Obrigatório. Identificador do paciente examinado.

#### Respostas Possíveis:
- Código 201 (Created) - Exame criado com sucesso. Retorna o JSON do exame criado no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.
----------------

### Obter exame por ID
```http
  GET /api/exames/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /exames/1|

```
Retorna o JSON do exame no corpo da resposta.
```
#### Respostas Possíveis:
- Código 200 (OK) - Exame encontrado. Retorna o JSON do exame no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Exame não encontrado.
----------------

### Atualizar exame
```http
  PUT /api/exames/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /exames/1 **Obrigatório** Body: JSON com os dados para atualizar exame|

```
{
	"nomeExame" : "Exame atualizado",
	"dataExame" : "02/02/2025",
	"horaExame" : "13:30",
	"tipoExame" : "Tipo atualizado",
	"laboratorio" : "Lab 365",
	"urlDocumento" : "Url atualizado",
	"resultados" : "Resultado atualizado",
	"pacienteId" : 5
}
```
#### Respostas Possíveis:
- Código 200 (OK) - Exame atualizado com sucesso. Retorna o JSON do exame atualizado no corpo da resposta.
- Código 400 (Bad Request) - Requisição inválida, por exemplo, dados ausentes ou incorretos.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Exame não encontrado.
----------------

### Deletar exame
```http
  DELETE /api/exames/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /exames/1|

```
Deleta o exame com o id passado no parâmetro de url.
```
#### Respostas Possíveis:
- Código 204 (No Content) - Exame excluído com sucesso.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Exame não encontrado.
----------------

### Listar pacientes para acessar prontuário
```http
  GET /api/pacientes/prontuarios
```

| Parâmetros de query   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `nome, id` | String |  Filtros opcionais, são parâmetros de query e caso não seja enviado nenhum, retorna todos os pacientes|
`Todos opcionais`
`Deve conter paginação (opcional)`


```
Retorna uma lista de objetos com os dados: número de registro, nome completo, convênio (plano de saúde).

```
#### Respostas Possíveis:
- Código 200 (OK) - Retorna uma lista de todos os pacientes no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Não há pacientes cadastrados.
----------------

### Listar os prontuários do paciente
```http
  GET /api/pacientes/{id}/prontuarios
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `ID`      | Long        |  ID é um parâmetro de url ex: /pacientes/1/prontuarios|

```
Retorna um objeto JSON contendo: nome do paciente, convênio, contato de emergência, alergias, cuidados específicos, lista de exames e lista de consultas. Ambas listas estão ordenadas pela data de realização (crescente).
```
#### Respostas Possíveis:
- Código 200 (OK) - Retorna o objeto no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
- Código 404 (Not Found) - Não há pacientes cadastrados com o id informado.
----------------

### Dashboard
```http
  POST /api/dashboard
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| N/A      | N/A        |   Retorna um JSON |

```
Retorna um JSON com a quantidade de pacientes cadastrados, quantidade de consultas cadastradas e a quantidade de exames cadastrados.
```
#### Respostas Possíveis:
- Código 200 (OK) - Retorna os dados no corpo da resposta.
- Código 401 (Unauthorized) - Falha de autenticação.
----------------
