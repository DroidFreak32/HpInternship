package com.hptask.Registration_MYSQL_PHP.display;

/**
 * Created by pavan on 17/03/2018.
 */

public class Value_holder {
    private String userName;
    private String userEmail;
    private String gender;

    Value_holder(String userName, String userEmail, String gender) {
        this.gender = gender;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}