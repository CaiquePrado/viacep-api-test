package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


import factory.ErrorMessageFactory;
import org.testng.annotations.Test;

import client.BaseTest;
import responses.Address;

public class ViacepFunctionalTest extends BaseTest {
  
  @Test
  public void shouldReturnValidCepDetails(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK)
    .extract()
    .body()
    .as(Address.class);
  }

  @Test
  public void shouldReturnErrorForInvalidCep(){
    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForValidButNonexistentCep(){
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body("erro", equalTo("true"));
  }

  @Test
  public void shouldReturnErrorWhenNoCepIsProvided(){
    viacepClient
    .getNoCep()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnValidCepByAddress(){
    viacepClient
    .getCepByAddress()
    .statusCode(SC_OK);
  }

  @Test
  public void shouldReturnErrorForAddressWithInvalidUF(){
    viacepClient
    .getCepByAddressInvalidUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForAddressWithoutUF(){
    viacepClient
    .getCepByAddressWithoutUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForAddressWithoutCity(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForAddressWithInvalidCity(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForAddressWithInvalidStreet(){
    viacepClient
    .getCepByAddressInvalidStreet()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test
  public void shouldReturnErrorForAddressWithoutStreet(){
    viacepClient
    .getCepByAddressWithoutStreet()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }
}


//TODO: Extrair como classe Adress para fazer assertions. https://github.com/CaiquePrado/desafio-viacep/blob/main/src/test/java/dbserver/desafioviacep/desafioviacep/ConsultaCepTest.java
//TODO: Fazer teste de ValidCepTest com provider para usar mais ceps e com mais diferencas que são certos. Ex: 01001-000 e 01001000.
//TODO:Adicionar description no @Test referentes aos cenários de teste.
//TODO:Adicionar logs em todo processo.
//TODO:Implementar allure reports.