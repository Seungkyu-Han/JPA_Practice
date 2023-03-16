package UserProgram;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserProgram {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static final UserService userService = new UserService();

    private static String email;
    private static String name;

    public static void main(String[] args) {
        EMF.init();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag){
            logger.info("1. Create, 2. Read, 3. Update, 4. Delete, 5. exit : ");
            int answer = scanner.nextInt();
            switch (answer) {
                case 1 -> CreateMethod();
                case 2 -> ReadMethod();
                case 3 -> UpdateMethod();
                case 4 -> DeleteMethod();
                case 5 -> flag = false;
            }
        }

        EMF.close();
        scanner.close();
    }

    private static void inputEmail(){
        Scanner scanner = new Scanner(System.in);
        logger.info("input email:");
        email = scanner.nextLine();
    }

    private static void inputName(){
        Scanner scanner = new Scanner(System.in);
        logger.info("input name:");
        name = scanner.nextLine();
    }

    private static void CreateMethod(){
        inputEmail();
        inputName();
        User user = new User(email, name, LocalDateTime.now());
        try{
            userService.CreateUser(user);
        }catch(Exception exception){
            System.out.println("createError");
        }
    }

    private static void ReadMethod(){
        inputEmail();
        try{
            User user = userService.ReadUser(email);
            System.out.println(user);
        }catch(Exception exception){
            System.out.println("readError");
        }
    }

    private static void UpdateMethod(){
        inputEmail();
        inputName();
        try{
            userService.UpdateUser(email, name);
            System.out.println(userService.ReadUser(email));
        }catch(Exception exception){
            System.out.println("updateError");
        }
    }

    private static void DeleteMethod(){
        inputEmail();
        try{
            userService.DeleteUser(email);
        }catch(Exception exception){
            System.out.println("deleteError");
        }
    }
}
