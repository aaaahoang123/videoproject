package user;

import api.url.ApiUrl;
import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import user.login.ReqLoginData;
import user.login.ResLoginData;
import user.login.attribute.ReqLoginAttribute;
import user.login.data.ResUserLoginData;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class LoginLogoutController {
    Scanner sc = new Scanner(System.in);

    public ReqLoginAttribute inputAttr(ReqLoginAttribute attr) {
        attr.setUsername(this.inputUserName());
        attr.setPassword(this.inputPassword());
        return attr;
    }

    public void sendReq(ReqLoginData loginData) {
        Gson gson = new Gson();
        ApiUrl apis = new ApiUrl();
        try {
            String res = Jsoup.connect(apis.getAuthenticationApi())
                    .requestBody(gson.toJson(loginData))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute()
                    .body();
            System.out.println("=====================");
            System.out.println(res);
            this.saveToken(gson.fromJson(res, ResLoginData.class));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void saveToken(ResLoginData res) {
        Properties prop = new Properties();
        if (res != null) {
            try {
                OutputStream output = new FileOutputStream("config.properties");
                prop.setProperty("token", res.getData().getId());
                prop.store(output, null);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }
    }

    public String getToken() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
            return prop.getProperty("token");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void logout() {
        Properties prop = new Properties();
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream("config.properties");
            output = new FileOutputStream("config.properties");
            prop.load(input);
            prop.remove("token");
            prop.store(output, null);
            System.out.println("Logout success full");
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private String inputUserName() {
        System.out.println("Please enter your username:");
        return sc.nextLine();
    }

    private String inputPassword() {
        System.out.println("Please enter your password:");
        return sc.nextLine();
    }
}
