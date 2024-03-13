# Desafio Técnico - README

## Decisões Técnicas e Arquiteturais

O objetivo deste desafio é criar uma aplicação web para cadastro de pessoas e endereços, utilizando Java com JSF (JavaServer Faces) e PrimeFaces para a interface do usuário, e EJB (Enterprise JavaBeans) para a camada de negócios. A aplicação segue uma arquitetura MVC (Model-View-Controller), onde as classes de modelo representam as entidades de negócio, os controladores gerenciam a lógica de negócios e as visualizações são definidas usando XHTML com PrimeFaces.

As decisões técnicas foram baseadas na necessidade de criar uma aplicação web robusta e escalável, utilizando tecnologias amplamente utilizadas no ecossistema Java EE.

## Frameworks e Bibliotecas Utilizadas

- PrimeFaces 5.3: Utilizado para criar uma interface de usuário rica e responsiva.
- JBoss Java EE All 7.0: Fornece as APIs e implementações necessárias para desenvolvimento de aplicações Java EE.
- PostgreSQL 42.3.2: Banco de dados relacional utilizado para armazenar os dados da aplicação.

## Compilação e Execução do Projeto

Para compilar e executar o projeto, siga os seguintes passos:

1. Clone o repositório do projeto para sua máquina local.
2. Abra o projeto em sua IDE.
3. Certifique-se de ter configurado um servidor de aplicação como o Tomcat para executar a aplicação.
4. Compile o projeto faça o deploy da aplicação.
5. Acesse a aplicação através do navegador web, utilizando a URL seuservidor/cadastro-pessoas.

## Execução dos Testes da Solução

Para executar os testes da solução, siga os passos abaixo:

1. Abra o projeto em sua IDE.
2. O pom já contém as dependencias JUnit e Mockito para os testes.
3. Execute os testes unitários localizados no diretório de testes do projeto.

## Notas Adicionais

- Este projeto foi desenvolvido como parte de um desafio técnico e não foi otimizado para produção. Algumas melhorias podem ser feitas em termos de segurança, desempenho e usabilidade.
- Recomenda-se o uso de um ambiente de desenvolvimento Java EE compatível com as tecnologias utilizadas neste projeto, como Eclipse com o plugin JBoss Tools.
