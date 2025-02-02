# Cenários de Teste - API ViaCEP

## Caso de Teste 01: Consulta de CEP

### CT01-01: Consulta um CEP válido com sucesso  
**Dado** que o usuário tem um `<CEP>` válido  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o CEP  
**Então** a API deve retornar um status de sucesso `200`  
**E** a API deve retornar as informações do endereço correspondente ao CEP  

#### Exemplos:
| CEP       |
|-----------|
| 01001-000 |
| 45005154  |
| 72800-000 |
| 31080970  |

---

### CT01-02: Consulta um CEP inválido  
**Dado** que o usuário tem um `<CEP>` inválido  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o CEP  
**Então** a API deve retornar um status de erro `400`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

#### Exemplos:
| CEP         |
|------------|
| 01001-0000 |
| 45005_154  |
| 72800-00   |
| 01001-00   |

---

### CT01-03: Consulta um CEP válido, mas inexistente  
**Dado** que o usuário tem um `<CEP>` válido, mas inexistente  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o CEP  
**Então** a API deve retornar um status de sucesso `"200"`  
**E** a API deve retornar a mensagem de erro `"true"`  

#### Exemplos:
| CEP        |
|-----------|
| 99999-999 |
| 12345678  |
| 54321-987 |
| 00000000  |

---

### CT01-04: Consulta sem CEP  
**Dado** que o usuário não tenha um CEP  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP sem o CEP  
**Então** a API deve retornar um status de erro `"400"`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

---

## Caso de Teste 02: Consulta de CEP por endereço

### CT02-01: Consulta de CEP por endereço com sucesso  
**Dado** que o usuário tem a `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de sucesso `"200"`  
**E** a API deve retornar o CEP correspondente ao endereço  

#### Exemplos:
| UF | Cidade      | Logradouro |
|----|------------|-----------|
| RS | Porto Alegre | Domingos  |
| SP | São Paulo    | Paulista  |
| BA | Salvador     | Santana   |

---

### CT02-02: Consulta de CEP por endereço inválido  
**Dado** que o usuário tem a `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de erro `"400"`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

#### Exemplos:
| UF | Cidade         | Logradouro           |
|----|--------------|--------------------|
| X  | Terra do nunca | Avenida Imaginária |
| C8 | Monte Olimpo  | Rua Imaginária     |
| $* | Narnia        | Júpiter            |

---

### CT02-03: Consulta de CEP com UF vazia  
**Dado** que o usuário tem a `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de erro `"400"`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

#### Exemplos:
| UF | Cidade       | Logradouro |
|----|-------------|-----------|
|    | Porto Alegre | Domingos  |
|    | São Paulo    | Paulista  |
|    | Salvador     | Santana   |

---

### CT02-04: Consulta de CEP com cidade vazia  
**Dado** que o usuário tem a `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de erro `"400"`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

#### Exemplos:
| UF | Cidade | Logradouro |
|----|--------|-----------|
| RS |        | Domingos  |
| SP |        | Paulista  |
| BA |        | Santana   |

---

### CT02-05: Consulta de CEP com logradouro vazio  
**Dado** que o usuário tem a `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de erro `"400"`  
**E** a API deve retornar a mensagem `"Bad Request"`  
**E** o usuário deve ser instruído a `"Verificar a URL"`  

#### Exemplos:
| UF | Cidade        | Logradouro |
|----|-------------|-----------|
| RS | Porto Alegre |           |
| SP | São Paulo    |           |
| BA | Salvador     |           |

---

### CT02-06: Consulta um CEP com cidade válida porém inexistente no Estado  
**Dado** que o usuário tem um `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de sucesso `"200"`  
**E** a API deve retornar um array vazio.  

#### Exemplos:
| UF | Cidade         | Logradouro |
|----|--------------|-----------|
| RS | São Gonçalo  | 1         |
| SP | Santa Catarina | Paulista  |
| BA | Belo Horizonte | Santana  |

---

### CT02-07: Consulta um CEP com logradouro válido porém inexistente na cidade  
**Dado** que o usuário tem um `<UF>`, a `<cidade>` e `<logradouro>`  
**Quando** o usuário faz uma requisição `GET` para a API ViaCEP com o endereço  
**Então** a API deve retornar um status de sucesso `"200"`  
**E** a API deve retornar um array vazio.  

#### Exemplos:
| UF | Cidade        | Logradouro          |
|----|-------------|--------------------|
| RS | Porto Alegre | Frei Benjamin     |
| SP | São Paulo    | Alto Maron        |
| BA | Salvador     | Morada dos Pássaros |

---

