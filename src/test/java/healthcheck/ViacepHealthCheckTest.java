package healthcheck;

import static org.apache.http.HttpStatus.SC_OK;

import org.testng.annotations.Test;

import client.BaseTest;

public class ViacepHealthCheckTest extends BaseTest {
  
  @Test
  public void HealthCheckTest(){
     viacepClient.getHealth().
     statusCode(SC_OK);
  }
}
