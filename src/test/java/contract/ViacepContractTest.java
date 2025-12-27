package contract;

import static utils.ApplicationConstants.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_OK;

import java.io.File;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import base.BaseTest;

@Epic("Contract Tests")
@Feature("Consulta de Endereços (ViaCEP)")
public class ViacepContractTest extends BaseTest {

  @Test()
  @Severity(SeverityLevel.CRITICAL)
  @Story("Busca direta por CEP")
  @Description("Valida se a estrutura do JSON (tipos de dados, campos obrigatórios) está conforme o esquema definido (JSON Schema) para um CEP válido.")
  public void shouldValidateValidCepContract() {
    viacepClient
            .getCepById()
            .statusCode(SC_OK)
            .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_CONTRACT_JSON)));
  }

  @Test()
  @Severity(SeverityLevel.CRITICAL)
  @Story("Busca direta por CEP")
  @Description("Valida se a estrutura do JSON de resposta para um CEP inexistente segue o contrato específico.")
  public void shouldValidateValidButNonexistentCepContract() {
    viacepClient
            .getValidButNonexistentCep()
            .statusCode(SC_OK)
            .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_BUT_NONE_EXISTENT_JSON)));
  }

  @Test()
  @Severity(SeverityLevel.CRITICAL)
  @Story("Pesquisa de CEP por Endereço")
  @Description("Valida se a lista de endereços retornada na busca por parâmetros (UF/Cidade/Rua) respeita o contrato de array de objetos.")
  public void shouldValidateCepByAddressContract() {
    viacepClient
            .getCepByAddress()
            .statusCode(SC_OK)
            .body(matchesJsonSchema(new File(SCHEMAS + GET_VALID_CEP_BY_ADDRESS_JSON)));
  }
}

