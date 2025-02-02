# Plano de Testes Viacep

## Introdução
A API Viacep é um serviço que fornece informações de endereços com base no CEP. É amplamente utilizada por desenvolvedores para agilizar a obtenção de dados de localização. Essencial para sistemas de entrega, cadastros de clientes e pesquisas de localização. Facilita a integração e melhora a experiência do usuário em projetos que envolvem informações de endereços no Brasil.

---

## Funcionalidades

| Funcionalidade | Comportamento Esperado | Verificações | Critérios de Aceite |
|---------------|----------------------|-------------|------------------|
| **Consulta de CEP** | Ao consultar um CEP válido, eu devo obter informações sobre o endereço correspondente. | A resposta deve incluir o CEP ou CEPS válidos do endereço correspondente. | A API deve retornar os dados do endereço correto. |
| **Consulta de CEP por endereço** | Ao consultar um CEP passando a UF, cidade e logradouro, eu devo obter o CEP correspondente ao endereço. | A resposta deve incluir o CEP válido correspondente ao endereço consultado. | A API deve retornar um ou mais CEPs válidos. |

---

## Estratégia de Teste

### Escopo de Testes
O plano de testes abrange todas as funcionalidades descritas na tabela acima.  
Serão executados testes em todos os níveis conforme a descrição abaixo.

- **Testes Automatizados**: Serão realizados testes de API em todos os endpoints seguindo a documentação de Cenários de Teste e deste Plano de Testes.
- **Testes Manuais**: Todas as funcionalidades serão testadas manualmente pelo time de qualidade seguindo a documentação de Cenários de Teste e deste Plano de Testes.

---

## Ambiente e Ferramentas

Os testes serão feitos no ambiente de homologação, que contém as mesmas configurações do ambiente de produção, com uma massa de dados gerada previamente pelo time de qualidade.

### Ferramentas Utilizadas

| Ferramenta  | Time | Descrição |
|------------|------|-----------|
| **Postman** | Qualidade | Ferramenta para realização de testes de API |
| **Rest-Assured** | Qualidade | Ferramenta para testes de API |

---

## Classificação de Bugs

Os Bugs serão classificados com as seguintes severidades:

| ID | Nível de Severidade | Descrição |
|----|--------------------|------------|
| **1** | Blocker | Bug que bloqueia o teste de uma função ou feature e causa crash na aplicação. Exemplo: botão não funciona, impedindo o uso completo da funcionalidade. Bloqueia a entrega. |
| **2** | Grave | Funcionalidade não funciona como esperado. Exemplo: input incomum causa efeitos irreversíveis. |
| **3** | Moderada | Funcionalidade não atinge certos critérios de aceitação, mas sua funcionalidade geral não é afetada. Exemplo: mensagem de erro ou sucesso não é exibida corretamente. |
| **4** | Pequena | Quase nenhum impacto na funcionalidade, porém atrapalha a experiência. Exemplo: erro ortográfico ou pequenos erros de UI. |

---

## Definição de Pronto

Será considerada pronta a funcionalidade que:

- Passar pelas verificações e testes descritos neste Plano de Testes.
- Não apresentar bugs com severidade acima de **Moderada**.
- Passar por uma validação de negócio de responsabilidade do time de produto.
