package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import client.BaseTest;

public class ViacepFunctionalTest extends BaseTest {
  
  @Test
  public void ValidCepTest(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK);
    // .extract()
    // .body()
    // .as(Address.class);

    //TODO: Extrair como classe Adress para fazer assertions. https://github.com/CaiquePrado/desafio-viacep/blob/main/src/test/java/dbserver/desafioviacep/desafioviacep/ConsultaCepTest.java
    //TODO: Fazer teste de ValidCepTest com provider para usar mais ceps e com mais diferencas que são certos. Ex: 01001-000 e 01001000.
    //TODO:Adicionar description no @Test referentes aos cenários de teste.
    //TODO:Adicionar logs em todo processo.
    //TODO:Implementar allure reports.
    //TODO:Mudar nome dos testes para padão Deve.
  }

  @Test
  public void invalidCepTest(){
    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST);
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
    .getCepByAddressWhithoutUF()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressWithoutCityTest(){
    viacepClient
    .getCepByAddressWhithoutCity()
    .statusCode(SC_BAD_REQUEST);
  }

  @Test
  public void CepByAddressInvalidCityTest(){
    viacepClient
    .getCepByAddressWhithoutCity()
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
    .getCepByAddressWhithoutStreet()
    .statusCode(SC_BAD_REQUEST);
  }
}
