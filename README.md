<div align="center">

# 📚 Sistema de Gestão de Biblioteca Acadêmica

Sistema desenvolvido em Java para simular o funcionamento básico de uma biblioteca acadêmica, com foco na prática de Programação Orientada a Objetos.

![Java](https://img.shields.io/badge/Java-JDK%208%2B-orange?style=for-the-badge&logo=java)
![Console](https://img.shields.io/badge/Interface-Console-blue?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![POO](https://img.shields.io/badge/Paradigma-POO-purple?style=for-the-badge)

</div>

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Conceitos de POO Aplicados](#-conceitos-de-poo-aplicados)
- [Funcionalidades](#-funcionalidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Requisitos](#-requisitos)
- [Observações](#-observações)
- [Desenvolvedores](#-desenvolvedores)

---

## 💡 Sobre o Projeto

Este sistema foi desenvolvido como projeto acadêmico com foco nos conceitos fundamentais de **Programação Orientada a Objetos (POO)**. O programa roda pelo console e permite gerenciar usuários, livros, empréstimos e devoluções de uma biblioteca acadêmica.

As entidades do sistema são representadas por classes separadas — usuários, alunos, professores, livros e empréstimos — e os dados são armazenados em memória durante a execução utilizando `ArrayList`.

---

## 🛠 Tecnologias Utilizadas

| Tecnologia | Uso |
|---|---|
| Java | Linguagem principal do projeto |
| Console | Interface textual de interação |
| ArrayList | Armazenamento de dados em memória |
| POO | Paradigma de organização das classes |

---

## 🎓 Conceitos de POO Aplicados

| Conceito | Onde aparece no projeto |
|---|---|
| **Classe e Objeto** | `Usuario`, `Aluno`, `Professor`, `Livros`, `Emprestimo` |
| **Encapsulamento** | Atributos privados com métodos getters/setters |
| **Herança** | `Aluno` e `Professor` herdam de `Usuario` |
| **Polimorfismo** | Cada tipo de usuário possui limite de empréstimos diferente |
| **Coleções** | Uso de `ArrayList` para guardar dados em memória |

---

## ⚙️ Funcionalidades

### 👤 Usuários
- Cadastrar aluno
- Cadastrar professor
- Listar usuários cadastrados
- Validar nome (sem números)
- Validar matrícula (somente números)
- Validar CPF (somente números, máximo de 11 dígitos)

### 📖 Livros
- Cadastrar livro
- Consultar livro por ISBN
- Listar livros cadastrados
- Controlar disponibilidade do livro

Campos do livro:

| Campo | Descrição |
|---|---|
| Título | Nome do livro |
| Autor | Autor da obra |
| ISBN | Código identificador |
| Ano | Ano de publicação |
| Editora | Editora do livro |
| Status | Disponível ou emprestado |

### 🔄 Empréstimos
- Realizar empréstimo
- Registrar número do empréstimo
- Vincular usuário ao empréstimo
- Vincular um ou mais livros ao empréstimo
- Registrar data informada pelo usuário
- Listar empréstimos
- Realizar devolução
- Atualizar status do livro após empréstimo ou devolução

---

## 🖥 Menu Principal

Ao iniciar o sistema, o menu principal é exibido assim:

```text
=== Sistema de Gestão de Biblioteca Acadêmica ===
1 - Usuários
2 - Livros
3 - Empréstimos
0 - Sair
Escolha uma opção:
```

Cada opção leva para um setor específico do sistema.

---

## 📁 Estrutura do Projeto

```text
📦 biblioteca-academica
 ┗ 📂 src
    ┣ 📄 Main.java
    ┣ 📄 MenuBiblioteca.java
    ┣ 📄 Usuario.java
    ┣ 📄 Aluno.java
    ┣ 📄 Professor.java
    ┣ 📄 Livros.java
    ┗ 📄 Emprestimo.java
```

### Explicação das Classes

| Classe | Responsabilidade |
|---|---|
| `Main` | Ponto de entrada; inicia o sistema |
| `MenuBiblioteca` | Exibe o menu principal e mantém as listas de dados |
| `Usuario` | Classe base (pai) para `Aluno` e `Professor` |
| `Aluno` | Representa usuários do tipo aluno |
| `Professor` | Representa usuários do tipo professor |
| `Livros` | Representa os livros e contém o menu de livros |
| `Emprestimo` | Representa e controla os empréstimos |

---

## 🚀 Como Executar

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/biblioteca-academica.git
cd biblioteca-academica
```

### 2. Compile o projeto

**Linux / macOS:**
```bash
javac -encoding UTF-8 -d out src/*.java
```

**Windows (PowerShell):**
```powershell
javac -encoding UTF-8 -d out src\*.java
```

### 3. Execute o sistema

```bash
java -cp out Main
```

---

## 📌 Requisitos

- **Java JDK 8** ou superior

**IDEs recomendadas:**

| IDE | Link |
|---|---|
| IntelliJ IDEA | https://www.jetbrains.com/idea/ |
| Eclipse | https://www.eclipse.org/ |
| Visual Studio Code | https://code.visualstudio.com/ |
| BlueJ | https://www.bluej.org/ |

---

## ⚠️ Observações

> - O sistema **não utiliza banco de dados**.
> - Os dados ficam salvos **apenas enquanto o programa está aberto**.
> - Ao encerrar o sistema, todos os dados cadastrados são **perdidos**.
> - O foco do projeto é praticar **Programação Orientada a Objetos em Java**.

---

## 👨‍💻 Desenvolvedores

<div align="center">

Desenvolvido por:

| [<img src="https://ui-avatars.com/api/?name=Joao+Victor&size=100&background=0D8ABC&color=fff&rounded=true" width="80"/>](https://github.com/) | [<img src="https://ui-avatars.com/api/?name=Pedro+Henrique&size=100&background=6A0DAD&color=fff&rounded=true" width="80"/>](https://github.com/) |
|:---:|:---:|
| **João Victor Machado Reino** | **Pedro Henrique Franco Dias** |
| Desenvolvedor | Desenvolvedor |

</div>

---

<div align="center">

Projeto desenvolvido para fins acadêmicos — Prática de Programação Orientada a Objetos em Java.

</div>
