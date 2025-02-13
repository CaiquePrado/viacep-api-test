package client;

import static utils.ApplicationConstants.*;
import static utils.EndpointConstants.CEP_BY_ID;
import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ViacepClient {
  
  private final RequestSpecification requestSpec;

  public ViacepClient(RequestSpecification requestSpec) {
    this.requestSpec = requestSpec;
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

  public ValidatableResponse getCepByAddress(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep",VALID_ADDRESS)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressInvalidAddress(){
    return  given().spec(requestSpec)
    .when()
    .pathParam("cep",INVALID_ADDRESS)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressInvalidUF(){
    return  given().spec(requestSpec)
    .when()
    .pathParam("cep",ADDRESS_INVALID_UF)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressWithoutUF(){
    return  given().spec(requestSpec)
    .when()
    .pathParam("cep",ADDRESS_WITHOUT_UF)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressWithoutCity(){
    return  given().spec(requestSpec)
    .when()
    .pathParam("cep",ADDRESS_WITHOUT_CITY)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressInvalidCity(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep", ADDRESS_INVALID_CITY)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressInvalidStreet(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep",ADDRESS_INVALID_STREET)
    .get(CEP_BY_ID)
    .then();
  }

  public ValidatableResponse getCepByAddressWithoutStreet(){
    return given().spec(requestSpec)
    .when()
    .pathParam("cep",ADDRESS_WITHOUT_STREET)
    .get(CEP_BY_ID)
    .then();
  }
}
