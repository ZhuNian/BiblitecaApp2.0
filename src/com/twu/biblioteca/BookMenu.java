package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 88888888 on 2015/6/3.
 */
public class BookMenu {
    ArrayList<Books> bookList = new ArrayList<Books>();//可以出借的书
    ArrayList<Books> checkedOutBookList = new ArrayList<Books>();//已经借出的书
    ArrayList<String> optionList = new ArrayList<String>();//功能列表
    public boolean isQuit = false;//标志退出

    public BookMenu(ArrayList<Books> boolList,ArrayList<String> optionList ) {
        this.bookList = boolList;
        this.optionList = optionList;
    }

    public BookMenu() {
        bookList.add(new Books(0,"admin","1935"));
        bookList.add(new Books(1,"jack","1945"));
        bookList.add(new Books(2,"jane","2001"));

        optionList.add("ListBooks");
        optionList.add("Check out");
        optionList.add("return book");
        optionList.add("Quit");
    }

    public void listBooks() {
        putMsg("Now List the Books:");
        int i = 0;
        int nCnt = bookList.size();
        for (i=0;i<nCnt;++i){
            bookList.get(i).showBook();
        }
    }

    public void showOptionList() {
        putMsg("Now Show the Options:");
        int i = 0;
        int nCnt = optionList.size();
        for (i=0;i<nCnt;++i){
            System.out.println(Integer.toString(i)+":"+optionList.get(i));
        }
    }

    //在java中好像没有函数数组这个东西？？
    public void setAnOption(int nInputNum) {
        if (nInputNum<0 || nInputNum>=optionList.size()){
            putMsg("Invalid Menu Option! Try Again.");
            return;
        }
        if (nInputNum == 0){
            listBooks();
            return;
        }
        if (nInputNum == 1){
            checkOut();
            return;
        }
        if (nInputNum == 2){
            returnBook();
            return;
        }
        if (nInputNum == 3){
            QuitMenu();
            return;
        }
    }

    private void QuitMenu() {
        isQuit = true;
        putMsg("Quit BibliotecaApp");
        return;
    }

    private void returnBook() {
        Scanner scanner = new Scanner(System.in);
        String strInput;
        int nInputNum = 0;

        putMsg("Please input the Book's Id: ");
        strInput = scanner.next();
        nInputNum = Integer.parseInt(strInput);

        int i = 0;
        int nCnt = checkedOutBookList.size();
        Books books;
        for(i=0;i<nCnt;++i){
            books = checkedOutBookList.get(i);
            if (books.getnBookId() == nInputNum){
                bookList.add(books);
                checkedOutBookList.remove(books);
                putMsg("Congratulations,return book done. ");
                break;
            }
        }
        if (i==nCnt){
            putMsg("The Book hasn't been checked out, so you " +
                    "can't return it.");
        }

        return;
    }

    private void checkOut() {
        listBooks();
        putMsg("Please Choose a Book Number: ");

        Scanner scanner = new Scanner(System.in);
        String strInput;
        int nInputNum = 0;
        strInput = scanner.next();
        nInputNum = Integer.parseInt(strInput);
        int nBookCnt = bookList.size();

        if (nInputNum<0 || nInputNum>=nBookCnt ){
            putMsg("That book is not available.");
            return;
        }

        int i = 0;
        Books boolks;
        for (i=0;i<nBookCnt;++i){
            boolks =bookList.get(i);
            if (boolks.getnBookId() == nInputNum){
                checkedOutBookList.add(boolks);
                bookList.remove(boolks);
                putMsg("Thank you! Enjoy the book.");
                break;
            }
        }
        if (i==nBookCnt){
            putMsg("That book is not available.");
        }
        return;
    }

    public static void putMsg(String str){
        System.out.println(str);
    }
}
