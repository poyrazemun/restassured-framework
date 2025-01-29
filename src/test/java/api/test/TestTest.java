package api.test;

import api.utilities.DataProviders;
import org.testng.annotations.Test;

public class TestTest {
    @Test(dataProvider = "userNameProvider", dataProviderClass = DataProviders.class)
    public void testUserName(String userName) {
        System.out.println("UserName: " + userName);
       
    }
}
