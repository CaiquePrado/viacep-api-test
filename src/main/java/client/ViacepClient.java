package client;

import static constants.ApplicationConstants.INVALID_CEP;
import static constants.ApplicationConstants.VALID_CEP;
import static constants.ApplicationConstants.VALID_CEP_BUT_NONE_EXISTENT;
import static constants.EndpointConstants.CEP_BY_ID;
import static constants.EndpointConstants.HTTP_200_UP;
import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ViacepClient {
  
  private final RequestSpecification requestSpec;

  public ViacepClient(RequestSpecification requestSpec) {
    this.requestSpec = requestSpec;
  }

  public ValidatableResponse getHealth(){
    return given().spec(requestSpec)
    .when()
    .get(HTTP_200_UP)
    .then();
  }

  public ValidatableResponse getCepById(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep", VALID_CEP)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getInvalidCepById(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep", INVALID_CEP)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getValidButNonexistentCep(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep", VALID_CEP_BUT_NONE_EXISTENT)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getNoCep(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep","")
    .get(CEP_BY_ID)
    .then();
  }
}
