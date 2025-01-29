package api.test;

import api.payload.UserPOJO;
import base.UserBase;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUserModule extends UserBase {

    Faker faker;
    UserPOJO user;

    @BeforeClass
    public void setData() {
        faker = new Faker();
        user = new UserPOJO();

        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());
    }


    @Test(priority = 1)
    public void testCreateUser() {

        logger.info("Post the user!"); //bu sekilde her yere logger koyabilirim ve logs dosyasinin altina kaydedilir!
        Response response = createUser(user);
        Assert.assertEquals(response.statusCode(), 200);


    }

    @Test(priority = 2, dependsOnMethods = "testCreateUser")
    public void testGetUser() {
        Response response = getUser(user.getUsername());
        Assert.assertEquals(response.statusCode(), 200);

    }


    @Test(priority = 3, dependsOnMethods = "testGetUser")
    public void testUpdateUser() {

        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());

        Response response = updateUser(user.getUsername(), user);
        Assert.assertEquals(response.statusCode(), 200);

        Response responseAfterUpdate = getUser(user.getUsername());
        Assert.assertEquals(responseAfterUpdate.statusCode(), 200);

    }


    @Test(priority = 4, dependsOnMethods = "testUpdateUser")
    public void testDeleteUser() {
        Response response = deleteUser(user.getUsername());
        Assert.assertEquals(response.statusCode(), 200);
    }

}
