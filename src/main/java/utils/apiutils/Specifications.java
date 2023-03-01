package utils.apiutils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import logger.ApiLogger;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Specifications {

    public static RequestSpecification requestSpecification(String url) {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .addFilter(new ApiLogger())
                .build();
    }
}
