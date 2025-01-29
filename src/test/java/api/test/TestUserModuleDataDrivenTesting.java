package api.test;


import api.payload.UserPOJO;
import api.utilities.DataProviders;
import base.UserBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestUserModuleDataDrivenTesting extends UserBase {


    @Test(priority = 1, dataProvider = "allUserData", dataProviderClass = DataProviders.class)
    public void testCreateUser(int userID, String userName, String firstName, String lastName, String email, String password, String phone) {

        UserPOJO user = new UserPOJO();
        user.setId(userID);
        user.setUsername(userName);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        Response response = createUser(user);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "userNameProvider", dataProviderClass = DataProviders.class)
    public void testDeleteUser(String userName) {
        Response response = deleteUser(userName);
        Assert.assertEquals(response.statusCode(), 200);
    }


}
