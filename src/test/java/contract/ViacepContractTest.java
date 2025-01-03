package contract;

import static constants.ApplicationConstants.GET_VALID_CEP_BUT_NONE_EXISTENT_JSON;
import static constants.ApplicationConstants.GET_VALID_CEP_CONTRACT_JSON;
import static constants.ApplicationConstants.SCHEMAS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;

import java.io.File;

import org.testng.annotations.Test;

import client.BaseTest;

public class ViacepContractTest extends BaseTest {
  
  @Test
  public void validCepContractTest(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_CONTRACT_JSON)));
  }

  @Test
  public void validButNonexistentCepContractTest(){
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_BUT_NONE_EXISTENT_JSON )));
  }
}
