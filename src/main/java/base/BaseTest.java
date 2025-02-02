package base;

import client.ViacepClient;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.RequestSpecBuilder;
import config.PropertiesUtils;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {
  private static final String DUMMY_URI = "viacep-baseuri";

  protected static final RequestSpecification spec = new RequestSpecBuilder()
          .setContentType(JSON)
          .setAccept(JSON)
          .setBaseUri(PropertiesUtils.getBaseURI(DUMMY_URI))
          .addFilter(new ResponseLoggingFilter())
          .addFilter(new RequestLoggingFilter())
          .build();

  protected static ViacepClient viacepClient = new ViacepClient(spec);
}
