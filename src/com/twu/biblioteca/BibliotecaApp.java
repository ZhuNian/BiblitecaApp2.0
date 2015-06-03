package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        BookMenu.putMsg("Welcome to  BibliotecaApp!");

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
    }

}
