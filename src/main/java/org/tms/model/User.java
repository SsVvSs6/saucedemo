package org.tms.model;

import lombok.Data;

@Data
public class User {

    private String login = "standard_user";
    private String password = "secret_sauce";

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
