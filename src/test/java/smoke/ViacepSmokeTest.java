package smoke;

import static org.apache.http.HttpStatus.SC_OK;

import dto.Address;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;
import base.BaseTest;
import response.AddressResponse;

import java.util.List;

public class ViacepSmokeTest extends BaseTest {

    @Test(description = "CT01-01 : Should return valid details for a given valid CEP")
    public void shouldReturnValidCepDetails(){

        Address expectedAddress = viacepClient
        .getCepById()
        .statusCode(SC_OK)
        .extract()
        .as(Address.class);

        assertThat(expectedAddress, is(AddressResponse.validCepResponse()));
    }

    @Test(description = "CT02-01 : Should return a valid CEP based on a given address")
    public void shouldReturnValidCepByAddress(){
        List<Address> expectedAddresses = viacepClient
        .getCepByAddress()
        .statusCode(SC_OK)
        .extract()
        .jsonPath()
        .getList("", Address.class);

        Address expectedAddress = expectedAddresses.getFirst();
        assertThat(expectedAddress, is(AddressResponse.validCepByAddressResponse()));
    }
}
