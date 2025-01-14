package package1;

import java.lang.ref.Cleaner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {

    public static int id;
    static String name;
    static String yob;
    static int height;
    static int weight;
    static Bmi bmi;
    public static List<Bmi> users = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    index();
                    break;
                case 3:
                    System.out.println("Enter any user id: ");
                    int choseId = scanner.nextInt();
                    view(choseId);
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Please enter a correct choice");
                    ;
            }
        } while (true);

    }

    public static void displayMenu() {
        System.out.println("Welcome: BMI CALCULATOR");
        System.out.println("");
        System.out.println("1.Create a record");
        System.out.println("2.Show BMI data for all users. ");
        System.out.println("3.Show BMI data for a selected user");
        System.out.println("4.Delete all records ");
        System.out.println("5.Exit ");
        System.out.println("");
        System.out.println("Please Enter Your choice ");

    }

    public static void view(int choseId) {

        String stringId = String.valueOf(choseId);

        for (Bmi user : users) {
            if (String.valueOf(user.getId()).equals(stringId)) {
                System.out.println("Showing data for user id: " + choseId);
                System.out.println("");
                System.out.println("User name: " + user.getName());
                System.out.println("User age: " + user.getAge());
                System.out.println("User BMI: " + user.getBmi());
                System.out.println("User BMI category is: " + user.getCategory());
                System.out.println("Recommendation :" + user.getRecommendation());

                System.out.println("");

            } else {
                System.out.println("No matching user found. Try another id");
            }
        }

        bmi.display();

    }

    public static void create() {

        System.out.println("Enter your id:");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your name:");
        name = scanner.nextLine();
        System.out.println("Enter your yob:");
        yob = scanner.nextLine();
        System.out.println("Enter your height in centi meters:");
        height = scanner.nextInt();
        System.out.println("Enter your weight in kg:");
        weight = scanner.nextInt();
        System.out.println("");
        if (id <= 0 || id >= 6) {
            System.out.println("Id must be greater than 0 and less than 5");
            System.out.println("Enter your id:");
            id = scanner.nextInt();

            if (Integer.parseInt(yob) >= 2025) {
                System.out.println("Year of birth must be less than 2025");
                System.out.println("Enter your yob:");
                int yobnum = scanner.nextInt();
                yob = String.valueOf(yobnum);
                bmi = new Bmi(id, name, yob, height, weight);
                bmi.calculate();
                bmi.display();
                users.add(bmi);
            } else {
                bmi = new Bmi(id, name, yob, height, weight);
                bmi.calculate();
                bmi.display();
                users.add(bmi);

            }

        } else if (Integer.parseInt(yob) >= 2025) {
            System.out.println("Year of birth must be less than 2025");
            System.out.println("Enter your yob:");
            int yobnum = scanner.nextInt();
            yob = String.valueOf(yobnum);
            bmi = new Bmi(id, name, yob, height, weight);
            bmi.calculate();
            bmi.display();
            users.add(bmi);

        } else {
            bmi = new Bmi(id, name, yob, height, weight);
            bmi.calculate();
            bmi.display();
            users.add(bmi);
        }

    }

    public static void index() {
        if (!String.valueOf(users.size()).equalsIgnoreCase("0")) {
            for (Bmi user : users) {
                System.out.println("Showind all data of " + user.getName());
                System.out.println("User id: " + user.getId());
                System.out.println("User name: " + user.getName());
                System.out.println("User age: " + user.getAge());
                System.out.println("User BMI: " + user.getBmi());
                System.out.println("User BMI category is: " + user.getCategory());
                System.out.println("Recommendation :" + user.getRecommendation());
                System.out.println("");
            }
        } else {
            System.out.println("No users found.Please create a record first.");
        }
        bmi.display();
    }

    public static void delete() {
        users.clear();
        System.out.println("Deleted all user records");

    }

    public static void exit() {
        System.out.println("Exiting system");
        System.exit(0);
    }

}
