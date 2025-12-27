package smoke;

import static org.apache.http.HttpStatus.SC_OK;

import dto.Address;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import base.BaseTest;
import factory.AddressFactory;

import java.util.List;

@Epic("Smoke Tests")
@Feature("Consulta de Endereços (ViaCEP)")
public class ViacepSmokeTest extends BaseTest {

    @Test(description = "CT01-01 : Should return valid details for a given valid CEP")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Busca direta por CEP")
    @Description("Verifica se a API retorna os dados corretos de endereço (logradouro, bairro, localidade) ao consultar um CEP válido e existente.")
    public void shouldReturnValidCepDetails() {

        Address expectedAddress = viacepClient
                .getCepById()
                .statusCode(SC_OK)
                .extract()
                .as(Address.class);

        assertThat(expectedAddress, is(AddressFactory.validCepResponse()));
    }

    @Test(description = "CT02-01 : Should return a valid CEP based on a given address")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Pesquisa de CEP por Endereço")
    @Description("Verifica se a API é capaz de retornar uma lista de endereços correspondentes ao pesquisar utilizando parâmetros de UF, Cidade e Logradouro.")
    public void shouldReturnValidCepByAddress() {

        List<Address> expectedAddresses = viacepClient
                .getCepByAddress()
                .statusCode(SC_OK)
                .extract()
                .jsonPath()
                .getList("", Address.class);

        Address expectedAddress = expectedAddresses.getFirst();
        assertThat(expectedAddress, is(AddressFactory.validCepByAddressResponse()));
    }
}
