package Generators;

import com.test_project.demo.model.CustomerInfo;
import com.test_project.demo.model.User;
import com.test_project.demo.model.Users;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class UserGenerator {

    User user;
    CustomerInfo customerInfo;
    List firstNameList = new ArrayList<String>();
    List lastNameList = new ArrayList<String>();
    List streetNameList = new ArrayList<String>();
    public List userList = new ArrayList<Users>();
    public List addressList = new ArrayList<CustomerInfo>();

    // Method for generating a names for users.
    public void GenerateNameList() throws FileNotFoundException {
        String firstNamePath = "/Users/tommytroest/OneDrive/Development/Databases for Developers/ExamProject/FeedMe/demo/src/main/java/Generators/firstNameList.txt";
        Scanner firstNameScanner = new Scanner(new File(firstNamePath));
        String lastNamePath = "/Users/tommytroest/OneDrive/Development/Databases for Developers/ExamProject/FeedMe/demo/src/main/java/Generators/lastNameList.txt";
        Scanner lastNameScanner = new Scanner(new File(lastNamePath));
        String streetNamePath = "/Users/tommytroest/OneDrive/Development/Databases for Developers/ExamProject/FeedMe/demo/src/main/java/Generators/streetNameList.txt";
        Scanner streetNameScanner = new Scanner(new File(streetNamePath));

        while (firstNameScanner.hasNext()) {
            firstNameList.add(firstNameScanner.next());
        }

        while (lastNameScanner.hasNext()) {
            lastNameList.add(lastNameScanner.next());
        }

        while (streetNameScanner.hasNext()) {
            streetNameList.add(streetNameScanner.next());
        }


    }

    // Method for generating random users for the DB.
    public void generateUser(int numberOfRandomUsers) {

        Random random = new Random();
        int randomNumber;
        int i = 0;
        int j = 0;
        int a = 0;
        int u = 0;

        while (a <= numberOfRandomUsers) {
            Users tempUser = new Users();
            CustomerInfo tempCustomer = new CustomerInfo();
            if (i <= numberOfRandomUsers) {
                randomNumber = random.nextInt(100);
                tempUser.setFirstName((String) (firstNameList.get(randomNumber)));
                i++;
            }
            if (j <= numberOfRandomUsers) {
                randomNumber = random.nextInt(100);
                tempUser.setLastName((String) (lastNameList.get(randomNumber)));
                tempUser.setEmail((tempUser.getFirstName() + tempUser.getLastName() + "@gmail.com").toLowerCase());
                tempUser.setPassword("1739808568540064291");
                tempUser.setRoleId(1);
                j++;
            }



            if (u <= numberOfRandomUsers) {
                randomNumber = random.nextInt(100);
                int number = random.nextInt(50);
                tempCustomer.setStreetName((String) (streetNameList.get(randomNumber)));
                tempCustomer.setStreetNumber("" + number);
                tempCustomer.setPostalCode(random.nextInt(2999));
                tempCustomer.setCity("København");
            }

            userList.add(tempUser);
            addressList.add(tempCustomer);
            a++;
        }
    }
}
