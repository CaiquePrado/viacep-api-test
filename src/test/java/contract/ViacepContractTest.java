package contract;

import static constants.ApplicationConstants.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;

import java.io.File;

import org.testng.annotations.Test;

import client.BaseTest;

public class ViacepContractTest extends BaseTest {

  @Test(description = "Should validate the contract for a valid CEP")
  public void shouldValidateValidCepContract() {
    viacepClient
    .getCepById()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_CONTRACT_JSON)));
  }

  @Test(description = "Should validate the contract for a valid but non-existent CEP")
  public void shouldValidateValidButNonexistentCepContract() {
    viacepClient
    .getValidButNonexistentCep()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_BUT_NONE_EXISTENT_JSON)));
  }

  @Test(description = "Should validate the contract for retrieving a valid CEP by address")
  public void shouldValidateCepByAddressContract() {
    viacepClient
    .getCepByAddress()
    .statusCode(SC_OK)
    .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_BY_ADDRESS_JSON)));
  }
}

