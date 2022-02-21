import com.revature.repository.UserDAO;

import java.util.Scanner;

public class Driver {

    private static Scanner scanner = new Scanner(System.in);
    //private static userDAO userDAO = new UserDao();


    public static void main(String[] args){



        System.out.println("Welcome to the Future");
        System.out.println("How can we help?");
        System.out.println("Login/n" +
                "About ReimbrusementApp/n"+
                "Exit/n");
        int input = scanner.nextInt();

        while(input != 4);
        switch (input){
            case 1:
                scanner.nextLine();
                System.out.println("You chose login");
                System.out.println("Please enter your username:");
                String username = scanner.nextLine();
                System.out.println("Please enter your password:");
                String password = scanner.nextLine();
                break;
            case 2:
                System.out.println("Exit, Goodbye.");
                break;
            case 3:
                System.out.println("I didn't recognize that option. Please only enter integers.");
                break;
        }
    }
}
