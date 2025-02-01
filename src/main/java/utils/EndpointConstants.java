package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class EndpointConstants {
  public static final String HTTP_200_UP = "/01001000/json/"; 
  public static final String CEP_BY_ID = "/{cep}/json/";

}
