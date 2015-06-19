package com.twu;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MovieMenuTest {
    @Ignore
    public void should_add_a_item() throws Exception {
        MovieMenu movieMenu = new MovieMenu();
        assertThat(movieMenu.getItemArrayList().size(),is(2));

        movieMenu.addItem(new Movie("lily", "1990", "jack", "8.0"));
        assertThat(movieMenu.getItemArrayList().size(), is(3));
        movieMenu.addItem(new Movie("lily","1990","jack","8.0"));//same movie
        assertThat(movieMenu.getItemArrayList().size(),is(3));
    }

    @Ignore
    public void should_list_all_the_movies() throws Exception {
        MovieMenu movieMenu = new MovieMenu();
        assertThat(movieMenu.showAllTheItems(),is(true));

    }

    @Test
    public void should_check_out() throws Exception {
        Movie m = new Movie("jack","2998","sjk","2.0");
        User user1 = new User("jill","123","zh@gmail.com","1233");
        MovieMenu movieMenu = new MovieMenu();
        assertThat(movieMenu.getItemArrayList().size(),is(2));
        assertThat(movieMenu.checkOut(user1, m), is(false));//check out fail cause m not existing
        movieMenu.showAllTheItems();

        movieMenu.addItem(m);//item1 now exiting
        assertThat(movieMenu.getItemArrayList().size(), is(3));
        assertThat(movieMenu.getCheckedout_itemArrayList().size(),is(0));
        assertThat(user1.getItems().size(), is(0));
        movieMenu.showAllTheItems();

        assertThat(movieMenu.checkOut(user1,m), is(true));//check out succeed
        assertThat(movieMenu.getItemArrayList().size(), is(2));
        assertThat(movieMenu.getCheckedout_itemArrayList().size(),is(1));
        assertThat(user1.getItems().size(),is(1));
        movieMenu.showAllTheItems();
    }
}