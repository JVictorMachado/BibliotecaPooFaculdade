# Sistema de Gestao de Biblioteca Academica

Sistema desenvolvido em Java para simular o funcionamento basico de uma biblioteca academica.

O projeto funciona pelo console e permite gerenciar usuarios, livros, emprestimos e devolucoes.

---

## Sobre o Projeto

Este sistema foi desenvolvido com foco nos conceitos principais de Programacao Orientada a Objetos.

Ele utiliza classes separadas para representar usuarios, alunos, professores, livros e emprestimos. Os dados sao armazenados em memoria durante a execucao do programa, utilizando `ArrayList`.

---

## Tecnologias Utilizadas

| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal |
| Console | Interface textual |
| ArrayList | Armazenamento em memoria |
| POO | Organizacao das classes |

---

## Conceitos de POO Aplicados

| Conceito | Onde aparece no projeto |
|---|---|
| Classe e objeto | `Usuario`, `Aluno`, `Professor`, `Livros`, `Emprestimo` |
| Encapsulamento | Atributos privados e metodos getters/setters |
| Heranca | `Aluno` e `Professor` herdam de `Usuario` |
| Polimorfismo | Cada tipo de usuario possui limite de emprestimos diferente |
| Colecoes | Uso de `ArrayList` para guardar dados em memoria |

---

## Funcionalidades

### Usuarios

- Cadastrar aluno.
- Cadastrar professor.
- Listar usuarios cadastrados.
- Validar nome sem numeros.
- Validar matricula somente com numeros.
- Validar CPF somente com numeros.
- Limitar CPF a no maximo 11 numeros.

### Livros

- Cadastrar livro.
- Consultar livro por ISBN.
- Listar livros cadastrados.
- Controlar disponibilidade do livro.

Campos do livro:

| Campo | Descricao |
|---|---|
| Titulo | Nome do livro |
| Autor | Autor da obra |
| ISBN | Codigo identificador |
| Ano | Ano de publicacao |
| Editora | Editora do livro |
| Status | Disponivel ou emprestado |

### Emprestimos

- Realizar emprestimo.
- Registrar numero do emprestimo.
- Vincular usuario ao emprestimo.
- Vincular um ou mais livros ao emprestimo.
- Registrar data informada pelo usuario.
- Listar emprestimos.
- Realizar devolucao.
- Atualizar status do livro apos emprestimo ou devolucao.

---

## Menu Principal

Ao iniciar o sistema, o menu principal e exibido assim:

```text
=== Sistema de Gestao de Biblioteca Academica ===
1 - Usuarios
2 - Livros
3 - Emprestimos
0 - Sair
Escolha uma opcao:
```

Cada opcao leva para um setor especifico do sistema.

---

## Estrutura do Projeto

```text
src/
  Main.java
  MenuBiblioteca.java
  Usuario.java
  Aluno.java
  Professor.java
  Livros.java
  Emprestimo.java
```

---

## Explicacao das Classes

| Classe | Responsabilidade |
|---|---|
| `Main` | Inicia o sistema |
| `MenuBiblioteca` | Exibe o menu principal e guarda as listas principais |
| `Usuario` | Classe base para alunos e professores |
| `Aluno` | Representa usuarios do tipo aluno |
| `Professor` | Representa usuarios do tipo professor |
| `Livros` | Representa os livros e possui o menu de livros |
| `Emprestimo` | Representa e controla os emprestimos |

---

## Como Executar

### Compilar

No terminal, dentro da pasta do projeto:

```bash
javac -encoding UTF-8 -d out src/*.java
```

No Windows PowerShell:

```powershell
javac -encoding UTF-8 -d out src\*.java
```

### Executar

```bash
java -cp out Main
```

---

## Requisitos

- Java JDK 8 ou superior.
- Editor ou IDE Java.

IDE recomendadas:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code
- BlueJ

---

## Observacoes

- O sistema nao utiliza banco de dados.
- Os dados ficam salvos apenas enquanto o programa esta aberto.
- Ao encerrar o sistema, os dados cadastrados sao perdidos.
- O foco do projeto e praticar Programacao Orientada a Objetos em Java.

