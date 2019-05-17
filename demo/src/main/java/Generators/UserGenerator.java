package Generators;

import com.test_project.demo.model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserGenerator {

    String firstNamePath = "/Users/tommytroest/OneDrive/Development/Databases for Developers/ExamProject/FeedMe/demo/src/main/java/Generators/firstNameList.txt";
    String lastNamePath = "/Users/tommytroest/OneDrive/Development/Databases for Developers/ExamProject/FeedMe/demo/src/main/java/Generators/lastNameList.txt";



    User user;
    List firstNameList = new ArrayList<String>();
    List lastNameList = new ArrayList<String>();

    List userList = new ArrayList<User>();

    public void GenerateNameList() throws FileNotFoundException {
        String firstName;
        int firstNameNumber = 0;
        int lastNameNumber = 0;
        Scanner firstNameScanner = new Scanner(new File(firstNamePath));
        Scanner lastNameScanner = new Scanner(new File(lastNamePath));
        while (firstNameScanner.hasNext()) {
            firstNameList.add(firstNameScanner.next());
            firstNameNumber++;
        }
        while (lastNameScanner.hasNext()) {
            lastNameList.add(lastNameScanner.next());
            lastNameNumber++;
        }
    }

    public void generateUser(int numberOfRandomUsers) {

        Random random = new Random();
        int randomNumber;
        int i = 0;
        int j = 0;
        int a = 0;
        while (a <= numberOfRandomUsers) {
            User tempUser = new User();
            if (i <= numberOfRandomUsers) {
                randomNumber = random.nextInt(100);
                System.out.println(randomNumber);
                tempUser.setFirstname((String) (firstNameList.get(randomNumber)));
                i++;
            }
            if (j <= numberOfRandomUsers) {
                randomNumber = random.nextInt(100);
                System.out.println(randomNumber);
                tempUser.setLastname((String) (lastNameList.get(randomNumber)));
                tempUser.setEmail((tempUser.getFirstname() + tempUser.getLastname() + "@gmail.com").toLowerCase());
                tempUser.setPassword("test123");

                j++;
            }
            userList.add(tempUser);

            a++;
        }

        for (Iterator<User> o = userList.iterator(); o.hasNext();) {
            User user = o.next();
            System.out.println(user.getFirstname());
            System
        }


    }
}
