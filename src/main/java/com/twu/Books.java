package com.twu;

import java.util.ArrayList;

/**
 * Created by ZN on 2015/6/3.
 */
public class Books {
    private String strAuthor;
    private String strPublishYear;

    public int getnBookId() {
        return nBookId;
    }

    private int nBookId;

    public Books(int nBookId,String strAuthor, String strPublishYear) {
        this.nBookId = nBookId;
        this.strAuthor = strAuthor;
        this.strPublishYear = strPublishYear;
    }

    public Books() {
    }

    public void show() {
        System.out.print(Integer.toString(nBookId)+": ");
        System.out.print("author:" + strAuthor+" ; ");
        System.out.println("publish year:"+strPublishYear);
    }
}
