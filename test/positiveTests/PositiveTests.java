package positiveTests;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import positiveTests.settingsForPositiveTests.BaseApi;

import java.io.File;
import java.util.Map;



public class PositiveTests {

    BaseApi baseReqSpec = new BaseApi();


    @Before
    public void setUp() {
        RestAssured.requestSpecification = baseReqSpec.spec;
    }

    @Test
    @Step
    @DisplayName("Создание пользователя")
    public void signIn() {
        File file = new File("/Users/denismart/Git/RestAssuredPetStore/test/positiveTests/POGOForPositiveTests/requests/SignInData.json");
        try {
            Response response = RestAssured.given()
                    .body(file)
                    .post("/user");
            response.then().assertThat().statusCode(200);
            System.out.println("Тест №1 по Регистрации прошел успешно! Статус код: " + response.statusCode());
        } catch (Exception e) {
            System.out.println("Тест №1 по Регистрации провалился : " + e.getMessage());
        }
    }

    @Test
    @Step
    @DisplayName("Авторизация пользователя")
    public void logIn() {
        File file = new File("/Users/denismart/Git/RestAssuredPetStore/test/positiveTests/POGOForPositiveTests/requests/logIn.json");
        try {
            Response response = RestAssured.given()
                    .body(file)
                    .post("/user/" + file.username);
        }

    }



}
