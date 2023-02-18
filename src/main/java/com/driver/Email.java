package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if(oldPassword.equals(getPassword())){
            boolean cond1 = newPassword.length()>=8;
            boolean cond2 = false, cond3 = false, cond4 = false, cond5 = false;
            for(char ch: newPassword.toCharArray()){
                if(ch>=97 && ch<=122) cond3 = true;
                else if(ch>=65 && ch<=90) cond2 = true;
                else if(ch>=48 && ch<=57) cond4 = true;
                else cond5 = true;
            }

            if(cond1 && cond2 && cond3 && cond4 && cond5) {
                this.password = newPassword;
            }
        }
    }
}
