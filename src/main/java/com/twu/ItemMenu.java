package com.twu;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

import static com.twu.Item.putMsg;

/**
 * Created by 88888888 on 2015/6/19.
 * function: this is the menu of items, it has two item list,one is the list
 * of items can be checked out, the other is the list of items have been checked
 * out.
 */
public class ItemMenu {
    private ArrayList<Item> itemArrayList = new ArrayList<Item>();//items can be checked out
    private ArrayList<Item> checkedout_itemArrayList = new ArrayList<Item>();//items have been checked out

    public Boolean showAllTheItems(){
        putMsg("here is the list of items can be checked out:");
        int i = 0;
        int nCnt = itemArrayList.size();
        for (i=0;i<nCnt;++i){
            System.out.print(Integer.toString(i)+":");
            itemArrayList.get(i).show();
        }
        return true;
    }
    public void showCheckedOutItems(){
        putMsg("here is the list of items have been checked out:");
        int i = 0;
        int nCnt = checkedout_itemArrayList.size();
        for (i=0;i<nCnt;++i){
            checkedout_itemArrayList.get(i).show();
        }
    }
    public Boolean checkOut(User user,Item it){
        if (itemArrayList.isEmpty()){
            return false;
        }
        int i = 0;
        int nCnt = itemArrayList.size();
        for (i=0;i<nCnt;++i){
            if (it.equals(itemArrayList.get(i))){
                itemArrayList.remove(it);
                checkedout_itemArrayList.add(it);
                user.addCheckOutItem(it);
                return true;
            }
        }
        return false;
    }
    public void addItem(Item it){
        int i = 0;
        int nCnt = itemArrayList.size();
        for (i=0;i<nCnt;++i){
            if (it.equals(itemArrayList.get(i))){
                return;
            }
        }
        itemArrayList.add(it);
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public void setItemArrayList(ArrayList<Item> itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public ArrayList<Item> getCheckedout_itemArrayList() {
        return checkedout_itemArrayList;
    }

    public void setCheckedout_itemArrayList(ArrayList<Item> checkedout_itemArrayList) {
        this.checkedout_itemArrayList = checkedout_itemArrayList;
    }
}
