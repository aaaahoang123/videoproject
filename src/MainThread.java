import user.UserMenu;

import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter your option:");
            System.out.println("1. User Manager (Login/Logout/Register)! Please login or register before use this app!");
            System.out.println("2. Exit");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    userMenu.mainMenu();
                    break;
                case 2:
                    System.exit(1);
                    break;
            }
        }
    }
}
