package positiveTests;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import positiveTests.POGOForPositiveTests.responses.LogIn.Root;
import positiveTests.settingsForPositiveTests.BaseApi;

import java.io.File;
import positiveTests.POGOForPositiveTests.requests.LogIn;


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

    /*
        Если бы АПИ возвращал токен - я бы засунул его в статичную переменную и использовал в следующих тестах
     */
    @Test
    @Step
    @DisplayName("Авторизация пользователя")
    public void logIn() {
        LogIn logIn = new LogIn();
        try {
            Response response = RestAssured.given()
                    .param(logIn.getUsername()+logIn.getPassword())
                    .get("/user/");
            Root root = response.then().assertThat().statusCode(200).and().extract().body().as(Root.class);
            if (root.getMessage().contentEquals("logged in user session:")) {
                System.out.println(root.getMessage());
            } else {
                System.out.println("Авторизация не удалась! " + root.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Тест №2 по Авторизации провалился!: " + e.getMessage());
        }

    }



}
