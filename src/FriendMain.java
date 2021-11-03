import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FriendMain {
    ArrayList<Friend> friends = new ArrayList<>();
    File file = new File("C:/Users/masp9/OneDrive/Skrivebord/text.txt");

    public static void main(String[] args) {
        FriendMain app = new FriendMain();
        app.run();

    }

    public void run() {
        String[] array = {"1. Show list of friends", "2. Register friend", "3. Delete friend",
                "4. Save list", "5. Load list"};
        Menu menu = new Menu("Hello, her kan du registrere dine venner"
                , "Choose option: ", array);
        menu.printMenu();


        boolean isRunning = true;
        while (isRunning)
            switch (menu.readChoice()) {

                case 1:
                    showFriends();
                    break;
                case 2:
                    enterFriend();
                    break;
                case 3:
                case 4:
                    saveList();
                    break;
                case 5:
                    loadList();
                    break;
                case 9:
                    isRunning = false;
            }
    }

    public void enterFriend() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phonenumber ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Friend newFriend = new Friend(name, phoneNumber, email);

        if (!checkFriend(newFriend)) {
            friends.add(newFriend);
        } else {
            System.out.println("You already have a friend with those exact information details");

        }
    }

    public void showFriends() {
        if (friends.size() > 0) {
            for (int i = 0; i < friends.size(); i++) {
                System.out.println(friends.get(i));

            }
        } else {
            System.out.println("You have no friends in your friendlist");
        }

    }

    public void loadList() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                Friend loadedFriend = new Friend(scanner.next(), scanner.next(), scanner.next());
                if (!checkFriend(loadedFriend)) {
                    friends.add(loadedFriend);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Found no file to load from.");
        }
    }

    public void saveList() {
        PrintStream output = null;

        try {
            output = new PrintStream(file);
            for (int i = 0; i < friends.size(); i++) {
                output.println(friends.get(i));

            }
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("Found no file to write to.");
        }

    }

    public void deleteFriend() {


    }

    // looper igennem friends-listen og sætter friendAlreadyRegistered til true, hvis der allerede er et
    // friend-objekt med identiske attributes. Har overridet equals-metoden i Friend, da den ellers
    // bare ville tjekke om det er referencer til samme objekt.
    public boolean checkFriend(Friend friend) {
        boolean friendAlreadyRegistered = false;
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).equals(friend)) {
                friendAlreadyRegistered = true;
            }
        }
        return friendAlreadyRegistered;


    }

}
