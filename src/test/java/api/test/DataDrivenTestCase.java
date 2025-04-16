package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTestCase {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testCreateUser(String userId, String userName, String firstName, String lastName, String userEmail, String pwd, String ph){
        User userPayload = new User();

        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(userEmail);
        userPayload.setPassword(pwd);
        userPayload.setPhone(ph);

        Response response = UserEndpoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String username){

         Response response = UserEndpoints.deleteUser(username);
         Assert.assertEquals(response.getStatusCode(), 200);


    }
}
