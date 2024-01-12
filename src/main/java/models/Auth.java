package models;

import configs.Configurations;
import lombok.Data;

@Data
public class Auth {
    private String user = Configurations.user;
    private String password = Configurations.password;
}
