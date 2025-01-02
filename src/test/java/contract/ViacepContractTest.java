package contract;

import static constants.ApplicationConstants.GET_VALID_CEP_CONTRACT_JSON;
import static constants.ApplicationConstants.SCHEMAS;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;

import java.io.File;

import org.testng.annotations.Test;

import client.BaseTest;

public class ViacepContractTest extends BaseTest {
  
  @Test
  public void validCepContract(){
    viacepClient
    .getCepById()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_CONTRACT_JSON)));
  }
}
