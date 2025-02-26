package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import factory.ErrorMessageFactory;
import org.testng.annotations.Test;
import base.BaseTest;

public class ViacepFunctionalTest extends BaseTest {

  @Test(description = "CT01-02 : Should return a bad request error for an invalid CEP")
  public void shouldReturnErrorForInvalidCep(){
    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT01-03 : Should return an error when the CEP is valid but does not exist")
  public void shouldReturnErrorForValidButNonexistentCep(){
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body("erro", equalTo("true"));
  }

  @Test(description = "CT01-04 : Should return a bad request error when no CEP is provided")
  public void shouldReturnErrorWhenNoCepIsProvided(){
    viacepClient
    .getNoCep()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-02 : Should return a bad request error for an invalid address")
  public void shouldReturnErrorForAddressWithInvalidAddress(){
    viacepClient
    .getCepByAddressInvalidAddress()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-05 : Should return a bad request error for an address with an invalid UF")
  public void shouldReturnErrorForAddressWithInvalidUF(){
    viacepClient
    .getCepByAddressInvalidUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-03 : Should return a bad request error for an address without UF")
  public void shouldReturnErrorForAddressWithoutUF(){
    viacepClient
    .getCepByAddressWithoutUF()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-04 : Should return a bad request error for an address without a city")
  public void shouldReturnErrorForAddressWithoutCity(){
    viacepClient
    .getCepByAddressWithoutCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-07 : Should return a bad request error for an address with an invalid city")
  public void shouldReturnErrorForAddressWithInvalidCity(){
    viacepClient
    .getCepByAddressInvalidCity()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-08 : Should return a bad request error for an address with an invalid street")
  public void shouldReturnErrorForAddressWithInvalidStreet(){
    viacepClient
    .getCepByAddressInvalidStreet()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-05 : Should return a bad request error for an address without a street")
  public void shouldReturnErrorForAddressWithoutStreet(){
    viacepClient
    .getCepByAddressWithoutStreet()
    .statusCode(SC_BAD_REQUEST)
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
    .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }
}


