package smoke;

import static org.apache.http.HttpStatus.SC_OK;

import org.testng.annotations.Test;

import base.BaseTest;

public class ViacepSmokeTest extends BaseTest {

    @Test(description = "Should return valid details for a given valid CEP")
    public void shouldReturnValidCepDetails(){
        viacepClient
        .getCepById()
        .statusCode(SC_OK);
    }

    @Test(description = "Should return a valid CEP based on a given address")
    public void shouldReturnValidCepByAddress(){
        viacepClient
        .getCepByAddress()
        .statusCode(SC_OK);
    }
}
