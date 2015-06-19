package com.twu;

import java.util.ArrayList;

/**
 * Created by ZN on 2015/6/6.
 */
public class optionMenu {
    ArrayList<String> optionList=  new ArrayList<String >();
    private Boolean isQuit = false;//quit the system

    public void showOptionList() {
        int i = 0;
        int nCnt = optionList.size();
        for (i = 0; i < nCnt; ++i) {
            System.out.println(Integer.toString(i) + ":" + optionList.get(i));
        }
    }
    public void setAnOption(int anOption){}

    public Boolean checkout() {return true;}

    public ArrayList<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<String> optionList) {
        this.optionList = optionList;
    }

    public Boolean getIsQuit() {
        return isQuit;
    }

    public void setIsQuit(Boolean isQuit) {
        this.isQuit = isQuit;
    }
}
