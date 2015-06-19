package com.twu;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.Item.putMsg;
import static com.twu.NewBiblitecaApp.getMovieMenu;

/**
 * Created by ZN on 2015/6/5.
 */
public class User extends optionMenu{
    String strUserName;
    String strUserPassword;
    String strEmail_address;
    String strPhone_num;
    ArrayList<User> userArrayList =  new ArrayList<User>();
    ArrayList<Movie>movies = new ArrayList<Movie>();//check out movies



    ArrayList<Item>items = new ArrayList<Item>();//checked out items

    public User(String strUserName, String strUserPassword, String strEmail_address, String strPhone_num) {
        this.strUserName = strUserName;
        this.strUserPassword = strUserPassword;
        this.strEmail_address = strEmail_address;
        this.strPhone_num = strPhone_num;

    }
    public User(){
        userArrayList.add(new User("jane","111","jane@gmail.com","65321"));
    }

    public Boolean login(String strUserName, String strUserPassword) {
        int i = 0;
        int nSize = userArrayList.size();
        User userTemp = userArrayList.get(i);
        for (i=0;i<nSize;++i){
            if (strUserName.equals(userTemp.getStrUserName())
                    && strUserPassword.equals(userTemp.getStrUserPassword())){
                this.strUserName = userTemp.getStrUserName();
                this.strUserPassword = userTemp.getStrUserPassword();
                this.strEmail_address = userTemp.getStrEmail_address();
                this.strPhone_num = userTemp.getStrPhone_num();
                return true;
            }
        }
        return false;
    }

    public void showOptionList() {
        ArrayList<String> optionList=  new ArrayList<String >();
        optionList.add("show user information");
        optionList.add("check out");
        optionList.add("Quit");
        setOptionList(optionList);
        super.showOptionList();
    }

    public void setAnOption(int anOption) {
        if (anOption<0 || anOption>=optionList.size()){
            putMsg("Invalid Menu Option! Try Again.");
            return;
        }
        if (anOption == 0){
            showDetailInformation();
            return;
        }
        if (anOption == 1){
            checkout();
            return;
        }
        if (anOption == 2){
            setIsQuit(true);
            return;
        }
    }

    public Boolean checkout() {
        MovieMenu movieMenu = getMovieMenu();
        if (movieMenu.getItemArrayList().isEmpty()){
            putMsg("there is no books can be checked out.please try latter.");
            return false;
        }
        movieMenu.showAllTheItems();
        putMsg("please input the number of the book you wanna check out.");
        Scanner scanner = new Scanner(System.in);
        String strInput;
        int nInputNum = 0;
        strInput = scanner.next();
        nInputNum= Integer.parseInt(strInput);
        if (nInputNum <0 || nInputNum >= movieMenu.getItemArrayList().size()){
            putMsg("the book is not existing! check out failed.");
            return false;
        }
        Boolean bResult = movieMenu.checkOut(this, movieMenu.getItemArrayList().get(nInputNum));
        if (bResult){
            putMsg("check out successful!Enjoy the movie");
        }
        else {
            putMsg("check out failed! May be you have input the wrong book number!");
            return false;
        }
        return bResult;
    }


    private void showDetailInformation() {
        putMsg("UserName:"+strUserName);
        putMsg("Email Address:"+strEmail_address);
        putMsg("Phone Number:"+strPhone_num);
    }

    public void addUser(User user) {
        int i = 0;
        int nSize = userArrayList.size();
        for (i=0;i<nSize;++i){
            User u = userArrayList.get(i);
            if ( (user.getStrUserName().equals(u.getStrUserName())
                    && user.getStrUserPassword().equals(u.getStrUserPassword()) )
                    || user.equals(u) ){
                return;
            }
            }
        userArrayList.add(user);
        }



    public String getStrUserName() {
        return strUserName;
    }

    public String getStrUserPassword() {
        return strUserPassword;
    }

    public String getStrEmail_address() {
        return strEmail_address;
    }

    public String getStrPhone_num() {
        return strPhone_num;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (strEmail_address != null ? !strEmail_address.equals(user.strEmail_address) : user.strEmail_address != null)
            return false;
        if (strPhone_num != null ? !strPhone_num.equals(user.strPhone_num) : user.strPhone_num != null) return false;
        if (strUserName != null ? !strUserName.equals(user.strUserName) : user.strUserName != null) return false;
        if (strUserPassword != null ? !strUserPassword.equals(user.strUserPassword) : user.strUserPassword != null)
            return false;
        if (userArrayList != null ? !userArrayList.equals(user.userArrayList) : user.userArrayList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = strUserName != null ? strUserName.hashCode() : 0;
        result = 31 * result + (strUserPassword != null ? strUserPassword.hashCode() : 0);
        result = 31 * result + (strEmail_address != null ? strEmail_address.hashCode() : 0);
        result = 31 * result + (strPhone_num != null ? strPhone_num.hashCode() : 0);
        result = 31 * result + (userArrayList != null ? userArrayList.hashCode() : 0);
        return result;
    }

    public Boolean getIsQuit() {
        return super.getIsQuit();
    }
    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void addCheckOutItem(Item it) {
        items.add(it);
    }
}
