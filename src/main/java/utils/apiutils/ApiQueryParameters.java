package utils.apiutils;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ApiQueryParameters {

    public static Map<String, String> getMapParamsSignUpUser(String userName, String userPassword) {
        Map<String, String> queryParamsSignUpUser = new HashMap<>();
        queryParamsSignUpUser.put(ApiParamName.USER_NAME, userName);
        queryParamsSignUpUser.put(ApiParamName.USER_PASSWORD, userPassword);
        return queryParamsSignUpUser;
    }
}
