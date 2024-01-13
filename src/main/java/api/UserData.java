package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserData {
    final static String CREATE_USER_URL = "/api/auth/register";
    final static String LOGIN_USER_URL = "/api/auth/login";
    final static String DELETE_USER_URL = "/api/auth/user";
    final static String UPDATE_USER_URL = "/api/auth/user";

    //Создание пользователя
    public static Response createUser(String email, String password, String name){
        NewUser newUser = new NewUser(email, password, name);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(newUser)
                .when()
                .post(CREATE_USER_URL);
    }
    //Авторизация пользователя
    public static Response loginUser(String email, String password){
        UserAuth userAuth = new UserAuth(email, password);
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(userAuth)
                .when()
                .post(LOGIN_USER_URL);
    }
    //Редактирование пользователя
    public static Response updateUser(String bearerToken, String email, String password, String name){
        NewUser newUser = new NewUser(email, password, name);
        return given()
                .headers("Content-type", "application/json","Authorization", bearerToken)
                .and()
                .body(newUser)
                .when()
                .patch(UPDATE_USER_URL);
    }
    //Удаление пользователя
    public static void deleteUser(String bearerToken){
        given()
                .headers("Authorization", bearerToken)
                .delete(DELETE_USER_URL);
    }
}