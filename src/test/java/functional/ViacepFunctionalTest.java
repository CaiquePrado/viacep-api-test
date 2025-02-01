package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import factory.ErrorMessageFactory;
import org.testng.annotations.Test;
import base.BaseTest;

public class ViacepFunctionalTest extends BaseTest {

  @Test(description = "Should return valid details for a given valid CEP")
  public void shouldReturnValidCepDetails(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK);
  }

  @Test(description = "Should return a bad request error for an invalid CEP")
  public void shouldReturnErrorForInvalidCep(){
    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return an error when the CEP is valid but does not exist")
  public void shouldReturnErrorForValidButNonexistentCep(){
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body("erro", equalTo("true"));
  }

  @Test(description = "Should return a bad request error when no CEP is provided")
  public void shouldReturnErrorWhenNoCepIsProvided(){
    viacepClient
    .getNoCep()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a valid CEP based on a given address")
  public void shouldReturnValidCepByAddress(){
    viacepClient
    .getCepByAddress()
    .statusCode(SC_OK);
  }

  @Test(description = "Should return a bad request error for an address with an invalid UF")
  public void shouldReturnErrorForAddressWithInvalidUF(){
    viacepClient
    .getCepByAddressInvalidUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a bad request error for an address without UF")
  public void shouldReturnErrorForAddressWithoutUF(){
    viacepClient
    .getCepByAddressWithoutUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a bad request error for an address without a city")
  public void shouldReturnErrorForAddressWithoutCity(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a bad request error for an address with an invalid city")
  public void shouldReturnErrorForAddressWithInvalidCity(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a bad request error for an address with an invalid street")
  public void shouldReturnErrorForAddressWithInvalidStreet(){
    viacepClient
    .getCepByAddressInvalidStreet()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getStatus()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getTitle()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().getDetails()));
  }

  @Test(description = "Should return a bad request error for an address without a street")
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
//TODO: Adicionar logs em todo processo.
//TODO: Allure reports ou extent.