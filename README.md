# viacep-api-test

Este é um projeto que utiliza Rest-Assured e TestNG para testar a API ViaCEP. Ele é destinado para a criação de uma suíte de testes automatizados para validar os endpoints da API.

## Documentação de Testes

Aqui estão alguns links para a documentação de teste do projeto:

- **[Planejamento de Testes](./TestPlan.md)**
- **[Cenários de testes](./TestScenarios.md)**
- Tabelas de Decisão: https://docs.google.com/spreadsheets/d/1fwqJ1LNm20Fgfo6l-bGZI7a89619hAiULIhKR3hL8Gk/edit?usp=sharing

## Pré-requisitos

Certifique-se de ter os seguintes pré-requisitos instalados antes de começar:

- **Java 21**: Certifique-se de ter o JDK 21 instalado em sua máquina. Você pode baixá-lo e instalá-lo a partir do site oficial da Oracle ou de outras fontes confiáveis.

- **Gradle**: Este projeto utiliza o Gradle como sistema de build. Certifique-se de ter o Gradle instalado em sua máquina. Você pode instalá-lo seguindo as instruções disponíveis no site oficial do Gradle.

- **IDE de sua preferência**: Recomenda-se o uso de uma IDE para desenvolvimento Java, como IntelliJ IDEA, VsCode, Eclipse ou Spring Tools Suite (STS).

## **Allure - Relatórios de Testes**

Este projeto utiliza **Allure** para gerar relatórios de testes. Certifique-se de ter o Allure instalado em sua máquina. Para instalar, acesse a [documentação oficial do Allure](https://docs.qameta.io/allure/) e siga as instruções adequadas ao seu sistema operacional.

---
## Executando os testes

Para executar os testes, você pode usar o comando `gradle test` no terminal.

## Visualizando o relatório de testes

Depois de executar os testes, uma pasta chamada `allure-results` será gerada. Siga o comando para ver o relatório de tests:

```bash
allure serve allure-results

