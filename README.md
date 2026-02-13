# 📚 LiterAlura - Catálogo de Livros

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-12%2B-blue)
![Status](https://img.shields.io/badge/Status-Concluído-success)

**Challenge Oracle ONE G9 - Alura**

[Sobre](#-sobre-o-projeto) • [Funcionalidades](#-funcionalidades) • [Demonstração](#-demonstração) • [Tecnologias](#%EF%B8%8F-tecnologias-utilizadas) • [Como Executar](#-como-executar) • [Autor](#-autor)

</div>

---

## 📖 Sobre o Projeto

**LiterAlura** é um catálogo interativo de livros desenvolvido como solução para o desafio proposto pela **Alura** em parceria com o programa **Oracle Next Education (ONE) - Geração 9**.

O projeto consiste em uma aplicação de console que consome a API **Gutendex** para buscar informações sobre livros, permitindo ao usuário cadastrá-los em um banco de dados PostgreSQL e realizar diversas consultas e filtros.

### 🎯 Objetivo do Desafio

Consolidar conhecimentos em:
- Consumo de APIs REST
- Persistência de dados com JPA/Hibernate
- Relacionamentos entre entidades
- Tratamento de exceções
- Boas práticas de desenvolvimento

---

## ✨ Funcionalidades

- **🔍 Buscar Livro por Título**: Pesquisa livros na API Gutendex e permite cadastrá-los localmente
- **📚 Listar Livros Registrados**: Exibe todos os livros salvos no banco de dados
- **✍️ Listar Autores Registrados**: Mostra todos os autores cadastrados
- **🎂 Listar Autores Vivos em Determinado Ano**: Filtra autores que estavam vivos em um ano específico
- **🌍 Listar Livros por Idioma**: Filtra livros por idioma (Português, Inglês, Espanhol, Francês)
- **💾 Validação de Duplicatas**: Impede cadastro de livros repetidos

---

## 🎬 Demonstração
```
===== MENU =====
1 - Buscar livro por título
2 - Listar livros registrados
3 - Listar autores registrados
4 - Listar autores vivos em determinado ano
5 - Listar livros por idioma
0 - Sair

Escolha uma opção: 1
Digite o título do livro: Dom Casmurro

Título: Dom Casmurro
Autor: Machado de Assis (1839-1908)
Idioma: Português
Downloads: 12.543

Livro cadastrado com sucesso!
```

---

## 🛠️ Tecnologias Utilizadas

### Backend
- **Java 21** - Linguagem de programação
- **Spring Boot 4.0.2** - Framework para aplicações Java
- **Spring Data JPA** - Abstração para persistência de dados
- **Hibernate** - ORM (Object-Relational Mapping)
- **PostgreSQL** - Banco de dados relacional

### Dependências
- **Jackson Databind 3.0.3** - Serialização/deserialização JSON
- **Maven** - Gerenciamento de dependências

### API Externa
- **[Gutendex API](https://gutendex.com/)** - Base de dados com 70.000+ livros do Projeto Gutenberg

---

## 📦 Estrutura do Projeto
```
literAlura/
├── src/main/java/br/com/luisEduardo/literAlura/
│   ├── dto/                      # Data Transfer Objects
│   │   ├── ApiResponse.java
│   │   ├── AutorApiResponse.java
│   │   └── LivroApiResponse.java
│   ├── exceptions/               # Exceções customizadas
│   │   ├── LivroRepetidoException.java
│   │   ├── NenhumAutorEncontradoException.java
│   │   ├── NenhumLivroEncontradoException.java
│   │   └── idiomaInvalidoException.java
│   ├── integration/              # Integração com API externa
│   │   ├── ConsumoApi.java
│   │   ├── ConverteDados.java
│   │   └── IConverteDados.java
│   ├── mapper/                   # Conversores DTO -> Entity
│   │   └── LivroMapper.java
│   ├── model/                    # Entidades JPA
│   │   ├── Autor.java
│   │   ├── Idioma.java
│   │   └── Livro.java
│   ├── principal/                # Interface CLI
│   │   └── Principal.java
│   ├── repository/               # Repositórios Spring Data
│   │   ├── AutorRepository.java
│   │   └── LivroRepository.java
│   ├── service/                  # Lógica de negócio
│   │   └── LivroService.java
│   └── LiterAluraApplication.java
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

---

## 🚀 Como Executar

### Pré-requisitos

- **Java 21** ou superior
- **Maven 3.6+**
- **PostgreSQL 12+**
- Git (para clonar o repositório)

### Passo a Passo

1. **Clone o repositório**
```bash
git clone https://github.com/LuisEduardoS23/Projeto_ONE_G9_LiterAlura.git
cd Projeto_ONE_G9_LiterAlura
```

2. **Configure o banco de dados PostgreSQL**
```sql
CREATE DATABASE literAlura;
```

3. **Configure as variáveis de ambiente**

No Windows (PowerShell):
```powershell
$env:DB_HOST="localhost:5432"
$env:DB_USER="seu_usuario"
$env:DB_PASSWORD="sua_senha"
```

No Linux/Mac:
```bash
export DB_HOST=localhost:5432
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
```

4. **Compile e execute o projeto**
```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 💡 Aprendizados

Durante o desenvolvimento deste projeto, consolidei conhecimentos em:

✅ Consumo de APIs REST com Java  
✅ Mapeamento objeto-relacional com JPA/Hibernate  
✅ Relacionamentos bidirecionais entre entidades  
✅ Tratamento de exceções customizadas  
✅ Validação de dados e regras de negócio  
✅ Uso de variáveis de ambiente para segurança  
✅ Padrão de camadas (Repository, Service, Controller)  
✅ Manipulação de JSON com Jackson

---

## 🤝 Contribuições

Este projeto foi desenvolvido como parte do desafio educacional da Alura + Oracle ONE. Sugestões e feedbacks são sempre bem-vindos!

---

## 👨‍💻 Autor

**Luís Eduardo**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](seu-linkedin-aqui)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/LuisEduardoS23)

---

## 📄 Licença

Este projeto foi desenvolvido como parte do programa **Oracle Next Education (ONE) - Geração 9** em parceria com a **Alura**.

---

<div align="center">

**#OracleNextEducation** | **#Alura** | **#Challenge**

Feito com ❤️ por [Luís Eduardo](https://github.com/LuisEduardoS23)

</div>