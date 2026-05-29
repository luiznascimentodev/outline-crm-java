# CRM de Leads em Java

Projeto em andamento, desenvolvido a partir da proposta descrita em [proposta.txt](proposta.txt). A ideia é construir um CRM simples para gestão de leads com console, persistência em PostgreSQL e uma separação clara entre visão, regra de negócio e acesso a dados.

## Visão geral

Este projeto nasceu como um exercício prático para consolidar fundamentos de Java com foco em arquitetura simples e organizada. A aplicação trabalha com cadastro, consulta, atualização e arquivamento de leads, usando uma estrutura baseada em `View`, `Service`, `DAO` e `Model`.

## Stack e decisões técnicas

- Java
- Maven
- JDBC
- PostgreSQL
- Gson
- dotenv

Arquiteturalmente, o foco foi manter a inteligência da aplicação no serviço, deixando o DAO responsável apenas pela comunicação com o banco. Isso ajuda a reduzir acoplamento e facilita evolução futura.

## Status do projeto

O projeto está em evolução e segue a proposta original. Neste momento, a base do CRM já está estruturada, com console interativo e persistência no banco. As próximas etapas estão relacionadas ao fechamento de venda e à importação de leads automatizados, conforme descrito na proposta.

## Como eu apresentei este projeto

Eu quis transformar uma proposta de CRM em uma aplicação real, saindo da teoria e colocando em prática conceitos de modelagem, persistência e organização de código.

Meu objetivo foi criar uma aplicação Java com banco de dados, validações de negócio e uma estrutura que fosse fácil de entender, testar e evoluir.

Para chegar nisso, eu:

- Modelei a entidade `Lead` com status e valor de negócio.
- Separei responsabilidades entre interface de console, serviço e DAO.
- Estruturei a conexão com PostgreSQL de forma centralizada.
- Adicionei validações básicas no serviço, como regra de telefone com 11 dígitos.
- Comecei a preparar o projeto para evoluir com importação via JSON e automações.

O resultado foi uma base funcional de CRM em Java com persistência em PostgreSQL e uma arquitetura mais limpa do que um script monolítico. O principal ganho foi o aprendizado prático de separação de camadas, validação de regras de negócio e integração com banco de dados.

## O que aprendi

- A importância de separar regra de negócio do acesso a dados.
- Como organizar uma aplicação Java em camadas simples e legíveis.
- Como usar JDBC de forma mais consciente e previsível.
- Como pensar uma evolução de produto a partir de uma proposta inicial.
- Como documentar um projeto de forma mais interessante para recrutadores.

## Próximos passos

- Finalizar o fluxo de fechamento de venda.
- Concluir a importação de leads via JSON.
- Melhorar as mensagens e a experiência do console.
- Adicionar testes para regras principais do serviço.

## Como rodar

1. Suba o PostgreSQL com o `docker-compose.yml`.
2. Copie o arquivo [.env.example](.env.example) para `.env` e ajuste as credenciais, se necessário.
3. Execute a aplicação pela classe principal `com.crm.Main`.

## Observação

Este repositório está sendo usado como vitrine de aprendizado. O código e a documentação estão sendo evoluídos de acordo com a proposta original e com foco em demonstrar raciocínio técnico, organização e capacidade de entrega incremental.
