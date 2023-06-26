
<h1 align="center">Api-develcode</h1>

<p align="center">
  <img alt="Github top language" src="https://img.shields.io/github/languages/top/moisespompilio/api-develcode?color=56BEB8">

  <img alt="Github language count" src="https://img.shields.io/github/languages/count/moisespompilio/api-develcode?color=56BEB8">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/moisespompilio/api-develcode?color=56BEB8">

  <img alt="License" src="https://img.shields.io/github/license/moisespompilio/api-develcode?color=56BEB8">

</p>


<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#memo-license">License</a> &#xa0; | &#xa0;
  <a href="https://github.com/moisespompilio" target="_blank">Author</a>
</p>

<br>

## :dart: About ##

A API desenvolvida para o desafio técnico da Develcode foi implementada em Java, utilizando Maven como gerenciador de dependências e PostgreSQL como banco de dados. O projeto também utiliza Docker para facilitar a sua utilização.

No caminho src/main/java/com/api/Develcode, encontramos a maior parte do código e da lógica de negócio do sistema. O projeto está dividido em três pastas principais: Config (responsável pelos arquivos de configuração do sistema, como Beans e repositórios), Shared (que contém elementos reutilizáveis do código, como classes abstratas genéricas e exceções) e Modules (que abriga a lógica de negócio do sistema, com cada módulo nomeado de acordo com a entidade ou função correspondente).

Dentro da pasta Modules, temos três subpastas: Domain (responsável por gerir a regra de negócio da aplicação, incluindo as entidades e os casos de uso), Application (responsável pela camada de aplicação, que faz a ligação entre a camada Adapter e Domain) e Adapter (responsável pela comunicação externa, incluindo os repositórios e controladores).

A pasta Domain abriga os casos de uso (Use Cases), que são as regras de negócio específicas da aplicação. Cada caso de uso é responsável por uma funcionalidade ou operação do sistema, definindo as ações a serem executadas nas entidades e manipulando os dados de acordo com a lógica de negócio.

A entidade "User" é a entidade do sistema e possui os seguintes atributos: Id (código), nome, foto (link para a foto) e data de nascimento.

A arquitetura do projeto segue os princípios da clean architecture e hexagonal, buscando separar as camadas de forma que cada uma não precise saber o que ocorre nas outras. Isso permite maior flexibilidade, testabilidade e manutenibilidade do código. Além disso, o projeto adota boas práticas de desenvolvimento, como Clean Code e os princípios SOLID.

## :sparkles: Features ##

:heavy_check_mark: Inicialização do projeto;\
:heavy_check_mark: Criação de classes abstratas genéricas para evitar repetição de código;\
:heavy_check_mark: Implementação do CRUD de usuários;\
:heavy_check_mark: Tratamento adequado das exceções;\
:heavy_check_mark: Documentação com o Swagger;

## :rocket: Technologies ##

Às seguintes tecnologias foram utilizadas neste projeto:

- [Java](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Docker](https://www.docker.com/)


## :white_check_mark: Requirements ##

Antes de iniciar :checkered_flag:, você precisa ter [Git](https://git-scm.com) e [Docker](https://www.docker.com/) instalados.

## :checkered_flag: Starting ##

```bash
# Clone do projeto
$ git clone https://github.com/moisesPompilio/api-develcode.git

# Acesso
$ cd api-develcode

# Start Docker
$ docker-compose up --build


# O server vai iniciar em <http://localhost:3000/v1>
```

## :memo: License ##

Este projeto está sob licença do MIT. Para mais detalhes, consulte o [LICENSE](LICENSE.md).


Made with :heart: by <a href="https://github.com/moisespompilio" target="_blank">Moises Pomppilio</a>

&#xa0;

<a href="#top">Back to top</a>
