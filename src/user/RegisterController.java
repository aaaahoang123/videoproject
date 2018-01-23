package user;

import api.url.ApiUrl;
import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import user.register.ReqRegisterData;
import user.register.attributes.ReqUserAttribute;

import java.util.Date;
import java.util.Scanner;

public class RegisterController {
    Scanner sc = new Scanner(System.in);

    public void sendReq(ReqRegisterData user) {
        Gson gson = new Gson();
        ApiUrl apis = new ApiUrl();
        try {
            String res = Jsoup.connect(apis.getMembersApi())
                    .requestBody(gson.toJson(user))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute()
                    .body();
            System.out.println("=========================");
            System.out.println(res);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public ReqUserAttribute inputAttr(ReqUserAttribute reqAttr) {

        reqAttr.setUsername(this.inputUserName());
        reqAttr.setPassword(this.inputPassword());
        this.confirmPassword(reqAttr.getPassword());
        reqAttr.setEmail(this.inputEmail());
        reqAttr.setFullName(this.inputName());
        reqAttr.setGender(this.inputGender());
        reqAttr.setBirthday(this.inputBirthday());
        reqAttr.setAvatar(this.inputAvatar());

        return reqAttr;
    }

    private String inputUserName() {
        boolean isValid = false;
        String username = "";
        while (!isValid) {
            System.out.println("Please enter the username:");
            username = sc.nextLine();
            isValid = this.validUserName(username);
        }
        return username;
    }

    private boolean validUserName(String un) {
        if (un.equals("") || un.length() == 0) {
            System.err.println("Username can't be blank!");
            return false;
        }
        if (un.length() < 8) {
            System.err.println("User name must have at least 8 characters!");
            return false;
        }
        System.out.println("Valid user name");
        return true;
    }

    private String inputPassword() {
        boolean valid = false;
        String password = "";
        while (!valid) {
            System.out.println("Please enter password:");
            password = sc.nextLine();
            valid = this.validPassword(password);
        }
        return password;
    }

    private boolean validPassword(String pass) {
        if (pass.equals("") || pass.length() == 0) {
            System.err.println("Password can't be blank!");
            return false;
        }
        if (pass.length() < 7) {
            System.err.println("Password must have at least 7 characters");
            return false;
        }
        System.out.println("Valid password");
        return true;
    }

    private void confirmPassword(String password) {
        String cp = "";
        while (!cp.equals(password)) {
            System.out.println("Please confirm your password:");
            cp = sc.nextLine();
            System.out.println(cp.equals(password) ? "Confirm password correct!" : "Password not match! Please enter again!");
        }
    }

    private String inputEmail() {
        System.out.println("Please enter the email:");
        return sc.nextLine();
    }

    private String inputName() {
        System.out.println("Please enter your full name:");
        return sc.nextLine();
    }

    private int inputGender() {
        int gender = 0;
        boolean valid = false;
        while (!valid) {
            System.out.println("Please enter your gender(1. Male, 2. Female, 0. Other):");
            gender = sc.nextInt();
            sc.nextLine();
            valid = validGender(gender);
        }
        return gender;
    }

    private boolean validGender(int gender) {
        if (gender != 0 && gender != 1 && gender != 2) {
            System.err.println("Gender must be 0,1,2");
            return false;
        }
        System.out.println("Valid gender");
        return true;
    }
    private long inputBirthday() {
        long birthday = 0;
        Date birthdayDate = null;
        String birthdayString = "";
        while (birthdayDate == null) {
            System.out.println("Please enter your birthday (mm/DD/yyyy):");
            birthdayString = sc.nextLine();
            try {
                birthdayDate = new Date(birthdayString);
                birthday = birthdayDate.toInstant().toEpochMilli();
            } catch (Exception e) {
                System.err.println("Invalid birthday! Please enter birthday with mm/DD/yyyy form!");
            }
        }
        return birthday;
    }

    private String inputAvatar() {
        System.out.println("Please enter your avatar:");
        return sc.nextLine();
    }
}