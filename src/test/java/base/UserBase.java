package base;

import api.payload.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;

@Getter
public class UserBase extends BaseRoutes {

    public Response createUser(UserPOJO userPOJO) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userPOJO)
                .when()
                .post("/user");

    }

    public Response getUser(String username) {
        return RestAssured
                .given()
                .pathParam("username", username)
                .when()
                .get("/user/{username}");


    }

    public Response updateUser(String username, UserPOJO userPOJO) {

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(userPOJO)
                .when()
                .put("/user/{username}");
    }


    public Response deleteUser(String username) {
        return RestAssured
                .given()
                .pathParam("username", username)
                .when()
                .delete("/user/{username}");
    }

}
