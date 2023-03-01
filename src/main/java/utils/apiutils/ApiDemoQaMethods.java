package utils.apiutils;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

@UtilityClass
public class ApiDemoQaMethods {

    public static final String LIST_BOOKS_JSON_PATH = "books";

    public static void signUpUser(Map<String, String> queryParamsSignUpUserMap) {
            given()
                .body(queryParamsSignUpUserMap)
                .when()
                .post(ApiEndpoints.SIGN_UP_USER)
                .then();
    }

    public static <T> List<T> getBooks(Class<T> namePojoClass) {
        return given()
                .when()
                .get(ApiEndpoints.GET_BOOK_STORE)
                .then()
                .statusCode(SC_OK)
                .extract().jsonPath().getList(LIST_BOOKS_JSON_PATH, namePojoClass);
    }
}
