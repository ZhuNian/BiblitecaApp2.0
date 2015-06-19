package com.twu;

import java.util.Scanner;

import static com.twu.Item.putMsg;
/**
*    name: part1.0 Biblioteca
*    function: all about book options
*/
public class BibliotecaApp {
    public static void main(String[] args) {

        putMsg("Welcome to  BibliotecaApp!");

        Books books = new Books();
        BookMenu bookMenu = new BookMenu();
        bookMenu.listBooks();
        bookMenu.showOptionList();

        Scanner scanner = new Scanner(System.in);
        String strInput;
        int nInputNum = 0;
        while (true){
            putMsg("Please Input an Option Number:");
            strInput = scanner.next();
            nInputNum= Integer.parseInt(strInput);
            bookMenu.setAnOption(nInputNum);
            if (bookMenu.isQuit){
                break;
            }
        }
   }
}
