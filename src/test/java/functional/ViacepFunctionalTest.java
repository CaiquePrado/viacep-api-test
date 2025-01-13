package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.equalTo;
import responses.ErrorMessage;


import factory.ErrorMessageFactory;
import org.testng.annotations.Test;

import client.BaseTest;
import responses.Address;

public class ViacepFunctionalTest extends BaseTest {
  
  @Test
  public void ValidCepTest(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK)
    .extract()
    .body()
    .as(Address.class);
  }

  @Test
  public void invalidCepTest(){
    ErrorMessage expectedError = ErrorMessageFactory.badRequestErrorMessage();

    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(expectedError.getStatus()))
    .body(containsString(expectedError.getTitle()))
    .body(containsString(expectedError.getDetails()));
  }

  @Test
  public void validButNonexistentCepTest(){
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body("erro", equalTo("true"));
  }

  @Test
  public void noCepTest(){
    viacepClient
    .getNoCep()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void validCepByAddressTest(){
    viacepClient
    .getCepByAddress()
    .statusCode(SC_OK);
  }

  @Test
  public void CepByAddressInvalidUFTest(){
    viacepClient
    .getCepByAddressInvalidUF()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressWithoutUFTest(){
    viacepClient
    .getCepByAddressWithoutUF()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressWithoutCityTest(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressInvalidCityTest(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressInvalidStreetTest(){
    viacepClient
    .getCepByAddressInvalidStreet()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressWithoutStreetTest(){
    viacepClient
    .getCepByAddressWithoutStreet()
    .statusCode(SC_BAD_REQUEST);
  }
}


//TODO: Extrair como classe Adress para fazer assertions. https://github.com/CaiquePrado/desafio-viacep/blob/main/src/test/java/dbserver/desafioviacep/desafioviacep/ConsultaCepTest.java
//TODO: Fazer teste de ValidCepTest com provider para usar mais ceps e com mais diferencas que são certos. Ex: 01001-000 e 01001000.
//TODO:Adicionar description no @Test referentes aos cenários de teste.
//TODO:Adicionar logs em todo processo.
//TODO:Implementar allure reports.
//TODO:Mudar nome dos testes para padão Deve.