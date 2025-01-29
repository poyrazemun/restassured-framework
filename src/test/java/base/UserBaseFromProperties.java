package base;

import api.payload.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;

import static api.utilities.ReadFromProperties.getURL;

@Getter
public class UserBaseFromProperties extends BaseRoutes {

    public Response createUser(UserPOJO userPOJO) {

        String post_url = getURL().getString("post_url");

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userPOJO)
                .when()
                .post(post_url);

    }

    public Response getUser(String username) {
        String get_url = getURL().getString("get_url");
        return RestAssured
                .given()
                .pathParam("username", username)
                .when()
                .get(get_url);


    }

    public Response updateUser(String username, UserPOJO userPOJO) {
        String update_url = getURL().getString("update_url");

        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(userPOJO)
                .when()
                .put(update_url);
    }


    public Response deleteUser(String username) {
        String delete_url = getURL().getString("delete_url");
        return RestAssured
                .given()
                .pathParam("username", username)
                .when()
                .delete(delete_url);
    }

}
