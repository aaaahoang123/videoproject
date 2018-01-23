package user;

import user.login.ReqLoginData;
import user.login.attribute.ReqLoginAttribute;
import user.login.data.ReqUserLoginData;
import user.register.ReqRegisterData;
import user.register.attributes.ReqUserAttribute;
import user.register.data.ReqUserData;

import java.util.Scanner;

public class UserMenu {
    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        LoginLogoutController loginLogoutController = new LoginLogoutController();
        while (true) {
            String token = loginLogoutController.getToken();
            System.out.println("Please enter your option:");
            if (token == null) {
                System.out.println("1. Register.");
                System.out.println("2. Login.");
            } else {
                System.out.println("1. Logout");
            }
            System.out.println("3. Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    if (token == null) {
                        this.register();
                        break;
                    } else {
                        loginLogoutController.logout();
                        break;
                    }
                case 2:
                    if (token == null) {
                        this.login();
                        break;
                    } else {
                        System.out.println("Please choose the right option!");
                        break;
                    }
                case 3:
                    System.out.println("Exit the app");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please choose the right option!");
                    break;
            }
        }
    }

    private void register() {
        ReqRegisterData reqUser = new ReqRegisterData();
        ReqUserData reqData = new ReqUserData();
        ReqUserAttribute reqAttr = new ReqUserAttribute();
        RegisterController registerController = new RegisterController();
        reqAttr = registerController.inputAttr(reqAttr);

        reqData.setAttributes(reqAttr);
        reqUser.setData(reqData);
        registerController.sendReq(reqUser);
    }

    private void login() {
        ReqLoginData reqLoginData = new ReqLoginData();
        ReqUserLoginData reqUserLoginData = new ReqUserLoginData();
        ReqLoginAttribute reqLoginAttribute = new ReqLoginAttribute();
        LoginLogoutController loginController = new LoginLogoutController();

        reqLoginAttribute = loginController.inputAttr(reqLoginAttribute);
        reqUserLoginData.setAttributes(reqLoginAttribute);
        reqLoginData.setData(reqUserLoginData);

        loginController.sendReq(reqLoginData);
    }
}
