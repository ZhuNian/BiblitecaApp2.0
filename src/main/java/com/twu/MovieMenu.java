package com.twu;

import java.util.ArrayList;

/**
 * Created by ZN on 2015/6/5.
 */
public class MovieMenu extends ItemMenu{
    public MovieMenu() {
        ArrayList<Item>movies = new ArrayList<Item>();
        addItem(new Movie("jane","2015","jack","9.0"));
        addItem(new Movie("jin","2025","jack","9.0"));
    }
    public void addItem(Movie m){
        int i = 0;
        int nCnt = getItemArrayList().size();
        for (i=0;i<nCnt;++i){
            if (m.equals(getItemArrayList().get(i))){
                return;
            }
        }
        getItemArrayList().add(m);
    }
}
