package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class ApplicationConstants {

  public static final String ENV = "env";
  public static final String UAT = "uat";

  public static final String VALID_CEP = "01001000";
  public static final String INVALID_CEP = "01001-00";
  public static final String VALID_CEP_BUT_NONE_EXISTENT = "99999-999";

  public static final String VALID_ADDRESS = "RS/PortoAlegre/Domingos";

  public static final String SCHEMAS = "src/test/resources/schemas/";
  public static final String GET_VALID_CEP_CONTRACT_JSON = "GET-valid-cep.json";
  public static final String GET_VALID_CEP_BUT_NONE_EXISTENT_JSON = "GET-valid-cep-but-none-existent.json";
}
