package client;

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
}
