# CRM de Leads em Java

Projeto de estudo com foco em evolução incremental de arquitetura e regras de negócio. A aplicação roda em console, persiste dados em PostgreSQL e foi construída para demonstrar crescimento técnico em camadas: de CRUD básico até fluxos de negócio mais completos.

## Resumo para recrutadores

Este projeto mostra minha forma de trabalhar: entregar valor em ciclos curtos, aumentar complexidade de forma controlada e manter organização do código conforme o sistema cresce.

O que já está implementado:

- Cadastro de leads com validação de telefone.
- Listagem de leads persistidos no banco.
- Busca por ID e atualização de cadastro com manutenção de valores anteriores.
- Arquivamento de lead (status LOST e contrato zerado).
- Fechamento de venda com validação de existência do lead e valor positivo.
- Importação de lead via JSON usando Gson, com regra automática de status.

## Stack

- Java
- Maven
- JDBC
- PostgreSQL
- Gson
- dotenv

## Arquitetura aplicada

O projeto está organizado em camadas com responsabilidades separadas:

- View: interação de menu e entrada de dados no console.
- Service: regras de negócio e validações.
- DAO: acesso e atualização dos dados no PostgreSQL.
- Model: representação da entidade de domínio (Lead).
- Infra: conexão com o banco centralizada.

Essa separação reduz acoplamento e facilita evolução, manutenção e testes.

## Evolução de complexidade (o que implementei em etapas)

1. Estrutura base
- Organização de projeto Java com Maven e separação por camadas.
- Conexão com banco e persistência inicial.

2. Operações de CRM
- Criação, listagem, busca e atualização de leads.
- Consolidação de operações CRUD em fluxo de console.

3. Regras de negócio
- Validação de telefone com 11 dígitos no serviço.
- Tratamento de casos inválidos com mensagens de erro.

4. Estados de funil comercial
- Arquivamento com transição explícita para LOST.
- Fechamento de venda com transição para WON e valor de contrato.

5. Entrada de dados estruturada
- Importação de lead em JSON com desserialização via Gson.
- Definição automática de status (NEW ou CONTACTED) conforme valor de negócio.

## O que aprendi

- Como transformar regras de negócio em métodos de serviço claros e reutilizáveis.
- Como modelar transições de status de forma consistente com o funil comercial.
- Como manter o DAO focado em persistência, sem vazar regra de negócio para SQL.
- Como evoluir um projeto simples para cenários mais realistas sem perder legibilidade.
- Como documentar entregas com foco em impacto técnico e comunicação para recrutadores.

## Estado atual

O CRM já cobre um fluxo funcional relevante para operação comercial básica: captura, manutenção, qualificação, encerramento de oportunidade e importação de dados.

## Próximos passos

- Melhorar tratamento de erros de entrada no console (parse seguro e UX).
- Adicionar testes automatizados para as regras do serviço.
- Evoluir importação JSON para arquivo externo/lote.
- Padronizar mensagens e internacionalização das validações.

## Como executar

1. Suba o banco com `docker compose up -d`.
2. Configure as variáveis de ambiente no arquivo `.env`.
3. Compile e rode com Maven:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.crm.Main"
```

## Objetivo do repositório

Este repositório é uma vitrine de aprendizado prático em Java back-end, com foco em:

- progressão técnica incremental,
- organização de código,
- decisões arquiteturais simples e bem justificadas,
- entrega contínua de funcionalidades.
