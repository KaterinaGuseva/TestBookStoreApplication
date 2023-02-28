package utils.apiutils;

import lombok.experimental.UtilityClass;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

@UtilityClass
public class ApiDemoQaMethods {

    public static <T> List<T> getBooks(Class<T> namePojoClass) {
        return given()
                .when()
                .get(Endpoints.GET_BOOK_STORE.getEndpoint())
                .then()
                .statusCode(SC_OK)
                .extract().jsonPath().getList("books", namePojoClass);
    }
}
