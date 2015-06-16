package com.twu;

import java.util.ArrayList;

/**
 * Created by 88888888 on 2015/6/16.
 */
public class User {
    String strUserName;
    String strUserPassword;
    String strEmail_address;
    String strPhone_num;
    ArrayList<User> userArrayList =  new ArrayList<User>();

    public User(String strUserName, String strUserPassword, String strEmail_address, String strPhone_num) {
        this.strUserName = strUserName;
        this.strUserPassword = strUserPassword;
        this.strEmail_address = strEmail_address;
        this.strPhone_num = strPhone_num;
    }
    public User(){
        userArrayList.add(new User("jane","111","123","321"));
    }

    public Boolean login(String strUserName, String strUserPassword) {
        int i = 0;
        int nSize = userArrayList.size();
        for (i=0;i<nSize;++i){
            if (strUserName.equals(userArrayList.get(i).getStrUserName())
                    && strUserPassword.equals(userArrayList.get(i).getStrUserPassword())){
                return true;
            }
        }
        return false;
    }

    public void showOptionList() {
    }

    public void setAnOption(int anOption) {
    }

    public void addUser(User user) {
        int i = 0;
        int nSize = userArrayList.size();
        for (i=0;i<nSize;++i){
            if ()
                return true;
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
}
