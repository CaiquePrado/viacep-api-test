package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import factory.ErrorMessageFactory;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import base.BaseTest;

@Epic("Functional Tests")
@Feature("Consulta de Endereços (ViaCEP)")
public class ViacepFunctionalTest extends BaseTest {

  @Test(description = "CT01-02 : Should return a bad request error for an invalid CEP")
  @Severity(SeverityLevel.NORMAL)
  @Story("Busca direta por CEP")
  @Description("Valida se a API retorna erro 400 (Bad Request) quando um CEP com formato inválido (ex: alfanumérico ou tamanho incorreto) é enviado.")
  public void shouldReturnErrorForInvalidCep() {
    viacepClient
            .getInvalidCepById()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT01-03 : Should return an error when the CEP is valid but does not exist")
  @Severity(SeverityLevel.NORMAL)
  @Story("Busca direta por CEP")
  @Description("Valida o comportamento quando o CEP possui formato válido (8 dígitos), mas não existe na base de dados (API deve retornar 200 OK com flag de erro).")
  public void shouldReturnErrorForValidButNonexistentCep() {
    viacepClient
            .getValidButNonexistentCep()
            .statusCode(SC_OK)
            .body("erro", equalTo("true"));
  }

  @Test(description = "CT01-04 : Should return a bad request error when no CEP is provided")
  @Severity(SeverityLevel.NORMAL)
  @Story("Busca direta por CEP")
  @Description("Valida se a API retorna erro quando o parâmetro de CEP é enviado vazio ou nulo na requisição.")
  public void shouldReturnErrorWhenNoCepIsProvided() {
    viacepClient
            .getNoCep()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-02 : Should return a bad request error for an invalid address")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida o tratamento de erro para uma busca genérica com endereço inválido.")
  public void shouldReturnErrorForAddressWithInvalidAddress() {
    viacepClient
            .getCepByAddressInvalidAddress()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-05 : Should return a bad request error for an address with an invalid UF")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida se a API rejeita requisições onde a UF (Unidade Federativa) informada não existe ou tem formato inválido.")
  public void shouldReturnErrorForAddressWithInvalidUF() {
    viacepClient
            .getCepByAddressInvalidUF()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-03 : Should return a bad request error for an address without UF")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida a obrigatoriedade do campo UF na busca por endereço.")
  public void shouldReturnErrorForAddressWithoutUF() {
    viacepClient
            .getCepByAddressWithoutUF()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-04 : Should return a bad request error for an address without a city")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida a obrigatoriedade do campo Cidade na busca por endereço.")
  public void shouldReturnErrorForAddressWithoutCity() {
    viacepClient
            .getCepByAddressWithoutCity()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-07 : Should return a bad request error for an address with an invalid city")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida se a API rejeita nomes de cidades que não atendem aos critérios mínimos (ex: menos de 3 caracteres).")
  public void shouldReturnErrorForAddressWithInvalidCity() {
    viacepClient
            .getCepByAddressInvalidCity()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-08 : Should return a bad request error for an address with an invalid street")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida se a API rejeita nomes de logradouros inválidos ou curtos demais.")
  public void shouldReturnErrorForAddressWithInvalidStreet() {
    viacepClient
            .getCepByAddressInvalidStreet()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }

  @Test(description = "CT02-05 : Should return a bad request error for an address without a street")
  @Severity(SeverityLevel.NORMAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida a obrigatoriedade do campo Logradouro na busca por endereço.")
  public void shouldReturnErrorForAddressWithoutStreet() {
    viacepClient
            .getCepByAddressWithoutStreet()
            .statusCode(SC_BAD_REQUEST)
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().status()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().title()))
            .body(containsString(ErrorMessageFactory.badRequestErrorMessage().details()));
  }
}


