package api.payload;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    int id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;
    int userStatus=0;
}
