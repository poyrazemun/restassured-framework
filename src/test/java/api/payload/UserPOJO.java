package api.payload;

import lombok.Getter;
import lombok.Setter;

//POJO: PLain old java object
//JSON: JavaScript Object Notation
@Getter
@Setter
public class UserPOJO {


    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus = 0;
}
