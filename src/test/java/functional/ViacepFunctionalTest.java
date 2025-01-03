package functional;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

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
  }

  @Test
  public void invalidCepTest(){
    viacepClient
    .getInvalidCepById()
    .statusCode(SC_BAD_REQUEST);
  }
}
