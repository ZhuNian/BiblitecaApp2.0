package com.twu;

import java.util.Scanner;

import static com.twu.Item.putMsg;

/**
 * Created by ZN on 2015/6/5.
 * name: part2.0 Biblioteca
 * function: add user login and registration and movie options
 */
public class NewBiblitecaApp {
    public static MovieMenu getMovieMenu() {
        return movieMenu;
    }

    public static void setMovieMenu(MovieMenu movieMenu) {
        NewBiblitecaApp.movieMenu = movieMenu;
    }

    public static MovieMenu movieMenu = new MovieMenu();//global movie Menu

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String strInput;
        String strUserName;
        String strUserPassword;
        Boolean bFirstTimeLogIn = true;
        int nInputNum = 0;
        User user = new User();
        MovieMenu movieMenu = new MovieMenu();

        putMsg("welcome to NewBiblitecaApp!");
        while(true){
            if (bFirstTimeLogIn){// first time to the system should login or register
                putMsg("this is your fist time to NewBiblitecaApp");
                putMsg("please input number 0 to log in or input other numbers to register.");
                strInput = scanner.next();
                nInputNum= Integer.parseInt(strInput);
                if (nInputNum==0){//login
                    putMsg("please input your name and password!");
                    strUserName = scanner.next();
                    strUserPassword = scanner.next();
                    while(!user.login(strUserName,strUserPassword)){//log in fail
                        putMsg("log in failed,try again!");
                        strUserName = scanner.next();
                        strUserPassword = scanner.next();
                    };
                    putMsg("log in succeed! please enjoy NewBiblitecaApp!");
                }
                else{//register
                    putMsg("Please Input your name,password,email,phone number.");
                    strUserName = scanner.next();
                    strUserPassword = scanner.next();
                    String strEmail_address;
                    String strPhone_num;
                    strEmail_address = scanner.next();
                    strPhone_num = scanner.next();

                    user.addUser(new User(strUserName, strUserPassword, strEmail_address, strPhone_num));
                    user.login(strUserName,strUserPassword);
                    putMsg("register succeed! please enjoy NewBiblitecaApp!");
                }
                bFirstTimeLogIn = false;
            }
            putMsg("Here is the option list in NewBiblitecaApp,please chooose one!");
            user.showOptionList();
            strInput = scanner.next();
            nInputNum= Integer.parseInt(strInput);
            user.setAnOption(nInputNum);
            if (user.getIsQuit()){
                putMsg("you choose to quit NewBiblitecaApp, see you!");
                break;
            }
        }
    }
}
