package com.twu;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {

 /*       BookMenu.putMsg("Welcome to  BibliotecaApp!");

        Books books = new Books();
        BookMenu bookMenu = new BookMenu();
        bookMenu.listBooks();
        bookMenu.showOptionList();

        Scanner scanner = new Scanner(System.in);
        String strInput;
        int nInputNum = 0;
        while (true){
            BookMenu.putMsg("Please Input an Option Number:");
            strInput = scanner.next();
            nInputNum= Integer.parseInt(strInput);
            bookMenu.setAnOption(nInputNum);
            if (bookMenu.isQuit){
                break;
            }
        }
*/
        Scanner scanner = new Scanner(System.in);
        String strInput;
        String strUserName;
        String strUserPassword;
        int nInputNum = 0;
        User user = new User();

        while(true){
            strInput = scanner.next();
            nInputNum= Integer.parseInt(strInput);
            if (nInputNum==0){//login
                strUserName = scanner.next();
                strUserPassword = scanner.next();
                user.login(strUserName,strUserPassword);
            }
            else {//registration
                strUserName = scanner.next();
                strUserPassword = scanner.next();
                String strEmail_address;
                String strPhone_num;
                strEmail_address = scanner.next();
                strPhone_num = scanner.next();

                user.addUser(new User(strUserName,strUserPassword,strEmail_address,strPhone_num));
            }
            user.showOptionList();
            strInput = scanner.next();
            nInputNum= Integer.parseInt(strInput);
            user.setAnOption(nInputNum);
        }
   }
}
