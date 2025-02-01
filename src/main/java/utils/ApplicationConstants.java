package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class ApplicationConstants {

  public static final String ENV = "env";
  public static final String UAT = "uat";

  public static final String VALID_CEP = "01001000";
  public static final String INVALID_CEP = "01001-00";
  public static final String VALID_CEP_BUT_NONE_EXISTENT = "99999-999";

  public static final String VALID_ADDRESS = "BA/Vitoria/pedrinhas";
  public static final String ADDRESS_WITHOUT_UF = "/PortoAlegre/Domingos";
  public static final String ADDRESS_INVALID_UF = "$*/PortoAlegre/Domingos";
  public static final String ADDRESS_WITHOUT_CITY = "RS/Domingos";
  public static final String ADDRESS_INVALID_CITY = "RS/Porto/ab";
  public static final String ADDRESS_INVALID_STREET = "RS/Porto/1";
  public static final String ADDRESS_WITHOUT_STREET = "RS/Porto/";

  public static final String SCHEMAS = "src/test/resources/schemas/";
  public static final String GET_VALID_CEP_CONTRACT_JSON = "GET-valid-cep.json";
  public static final String GET_VALID_CEP_BUT_NONE_EXISTENT_JSON = "GET-valid-cep-but-none-existent.json";
  public static final String GET_VALID_CEP_BY_ADDRESS_JSON = "GET-valid-cep-by-address.json";
}
