import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<User> users = new ArrayList<>();
    private File file = new File("src/users.txt");


    public void run() {
        Menu menu = new Menu("Menu", "Choose an option: ", new String[]{"1. View user list",
                "2. Create new user", "3. Delete user", "9. Quit"});
        loadFile();

        menu.printMenu();

        boolean isRunning = true;
        while (isRunning)
            switch (menu.readChoice()) {

                case 1:
                    viewUserList();
                    break;
                case 2:
                    createNewUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 9:
                    isRunning = false;
                    break;
                default:
                    menu.printMenu();

            }
    }

    public void createNewUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Indtast ID: ");
        while (!input.hasNextInt()) {
            System.out.print("Kan kun indtaste tal, prøv igen: ");
            input.next();
        }
        int userId = input.nextInt();
        System.out.print("Indtast navn: ");
        String userName = input.next();
        System.out.print("Indtast password: ");
        String password = input.next();

        users.add(new User(userId, userName, password));
        saveFile();


    }

    public void saveFile() {
        PrintStream output = null;

        try {
            output = new PrintStream(file);
            for (int i = 0; i < users.size(); i++) {
                output.println(users.get(i));

            }
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    public void loadFile() {

        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                users.add(new User(input.nextInt(), input.next(), input.next()));

            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public void viewUserList() {
        int element = 0;
        for (User user : users) {
            System.out.println(element + " " + user);
            element++;

        }

    }

    public void deleteUser() {
        Scanner input = new Scanner(System.in);
        System.out.print("Vælg hvilket element du vil slette: ");
        boolean isRunning = true;
        while (isRunning) {
            int elementNumber = input.nextInt();
            if (users.size() != 0) {
                if (elementNumber >= 0 && elementNumber < users.size()) {
                    users.remove(elementNumber);
                    isRunning = false;
                } else {
                    System.out.print("Det valgte element findes ikke, prøv igen: ");
                }
            } else {
                System.out.println("Der er ikke nogle elementer at slette.");
                isRunning = false;
            }


        }

        saveFile();
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

}

